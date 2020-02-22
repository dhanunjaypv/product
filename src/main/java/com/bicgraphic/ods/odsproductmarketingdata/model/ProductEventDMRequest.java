
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
public class ProductEventDMRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventRequest")
    @Valid
    @NotNull(message = "{validation.eventRequest.notNull}")
    private ProductEventRequest eventRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	

	public ProductEventRequest getEventRequest() {
		return eventRequest;
	}

	public void setEventRequest(ProductEventRequest eventRequest) {
		this.eventRequest = eventRequest;
	}

	@Override
	public String toString() {
		return "ProductEventDMRequest [eventRequest=" + eventRequest + ", additionalProperties=" + additionalProperties
				+ "]";
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
        if ((other instanceof ProductEventDMRequest) == false) {
            return false;
        }
        ProductEventDMRequest rhs = ((ProductEventDMRequest) other);
        return new EqualsBuilder().append(eventRequest, rhs.eventRequest).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
