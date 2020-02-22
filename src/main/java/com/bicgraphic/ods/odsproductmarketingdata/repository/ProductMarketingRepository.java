package com.bicgraphic.ods.odsproductmarketingdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingData;

@Repository
public interface ProductMarketingRepository extends  MongoRepository<ProductMarketingData, String> {
	
    ProductMarketingData findByProductId(String productId);
}
