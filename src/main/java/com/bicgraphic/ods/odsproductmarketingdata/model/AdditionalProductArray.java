package com.bicgraphic.ods.odsproductmarketingdata.model;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalProductArray {

	@JsonProperty("RelationType")
	 @NotBlank(message = "{validation.relationType.notNull}")
	private String relationType;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("ProductName")
	 @NotBlank(message = "{validation.productName.notNull}")
	private String productName;

	@JsonProperty("ProductLine")
	 @NotBlank(message = "{validation.productLine.notNull}")
	private String productLine;

	@JsonProperty("ProductId")
	 @NotBlank(message = "{validation.productId.notNull}")
	private String productId;

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "AdditionalProductArray [relationType=" + relationType + ", description=" + description
				+ ", productName=" + productName + ", productLine=" + productLine + ", productId=" + productId + "]";
	}

}
