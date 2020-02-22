
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "productId", "ProductData" })

@Document(collection = "ProductMarketingCollection")
public class ProductMarketingData {

    @Id
    @JsonIgnore
    private String _id;
    
    @JsonProperty("productId")
    private String productId;
	
    @JsonProperty("ProductData")
    @Valid
    private List<ProductData> productData;

    @JsonProperty("ProductOrg")
    @Valid
    private List<ProductOrg> productOrg;

    @JsonProperty("ProductAttributeData")
    @Valid
    private List<ProductAttributeData> productAttributeData;

    @JsonProperty("ProductShippingInfo")
    @Valid
    private ProductAlertInfo productAlertInfo;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<ProductData> getProductData() {
        return productData;
    }

    public void setProductData(List<ProductData> productData) {
        this.productData = productData;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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

    public ProductAlertInfo getProductAlertInfo() {
        return productAlertInfo;
    }

    public void setProductAlertInfo(ProductAlertInfo productAlertInfo) {
        this.productAlertInfo = productAlertInfo;
    }
    
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productId).append(productData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductMarketingData) == false) {
            return false;
        }
        ProductMarketingData rhs = ((ProductMarketingData) other);
        return new EqualsBuilder().append(productId, rhs.productId).append(productData, rhs.productData)
                .isEquals();
    }

}
