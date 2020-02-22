package com.bicgraphic.ods.odsproductmarketingdata.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationUtilities;
import com.bicgraphic.ods.odsproductmarketingdata.common.EventProperties;
import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventDMResponse;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadataDM;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventService;
import com.bicgraphic.ods.odsproductmarketingdata.service.WebsiteProductMarketingService;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

/**
 * The Class WebsiteProductMarketingDataController.
 */
@Controller
public class WebsiteProductMarketingDataController {
	
	/** The website product marketing service. */
	@Autowired
	private WebsiteProductMarketingService websiteProductMarketingService;
	/** The application utilities. */
	@Autowired
	private ApplicationUtilities applicationUtilities;

	/** The event service. */
	@Autowired
	private EventService eventService;

	
	/** The event props. */
	@Autowired
	private EventProperties eventProps;

	
	/**
	 * Push website product marketing data.
	 *
	 * @param eventMetaDataDM the event meta data DM
	 * @param bindingResult the binding result
	 * @return the response entity
	 */
	@PostMapping(value = "/websiteProductMarketingData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventDMResponse> pushWebsiteProductMarketingData(
			@Valid @RequestBody EventMetadataDM eventMetaDataDM,BindingResult bindingResult) {
		LoggerUtil.info("WS request object #{}", eventMetaDataDM);
		EventDMResponse eventDMResponse = new EventDMResponse();
		EventResponse wsEventResponse = new EventResponse();
		EventMetadata eventMetadata = eventMetaDataDM.getEventMetadata();
		wsEventResponse.setEventBusinessID(eventMetadata.getEventBusinessID());
		List<String> responseList = new ArrayList<>();
		try {
			boolean validationFlag = applicationUtilities.preValidateForPull(eventMetadata, responseList, bindingResult);
			if (!validationFlag) {
				wsEventResponse = websiteProductMarketingService.pushProductMarketingData(eventMetaDataDM);
				if (wsEventResponse.getEventStatus().value().equalsIgnoreCase(ProductMarketingConstants.SUCCESS_STATUS)) {
					applicationUtilities.prepareSuccessResponse(wsEventResponse, wsEventResponse.getEventErrorCode(),
							wsEventResponse.getEventStatusMessage());
					eventMetadata.setEventSourceSystem("ODS-TO-WS");
					
				} else {
					applicationUtilities.prepareErrDetailsResponse(wsEventResponse, wsEventResponse.getEventErrorCode(),
							wsEventResponse.getEventStatusMessage());
				}

			} else {
				LoggerUtil.info("Event object is empty or Not Matching #{}", eventMetadata);
				applicationUtilities.prepareErrDetailsResponse(wsEventResponse,
						ProductMarketingConstants.INV_STRUCTURE_CODE, String.join(",", responseList));
			}
		} catch (ODSException exception) {
			LoggerUtil.info("warning error while sending product marketing data to ws  #{}", exception.getRespMsg());
			applicationUtilities.prepareErrDetailsResponse(wsEventResponse, exception.getRespCode(),
					exception.getRespMsg());
		} catch (Exception exception) {
			LoggerUtil.info("Error while sending product marketing data to ws  #{}", exception.getMessage());
			applicationUtilities.prepareErrDetailsResponse(wsEventResponse, ProductMarketingConstants.UNKNOWN_ERR_CODE,
					ProductMarketingConstants.UNKNOWN_ERR_MSG);
		}
		finally{
			try {
				eventMetadata.setReasonCode(wsEventResponse.getEventErrorCode());
				eventMetadata.setReasonDescription(wsEventResponse.getEventStatusMessage());
				eventMetadata.setStatus(wsEventResponse.getEventStatus().value());
				eventMetadata.setEventSourceSystem("ODS-TO-WS");
				EventResponse eventMetaDataRes = eventService.sendEventMetaData(eventMetadata,
						eventProps.getStoreOdsPushEvents());
				wsEventResponse.setEnterpriseEventID(eventMetaDataRes.getEnterpriseEventID());
			} catch (ODSException exception) {
				LoggerUtil.info("Error while sending EventMetaData  #{}", exception.getRespMsg());
				applicationUtilities.prepareErrDetailsResponse(wsEventResponse, exception.getRespCode(),
						exception.getRespMsg());
			}
		}
		wsEventResponse.setEventBusinessID(eventMetadata.getEventBusinessID());
		eventDMResponse.setEventResponse(wsEventResponse);
		LoggerUtil.info("Website product marketing responce object #{}", eventDMResponse);
		return new ResponseEntity<>(eventDMResponse, HttpStatus.OK);

	}

	
}
