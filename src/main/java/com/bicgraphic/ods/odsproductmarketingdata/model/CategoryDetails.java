
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
    "CategoryDetail"
})
public class CategoryDetails {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CategoryDetail")
    @Valid
    private List<CategoryDetail> categoryDetail = new ArrayList<>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The categoryDetail
     */
    public List<CategoryDetail> getCategoryDetail() {
        return categoryDetail;
    }

    /**
     * 
     * (Required)
     * 
     * @param categoryDetail
     *     The CategoryDetail
     */
    public void setCategoryDetail(List<CategoryDetail> categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
