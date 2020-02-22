package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationRouter;
import com.bicgraphic.ods.odsproductmarketingdata.common.ApplicationUtilities;
import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.common.RouterResponse;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventService;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class EventServiceImpl.
 */
@Service
public class EventServiceImpl implements EventService {

	/** The application router. */
	@Autowired
	private ApplicationRouter applicationRouter;
	
	/** The application utilities. */
	@Autowired
	private ApplicationUtilities applicationUtilities;
	
	/* (non-Javadoc)
	 * @see com.bicgraphic.ods.odsproductmarketingdata.service.EventService#sendEventMetaData(com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata, java.lang.String, java.lang.String)
	 */
	@Override
	public EventResponse sendEventMetaData(EventMetadata eventMetadata,String serviceUri) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			
			RouterResponse serviceResponse = applicationRouter.invokeService(serviceUri,applicationUtilities.prepareHttpHeaders(),HttpMethod.POST,eventMetadata);
			LoggerUtil.info("response from event #{}", serviceResponse);
			if (serviceResponse.getHttpCode().is2xxSuccessful()) {
			return objectMapper.readValue(serviceResponse.getData(), EventResponse.class);
			}else {
				throw new ODSException(serviceResponse.getHttpCode().toString(),serviceResponse.getData());
			}
		} catch (ODSException exception) {
			LoggerUtil.info("Custom Exception While Sending EventMetaData #{}", exception.getRespMsg());
			throw new ODSException(exception.getRespCode(), exception.getRespMsg());
		} catch (Exception exception) {
			LoggerUtil.info("Exception #{}", exception.getMessage());
			throw new ODSException(ProductMarketingConstants.DATA_CONVERTION_FAIL_CODE, ProductMarketingConstants.DATA_CONVERTION_FAIL_MSG);
		}
	}
	
	

}
