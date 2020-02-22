
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ProductAttributes"
})
public class ProductAttributesArray {

    @JsonProperty("ProductAttributes")
    @Valid
    private List<ProductAttributes> productAttributes = new ArrayList<ProductAttributes>();
   

    /**
     * 
     * @return
     *     The productAttributes
     */
    @JsonProperty("ProductAttributes")
    public List<ProductAttributes> getProductAttributes() {
        return productAttributes;
    }

    /**
     * 
     * @param productAttributes
     *     The productAttributes
     */
    @JsonProperty("ProductAttributes")
    public void setProductAttributes(List<ProductAttributes> productAttributes) {
        this.productAttributes = productAttributes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    
}
