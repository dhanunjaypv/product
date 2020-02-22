package com.bicgraphic.ods.odsproductmarketingdata.model;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productId",
    "CategoryDetails",
    "AdditionalProducts"
})
public class ProductOrg {

	    @JsonProperty("productId")
	    @NotBlank(message = "{validation.productId.notNull}")
	    private String productId;
	  
	    @JsonProperty("CategoryDetails")
	    @Valid
	    private CategoryDetails categoryDetails;

	    @JsonProperty("AdditionalProducts")
	    @Valid
	    private AdditionalProducts additionalProducts;

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public CategoryDetails getCategoryDetails() {
			return categoryDetails;
		}

		public void setCategoryDetails(CategoryDetails categoryDetails) {
			this.categoryDetails = categoryDetails;
		}

		public AdditionalProducts getAdditionalProducts() {
			return additionalProducts;
		}

		public void setAdditionalProducts(AdditionalProducts additionalProducts) {
			this.additionalProducts = additionalProducts;
		}

		@Override
		public String toString() {
			return "ProductOrg [productId=" + productId + ", categoryDetails=" + categoryDetails
					+ ", additionalProducts=" + additionalProducts + "]";
		}

}
