package com.bicgraphic.ods.odsproductmarketingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketingPoint {

	@JsonProperty("PointType")
	private String pointType;
	
	@JsonProperty("PointCopy")
	private String pointCopy;

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public String getPointCopy() {
		return pointCopy;
	}

	public void setPointCopy(String pointCopy) {
		this.pointCopy = pointCopy;
	}

	@Override
	public String toString() {
		return "MarketingPoint [pointType=" + pointType + ", pointCopy=" + pointCopy + "]";
	}
	
	
	
	
}
