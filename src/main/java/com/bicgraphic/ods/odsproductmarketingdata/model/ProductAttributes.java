package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "AttributeId",
    "Attribute",
    "ItemId",
    "AttributeName",
    "CatalogCountry",
    "AttributeValue",
    "AttributeCountry"
})
public class ProductAttributes {
	
	@JsonProperty("AttributeId")
	private String attributeId;
	
	@JsonProperty("Attribute")
	private String attribute;
	
	@JsonProperty("ItemId")
	private String itemId;
	
	@JsonProperty("AttributeName")
	private String attributeName;
	
	@JsonProperty("CatalogCountry")
	private String catalogCountry;
	
	@JsonProperty("AttributeValue")
	private String attributeValue;
	
	@JsonProperty("ODSLastModifiedDate")
    @JsonPropertyDescription("")
    private String odsLastModifiedDate;
	
	public String getOdsLastModifiedDate() {
		return odsLastModifiedDate;
	}
	public void setOdsLastModifiedDate(String odsLastModifiedDate) {
		this.odsLastModifiedDate = odsLastModifiedDate;
	}
	@JsonProperty("AttributeCountry")
	private String attributeCountry;
	public String getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getCatalogCountry() {
		return catalogCountry;
	}
	public void setCatalogCountry(String catalogCountry) {
		this.catalogCountry = catalogCountry;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	public String getAttributeCountry() {
		return attributeCountry;
	}
	public void setAttributeCountry(String attributeCountry) {
		this.attributeCountry = attributeCountry;
	}
	
	
}
