package com.bicgraphic.ods.odsproductmarketingdata.model;


import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDetail {
	
    @JsonProperty("categorySet")
	private String categorySet;
    
    @JsonProperty("categoryCode")
    @NotBlank(message = "{validation.categoryCode.notNull}")
	private String categoryCode;
    
    @JsonProperty("categoryName")
    @NotBlank(message = "{validation.categoryName.notNull}")
	private String categoryName;

    @JsonProperty("ODSLastModifiedDate")
    @JsonPropertyDescription("")
    private String odsLastModifiedDate;

 

	public String getOdsLastModifiedDate() {
		return odsLastModifiedDate;
	}

	public void setOdsLastModifiedDate(String odsLastModifiedDate) {
		this.odsLastModifiedDate = odsLastModifiedDate;
	}

	@JsonProperty("categoryStatus")
    @NotBlank(message = "{validation.categoryStatus.notNull}")
	private String categoryStatus;
    
    @JsonProperty("categoryEffDate")
    @NotBlank(message = "{validation.categoryEffDate.notNull}")
	private String categoryEffDate;
    
    @JsonProperty("SubCategoryDetails")
    @Valid
	private SubCategoryDetails subCategoryDetails;

	public String getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(String categorySet) {
		this.categorySet = categorySet;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCategoryEffDate() {
		return categoryEffDate;
	}

	public void setCategoryEffDate(String categoryEffDate) {
		this.categoryEffDate = categoryEffDate;
	}

	public SubCategoryDetails getSubCategoryDetails() {
		return subCategoryDetails;
	}

	public void setSubCategoryDetails(SubCategoryDetails subCategoryDetails) {
		this.subCategoryDetails = subCategoryDetails;
	}

	
}
