package com.actmecsgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ActmecsgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActmecsgramApplication.class, args);
		System.out.println("App is Running Fine");
	}
	@Bean
	public RestTemplate restTemplate() {
			return new RestTemplate();
	}
	

}
