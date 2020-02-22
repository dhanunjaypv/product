package com.bicgraphic.ods.odsproductmarketingdata.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata.EventType;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductData;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductEventDMRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductEventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingDataDMRequest;
import com.bicgraphic.odsutils.CommonUtils;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSConstants;
import com.bicgraphic.odsutils.ODSException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The Class ApplicationUtilities.
 */
@Component
public class ApplicationUtilities extends CommonUtils{ 
  

	/**
	 * Pre validate.
	 *
	 * @param productEventDMRequestJson the product event DM request json
	 * @param errorResponseList the error response list
	 * @param bindingResult the binding result
	 * @return true, if successful
	 */
	public boolean preValidate(ProductMarketingDataDMRequest productEventDMRequestJson, List<String> errorResponseList, BindingResult bindingResult) {
		
		EventRequest eventRequest = productEventDMRequestJson.getEventRequest();
		boolean validationFlag = false;
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				errorResponseList.add(error.getDefaultMessage()+" in "+eventRequest.getEventObject());
			}
			validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
		}
			
		else {
			if(!Arrays.asList(ProductMarketingConstants.EVENT_OBJECTS.split("\\s*,\\s*")).contains(eventRequest.getEventObject())){
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
				errorResponseList.add(ProductMarketingConstants.EVENT_OBJECT_ERR_MSG);
			}
			if(eventRequest.getEventObject().equals("ENTERPRISEPRODUCT") && !eventRequest.getEventBusinessID().equalsIgnoreCase(eventRequest.getProductData().get(0).getProductId()))
			{
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
				errorResponseList.add(ProductMarketingConstants.EVENTBUSINESSID_PRODUCTID_ERR_MSG+eventRequest.getEventObject());
			}
			else if(eventRequest.getEventObject().equals("PRODUCTORG") && !eventRequest.getEventBusinessID().equalsIgnoreCase(eventRequest.getProductOrg().get(0).getProductId()))
			{
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
				errorResponseList.add(ProductMarketingConstants.EVENTBUSINESSID_PRODUCTID_ERR_MSG+eventRequest.getEventObject());
			}
			else if(eventRequest.getEventObject().equals("PRODUCTALERT") && !eventRequest.getEventBusinessID().equalsIgnoreCase(eventRequest.getProductAlertInfo().getProductId()))
			{
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
				errorResponseList.add(ProductMarketingConstants.EVENTBUSINESSID_PRODUCTID_ERR_MSG+eventRequest.getEventObject());
			}
			else if(eventRequest.getEventObject().equals("PRODUCTATTRIBUTE") && !eventRequest.getEventBusinessID().equalsIgnoreCase(eventRequest.getProductAttributeData().get(0).getProductId()))
			{
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
				errorResponseList.add(ProductMarketingConstants.EVENTBUSINESSID_PRODUCTID_ERR_MSG+eventRequest.getEventObject());
			}
			
		}
		LoggerUtil.info("preValidate method errorResponseList #{} ",errorResponseList);
		return validationFlag;
	}
	
	/**
	 * Builds the event meta data.
	 *
	 * @param eventRequest the event request
	 * @return the event metadata
	 */
	public EventMetadata buildEventMetaData(EventRequest eventRequest) {
		EventMetadata eventMetadata=new EventMetadata();
		eventMetadata.setEventBusinessID(eventRequest.getEventBusinessID());
		eventMetadata.setEventDateTime(eventRequest.getEventDateTime());
		eventMetadata.setEventObject(eventRequest.getEventObject());
		eventMetadata.setEventType(EventType.fromValue(eventRequest.getEventType()));
		return eventMetadata;
	}
	
	/**
	 * Prepare http headers.
	 *
	 * @return the http headers
	 */
	public HttpHeaders prepareHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
	
	/* (non-Javadoc)
	 * @see com.bicgraphic.odsutils.CommonUtils#prepareErrDetailsResponse(com.bicgraphic.odsutils.EventResponse, java.lang.String, java.lang.String)
	 */
	// preparing ERROR Response
    public void prepareErrDetailsResponse(EventResponse eventResponse, String code, String msg) {
        eventResponse.setEventErrorCode(code);
        eventResponse.setEventStatusMessage(msg);
        eventResponse.setMustRetryFlag(ODSConstants.TRUE_FLG_BOOLEAN);
        eventResponse.setEventStatus(EventResponse.EventStatus.ERROR);
    }

    /* (non-Javadoc)
     * @see com.bicgraphic.odsutils.CommonUtils#prepareSuccessResponse(com.bicgraphic.odsutils.EventResponse, java.lang.String, java.lang.String)
     */
    // preparing SUCCESS Response
    public void prepareSuccessResponse(EventResponse eventResponse, String code, String msg) {
        eventResponse.setEventStatusMessage(msg);
        eventResponse.setMustRetryFlag(ODSConstants.FALSE_FLG_BOOLEAN);
        eventResponse.setEventStatus(EventResponse.EventStatus.SUCCESS);
    }
    
    /**
     * Pre validate for pull.
     *
     * @param eventMetadata the event metadata
     * @param responseList the response list
     * @param bindingResult the binding result
     * @return true, if successful
     */
    public boolean preValidateForPull(EventMetadata eventMetadata, List<String> responseList,
			BindingResult bindingResult) {
		LoggerUtil.info("preValidating Product Price Event Request Object #{} ", eventMetadata);
		boolean validationFlag = ProductMarketingConstants.FALSE_FLG_BOOLEAN;
		
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				responseList.add(error.getDefaultMessage());
			}
			validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
		}
		else{
				if (!eventMetadata.getEventObject().equals(ProductMarketingConstants.EVENT_OBJECT_PRODUCT)) {
				responseList.add(ProductMarketingConstants.EVENT_OBJECT_PRODUCT_ERR_MSG);
				validationFlag = ProductMarketingConstants.TRUE_FLG_BOOLEAN;
			}
			}
			LoggerUtil.info("preValidate method errorResponseList #{} ", responseList);
			return validationFlag;
	}
	
   
	/**
	 * Convert type reference.
	 *
	 * @param <T>
	 *            the generic type
	 * @param reqJson
	 *            the req json
	 * @param clazz
	 *            the clazz
	 * @return the t
	 */
	public <T> T convertTypeReference(String reqJson, Class<T> clazz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(reqJson, clazz);
		} catch (Exception exception) {
			LoggerUtil.info("Error : while convertion request to bean class#{}", exception.getMessage());
			throw new ODSException(ProductMarketingConstants.DATA_CONVERTION_FAIL_CODE,ProductMarketingConstants.DATA_CONVERTION_FAIL_MSG+exception.getMessage());
		}
	
	}
	
	
	/**
	 * Prepare product data event request.
	 *
	 * @param eventMetadata the event metadata
	 * @param productData the product data
	 * @return the string
	 */
	public String prepareProductDataEventRequest(EventMetadata eventMetadata,List<ProductData> productData) {

		ProductEventDMRequest productEventDMRequest = new ProductEventDMRequest();
		try {
			LoggerUtil.info("preparing productEventDMRequest to push to WS #{} #{}", eventMetadata, productData);

			ProductEventRequest eventRequest = new ProductEventRequest();
			BeanUtils.copyProperties(eventMetadata, eventRequest);

			eventRequest.setEventType(ProductEventRequest.EventType.fromValue(eventMetadata.getEventType().value()));
			for(ProductData productDataList:productData)
			{
				productDataList.setOdsLastModifiedDate(null);
			}
			eventRequest.setProductData(productData.get(0));
			productEventDMRequest.setEventRequest(eventRequest);
			return new ObjectMapper().writeValueAsString(productEventDMRequest);
		} catch (Exception exception) {
			LoggerUtil.info("Exception:preparing productEventDMRequest to push to WS ", exception.getMessage());
			throw new ODSException(ProductMarketingConstants.REQ_BUILD_FAIL_CODE, ProductMarketingConstants.REQ_BUILD_FAIL_MSG);
		}

	}
}
