package com.bicgraphic.ods.odsproductmarketingdata.service;

import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;

/**
 * The Interface ProductMarketingIngestionService.
 */
@Service
public interface ProductMarketingIngestionService {
	
	/**
	 * Product marketing CUD.
	 *
	 * @param eventRequest the event request
	 * @return the string
	 */
	String productMarketingCUD(EventRequest eventRequest);
	
}
