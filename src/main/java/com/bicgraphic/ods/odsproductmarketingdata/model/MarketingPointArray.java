package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MarketingPointArray"
})
public class MarketingPointArray {

	   @JsonProperty("MarketingPoint")
	    @Valid
	    private List<MarketingPoint> marketingPoint = new ArrayList<>();

	public List<MarketingPoint> getMarketingPoint() {
		return marketingPoint;
	}

	public void setMarketingPoint(List<MarketingPoint> marketingPoint) {
		this.marketingPoint = marketingPoint;
	}
	
	
	
}
