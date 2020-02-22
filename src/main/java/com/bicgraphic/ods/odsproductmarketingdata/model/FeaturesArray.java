
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Features"
})
public class FeaturesArray {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Features")
    @Valid
    @NotNull
    private List<Features> features = new ArrayList<Features>();
   
    /**
     * 
     * (Required)
     * 
     * @return
     *     The features
     */
    @JsonProperty("features ")
    public List<Features> getFeatures() {
        return features;
    }

    /**
     * 
     * (Required)
     * 
     * @param features
     *     The features 
     */
    @JsonProperty("features ")
    public void setFeatures(List<Features> features) {
        this.features = features;
    }

  

   

}
