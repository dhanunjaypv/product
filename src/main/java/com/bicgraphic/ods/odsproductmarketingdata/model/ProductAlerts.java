package com.bicgraphic.ods.odsproductmarketingdata.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SequenceNum",
    "Alert",
    "CreationDate",
    "LastUpdateDate",
    "AlertType","AlertId","Visibility","Country","Status"
})
public class ProductAlerts {
	
	@JsonProperty("SequenceNum")
	private String sequenceNum;
	
	@JsonProperty("Alert")
	private String alert;
	
	@JsonProperty("CreationDate")
	private String creationDate;
	
	@JsonProperty("LastUpdateDate")
	private String lastUpdateDate;
	
	@JsonProperty("AlertType")
	private String alertType;
	
	@JsonProperty("AlertId")
	private String alertId;
	

    @JsonProperty("ODSLastModifiedDate")
    @JsonPropertyDescription("")
    private String odsLastModifiedDate;

	public String getOdsLastModifiedDate() {
		return odsLastModifiedDate;
	}

	public void setOdsLastModifiedDate(String odsLastModifiedDate) {
		this.odsLastModifiedDate = odsLastModifiedDate;
	}

	@JsonProperty("Visibility")
	private String visibility;
	
	@JsonProperty("Country")
	private String country;

	@JsonProperty("Status")
	private String status;
	
	

	public String getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(String sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder().append(alertId).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductAlerts other = (ProductAlerts) obj;
        if (alertId == null) {
            if (other.alertId != null)
                return false;
        } else if (!alertId.equals(other.alertId))
            return false;
        return true;
    }
	
	
	
	
	

}
