package com.techefx.microservices.productstockservice.techefxproductstockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class TechefxProductStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechefxProductStockServiceApplication.class, args);
	}

}
