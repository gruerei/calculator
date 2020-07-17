package com.iteriam.calculator.service;


import org.springframework.stereotype.Service;

import com.iteriam.calculator.exceptions.OperationNotValidException;
import com.iteriam.calculator.model.Addition;
import com.iteriam.calculator.model.Operation;
import com.iteriam.calculator.model.Substraction;

@Service
public class OperationService {

	/**
	 * Metodo que recoge la logica de la calculadora. Identifica la operacion y llama a la operación matematica que aplique.
	 * Finalmente devuelve el resultado de la operacion.
	 * 
	 * @param elem1
	 * @param elem2
	 * @param operator
	 * @return
	 * @throws OperationNotValidException
	 */
	public double calculate(double elem1, double elem2, String operator) throws OperationNotValidException {
		
		Operation oper = null;
		
		if(operator.equals(OperationsEnum.ADDITION.getOperator())) {
			oper = new Addition(elem1, elem2);
		}else if(operator.equals(OperationsEnum.SUSTRACTION.getOperator())) {
			oper = new Substraction(elem1, elem2);
		}
		
		if(oper == null) {
			throw new OperationNotValidException("NOT VALID", "Operation [" + operator + "] not valid");
		}else {
			return oper.calculate(elem1, elem2);
		}
		
	}
	
}
