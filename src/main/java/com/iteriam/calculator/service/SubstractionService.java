package com.iteriam.calculator.service;

import org.springframework.stereotype.Service;

/**
 * Clase para la Operación RESTA.
 * @author Gabriel
 *
 */
@Service
public class SubstractionService implements OperationService {


	@Override
	public double calculate(double elem1, double elem2) {
		return elem1 - elem2;
	}


}
