package com.bicgraphic.ods.odsproductmarketingdata.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:ods_events.properties") 
public class EventProperties {
	
    
    @Value("${service.event.endpoint}")
	private String eventEndpoint;

	@Value("${service.event.storeOdsPushEvents}")
	private String storeOdsPushEvents;
	
	@Value("${service.ws.auth.token.endpoint}")
	private String authTokenEndpoint;
	
	/*@Value("${service.ws.authorize.endpoint}")
	private String authorizeEndpoint;*/
	
	@Value("${service.ws.auth.email.val}")
	private String email;
	
	@Value("${service.ws.auth.password.val}")
	private String password;
	
	@Value("${service.ws.storeProductData}")
	private String storeWSProductDataEndpoint;
	

	public String getEventEndpoint() {
		return eventEndpoint;
	}



	public void setEventEndpoint(String eventEndpoint) {
		this.eventEndpoint = eventEndpoint;
	}



	public String getStoreOdsPushEvents() {
		return storeOdsPushEvents;
	}



	public void setStoreOdsPushEvents(String storeOdsPushEvents) {
		this.storeOdsPushEvents = storeOdsPushEvents;
	}



	public String getAuthTokenEndpoint() {
		return authTokenEndpoint;
	}



	public void setAuthTokenEndpoint(String authTokenEndpoint) {
		this.authTokenEndpoint = authTokenEndpoint;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getStoreWSProductDataEndpoint() {
		return storeWSProductDataEndpoint;
	}



	public void setStoreWSProductDataEndpoint(String storeWSProductDataEndpoint) {
		this.storeWSProductDataEndpoint = storeWSProductDataEndpoint;
	}



	@Override
	public String toString() {
		return "EventProperties [eventEndpoint=" + eventEndpoint + ", storeOdsPushEvents=" + storeOdsPushEvents
				+ ", authTokenEndpoint=" + authTokenEndpoint + ", email=" + email + ", password=" + password
				+ ", storeWSProductDataEndpoint=" + storeWSProductDataEndpoint + "]";
	}

}
