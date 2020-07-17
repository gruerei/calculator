package com.iteriam.calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iteriam.calculator.dto.InDTO;
import com.iteriam.calculator.exceptions.OperationNotValidException;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class CalculatorControllerTest {
	
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    private InDTO inDtoAdd;
    
    private InDTO inDtoSubs;
    
    private InDTO inDtoKO;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        
        inDtoAdd = new InDTO(3.0, 1.0, "+");
        inDtoSubs = new InDTO(3.0, 1.0, "-");
        inDtoKO = new InDTO(3.0, 1.0, "^");
    }
    
    @Test
	public void testSuma() throws Exception {
    	
    	mockMvc.perform(MockMvcRequestBuilders
    		      .post("/calculator")
    		      .content(asJsonString(inDtoAdd))
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The result of the + operation is 4.0"));
    	

	}
    
    @Test
	public void testResta() throws Exception {
    	
    	mockMvc.perform(MockMvcRequestBuilders
    		      .post("/calculator")
    		      .content(asJsonString(inDtoSubs))
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The result of the - operation is 2.0"));
    	

	}
    
    @Test
   	public void testKO() throws Exception {
       	
       	mockMvc.perform(MockMvcRequestBuilders
       		      .post("/calculator")
       		      .content(asJsonString(inDtoKO))
       		      .contentType(MediaType.APPLICATION_JSON))
       		      .andExpect(status().isBadRequest())
       		      .andExpect(result -> assertTrue(result.getResolvedException() instanceof OperationNotValidException));
       	

   	}
    
    public String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
