package com.iteriam.calculator.service.impl;

import org.springframework.stereotype.Service;

import com.iteriam.calculator.service.OperationService;

/**
 * Clase para la Operación RESTA.
 * @author Gabriel
 *
 */
@Service
public class SubtractionService implements OperationService {


	@Override
	public double calculate(double elem1, double elem2) {
		return elem1 - elem2;
	}


}
