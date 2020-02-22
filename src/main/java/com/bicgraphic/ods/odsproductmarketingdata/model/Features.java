package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "Feature",
    "FeatureCountry"
})
public class Features {
	
	@JsonProperty("Feature")
	private String feature;
	@JsonProperty("FeatureCountry")
	private String featureCountry;
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getFeatureCountry() {
		return featureCountry;
	}
	public void setFeatureCountry(String featureCountry) {
		this.featureCountry = featureCountry;
	}
	@Override
	public String toString() {
		return "Features [feature=" + feature + ", featureCountry=" + featureCountry + "]";
	}
	
	
	

}
