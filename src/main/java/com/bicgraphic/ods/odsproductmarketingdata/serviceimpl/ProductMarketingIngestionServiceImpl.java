package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;
import com.bicgraphic.ods.odsproductmarketingdata.service.ProductMarketingIngestionService;


/**
 * The Class ProductMarketingIngestionServiceImpl.
 */
@Service
public class ProductMarketingIngestionServiceImpl implements ProductMarketingIngestionService {

	/** The event type factory. */
	@Autowired
	Function<String, Function<String, EventObjectTypeService>> eventTypeFactory;
	
	/* (non-Javadoc)
	 * @see com.bicgraphic.ods.odsproductmarketingdata.service.ProductMarketingIngestionService#productMarketingCUD(com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest)
	 */
	@Override
	public String productMarketingCUD(EventRequest eventRequest) {
	    return eventTypeFactory.apply(eventRequest.getEventObject()).apply(eventRequest.getEventType()).performOperation(eventRequest);
	}
}