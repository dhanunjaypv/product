package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductAlerts;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;
import com.bicgraphic.ods.odsproductmarketingdata.repository.ProductMarketingRepository;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

@Service
public class ProductAlertUpsertEventTypeService implements EventObjectTypeService {

    @Autowired
    private ProductMarketingRepository productMarketingRepository;

    @Override
    public String performOperation(EventRequest eventRequest) {
        try {
            ProductMarketingData newProductMarketingData = new ProductMarketingData();
            LoggerUtil.info("Product Marketing CUD for ProductAlerts #{}",eventRequest.getProductAlertInfo());
            ProductMarketingData productMarketingData = productMarketingRepository.findByProductId(eventRequest.getEventBusinessID());
            newProductMarketingData.setProductId(eventRequest.getEventBusinessID());
            if (productMarketingData != null) {
                newProductMarketingData.set_id(productMarketingData.get_id());
                Set<ProductAlerts> alertInfos = new HashSet<>();
                if(productMarketingData.getProductAlertInfo()!=null) {              
                    for(ProductAlerts existingProdAlert: productMarketingData.getProductAlertInfo().getProductAlertsArray().getProductAlerts()) {
                        for(ProductAlerts newProdAlert: eventRequest.getProductAlertInfo().getProductAlertsArray().getProductAlerts()) {
                            if(existingProdAlert.getAlertId().equals(newProdAlert.getAlertId())) {
                                alertInfos.add(newProdAlert);
                            }
                        }
                    }
                    for(ProductAlerts existingProdAlert: productMarketingData.getProductAlertInfo().getProductAlertsArray().getProductAlerts()) {
                        alertInfos.add(existingProdAlert);
                    }
                }
                for(ProductAlerts newProdAlert: eventRequest.getProductAlertInfo().getProductAlertsArray().getProductAlerts()) {
                    alertInfos.add(newProdAlert);
                }
                eventRequest.getProductAlertInfo().getProductAlertsArray().getProductAlerts().clear();
                eventRequest.getProductAlertInfo().getProductAlertsArray().getProductAlerts().addAll(alertInfos);
                newProductMarketingData.setProductAlertInfo(eventRequest.getProductAlertInfo());
                newProductMarketingData.setProductOrg(productMarketingData.getProductOrg());
                newProductMarketingData.setProductAttributeData(productMarketingData.getProductAttributeData());
                newProductMarketingData.setProductData(productMarketingData.getProductData());
            } else {
                newProductMarketingData.setProductAlertInfo(eventRequest.getProductAlertInfo());
                newProductMarketingData.setProductOrg(null);
                newProductMarketingData.setProductAttributeData(null);
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
