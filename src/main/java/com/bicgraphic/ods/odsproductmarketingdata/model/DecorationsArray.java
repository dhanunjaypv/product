
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Decorations"
})
public class DecorationsArray {

    @JsonProperty("Decorations")
    @Valid
    private List<Decorations> decorations = new ArrayList<Decorations>();
   

    /**
     * 
     * @return
     *     The Decorations
     */
    @JsonProperty("Decorations")
    public List<Decorations> getDecorations() {
        return decorations;
    }

    /**
     * 
     * @param Decorations
     *     The Decorations
     */
    @JsonProperty("Decorations")
    public void setDecorations(List<Decorations> decorations) {
        this.decorations = decorations;
    }

   

  

}
