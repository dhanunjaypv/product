package com.bicgraphic.ods.odsproductmarketingdata.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationUtilities;
import com.bicgraphic.ods.odsproductmarketingdata.common.EventProperties;
import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventDMResponse;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingDataDMRequest;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventService;
import com.bicgraphic.ods.odsproductmarketingdata.service.ProductMarketingIngestionService;
import com.bicgraphic.odsutils.APIInfo;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;

/**
 * The Class ProductMarketingDataIngestionAPIController.
 */
@RestController
public class ProductMarketingDataIngestionAPIController {

    /** The product marketing ingestion service. */
    @Autowired
    private ProductMarketingIngestionService productMarketingIngestionService;

    /** The event service. */
    @Autowired
    EventService eventService;
    
    /** The event properties. */
    @Autowired
    EventProperties eventProperties;
    
    /** The application utilities. */
    @Autowired
    private ApplicationUtilities applicationUtilities;

    /** The build properties. */
	@Autowired
	private BuildProperties buildProperties;

    /**
     * Product CUD.
     *
     * @param productMarketingDataDMRequest the product marketing data DM request
     * @param bindingResults the binding results
     * @return the response entity
     */
    @PostMapping(value = "/ProductMarketingIngestionAPI", consumes = {
            MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDMResponse> productCUD(@Valid @RequestBody ProductMarketingDataDMRequest productMarketingDataDMRequest,
            BindingResult bindingResult) {
        LoggerUtil.info("Push Request ProductMarketingDataDMRequest Object #{}", productMarketingDataDMRequest);
        EventRequest eventRequest = productMarketingDataDMRequest.getEventRequest();
        String operationResponse = null;
        List<String> responseList = new ArrayList<>();
        EventDMResponse eventDMResponse = new EventDMResponse();
        EventResponse eventResponse = new EventResponse();
       
        try {

            boolean validationflag = applicationUtilities.preValidate(productMarketingDataDMRequest, responseList,bindingResult);
            if (validationflag)
            {
                LoggerUtil.info("validationflag#{} ,validationResponselist cud Req #{}", validationflag, responseList);
                applicationUtilities.prepareErrDetailsResponse(eventResponse, ProductMarketingConstants.INV_INPUT_CODE,String.join(",", responseList));
            } 
            else 
            {
                operationResponse = productMarketingIngestionService.productMarketingCUD(eventRequest);
                if (operationResponse != null && operationResponse.equalsIgnoreCase(ProductMarketingConstants.SUCCESS_STATUS)) 
                {
                 applicationUtilities.prepareSuccessResponse(eventResponse, ProductMarketingConstants.SUCCESS_CODE,eventRequest.getEventType() + ProductMarketingConstants.SUCCESS_MSG);
                }
                else 
                {
                 applicationUtilities.prepareErrDetailsResponse(eventResponse, ProductMarketingConstants.FAIL_CODE,eventRequest.getEventType() + ProductMarketingConstants.FAIL_MSG);
                }
            }
        }catch (ODSException exception) {
			LoggerUtil.info("Error While Operating productMarketingCUD Operatoins #{}", exception.getRespMsg());
			applicationUtilities.prepareErrDetailsResponse(eventResponse, exception.getRespCode(),
					exception.getRespMsg());
		} catch (Exception exception) {
			LoggerUtil.info("Error While Operating productMarketingCUD Operatoins #{}", exception.getMessage());
			applicationUtilities.prepareErrDetailsResponse(eventResponse, ProductMarketingConstants.UNKNOWN_ERR_CODE,ProductMarketingConstants.UNKNOWN_ERR_MSG);
		}
        finally {
            if(eventRequest.getLogEvent() == null || Boolean.TRUE.equals(eventRequest.getLogEvent())) {
    			try {
    				EventMetadata eventMetadata = applicationUtilities.buildEventMetaData(eventRequest);
    				eventMetadata.setEventSourceSystem(eventRequest.getEventSourceSystem());
    				EventResponse eventMetaDataRes = eventService.sendEventMetaData(eventMetadata,
    						eventProperties.getEventEndpoint());
    				eventResponse.setEnterpriseEventID(eventMetaDataRes.getEnterpriseEventID());
    			} catch (ODSException exception) {
    				LoggerUtil.info("Error while sending EventMetaData  #{}", exception.getRespMsg());
    				applicationUtilities.prepareErrDetailsResponse(eventResponse, exception.getRespCode(),
    						exception.getRespMsg());
    			}
            }
		}
        eventResponse.setEventBusinessID(eventRequest.getEventBusinessID());
        eventDMResponse.setEventResponse(eventResponse);
        LoggerUtil.info("Push Request Response Object: {} ", eventDMResponse);
        return new ResponseEntity<>(eventDMResponse, HttpStatus.OK);

    }
    
    /**
	 * Gets the version.
	 *
	 * @return the version
	 */
	@GetMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getVersion() {
		APIInfo apiInfo = new APIInfo();
		apiInfo.setBuildNumber(buildProperties.getVersion());
		return new ResponseEntity<>(apiInfo, HttpStatus.OK);
	}

	/**
	 * Gets the diagnostics.
	 *
	 * @return the diagnostics
	 */
	@GetMapping(value = "/diagnostics", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDiagnostics() {
		APIInfo apiInfo = new APIInfo();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// Getting the DB config from Properties file and checking the
			// connection
			ClassLoader classLoader = this.getClass().getClassLoader();
			input = classLoader.getResourceAsStream(ProductMarketingConstants.INTEGRATION_MONGO_PROPERITIES);
			Builder builder = MongoClientOptions.builder().connectTimeout(300);
			prop.load(input);
			String hostName = prop.getProperty(ProductMarketingConstants.MONGO_HOSTNAME);
			String port = prop.getProperty(ProductMarketingConstants.MONGO_PORT);
			apiInfo.setMongoPropertyFile(ProductMarketingConstants.MONGO_DB_FILE_ACCESS_SUCCESS_MSG);
			try (MongoClient mongo = new MongoClient(new ServerAddress(hostName, Integer.parseInt(port)),
					builder.build());) {
				mongo.getAddress();
			}
			apiInfo.setMongoConnection(ProductMarketingConstants.MONGO_DB_SUCCESS_MSG);
		} catch (NullPointerException exception) {
			LoggerUtil.info("NullPointerException #{}", exception.getMessage());
			apiInfo.setMongoPropertyFile(ProductMarketingConstants.MONGO_DB_FILE_ACCESS_FAILED_MSG);
		} catch (MongoTimeoutException exception) {
			LoggerUtil.info("Error while processing Diagnostics operation #{}", exception.getMessage());
			apiInfo.setMongoConnection(ProductMarketingConstants.MONGO_DB_FAILED_MSG);
		} catch (Exception exception) {
			LoggerUtil.info("Error while processing Diagnostics operation #{}", exception.getMessage());
			throw new ODSException(ProductMarketingConstants.UNKNOWN_ERR_CODE, ProductMarketingConstants.UNKNOWN_ERR_MSG);
		}

		return new ResponseEntity<>(apiInfo, HttpStatus.OK);
	}

}
