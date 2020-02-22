
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeData {
	
    @JsonProperty("ProductId")
    @NotBlank(message = "{valid.productId.notNullEmpty}")
    private String productId;
    
    @JsonProperty("ProductIncludes")
    private String productIncludes;
    
    @JsonProperty("DecorationsArray")
    @Valid
    private DecorationsArray decorationsArray;
    
    @JsonProperty("FeaturesArray")
    @Valid
    private FeaturesArray featuresArray;
    
    @JsonProperty("CatalogNotesArray")
    @Valid
    private CatalogNotesArray catalogNotesArray;
    
    @JsonProperty("ProductAttributesArray")
    @Valid
    private ProductAttributesArray productAttributesArray;
    
    @JsonProperty("ImprintColorArray")
    @Valid
    private List<ImprintColorArray> imprintColorArray = new ArrayList<>();

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductIncludes() {
		return productIncludes;
	}

	public void setProductIncludes(String productIncludes) {
		this.productIncludes = productIncludes;
	}

	public DecorationsArray getDecorationsArray() {
		return decorationsArray;
	}

	public void setDecorationsArray(DecorationsArray decorationsArray) {
		this.decorationsArray = decorationsArray;
	}

	public FeaturesArray getFeaturesArray() {
		return featuresArray;
	}

	public void setFeaturesArray(FeaturesArray featuresArray) {
		this.featuresArray = featuresArray;
	}

	public CatalogNotesArray getCatalogNotesArray() {
		return catalogNotesArray;
	}

	public void setCatalogNotesArray(CatalogNotesArray catalogNotesArray) {
		this.catalogNotesArray = catalogNotesArray;
	}

	public ProductAttributesArray getProductAttributesArray() {
		return productAttributesArray;
	}

	public void setProductAttributesArray(ProductAttributesArray productAttributesArray) {
		this.productAttributesArray = productAttributesArray;
	}

	public List<ImprintColorArray> getImprintColorArray() {
		return imprintColorArray;
	}

	public void setImprintColorArray(List<ImprintColorArray> imprintColorArray) {
		this.imprintColorArray = imprintColorArray;
	}
    
    
    
   

}
