package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "ImprintMethod",
    "ImprintDescription",
    "ColorDescription",
    "PmsColor",
    "PmsMatch",
    "HexColor",
    "ProductParentColor"
})
public class ImprintColors {
	
	@JsonProperty("ImprintMethod")
	private String imprintMethod;
	
	@JsonProperty("ImprintDescription")
	private String imprintDescription;
	
	@JsonProperty("ColorDescription")
	private String colorDescription;
	
	@JsonProperty("PmsColor")
	private String pmsColor;
	
	@JsonProperty("PmsMatch")
	private String pmsMatch;
	
	@JsonProperty("HexColor")
	private String hexColor;
	
	@JsonProperty("ProductParentColor")
	private String productParentColor;
	
	public String getImprintMethod() {
		return imprintMethod;
	}
	public void setImprintMethod(String imprintMethod) {
		this.imprintMethod = imprintMethod;
	}
	public String getImprintDescription() {
		return imprintDescription;
	}
	public void setImprintDescription(String imprintDescription) {
		this.imprintDescription = imprintDescription;
	}
	public String getColorDescription() {
		return colorDescription;
	}
	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
	}
	public String getPmsColor() {
		return pmsColor;
	}
	public void setPmsColor(String pmsColor) {
		this.pmsColor = pmsColor;
	}
	public String getPmsMatch() {
		return pmsMatch;
	}
	public void setPmsMatch(String pmsMatch) {
		this.pmsMatch = pmsMatch;
	}
	public String getHexColor() {
		return hexColor;
	}
	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}
	public String getProductParentColor() {
		return productParentColor;
	}
	public void setProductParentColor(String productParentColor) {
		this.productParentColor = productParentColor;
	}
	@Override
	public String toString() {
		return "ImprintColors [imprintMethod=" + imprintMethod + ", imprintDescription=" + imprintDescription
				+ ", colorDescription=" + colorDescription + ", pmsColor=" + pmsColor + ", pmsMatch=" + pmsMatch
				+ ", hexColor=" + hexColor + ", productParentColor=" + productParentColor + "]";
	}
	
	
	

}
