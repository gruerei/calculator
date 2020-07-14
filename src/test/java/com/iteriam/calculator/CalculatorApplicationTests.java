package com.iteriam.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.calculator.utils.Tracer;


@SpringBootTest
class CalculatorApplicationTests {

	@Autowired
	Tracer tracer;
	
	@Test
	void contextLoads() {
	}

	@Test
	void test1() {
		int i = 1 + 4;
		int j = 5;
		
		tracer.trace(i+j);
		
		Assertions.assertEquals(i, j);
	}
}
