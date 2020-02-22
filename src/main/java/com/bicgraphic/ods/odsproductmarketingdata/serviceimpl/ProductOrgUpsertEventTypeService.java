package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.CategoryDetail;
import com.bicgraphic.ods.odsproductmarketingdata.model.CategoryDetails;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductOrg;
import com.bicgraphic.ods.odsproductmarketingdata.repository.ProductMarketingRepository;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

@Service
public class ProductOrgUpsertEventTypeService implements EventObjectTypeService {

      @Autowired
        private ProductMarketingRepository productMarketingRepository;
      
    @Override
    public String performOperation(EventRequest eventRequest) {
        
        try {
            LoggerUtil.info("Product Marketing CUD for ProductOrg #{}",eventRequest.getProductOrg());
            ProductMarketingData newProductMarketingData = new ProductMarketingData();
            newProductMarketingData.setProductId(eventRequest.getEventBusinessID());
            
            ProductMarketingData productMarketingData = productMarketingRepository.findByProductId(eventRequest.getEventBusinessID());
            
            if (productMarketingData != null) {
                newProductMarketingData.set_id(productMarketingData.get_id());
                newProductMarketingData.setProductData(productMarketingData.getProductData());
                newProductMarketingData.setProductAlertInfo(productMarketingData.getProductAlertInfo());
                newProductMarketingData.setProductAttributeData(productMarketingData.getProductAttributeData());
            } else {
                newProductMarketingData.setProductData(null);
                newProductMarketingData.setProductAlertInfo(null);
                newProductMarketingData.setProductAttributeData(null);
            } 
            ProductOrg requestProductOrg = eventRequest.getProductOrg().stream().findFirst().orElse(new ProductOrg());
            List<ProductOrg>  productOrgList = new ArrayList<>();
            setDatabasedOnSourceSystemForCreate(requestProductOrg,eventRequest.getEventSourceSystem());
            productOrgList.add(requestProductOrg);
            newProductMarketingData.setProductOrg(productOrgList);
            productMarketingRepository.save(newProductMarketingData);
        } catch (Exception exception) {
            LoggerUtil.info("DataBase have some issue while accessing #{}", exception.getMessage());
            throw new ODSException(ProductMarketingConstants.DB_INTERNAL_ERROR_CODE, ProductMarketingConstants.DB_INTERNAL_ERROR_MSG);
        }
        return ProductMarketingConstants.SUCCESS_STATUS;
    }
    private void setDatabasedOnSourceSystemForCreate(ProductOrg productOrg, String eventSourceSystem) {
        if (ProductMarketingConstants.EBS_SOURCE_SYSTEM.equals(eventSourceSystem)) {
            productOrg.setAdditionalProducts(null);
            if (null != productOrg.getCategoryDetails() && !CollectionUtils.isEmpty(productOrg.getCategoryDetails().getCategoryDetail())) {
                validateAndSetCategoryDetailsforCreate(productOrg);
            }
        } /*
             * else if
             * (ProductMarketingConstants.GN_SOURCE_SYSTEM.equals(eventSourceSystem)) {
             * 
             * productOrg.setCategoryDetails(null); }
             */
    }
    private void validateAndSetCategoryDetailsforCreate(ProductOrg productOrgReq) {
        CategoryDetails categoryDetails = productOrgReq.getCategoryDetails();
        List<CategoryDetail> categoryDetaillist = null;
        if(null!= categoryDetails && !categoryDetails.getCategoryDetail().isEmpty()) {
            categoryDetaillist = categoryDetails.getCategoryDetail().stream().filter(categoryDetail -> ProductMarketingConstants.BIC_RESOURCE_ASSIGNMENT
                    .equals(categoryDetail.getCategorySet()))
            .collect(Collectors.toList());
            categoryDetails.getCategoryDetail().clear();
            if(!categoryDetaillist.isEmpty()) {
                categoryDetails.getCategoryDetail().add(categoryDetaillist.get(0));
                productOrgReq.setCategoryDetails(categoryDetails);
            }
        }
    }
}
