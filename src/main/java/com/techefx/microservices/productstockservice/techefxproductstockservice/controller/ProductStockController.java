package com.techefx.microservices.productstockservice.techefxproductstockservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productstockservice.techefxproductstockservice.benas.ProductStockBean;
import com.techefx.microservices.productstockservice.techefxproductstockservice.entity.ProductStock;
import com.techefx.microservices.productstockservice.techefxproductstockservice.repository.ProductStockRepository;

@RestController
public class ProductStockController {

	@Autowired
	Environment environment;

	@Autowired
	ProductStockRepository repository;

	@GetMapping(value = "/{productName}")
	public ProductStock checkProductStock(@PathVariable String productName) {

		ProductStock productStock = repository.findByProductName(productName);

		return productStock;
	}

	@GetMapping(value = "/{productName}/{productAvailability}")
	public ProductStock checkProductStock(@PathVariable String productName, @PathVariable String productAvailability) {

		ProductStock productStock = repository.findByProductNameAndProductAvailability(productName,
				productAvailability);

		ProductStockBean productStockBean = new ProductStockBean(productStock.getId(), productStock.getProductName(),
				productStock.getProductPrice(), productStock.getProductAvailability(), productStock.getDiscountOffer(),
				Integer.parseInt(environment.getProperty("local.server.port")));

		return productStock;
	}

}