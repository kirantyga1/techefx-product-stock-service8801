package com.techefx.microservices.productstockservice.techefxproductstockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techefx.microservices.productstockservice.techefxproductstockservice.entity.ProductStock;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {

	ProductStock findByProductName(String productName);

	//@Query("select p from ProductStock p where p.productName= :productName and p.productAvailability = :productAvailability")
	ProductStock findByProductNameAndProductAvailability(String productName, String productAvailability);

	
}
