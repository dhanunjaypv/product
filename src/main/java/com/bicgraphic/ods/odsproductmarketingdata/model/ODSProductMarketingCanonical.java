
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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
    "ProductMarketingData"
})
public class ODSProductMarketingCanonical {

    /**
     * 
     */
    @JsonProperty("ProductMarketingData")
    @Valid
    private ProductMarketingData productMarketingData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The productMarketingData
     */
    @JsonProperty("ProductMarketingData")
    public ProductMarketingData getProductMarketingData() {
        return productMarketingData;
    }

    /**
     * 
     * @param productMarketingData
     *     The ProductMarketingData
     */
    @JsonProperty("ProductMarketingData")
    public void setProductMarketingData(ProductMarketingData productMarketingData) {
        this.productMarketingData = productMarketingData;
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
        return new HashCodeBuilder().append(productMarketingData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ODSProductMarketingCanonical) == false) {
            return false;
        }
        ODSProductMarketingCanonical rhs = ((ODSProductMarketingCanonical) other);
        return new EqualsBuilder().append(productMarketingData, rhs.productMarketingData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
