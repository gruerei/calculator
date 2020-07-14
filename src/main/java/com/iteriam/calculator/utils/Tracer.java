package com.iteriam.calculator.utils;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;

@Component
public class Tracer implements TracerAPI {

	private io.corp.calculator.TracerImpl tracerExt;
	
	public Tracer() {
		tracerExt = new io.corp.calculator.TracerImpl();
	}
	
	@Override
	public <T> void trace(T result) {
		tracerExt.trace(result);
	}

}
