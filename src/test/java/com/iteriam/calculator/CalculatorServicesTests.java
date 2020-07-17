package com.iteriam.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.calculator.service.AdditionService;
import com.iteriam.calculator.service.SubstractionService;
import com.iteriam.calculator.utils.Tracer;



@SpringBootTest
class CalculatorServicesTests {

	@Autowired
	Tracer tracer;
	
	@Autowired
	AdditionService additionService;
	
	@Autowired
	SubstractionService substractionService;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testAddition() {
		double elem1 = 6.5;
		double elem2 = 3;
		
		double result = additionService.calculate(elem1, elem2);

		Assertions.assertEquals(9.5, result);
		tracer.trace("Suma : " + elem1 + " + " + elem2 + " : " + result);
	}
	
	@Test
	void testSustraction() {
		double elem1 = 6.5;
		double elem2 = 3;
		
		double result = substractionService.calculate(elem1, elem2);

		Assertions.assertEquals(3.5, result);
		tracer.trace("Resta : " + elem1 + " - " + elem2 + " : " + result);
	}
	

}
