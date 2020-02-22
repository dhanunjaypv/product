
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EventObject",
    "EventType",
    "EventDateTime",
    "EventSourceSystem",
    "EventBusinessID",
    
    "ProductData",
    "ProductShippingInfo",
    "ProductOrg",
    "ProductAttributeData"
})
public class EventRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventObject")
    @NotNull
    private String eventObject;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventType")
    @NotNull
    private String eventType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventDateTime")
    @NotNull
    private String eventDateTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventSourceSystem")
    @NotNull
    private String eventSourceSystem;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventBusinessID")
    @NotNull
    private String eventBusinessID;

    @Transient
    private Boolean logEvent;

    
    /**
     * 
     */
    
    

    @JsonProperty("ProductData")
    @Valid
    private List<ProductData> productData;
    
    @JsonProperty("ProductShippingInfo")
    @Valid
    private ProductAlertInfo productAlertInfo;
    
    @JsonProperty("ProductOrg")
    @Valid
    private List<ProductOrg> productOrg;
    
    
    @JsonProperty("ProductAttributeData")
    @Valid
    private List<ProductAttributeData> productAttributeData;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

   

	public String getEventObject() {
		return eventObject;
	}


	public void setEventObject(String eventObject) {
		this.eventObject = eventObject;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public String getEventDateTime() {
		return eventDateTime;
	}


	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}


	public String getEventSourceSystem() {
		return eventSourceSystem;
	}


	public void setEventSourceSystem(String eventSourceSystem) {
		this.eventSourceSystem = eventSourceSystem;
	}


	public String getEventBusinessID() {
		return eventBusinessID;
	}


	public void setEventBusinessID(String eventBusinessID) {
		this.eventBusinessID = eventBusinessID;
	}


	public List<ProductData> getProductData() {
		return productData;
	}


	public void setProductData(List<ProductData> productData) {
		this.productData = productData;
	}



	public ProductAlertInfo getProductAlertInfo() {
		return productAlertInfo;
	}


	public void setProductAlertInfo(ProductAlertInfo productAlertInfo) {
		this.productAlertInfo = productAlertInfo;
	}


	public List<ProductOrg> getProductOrg() {
		return productOrg;
	}


	public void setProductOrg(List<ProductOrg> productOrg) {
		this.productOrg = productOrg;
	}


	public List<ProductAttributeData> getProductAttributeData() {
		return productAttributeData;
	}


	public void setProductAttributeData(List<ProductAttributeData> productAttributeData) {
		this.productAttributeData = productAttributeData;
	}
	
	public Boolean getLogEvent() {
        return logEvent;
    }


    public void setLogEvent(Boolean logEvent) {
        this.logEvent = logEvent;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventObject).append(eventType).append(eventDateTime).append(eventSourceSystem).append(eventBusinessID).append(productAlertInfo).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventRequest) == false) {
            return false;
        }
        EventRequest rhs = ((EventRequest) other);
        return new EqualsBuilder().append(eventObject, rhs.eventObject).append(eventType, rhs.eventType).append(eventDateTime, rhs.eventDateTime).append(eventSourceSystem, rhs.eventSourceSystem).append(eventBusinessID, rhs.eventBusinessID).append(productAlertInfo, rhs.productAlertInfo).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    public enum EventType {

        CREATE("CREATE"),
        UPDATE("UPDATE"),
        DELETE("DELETE"),
    	UPSERT("UPSERT");
        private final String value;
        private final static Map<String, EventRequest.EventType> CONSTANTS = new HashMap<String, EventRequest.EventType>();

        static {
            for (EventRequest.EventType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private EventType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static EventRequest.EventType fromValue(String value) {
            EventRequest.EventType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
}
