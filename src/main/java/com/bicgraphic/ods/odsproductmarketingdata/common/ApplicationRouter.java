package com.bicgraphic.ods.odsproductmarketingdata.common;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSConstants;
import com.bicgraphic.odsutils.ODSException;

/**
 * The Class ApplicationRouter.
 */
@Component
public class ApplicationRouter {



	/**
	 * Invoke post service.
	 *
	 * @param serviceName the service URL
	 * @param requestObj the request obj
	 * @return the string
	 */
	public RouterResponse invokeService(String serviceName, HttpHeaders headers,HttpMethod method,Object requestObj) {
		LoggerUtil.info("Router Request serviceName requestObj {}{}#", serviceName,requestObj);
		//SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	   /* Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(proxyUrl, 3128));
	    requestFactory.setProxy(proxy);*/
	    RestTemplate restTemplate = new RestTemplate();
		RouterResponse routerResponse = new RouterResponse();
		ResponseEntity<String> eventResponse=null;
		try { 
			restTemplate.getMessageConverters()
	        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
			
			eventResponse = restTemplate.exchange(serviceName, method,
					new HttpEntity<>(requestObj, headers), String.class);
				
				routerResponse.setHttpCode(eventResponse.getStatusCode());
				routerResponse.setData(eventResponse.getBody());
				LoggerUtil.info("Router Response {}#", routerResponse);
			
		} catch (HttpStatusCodeException exception) {
			LoggerUtil.info("Router Bad Response #{}", exception.getResponseBodyAsString());
			routerResponse.setHttpCode(exception.getStatusCode());
			routerResponse.setData(exception.getResponseBodyAsString());
		} catch (Exception exception) {
			LoggerUtil.info("Router Bad Response #{}", exception.getMessage());
			throw new ODSException(ODSConstants.NETWORK_ERR_CODE,serviceName+ ",Issue:" + ODSConstants.NETWORK_ERR_MSG + exception.getMessage());
			
		}
		return routerResponse;
	}

	
}
