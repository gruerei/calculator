package com.iteriam.calculator.model;


public class Addition extends Operation{

	public Addition(double elem1, double elem2) {
		super(elem1, elem2);
	}

	@Override
	public double calculate(double elem1, double elem2) {
		super.result = elem1 + elem2;
		return super.result;
	}

}
