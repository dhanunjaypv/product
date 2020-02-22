package com.bicgraphic.ods.odsproductmarketingdata.model;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubCategoryDetail {
	@JsonProperty("SubCategorycode")
	@NotBlank(message = "{validation.subCategorycode.notNull}")
	private String subCategorycode;

	@JsonProperty("SubcategoryName")
	@NotBlank(message = "{validation.subcategoryName.notNull}")
	private String subcategoryName;

	@JsonProperty("Subcategorystatus")
	@NotBlank(message = "{validation.subcategorystatus.notNull}")
	private String subcategorystatus;

	@JsonProperty("SubcategoryEffDate")
	private String subcategoryEffDate;

	public String getSubCategorycode() {
		return subCategorycode;
	}

	public void setSubCategorycode(String subCategorycode) {
		this.subCategorycode = subCategorycode;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getSubcategorystatus() {
		return subcategorystatus;
	}

	public void setSubcategorystatus(String subcategorystatus) {
		this.subcategorystatus = subcategorystatus;
	}

	public String getSubcategoryEffDate() {
		return subcategoryEffDate;
	}

	public void setSubcategoryEffDate(String subcategoryEffDate) {
		this.subcategoryEffDate = subcategoryEffDate;
	}

	@Override
	public String toString() {
		return "SubCategoryDetail [subCategorycode=" + subCategorycode + ", subcategoryName=" + subcategoryName
				+ ", subcategorystatus=" + subcategorystatus + ", subcategoryEffDate=" + subcategoryEffDate + "]";
	}

}
