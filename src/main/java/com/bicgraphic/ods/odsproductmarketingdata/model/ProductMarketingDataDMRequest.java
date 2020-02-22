
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EventRequest"
})
public class ProductMarketingDataDMRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventRequest")
    @Valid
    @NotNull(message = "{validation.eventRequest.notNull}")
    private EventRequest eventRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventRequest
     */
    @JsonProperty("EventRequest")
    public EventRequest getEventRequest() {
        return eventRequest;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventRequest
     *     The EventRequest
     */
    @JsonProperty("EventRequest")
    public void setEventRequest(EventRequest eventRequest) {
        this.eventRequest = eventRequest;
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
        return new HashCodeBuilder().append(eventRequest).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductMarketingDataDMRequest) == false) {
            return false;
        }
        ProductMarketingDataDMRequest rhs = ((ProductMarketingDataDMRequest) other);
        return new EqualsBuilder().append(eventRequest, rhs.eventRequest).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
