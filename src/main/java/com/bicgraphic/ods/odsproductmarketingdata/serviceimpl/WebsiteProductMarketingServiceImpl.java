package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationRouter;
import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationUtilities;
import com.bicgraphic.ods.odsproductmarketingdata.common.EventProperties;
import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.common.RouterResponse;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventDMResponse;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadataDM;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductData;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;
import com.bicgraphic.ods.odsproductmarketingdata.repository.ProductMarketingRepository;
import com.bicgraphic.ods.odsproductmarketingdata.service.WebsiteProductMarketingService;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;
import com.bicgraphic.odsutils.WSCacheClearTimerTask;
import com.bicgraphic.odsutils.WebsiteAccessToken;

/**
 * The Class WebsiteProductMarketingServiceImpl.
 */
@Service
public class WebsiteProductMarketingServiceImpl implements WebsiteProductMarketingService{

	 /** The product marketing repository. */
 	@Autowired
	    private ProductMarketingRepository productMarketingRepository;
	
	 /** The application router. */
    @Autowired
    private ApplicationRouter applicationRouter;

    /** The application utilities. */
    @Autowired
    private ApplicationUtilities applicationUtilities;

    /** The event properties. */
    @Autowired
    private EventProperties eventProperties;

    /**
	 * Push product marketing data.
	 *
	 * @param eventMetaDataDM the event meta data DM
	 * @return the event response
	 */
	@Override
	public EventResponse pushProductMarketingData(EventMetadataDM eventMetaDataDM) {
        LoggerUtil.info("pushing ProductData to WS #{}", eventMetaDataDM);
        RouterResponse wsProductPricingStorResponse = null;
        List<ProductData> productData = null;
        EventResponse wsEventResponse = new EventResponse();
        EventDMResponse eventDMResponse = new EventDMResponse();
        EventMetadata eventMetadata = eventMetaDataDM.getEventMetadata();

        try {
            productData = fetchProductMarketingData(eventMetadata);
            if (productData.isEmpty()) {
                throw new ODSException(ProductMarketingConstants.DATA_NOT_FOUND_CODE, ProductMarketingConstants.DATA_NOT_FOUND_MSG);
            } else {
                String token = generateWSAuthToken(wsEventResponse);

                if (wsEventResponse.getEventErrorCode().equals(ProductMarketingConstants.SUCCESS_CODE)) {
                    String productDataEventDMRequest = applicationUtilities.prepareProductDataEventRequest(eventMetadata,
                            productData);
                    LoggerUtil.info("Pushing ProductMarketing Data From ODS to WS: ServiceUrl#{},Request#{}",
                            eventProperties.getStoreWSProductDataEndpoint(), productDataEventDMRequest);

                    wsProductPricingStorResponse = applicationRouter.invokeService(
                            eventProperties.getStoreWSProductDataEndpoint(), prepareWSHttpHeaders(token), HttpMethod.POST,
                            productDataEventDMRequest);
                    if (wsProductPricingStorResponse.getHttpCode().is5xxServerError()) {
                        if (wsProductPricingStorResponse.getData().contains("The token is expired")) {
                            //Clearing the cache manually
                            WSCacheClearTimerTask task = new WSCacheClearTimerTask();
                                task.run();
                            String newtoken = generateWSAuthToken(wsEventResponse);
                            if (wsEventResponse.getEventErrorCode().equals(ProductMarketingConstants.SUCCESS_CODE)) {
                                wsProductPricingStorResponse = applicationRouter.invokeService(
                                        eventProperties.getStoreWSProductDataEndpoint(), prepareWSHttpHeaders(newtoken),
                                        HttpMethod.POST, productDataEventDMRequest);
                            } else {
                                return wsEventResponse;
                            }
                        }
                    }
                    if (wsProductPricingStorResponse.getHttpCode().is2xxSuccessful()) {
                        eventDMResponse = applicationUtilities.convertTypeReference(wsProductPricingStorResponse.getData(),
                                EventDMResponse.class);
                        wsEventResponse = eventDMResponse.getEventResponse();
                    } else if (wsProductPricingStorResponse.getHttpCode().is4xxClientError()) {
                        wsEventResponse.setEventErrorCode(ProductMarketingConstants.NETWORK_ERR_CODE);
                        wsEventResponse.setEventStatusMessage(wsProductPricingStorResponse.getData());
                    } else {

                        wsEventResponse.setEventErrorCode(ProductMarketingConstants.NETWORK_ERR_CODE);
                        wsEventResponse.setEventStatusMessage(
                                eventProperties.getStoreWSProductDataEndpoint() + ProductMarketingConstants.NETWORK_ERR_MSG);
                    }

                }
                LoggerUtil.info("Response from pushProductData #{}", wsEventResponse);
                return wsEventResponse;
            }
        } catch (ODSException exception) {
            LoggerUtil.info("ODSException #{} ", exception.getRespMsg());
            throw exception;
        } catch (Exception exception) {
            LoggerUtil.info("Exception #{}", exception.getMessage());
            throw new ODSException(ProductMarketingConstants.NETWORK_ERR_CODE, ProductMarketingConstants.NETWORK_ERR_MSG);
        }

    }
	
