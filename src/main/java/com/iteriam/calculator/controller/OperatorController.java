package com.iteriam.calculator.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.calculator.dto.ErrorDTO;
import com.iteriam.calculator.dto.InDTO;
import com.iteriam.calculator.dto.OutDTO;
import com.iteriam.calculator.exceptions.OperationNotValidException;
import com.iteriam.calculator.model.service.OperationService;
import com.iteriam.calculator.utils.Tracer;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/")
public class OperatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);
	
	@Autowired
	OperationService operationService;
	
	@Autowired
	Tracer tracer;

	@ApiOperation(produces = "application/json", value = "Devuelve la Operación Resultado. LOS OPERADORS VALIDOS SON: '+' -> SUMA , '-' -> RESTA")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Syntax for Client Request.", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
	@PostMapping(value = "/calculate_operation", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OutDTO> operationEndpoint(@Validated @RequestBody InDTO inDTO) throws OperationNotValidException,
	MethodArgumentNotValidException {
		
		logger.info("Endpoint GET called -> /calculate_operation");
		
		double result;
		try {
			result = operationService.calculate(inDTO.getElem1(), inDTO.getElem2(), inDTO.getOperation());
		} catch (OperationNotValidException e) {
			tracer.trace("ERROR:" + e.getMessage());
			throw e;
		}
		String outMsg = "The result of the " + inDTO.getOperation() + " operation is " + result;
		tracer.trace(outMsg);
		
		return new ResponseEntity<>(new OutDTO(outMsg, result), HttpStatus.OK);
	}
	
}
