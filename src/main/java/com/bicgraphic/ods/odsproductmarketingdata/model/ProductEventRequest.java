package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EventObject",
    "EventType",
    "EventDateTime",
    "EventSourceSystem",
    "EventBusinessID",
    "ProductData"
})
public class ProductEventRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventObject")
    @NotBlank(message = "{validation.eventObject.notNull}")
    private String eventObject; 
    /**
     * 
     * (Required)
     * 
     */
    
    @JsonProperty("EventType")
    @JsonPropertyDescription("")
    @NotNull(message = "{validation.eventType.notNull}")
    private ProductEventRequest.EventType eventType;
    
 
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventDateTime")
    @NotBlank(message = "{validation.eventDateTime.notNull}")
    private String eventDateTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventSourceSystem")
    @NotBlank(message = "{validation.eventSourceSystem.notNull}")
    private String eventSourceSystem;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventBusinessID")
    @NotBlank(message = "{validation.eventBusinessID.notNull}")
    private String eventBusinessID;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ProductData")
    @Valid
    @NotNull(message = "{validation.productData.notNull}")
    private ProductData productData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventObject
     */
    @JsonProperty("EventObject")
    public String getEventObject() {
        return eventObject;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventObject
     *     The EventObject
     */
    @JsonProperty("EventObject")
    public void setEventObject(String eventObject) {
        this.eventObject = eventObject;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventType
     */
    @JsonProperty("EventType")
    public EventType getEventType() {
        return eventType;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventType
     *     The EventType
     */
    @JsonProperty("EventType")
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventDateTime
     */
    @JsonProperty("EventDateTime")
    public String getEventDateTime() {
        return eventDateTime;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventDateTime
     *     The EventDateTime
     */
    @JsonProperty("EventDateTime")
    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventSourceSystem
     */
    @JsonProperty("EventSourceSystem")
    public String getEventSourceSystem() {
        return eventSourceSystem;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventSourceSystem
     *     The EventSourceSystem
     */
    @JsonProperty("EventSourceSystem")
    public void setEventSourceSystem(String eventSourceSystem) {
        this.eventSourceSystem = eventSourceSystem;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventBusinessID
     */
    @JsonProperty("EventBusinessID")
    public String getEventBusinessID() {
        return eventBusinessID;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventBusinessID
     *     The EventBusinessID
     */
    @JsonProperty("EventBusinessID")
    public void setEventBusinessID(String eventBusinessID) {
        this.eventBusinessID = eventBusinessID;
    }

   

	


	public ProductData getProductData() {
		return productData;
	}

	public void setProductData(ProductData productData) {
		this.productData = productData;
	}

	@Override
	public String toString() {
		return "EventRequest [eventObject=" + eventObject + ", eventType=" + eventType + ", eventDateTime="
				+ eventDateTime + ", eventSourceSystem=" + eventSourceSystem + ", eventBusinessID=" + eventBusinessID
				+ ", productData=" + productData + ", additionalProperties=" + additionalProperties + "]";
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventObject).append(eventType).append(eventDateTime).append(eventSourceSystem).append(eventBusinessID).append(productData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductEventRequest) == false) {
            return false;
        }
        ProductEventRequest rhs = ((ProductEventRequest) other);
        return new EqualsBuilder().append(eventObject, rhs.eventObject).append(eventType, rhs.eventType).append(eventDateTime, rhs.eventDateTime).append(eventSourceSystem, rhs.eventSourceSystem).append(eventBusinessID, rhs.eventBusinessID).append(productData, rhs.productData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public enum EventType {

        CREATE("CREATE"),
        UPDATE("UPDATE"),
        DELETE("DELETE"),
        UPSERT("UPSERT");
        private final String value;
        private final static Map<String, ProductEventRequest.EventType> CONSTANTS = new HashMap<String, ProductEventRequest.EventType>();

        static {
            for (ProductEventRequest.EventType c: values()) {
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
        public static ProductEventRequest.EventType fromValue(String value) {
            ProductEventRequest.EventType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
}
