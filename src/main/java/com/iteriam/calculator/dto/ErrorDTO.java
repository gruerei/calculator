package com.iteriam.calculator.dto;

import java.io.Serializable;

/**
 * DTO for transferring error messages.
 */
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private String description;


    public ErrorDTO() {
    }

    public ErrorDTO(String message) {
        this(message, null);
    }

    public ErrorDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }
    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}
