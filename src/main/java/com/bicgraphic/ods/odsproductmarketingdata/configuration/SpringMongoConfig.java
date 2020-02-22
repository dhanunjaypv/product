package com.bicgraphic.ods.odsproductmarketingdata.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.bicgraphic.ods.odsproductmarketingdata")
@PropertySource(value = "classpath:integration_mongo.properties")
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Value("${mongo.hostname}")
	private String mongoHost;

	@Value("${mongo.port}")
	private String mongoPort;

	@Value("${productMarketingDB.dbname}")
	private String mongoDB;

	@Override
	public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
		return super.mongoMappingContext();
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoHost + ":" + mongoPort);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDB;
	}
}
