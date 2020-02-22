package com.bicgraphic.ods.odsproductmarketingdata.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventRequest;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductData;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;
import com.bicgraphic.ods.odsproductmarketingdata.repository.ProductMarketingRepository;
import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

@Service
@Qualifier("productDataMarketingIngestionService")
public class ProductDataUpsertEventTypeService implements EventObjectTypeService {

    @Autowired
    private ProductMarketingRepository productMarketingRepository;

    @Override
    public String performOperation(EventRequest eventRequest) {
        
        try {
        	LoggerUtil.info("Product Marketing CUD for ProductData #{}",eventRequest.getProductData());
        	ProductMarketingData newProductMarketingData = new ProductMarketingData();
        	newProductMarketingData.setProductId(eventRequest.getEventBusinessID());
        	
			ProductMarketingData productMarketingData = productMarketingRepository.findByProductId(eventRequest.getEventBusinessID());
			List<ProductData> productDataList = new ArrayList<>();
			ProductData productDataFinal =null;
			if (productMarketingData != null) {
				productDataFinal=null!= productMarketingData.getProductData() ? productMarketingData.getProductData().get(0) : new ProductData();
			    newProductMarketingData.set_id(productMarketingData.get_id());
			    newProductMarketingData.setProductOrg(productMarketingData.getProductOrg());
			    newProductMarketingData.setProductAlertInfo(productMarketingData.getProductAlertInfo());
			    newProductMarketingData.setProductAttributeData(productMarketingData.getProductAttributeData());
			} else {
				productDataFinal=new ProductData();
			    newProductMarketingData.setProductOrg(null);
			    newProductMarketingData.setProductAlertInfo(null);
			    newProductMarketingData.setProductAttributeData(null);
			}

			ProductData requestProductData = eventRequest.getProductData().stream().findFirst().orElse(new ProductData());
            try {
                extractFieldsBySourceSystem(requestProductData, eventRequest.getEventSourceSystem(), productDataFinal);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException exception) {
            	LoggerUtil.info("DataBase have some issue while accessing #{}", exception.getMessage());
    			throw new ODSException(ProductMarketingConstants.DATA_CONVERTION_FAIL_CODE, ProductMarketingConstants.DATA_CONVERTION_FAIL_MSG);
            }
            productDataList.add(productDataFinal);
            newProductMarketingData.setProductData(productDataList);
			

			productMarketingRepository.save(newProductMarketingData);
		} catch (Exception exception) {
			LoggerUtil.info("DataBase have some issue while accessing #{}", exception.getMessage());
			throw new ODSException(ProductMarketingConstants.DB_INTERNAL_ERROR_CODE, ProductMarketingConstants.DB_INTERNAL_ERROR_MSG);
		}
        return ProductMarketingConstants.SUCCESS_STATUS;
    }

    private void extractFieldsBySourceSystem(ProductData productData, String eventSourceSystem, ProductData productDataFinal)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<String> sourceFileds = new ArrayList<>();
        if (ProductMarketingConstants.GN_SOURCE_SYSTEM.equals(eventSourceSystem)) {
            sourceFileds = Arrays.asList(ProductMarketingConstants.PRODUCT_GN_FIELDS.split("\\s*,\\s*"));
            productDataFinal.setKeywordsArray(productData.getKeywordsArray());
            productDataFinal.setMarketingPointArray(productData.getMarketingPointArray());

        } else if (ProductMarketingConstants.EBS_SOURCE_SYSTEM.equals(eventSourceSystem)) {
            sourceFileds = Arrays.asList(ProductMarketingConstants.PRODUCT_EBS_FIELDS.split("\\s*,\\s*"));
            if ("Y".equalsIgnoreCase(productData.getIsHazardous())) {
                productData.setIsHazardous(Boolean.TRUE.toString());
            } else if ("N".equalsIgnoreCase(productData.getIsHazardous())) {
                productData.setIsHazardous(Boolean.FALSE.toString());
            }
        }
        if(eventSourceSystem.contains(ProductMarketingConstants.PRODUCTMANAGER_TO_PRODUCTMARKETING)){
             sourceFileds = Arrays.asList(ProductMarketingConstants.PRODUCT_ENTERPRISE_FIELDS.split("\\s*,\\s*"));
        }

        for (String propertyName : sourceFileds) {
            BeanUtils.setProperty(productDataFinal, propertyName, BeanUtils.getProperty(productData, propertyName));
        }
    }
    }