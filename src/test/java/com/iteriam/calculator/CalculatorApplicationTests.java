package com.iteriam.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.calculator.exceptions.OperationNotValidException;
import com.iteriam.calculator.model.service.OperationService;
import com.iteriam.calculator.utils.Tracer;



@SpringBootTest
class CalculatorApplicationTests {

	@Autowired
	Tracer tracer;
	
	@Autowired
	OperationService operationService;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testAddition() {
		double elem1 = 6.5;
		double elem2 = 3;
		
		double result = 0;
		try {
			result = operationService.calculate(elem1, elem2, "+");
			
		} catch (OperationNotValidException e) {
			e.printStackTrace();
			Assertions.fail("Operation not valid");
		}
		
		Assertions.assertEquals(9.5, result);
		tracer.trace("Suma : " + elem1 + " + " + elem2 + " : " + result);
	}
	
	@Test
	void testSustraction() {
		double elem1 = 6.5;
		double elem2 = 3;
		
		double result = 0;
		try {
			result = operationService.calculate(elem1, elem2, "-");
			
		} catch (OperationNotValidException e) {
			e.printStackTrace();
			Assertions.fail("Operation not valid");
		}
		
		Assertions.assertEquals(3.5, result);
		tracer.trace("Resta : " + elem1 + " - " + elem2 + " : " + result);
	}
	
	@Test()
	void testKO() {
		double elem1 = 6.5;
		double elem2 = 3;
		
		double result = 0;
		
		Assertions.assertThrows(OperationNotValidException.class, () -> {
				operationService.calculate(elem1, elem2, ";");
		});
			
		
		
		//Assertions.fail("Test will fail if gets here");
	}
}
