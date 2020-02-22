package com.bicgraphic.ods.odsproductmarketingdata.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "ImprintColors" 
})
public class ImprintColorArray {
	
	@JsonProperty("ImprintColors")
	ImprintColors imprintColors;

	public ImprintColors getImprintColors() {
		return imprintColors;
	}

	public void setImprintColors(ImprintColors imprintColors) {
		this.imprintColors = imprintColors;
	}

	@Override
	public String toString() {
		return "ImprintColorArray [imprintColors=" + imprintColors + "]";
	}


	

}
