package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"Method",
    "ImprintArea",
    "Dimension",
    "ColorsIncluded",
    "MaxColors",
    "ImprintType"
})
public class Decorations {
	
	@JsonProperty("Method")
	private String method;
	 
    @JsonProperty("ImprintArea")
	private String imprintArea;
    
    @JsonProperty("Dimension")
    private String dimension;
    
    @JsonProperty("ColorsIncluded")
    private String colorsIncluded;
    
    @JsonProperty("MaxColors")
    private String maxColors;
    
    @JsonProperty("ImprintType")
    private String imprintType;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getImprintArea() {
		return imprintArea;
	}
	public void setImprintArea(String imprintArea) {
		this.imprintArea = imprintArea;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getColorsIncluded() {
		return colorsIncluded;
	}
	public void setColorsIncluded(String colorsIncluded) {
		this.colorsIncluded = colorsIncluded;
	}
	public String getMaxColors() {
		return maxColors;
	}
	public void setMaxColors(String maxColors) {
		this.maxColors = maxColors;
	}
	public String getImprintType() {
		return imprintType;
	}
	public void setImprintType(String imprintType) {
		this.imprintType = imprintType;
	}
	@Override
	public String toString() {
		return "Decorations [method=" + method + ", imprintArea=" + imprintArea + ", dimension=" + dimension
				+ ", colorsIncluded=" + colorsIncluded + ", maxColors=" + maxColors + ", imprintType=" + imprintType
				+ "]";
	}
	
	
	
	
}
