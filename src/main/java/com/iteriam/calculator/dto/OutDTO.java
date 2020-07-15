package com.iteriam.calculator.dto;

public class OutDTO {
	private String message;
	private double result;
	
	public OutDTO() {}

	
	public OutDTO(String message, double result) {
		super();
		this.message = message;
		this.result = result;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	
	
	
	
}
