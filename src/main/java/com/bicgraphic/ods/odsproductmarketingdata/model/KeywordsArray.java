package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Keywords"
})
public class KeywordsArray {
	 @JsonProperty("Keywords")
	    @Valid
	    private List<Keywords> keywords = new ArrayList<>();

	public List<Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keywords> keywords) {
		this.keywords = keywords;
	}
	
	
	 
	 
}
