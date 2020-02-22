
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AdditionalProductArray"
})
public class AdditionalProducts {

    @JsonProperty("AdditionalProductArray")
    @Valid
    private List<AdditionalProductArray> additionalProductArray = new ArrayList<>();

    /**
     * 
     * @return
     *     The additionalProductArray
     */
    public List<AdditionalProductArray> getAdditionalProductArray() {
        return additionalProductArray;
    }

    /**
     * 
     * @param additionalProductArray
     *     The AdditionalProductArray
     */
    public void setAdditionalProductArray(List<AdditionalProductArray> additionalProductArray) {
        this.additionalProductArray = additionalProductArray;
    }

    @Override
	public String toString() {
		return "AdditionalProducts [additionalProductArray=" + additionalProductArray + "]";
	}

}
