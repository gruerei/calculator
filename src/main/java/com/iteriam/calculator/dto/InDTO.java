package com.iteriam.calculator.dto;


import javax.validation.constraints.NotNull;


public class InDTO {
	
	@NotNull(message = "elem1 is mandatory")
	private Double elem1;
	
	@NotNull(message = "elem2 is mandatory")
	private Double elem2;
	
	@NotNull(message = "operation is mandatory")
	private String operation;
	
	
	public InDTO(Double elem1, Double elem2, String operation) {
		this.elem1 = elem1;
		this.elem2 = elem2;
		this.operation = operation;
	}
	
	public InDTO() {}


	public Double getElem1() {
		return elem1;
	}


	public void setElem1(Double elem1) {
		this.elem1 = elem1;
	}


	public Double getElem2() {
		return elem2;
	}


	public void setElem2(Double elem2) {
		this.elem2 = elem2;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	
	
	
	
	
}
