package com.bicgraphic.ods.ODSProductMarketingData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import com.bicgraphic.ods.odsproductmarketingdata.model.EventMetadataDM;
import com.bicgraphic.ods.odsproductmarketingdata.model.ProductMarketingDataDMRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OdsProductMarketingDataApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebsiteProductMarketingDataControllerTest {
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
	
	

	//Customer account creation
		@Test
		public void testAStore1() throws Exception {

			File file = ResourceUtils.getFile("classpath:productData_testData.json");
			ObjectMapper mapper = new ObjectMapper();
			ProductMarketingDataDMRequest productEventDMRequest = mapper.readValue(file, ProductMarketingDataDMRequest.class);
			productEventDMRequest.getEventRequest().setEventBusinessID(dynamicId);
			productEventDMRequest.getEventRequest().setEventSourceSystem("EBS");
			productEventDMRequest.getEventRequest().getProductData().get(0).setProductId(dynamicId);
			String productEventDMRequestJson = mapper.writeValueAsString(productEventDMRequest);
			mockMvc.perform(post("/ProductMarketingIngestionAPI").contentType(MediaType.APPLICATION_JSON).content(productEventDMRequestJson)).andDo(print())
					.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
			
	
			
			File wsfile = ResourceUtils.getFile("classpath:productData_Ws.json");
			EventMetadataDM  eventMetadataDM = mapper.readValue(wsfile, EventMetadataDM.class);
			eventMetadataDM.getEventMetadata().setEventBusinessID(dynamicId);
			String eventJson = mapper.writeValueAsString(eventMetadataDM);
			mockMvc.perform(post("/websiteProductMarketingData").contentType(MediaType.APPLICATION_JSON).content(eventJson)).andDo(print())
					.andExpect(status().isOk()).andExpect(jsonPath("$..EventStatus").value("SUCCESS"));
		}
		
		
	@Test
	public void testPushWebsiteCustomerAddress()throws Exception {
		
		String	staticId = String.valueOf(System.currentTimeMillis());
		File file = ResourceUtils.getFile("classpath:productData_Ws.json");
		ObjectMapper mapper = new ObjectMapper();
		EventMetadataDM  eventMetadataDM = mapper.readValue(file, EventMetadataDM.class);

		eventMetadataDM.getEventMetadata().setEventBusinessID(staticId);
		String eventJson = mapper.writeValueAsString(eventMetadataDM);
		mockMvc.perform(
				post("/websiteProductMarketingData").contentType(MediaType.APPLICATION_JSON).content(eventJson))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$..EventStatusMessage").value("No Records found for given Product ID"));
	}
	
	
	
	
	
	

}
