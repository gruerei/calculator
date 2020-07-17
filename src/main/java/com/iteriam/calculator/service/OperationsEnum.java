package com.iteriam.calculator.service;

/**
 * Operaciones permitidas por la aplicación
 */
public enum OperationsEnum {
	ADDITION("+"),
	SUSTRACTION("-");
	
	private final String operator;

	private OperationsEnum(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
	
	
	
}
