package com.iteriam.calculator.model;

/**
 * Clase Abstracta que da soporte a cualquier operación de la Calculadora.
 * @author Gabriel
 *
 */
public abstract class Operation {
	private double elem1;
	private double elem2;
	protected double result;
	
	public Operation(double elem1, double elem2) {
		this.elem1 = elem1;
		this.elem2 = elem2;
	}

	public double getElem1() {
		return elem1;
	}

	public double getElem2() {
		return elem2;
	}

	public double getResult() {
		return result;
	}
	
	
	public abstract double calculate(double elem1, double elem2);
	
}
