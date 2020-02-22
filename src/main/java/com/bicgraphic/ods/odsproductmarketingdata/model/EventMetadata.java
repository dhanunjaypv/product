
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
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


/**
 * Customer Event Request from source system describing the kind of event and the customer data being edited
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EventObject",
    "EventType",
    "EventDateTime",
    "EventSourceSystem",
    "EventBusinessID",
    "EventDatabaseName",
    "EventCollectionName"
})
public class EventMetadata {

    /**
     * The type of event object being transmitted from source system
     * (Required)
     * 
     */
    @JsonProperty("EventObject")
    @JsonPropertyDescription("")
    @NotBlank(message = "{validation.eventObject.notNull}")
    private String eventObject;
    /**
     * The type of event data being transmitted from source system. Create / Update /Delete
     * (Required)
     * 
     */
    @JsonProperty("EventType")
    @JsonPropertyDescription("")
    @NotNull(message = "{validation.eventType.notNull}")
    private EventMetadata.EventType eventType;
    /**
     * The date and time at which the even occurred in the source system
     * (Required)
     * 
     */
    @JsonProperty("EventDateTime")
    @JsonPropertyDescription("")
    @NotBlank(message = "{validation.eventDateTime.notNull}")
    private String eventDateTime;
    /**
     * The source system at which the event occured
     * (Required)
     * 
     */
    @JsonProperty("EventSourceSystem")
    @JsonPropertyDescription("")
   @NotBlank(message = "{validation.eventSourceSystem.notNull}")
    private String eventSourceSystem;
    /**
     * Business event ID for which the data is being transmitted in the current event
     * (Required)
     * 
     */
    @JsonProperty("EventBusinessID")
    @JsonPropertyDescription("")
    @NotBlank(message = "{validation.eventBusinessID.notNull}")
    private String eventBusinessID;
    /**
     * Mongo DB Database Name to extract event data for associated Event Object
     * (Required)
     * 
     */
    @JsonProperty("EventDatabaseName")
    @JsonPropertyDescription("")
    private String eventDatabaseName;
    /**
     * Mongo DB Collection Name to extract event data for associated Event Object
     * (Required)
     * 
     */
    @JsonProperty("EventCollectionName")
    @JsonPropertyDescription("")
    private String eventCollectionName;
    
//  "Status",
  @JsonProperty("Status")
  @JsonPropertyDescription("")
  private String status;
  
//  "ReasonCode",
  @JsonProperty("ReasonCode")
  @JsonPropertyDescription("")
  private String reasonCode;
  
//  "ReasonDescription"
  @JsonProperty("ReasonDescription")
  @JsonPropertyDescription("")
  private String reasonDescription;
  
    public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getReasonCode() {
	return reasonCode;
}

public void setReasonCode(String reasonCode) {
	this.reasonCode = reasonCode;
}

public String getReasonDescription() {
	return reasonDescription;
}

public void setReasonDescription(String reasonDescription) {
	this.reasonDescription = reasonDescription;
}

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The type of event object being transmitted from source system
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
     * The type of event object being transmitted from source system
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
     * The type of event data being transmitted from source system. Create / Update /Delete
     * (Required)
     * 
     * @return
     *     The eventType
     */
    @JsonProperty("EventType")
    public EventMetadata.EventType getEventType() {
        return eventType;
    }

    /**
     * The type of event data being transmitted from source system. Create / Update /Delete
     * (Required)
     * 
     * @param eventType
     *     The EventType
     */
    @JsonProperty("EventType")
    public void setEventType(EventMetadata.EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * The date and time at which the even occurred in the source system
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
     * The date and time at which the even occurred in the source system
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
     * The source system at which the event occured
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
     * The source system at which the event occured
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
     * Business event ID for which the data is being transmitted in the current event
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
     * Business event ID for which the data is being transmitted in the current event
     * (Required)
     * 
     * @param eventBusinessID
     *     The EventBusinessID
     */
    @JsonProperty("EventBusinessID")
    public void setEventBusinessID(String eventBusinessID) {
        this.eventBusinessID = eventBusinessID;
    }

    /**
     * Mongo DB Database Name to extract event data for associated Event Object
     * (Required)
     * 
     * @return
     *     The eventDatabaseName
     */
    @JsonProperty("EventDatabaseName")
    public String getEventDatabaseName() {
        return eventDatabaseName;
    }

    /**
     * Mongo DB Database Name to extract event data for associated Event Object
     * (Required)
     * 
     * @param eventDatabaseName
     *     The EventDatabaseName
     */
    @JsonProperty("EventDatabaseName")
    public void setEventDatabaseName(String eventDatabaseName) {
        this.eventDatabaseName = eventDatabaseName;
    }

    /**
     * Mongo DB Collection Name to extract event data for associated Event Object
     * (Required)
     * 
     * @return
     *     The eventCollectionName
     */
    @JsonProperty("EventCollectionName")
    public String getEventCollectionName() {
        return eventCollectionName;
    }

    /**
     * Mongo DB Collection Name to extract event data for associated Event Object
     * (Required)
     * 
     * @param eventCollectionName
     *     The EventCollectionName
     */
    @JsonProperty("EventCollectionName")
    public void setEventCollectionName(String eventCollectionName) {
        this.eventCollectionName = eventCollectionName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
        return new HashCodeBuilder().append(eventObject).append(eventType).append(eventDateTime).append(eventSourceSystem).append(eventBusinessID).append(eventDatabaseName).append(eventCollectionName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventMetadata) == false) {
            return false;
        }
        EventMetadata rhs = ((EventMetadata) other);
        return new EqualsBuilder().append(eventObject, rhs.eventObject).append(eventType, rhs.eventType).append(eventDateTime, rhs.eventDateTime).append(eventSourceSystem, rhs.eventSourceSystem).append(eventBusinessID, rhs.eventBusinessID).append(eventDatabaseName, rhs.eventDatabaseName).append(eventCollectionName, rhs.eventCollectionName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public enum EventType {

        CREATE("CREATE"),
        UPDATE("UPDATE"),
        UPSERT("UPSERT"),
        DELETE("DELETE");
        private final String value;
        private final static Map<String, EventMetadata.EventType> CONSTANTS = new HashMap<String, EventMetadata.EventType>();

        static {
            for (EventMetadata.EventType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private EventType(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
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
        public static EventMetadata.EventType fromValue(String value) {
            EventMetadata.EventType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
