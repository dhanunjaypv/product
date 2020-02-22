
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
    "productId",
    "productAlertsArray"
})
public class ProductAlertInfo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ProductId")
    @NotNull
    private String productId;
    @JsonProperty("ProductAlertsArray")
    @Valid
    private ProductAlertsArray productAlertsArray;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * (Required)
     * 
     * @param productId
     *     The productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The productAlertsArray
     */
    public ProductAlertsArray getProductAlertsArray() {
        return productAlertsArray;
    }

    /**
     * 
     * @param productAlertsArray
     *     The productAlertsArray
     */
    public void setProductAlertsArray(ProductAlertsArray productAlertsArray) {
        this.productAlertsArray = productAlertsArray;
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
        return new HashCodeBuilder().append(productId).append(productAlertsArray).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductAlertInfo) == false) {
            return false;
        }
        ProductAlertInfo rhs = ((ProductAlertInfo) other);
        return new EqualsBuilder().append(productId, rhs.productId).append(productAlertsArray, rhs.productAlertsArray).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
