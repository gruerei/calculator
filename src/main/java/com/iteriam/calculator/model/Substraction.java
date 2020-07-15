package com.iteriam.calculator.model;


public class Substraction extends Operation{

	public Substraction(double elem1, double elem2) {
		super(elem1, elem2);
	}

	@Override
	public double calculate(double elem1, double elem2) {
		super.result = elem1 - elem2;
		return super.result;
	}

}
