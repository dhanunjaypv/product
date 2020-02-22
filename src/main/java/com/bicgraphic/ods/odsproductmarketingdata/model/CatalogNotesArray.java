
package com.bicgraphic.ods.odsproductmarketingdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CatalogNotes"
})
public class CatalogNotesArray {

    @JsonProperty("CatalogNotes")
    @Valid
    private List<CatalogNotes> catalogNotes = new ArrayList<CatalogNotes>();
  

    /**
     * 
     * @return
     *     The catalogNotes
     */
    @JsonProperty("CatalogNotes")
    public List<CatalogNotes> getCatalogNotes() {
        return catalogNotes;
    }

    /**
     * 
     * @param catalogNotes
     *     The CatalogNotes
     */
    @JsonProperty("CatalogNotes")
    public void setCatalogNotes(List<CatalogNotes> catalogNotes) {
        this.catalogNotes = catalogNotes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

  

}
