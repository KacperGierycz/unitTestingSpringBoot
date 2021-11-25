package unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import unittesting.unittesting.business.ItemBusinessService;
import unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void dummyItem() throws Exception {
		
			
		//call "/hello-world"
		RequestBuilder request=MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
	//	JSONAssert.assertEquals(expected, actual, strict);
		
		//assertEquals("Hello World",result.getResponse().getContentAsString());
		//getContentAsString());toString());
		//verify "Hello World"
		
		
		
	}

	
	@Test
	public void ItemFromBusinesService_basic() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(
				new Item(2,"Item2",10,10));
		
			
		//call "/hello-world"
		RequestBuilder request=MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2 ,\"name\":\"Item2\",\"price\":10,\"quantity\":10}"))
				.andReturn();
		
	//	JSONAssert.assertEquals(expected, actual, strict);

	
	}
	
	
	
	
	
	
	
	
	
	
}
