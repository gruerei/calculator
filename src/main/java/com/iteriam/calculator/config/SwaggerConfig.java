package com.iteriam.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración necesaria para el uso de SWAGGER2
 * @author Gabriel
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.iteriam.calculator.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Calculator: REST API")
				.description("REST API que devuelve el resultado de la operación invocada mediante parametros.")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}

}