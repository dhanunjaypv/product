package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Keywords {

	
	@JsonProperty("Keyword")
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Keywords [keyword=" + keyword + "]";
	}

	
	
}
