package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;
import com.bicgraphic.ods.odsproductmarketingdata.repository.ProductMarketingRepository;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

@Service
public class ProductAttributeUpsertEventTypeService implements EventObjectTypeService {
    @Autowired
    private ProductMarketingRepository productMarketingRepository;
    @Override
    public String performOperation(EventRequest eventRequest) {
        
        try {
            ProductMarketingData newProductMarketingData = new ProductMarketingData();
            newProductMarketingData.setProductId(eventRequest.getEventBusinessID());
            LoggerUtil.info("Product Marketing CUD for ProductAttribute #{}",eventRequest.getProductAttributeData());
            ProductMarketingData productMarketingData = productMarketingRepository.findByProductId(eventRequest.getEventBusinessID());
            newProductMarketingData.setProductAttributeData(eventRequest.getProductAttributeData());
            if (productMarketingData != null) {
                newProductMarketingData.set_id(productMarketingData.get_id());
                newProductMarketingData.setProductOrg(productMarketingData.getProductOrg());
                newProductMarketingData.setProductAlertInfo(productMarketingData.getProductAlertInfo());
                newProductMarketingData.setProductData(productMarketingData.getProductData());
            } else {
                newProductMarketingData.setProductOrg(null);
                newProductMarketingData.setProductAlertInfo(null);
                newProductMarketingData.setProductData(null);
            }

            productMarketingRepository.save(newProductMarketingData);
        } catch (Exception exception) {
            LoggerUtil.info("DataBase have some issue while accessing #{}", exception.getMessage());
            throw new ODSException(ProductMarketingConstants.DB_INTERNAL_ERROR_CODE, ProductMarketingConstants.DB_INTERNAL_ERROR_MSG);
        }
        return ProductMarketingConstants.SUCCESS_STATUS;
    }

}
