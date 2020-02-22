/**
 * 
 */
package com.bicgraphic.ods.odsproductmarketingdata.service;

import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadata;
import com.bicgraphic.odsutils.EventResponse;

/**
 * The Interface EventService.
 *
 * @author dhanunjaya.potteti
 */
@Service
public interface EventService {

	/**
	 * Send event meta data.
	 *
	 * @param eventMetadata the event metadata
	 * @param serviceUri the service uri
	 * @param proxyUrl the proxy url
	 * @return the event response
	 */
	public EventResponse sendEventMetaData(EventMetadata eventMetadata,String serviceUri) ;

	
}
