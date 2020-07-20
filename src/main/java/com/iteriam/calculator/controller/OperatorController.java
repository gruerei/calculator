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
import com.iteriam.calculator.service.OperationsEnum;
import com.iteriam.calculator.service.impl.AdditionService;
import com.iteriam.calculator.service.impl.SubtractionService;
import com.iteriam.calculator.utils.Tracer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/")
@Api(tags = "Este Controller devuelve el resultado de la operación invocada mediante parametros.") 
public class OperatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);
	
	@Autowired
	AdditionService additionService;
	
	@Autowired
	SubtractionService subtractionService;
	
	
	@Autowired
	Tracer tracer;

	@ApiOperation(produces = "application/json", value = "Devuelve la Operación Resultado. LOS OPERADORES VALIDOS SON: '+' -> SUMA , '-' -> RESTA. "
			+ "Si la operacion no se reconoce devuelve una OperationNotValidException.")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Syntax for Client Request.", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error.", response = ErrorDTO.class) })
	@PostMapping(value = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OutDTO> operationEndpoint(@Validated @RequestBody InDTO inDTO) throws OperationNotValidException,
	MethodArgumentNotValidException {
		
		logger.info("Endpoint POST called -> /calculator");
		
		double result = 0;
		if(inDTO.getOperation().equals(OperationsEnum.ADDITION.getOperator())) {
			result =  additionService.calculate(inDTO.getElem1(), inDTO.getElem2());
		}else if(inDTO.getOperation().equals(OperationsEnum.SUSTRACTION.getOperator())) {
			result =  subtractionService.calculate(inDTO.getElem1(), inDTO.getElem2());
		} else {
			throw new OperationNotValidException("NOT VALID", "Operation [" + inDTO.getOperation() + "] not valid");
		}
			
		
		String outMsg = "The result of the " + inDTO.getOperation() + " operation is " + result;
		tracer.trace(outMsg);
		
		return new ResponseEntity<>(new OutDTO(outMsg, result), HttpStatus.OK);
	}
	
}
