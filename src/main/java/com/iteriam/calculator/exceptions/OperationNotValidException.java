package com.iteriam.calculator.exceptions;

public class OperationNotValidException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorCode;

    public OperationNotValidException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
