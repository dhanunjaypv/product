package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategoryDetails {

	@JsonProperty("SubCategoryDetail")
	@Valid
	private List<SubCategoryDetail> subCategoryDetail = new ArrayList<>();

	public List<SubCategoryDetail> getSubCategoryDetail() {
		return subCategoryDetail;
	}

	public void setSubCategoryDetail(List<SubCategoryDetail> subCategoryDetail) {
		this.subCategoryDetail = subCategoryDetail;
	}

	@Override
	public String toString() {
		return "SubCategoryDetails [subCategoryDetail=" + subCategoryDetail + "]";
	}

}
