package com.actmecsgram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
	@Bean
	  public OpenAPI customOpenAPI() { return new OpenAPI() .info(new
	  Info().title("Atmecsgram Service API") .description("API documentation for the Atmecsgram service")
	  .version("1.0"));
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Set the origin of your Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") 
                .allowedHeaders("*")
                .allowCredentials(true);
    }
	
}