	/**
	 * Generate WS auth token.
	 *
	 * @param wsAuthResponse the ws auth response
	 * @return the string
	 */
	private String generateWSAuthToken(EventResponse wsAuthResponse) {
        LoggerUtil.info("generating authentication token #{}", wsAuthResponse);
        WebsiteAccessToken websiteAccessToken = applicationUtilities.websiteAccessToken();
        
        String token = websiteAccessToken.getAuthenticationToken();
        if (null != token) {

            wsAuthResponse.setEventErrorCode(ProductMarketingConstants.SUCCESS_CODE);

        } else {
            wsAuthResponse.setEventErrorCode(ProductMarketingConstants.NETWORK_ERR_CODE);
            wsAuthResponse.setEventStatusMessage(
                    eventProperties.getAuthTokenEndpoint() + ProductMarketingConstants.NETWORK_ERR_MSG);
        }
        return token;

    }
    
    /**
     * Prepare WS http headers.
     *
     * @param token the token
     * @return the http headers
     */
    private HttpHeaders prepareWSHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }

    
    /**
     * Fetch product marketing data.
     *
     * @param eventMetadata the event metadata
     * @return the list
     */
    private List<ProductData> fetchProductMarketingData(EventMetadata eventMetadata) {

    	ProductMarketingData productMarketingData=new ProductMarketingData();
        List<ProductData> productData = new ArrayList<>();
        try {

            if (ProductMarketingConstants.EVENT_OBJECT_PRODUCT.equals(eventMetadata.getEventObject())) {
            	productMarketingData = productMarketingRepository.findByProductId(eventMetadata.getEventBusinessID());
                if (null != productMarketingData) {
                	productData=productMarketingData.getProductData();
                	if(!productData.isEmpty())
                	{
                		 return productData;
                	}else {
                        throw new ODSException(ProductMarketingConstants.DATA_NOT_FOUND_CODE,
                                ProductMarketingConstants.DATA_NOT_FOUND_MSG);
                    }

                } else {
                    throw new ODSException(ProductMarketingConstants.DATA_NOT_FOUND_CODE,
                            ProductMarketingConstants.DATA_NOT_FOUND_MSG);
                }

            } 

        } catch (ODSException exception) {
            LoggerUtil.info("DataBase issue while accessing # {}.", exception.getMessage());
            throw exception;

        } catch (Exception exception) {
            LoggerUtil.info("DataBase issue while accessing # {}.", exception.getMessage());
            throw new ODSException(ProductMarketingConstants.DB_INTERNAL_ERROR_CODE, ProductMarketingConstants.DB_INTERNAL_ERROR_MSG);

        }
        return productData;
    }

}
