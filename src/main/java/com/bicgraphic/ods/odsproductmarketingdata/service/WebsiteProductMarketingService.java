package com.bicgraphic.ods.odsproductmarketingdata.service;

import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadataDM;
import com.bicgraphic.odsutils.EventResponse;

/**
 * The Interface WebsiteProductMarketingService.
 */
@Service
public interface WebsiteProductMarketingService {

	/**
	 * Push product marketing data.
	 *
	 * @param eventMetaDataDM the event meta data DM
	 * @return the event response
	 */
	EventResponse pushProductMarketingData(EventMetadataDM eventMetaDataDM);

}
