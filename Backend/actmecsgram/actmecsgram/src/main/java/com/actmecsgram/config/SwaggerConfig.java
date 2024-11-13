package com.actmecsgram.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	  public OpenAPI customOpenAPI() { return new OpenAPI() .info(new
	  Info().title("Atmecsgram Service API") .description("API documentation for the Atmecsgram service")
	  .version("1.0"));
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
			return new RestTemplate();
	}
}
