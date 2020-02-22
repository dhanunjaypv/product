package com.bicgraphic.ods.ODSProductMarketingData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import com.bicgraphic.ods.odsproductmarketingdata.OdsProductMarketingDataApplication;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingDataDMRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =OdsProductMarketingDataApplication.class )
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OdsProductMarketingDataApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired 
	private WebApplicationContext wac;
	
	
	static String dynamicId = "";

	@BeforeClass
	public static void setDynamicId() {
		dynamicId = String.valueOf(System.currentTimeMillis());
	}

	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test1() throws Exception {

		File file = ResourceUtils.getFile("classpath:productData_testData.json");
		ObjectMapper mapper = new ObjectMapper();
		ProductMarketingDataDMRequest productMarketingDataDMRequest= mapper.readValue(file, ProductMarketingDataDMRequest.class);
		productMarketingDataDMRequest.getEventRequest().setEventBusinessID(dynamicId);
		productMarketingDataDMRequest.getEventRequest().getProductData().get(0).setProductId(dynamicId);
		productMarketingDataDMRequest.getEventRequest().setEventObject("ENTERPRISEPRODUCT");
		String productEventDMRequestJson = mapper.writeValueAsString(productMarketingDataDMRequest);
		mockMvc.perform(post("/ProductMarketingIngestionAPI").contentType(MediaType.APPLICATION_JSON).content(productEventDMRequestJson)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
	}
	
	@Test
	public void test2() throws Exception {

		File file = ResourceUtils.getFile("classpath:productData_testData.json");
		ObjectMapper mapper = new ObjectMapper();
		ProductMarketingDataDMRequest productMarketingDataDMRequest= mapper.readValue(file, ProductMarketingDataDMRequest.class);
		productMarketingDataDMRequest.getEventRequest().setEventBusinessID(dynamicId);
		productMarketingDataDMRequest.getEventRequest().getProductOrg().get(0).setProductId(dynamicId);
		productMarketingDataDMRequest.getEventRequest().setEventObject("PRODUCTORG");
		String productEventDMRequestJson = mapper.writeValueAsString(productMarketingDataDMRequest);
		mockMvc.perform(post("/ProductMarketingIngestionAPI").contentType(MediaType.APPLICATION_JSON).content(productEventDMRequestJson)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
	}
	
	@Test
	public void test3() throws Exception {

		File file = ResourceUtils.getFile("classpath:productData_testData.json");
		ObjectMapper mapper = new ObjectMapper();
		ProductMarketingDataDMRequest productMarketingDataDMRequest= mapper.readValue(file, ProductMarketingDataDMRequest.class);
		productMarketingDataDMRequest.getEventRequest().setEventBusinessID(dynamicId);
		productMarketingDataDMRequest.getEventRequest().getProductAttributeData().get(0).setProductId(dynamicId);
		productMarketingDataDMRequest.getEventRequest().setEventObject("PRODUCTATTRIBUTE");
		String productEventDMRequestJson = mapper.writeValueAsString(productMarketingDataDMRequest);
		mockMvc.perform(post("/ProductMarketingIngestionAPI").contentType(MediaType.APPLICATION_JSON).content(productEventDMRequestJson)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
	}
	
	@Test
	public void test4() throws Exception {

		File file = ResourceUtils.getFile("classpath:productData_testData.json");
		ObjectMapper mapper = new ObjectMapper();
		ProductMarketingDataDMRequest productMarketingDataDMRequest= mapper.readValue(file, ProductMarketingDataDMRequest.class);
		productMarketingDataDMRequest.getEventRequest().setEventBusinessID(dynamicId);
		productMarketingDataDMRequest.getEventRequest().getProductAlertInfo().setProductId(dynamicId);
		productMarketingDataDMRequest.getEventRequest().setEventObject("PRODUCTALERT");
		String productEventDMRequestJson = mapper.writeValueAsString(productMarketingDataDMRequest);
		mockMvc.perform(post("/ProductMarketingIngestionAPI").contentType(MediaType.APPLICATION_JSON).content(productEventDMRequestJson)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
	}
	
	@Test
	public void testCStore6() throws Exception {

		mockMvc.perform(get("/version")).andExpect(status().isOk());
	}

	@Test
	public void testCStore7() throws Exception {

		mockMvc.perform(get("/diagnostics")).andExpect(status().isOk())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("SUCCESS")))
				.andExpect(content().string(org.hamcrest.Matchers.containsString("UP")));
	}
	
}
