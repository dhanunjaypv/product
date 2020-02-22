
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productAlerts"
})
public class ProductAlertsArray {

    @JsonProperty("ProductAlerts")
    @Valid
    private List<ProductAlerts> productAlerts = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    

    public List<ProductAlerts> getProductAlerts() {
		return productAlerts;
	}

	public void setProductAlerts(List<ProductAlerts> productAlerts) {
		this.productAlerts = productAlerts;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productAlerts).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductAlertsArray) == false) {
            return false;
        }
        ProductAlertsArray rhs = ((ProductAlertsArray) other);
        return new EqualsBuilder().append(productAlerts, rhs.productAlerts).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
