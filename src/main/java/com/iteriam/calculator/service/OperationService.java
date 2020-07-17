package com.iteriam.calculator.model.service;


import org.springframework.stereotype.Service;

import com.iteriam.calculator.exceptions.OperationNotValidException;
import com.iteriam.calculator.model.Addition;
import com.iteriam.calculator.model.Operation;
import com.iteriam.calculator.model.Substraction;

@Service
public class OperationService {

	public double calculate(double elem1, double elem2, String operator) throws OperationNotValidException {
		
		Operation oper = null;
		
		if(operator.equals("+")) {
			oper = new Addition(elem1, elem2);
		}else if(operator.equals("-")) {
			oper = new Substraction(elem1, elem2);
		}
		
		if(oper == null) {
			throw new OperationNotValidException("NOT VALID", "Operation [" + operator + "] not valid");
		}else {
			return oper.calculate(elem1, elem2);
		}
		
	}
	
}
