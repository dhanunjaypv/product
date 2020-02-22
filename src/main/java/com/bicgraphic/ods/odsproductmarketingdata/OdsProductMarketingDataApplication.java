package com.bicgraphic.ods.odsproductmarketingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.bicgraphic.odsutils", "com.bicgraphic.*" })
public class OdsProductMarketingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdsProductMarketingDataApplication.class, args);
	}

}
