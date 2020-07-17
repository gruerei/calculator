package com.iteriam.calculator.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.iteriam.calculator.dto.ErrorDTO;
import com.iteriam.calculator.exceptions.OperationNotValidException;

/**
 * Manejador Global de Excepciones.
 * @author Gabriel
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	Tracer tracer;

	/**
	 * Recoge las excepciones causadas por la Validacion de los Parametros de Entrada, la traza con Tracer
	 * y la devuelve en un ErrorDTO con formato amigable.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<?> globalExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		StringBuffer errorMsgs = new StringBuffer();
		for (FieldError fieldError : fieldErrors) {
			errorMsgs.append(fieldError.getDefaultMessage() + ". ");
		}

		ErrorDTO errorDetails = new ErrorDTO(errorMsgs.toString(), request.getDescription(false));
		tracer.trace("ERROR:" + errorMsgs.toString());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	/**
	 * * Recoge las excepciones causadas por la Validacion de Operaciones no Soportadas, la traza con Tracer
	 * y la devuelve en un ErrorDTO con formato amigable.
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(OperationNotValidException.class)
	public ResponseEntity<?> globalExceptionHandler(OperationNotValidException ex, WebRequest request) {

		ErrorDTO errorDetails = new ErrorDTO(ex.getMessage(), request.getDescription(false));
		tracer.trace("ERROR:" + ex.getMessage());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}

}
