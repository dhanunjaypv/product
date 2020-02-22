package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({
    "CatalogNote",
    "CatalogCountry"
})
public class CatalogNotes {
	
	@JsonProperty("CatalogNote")
	private String catalogNote;
	 
	@JsonProperty("CatalogCountry")
	private String catalogCountry;
	public String getCatalogNote() {
		return catalogNote;
	}
	public void setCatalogNote(String catalogNote) {
		this.catalogNote = catalogNote;
	}
	public String getCatalogCountry() {
		return catalogCountry;
	}
	public void setCatalogCountry(String catalogCountry) {
		this.catalogCountry = catalogCountry;
	}
	@Override
	public String toString() {
		return "CatalogNotes [catalogNote=" + catalogNote + ", catalogCountry=" + catalogCountry + "]";
	}
	
	

}
