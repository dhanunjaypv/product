package com.bicgraphic.ods.odsproductmarketingdata.model;


import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductData {
	
	
	@JsonProperty("ProductId")
	@NotBlank(message = "{validation.productId.notNull}")
	private String productId;
	
	@JsonProperty("ProductName")
	private String productName;
	
	@JsonProperty("ProductNameCanada")
	private String productNameCanada;
	
	@JsonProperty("CopyChangeAllowed")
	private String copyChangeAllowed;
	
	@JsonProperty("CannotShipto")
	private String cannotShipto;
	
	@JsonProperty("ProductDescription")
	private String productDescription;
	
	@JsonProperty("ProductCategory")
	private String productCategory;
	
	@JsonProperty("ProductSubCategory")
	private String productSubCategory;
	
	@JsonProperty("KeywordsArray")
	@Valid
	private KeywordsArray keywordsArray;
	
	@JsonProperty("MarketingPointArray")
	private MarketingPointArray marketingPointArray;
	
	@JsonProperty("ProductSubstatus")
	private String productSubstatus;
	
	@JsonProperty("SubStatusReason")
	private String subStatusReason;
	
	@JsonProperty("VisibleFlag")
	private String visibleFlag;
	
	@JsonProperty("IsHazardous")
	private String isHazardous;
	
	@JsonProperty("ActiveDate")
	private String activeDate;
	
	@JsonProperty("IntroDate")
	private String introDate;
	

	@JsonProperty("EBSCreateDate")
	private String eBSCreateDate;
	
	@JsonProperty("OldProductId")
	private String oldProductId;
	
	@JsonProperty("BlanksAllowed")
	private String blanksAllowed;
	

    @JsonProperty("ODSLastModifiedDate")
    @JsonPropertyDescription("")
    private String odsLastModifiedDate;
	
	@JsonProperty("InkChangeAllowed")
	private String inkChangeAllowed;
	
	@JsonProperty("HalftoneAllowed")
	private String halftoneAllowed;
	
	@JsonProperty("PmsMatch")
	private String pmsMatch;
	
	@JsonProperty("QualifiesForEQP")
	private String qualifiesForEQP;
	
	@JsonProperty("QualifiesForDSP")
	private String qualifiesForDSP;
	
	@JsonProperty("CombinedQuanity")
	private String combinedQuantity;
	
	@JsonProperty("Material")
	private String material;
	
	@JsonProperty("SampleFlag")
	private String sampleFlag;
	
	@JsonProperty("WebOrderableFlag")
	private String webOrderableFlag;
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("EBSstatus")
	private String eBSstatus;
	
	@JsonProperty("GNstatus")
	private String gnStatus;
	
	@JsonProperty("StandardImprintColors")
	private String standardImprintColors;
	
	@JsonProperty("VirtualSample")
	private String virtualSample;
	
	@JsonProperty("Brand")
	private String brand;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameCanada() {
		return productNameCanada;
	}

	public void setProductNameCanada(String productNameCanada) {
		this.productNameCanada = productNameCanada;
	}

	public String getCopyChangeAllowed() {
		return copyChangeAllowed;
	}

	public void setCopyChangeAllowed(String copyChangeAllowed) {
		this.copyChangeAllowed = copyChangeAllowed;
	}

	public String getCannotShipto() {
		return cannotShipto;
	}

	public void setCannotShipto(String cannotShipto) {
		this.cannotShipto = cannotShipto;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public KeywordsArray getKeywordsArray() {
		return keywordsArray;
	}

	public void setKeywordsArray(KeywordsArray keywordsArray) {
		this.keywordsArray = keywordsArray;
	}

	public MarketingPointArray getMarketingPointArray() {
		return marketingPointArray;
	}

	public void setMarketingPointArray(MarketingPointArray marketingPointArray) {
		this.marketingPointArray = marketingPointArray;
	}

	public String getProductSubstatus() {
		return productSubstatus;
	}

	public void setProductSubstatus(String productSubstatus) {
		this.productSubstatus = productSubstatus;
	}

	public String getSubStatusReason() {
		return subStatusReason;
	}

	public void setSubStatusReason(String subStatusReason) {
		this.subStatusReason = subStatusReason;
	}

	public String getVisibleFlag() {
		return visibleFlag;
	}

	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

	public String getIsHazardous() {
		return isHazardous;
	}

	public void setIsHazardous(String isHazardous) {
		this.isHazardous = isHazardous;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getIntroDate() {
		return introDate;
	}

	public void setIntroDate(String introDate) {
		this.introDate = introDate;
	}

	public String geteBSCreateDate() {
		return eBSCreateDate;
	}

	public void seteBSCreateDate(String eBSCreateDate) {
		this.eBSCreateDate = eBSCreateDate;
	}

	public String getOldProductId() {
		return oldProductId;
	}

	public void setOldProductId(String oldProductId) {
		this.oldProductId = oldProductId;
	}

	public String getBlanksAllowed() {
		return blanksAllowed;
	}

	public void setBlanksAllowed(String blanksAllowed) {
		this.blanksAllowed = blanksAllowed;
	}

	
	public String getOdsLastModifiedDate() {
		return odsLastModifiedDate;
	}

	public void setOdsLastModifiedDate(String odsLastModifiedDate) {
		this.odsLastModifiedDate = odsLastModifiedDate;
	}

	public String getInkChangeAllowed() {
		return inkChangeAllowed;
	}

	public void setInkChangeAllowed(String inkChangeAllowed) {
		this.inkChangeAllowed = inkChangeAllowed;
	}

	public String getHalftoneAllowed() {
		return halftoneAllowed;
	}

	public void setHalftoneAllowed(String halftoneAllowed) {
		this.halftoneAllowed = halftoneAllowed;
	}

	public String getPmsMatch() {
		return pmsMatch;
	}

	public void setPmsMatch(String pmsMatch) {
		this.pmsMatch = pmsMatch;
	}

	public String getQualifiesForEQP() {
		return qualifiesForEQP;
	}

	public void setQualifiesForEQP(String qualifiesForEQP) {
		this.qualifiesForEQP = qualifiesForEQP;
	}

	public String getQualifiesForDSP() {
		return qualifiesForDSP;
	}

	public void setQualifiesForDSP(String qualifiesForDSP) {
		this.qualifiesForDSP = qualifiesForDSP;
	}

	public String getCombinedQuantity() {
		return combinedQuantity;
	}

	public void setCombinedQuantity(String combinedQuantity) {
		this.combinedQuantity = combinedQuantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSampleFlag() {
		return sampleFlag;
	}

	public void setSampleFlag(String sampleFlag) {
		this.sampleFlag = sampleFlag;
	}

	public String getWebOrderableFlag() {
		return webOrderableFlag;
	}

	public void setWebOrderableFlag(String webOrderableFlag) {
		this.webOrderableFlag = webOrderableFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String geteBSstatus() {
		return eBSstatus;
	}

	public void seteBSstatus(String eBSstatus) {
		this.eBSstatus = eBSstatus;
	}

	public String getGnStatus() {
		return gnStatus;
	}

	public void setGnStatus(String gnStatus) {
		this.gnStatus = gnStatus;
	}

	public String getStandardImprintColors() {
		return standardImprintColors;
	}

	public void setStandardImprintColors(String standardImprintColors) {
		this.standardImprintColors = standardImprintColors;
	}

	public String getVirtualSample() {
		return virtualSample;
	}

	public void setVirtualSample(String virtualSample) {
		this.virtualSample = virtualSample;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ProductData [productId=" + productId + ", productName=" + productName + ", productNameCanada="
				+ productNameCanada + ", copyChangeAllowed=" + copyChangeAllowed + ", cannotShipto=" + cannotShipto
				+ ", productDescription=" + productDescription + ", productCategory=" + productCategory
				+ ", productSubCategory=" + productSubCategory + ", keywordsArray=" + keywordsArray
				+ ", marketingPointArray=" + marketingPointArray + ", productSubstatus=" + productSubstatus
				+ ", subStatusReason=" + subStatusReason + ", visibleFlag=" + visibleFlag + ", isHazardous="
				+ isHazardous + ", activeDate=" + activeDate + ", introDate=" + introDate + ", eBSCreateDate="
				+ eBSCreateDate + ", oldProductId=" + oldProductId + ", blanksAllowed=" + blanksAllowed
				+ ", odsLastModifiedDate=" + odsLastModifiedDate + ", inkChangeAllowed=" + inkChangeAllowed
				+ ", halftoneAllowed=" + halftoneAllowed + ", pmsMatch=" + pmsMatch + ", qualifiesForEQP="
				+ qualifiesForEQP + ", qualifiesForDSP=" + qualifiesForDSP + ", combinedQuantity=" + combinedQuantity
				+ ", material=" + material + ", sampleFlag=" + sampleFlag + ", webOrderableFlag=" + webOrderableFlag
				+ ", status=" + status + ", eBSstatus=" + eBSstatus + ", gnStatus=" + gnStatus
				+ ", standardImprintColors=" + standardImprintColors + ", virtualSample=" + virtualSample + ", brand="
				+ brand + "]";
	}

	

}
