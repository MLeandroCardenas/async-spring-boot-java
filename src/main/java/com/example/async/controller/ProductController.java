package com.example.async.controller;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.model.Product;
import com.example.async.service.IProducService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private IProducService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() throws Exception {
		List<Product> list1 = productService.getProducts1();
		List<Product> list2 = productService.getProducts2();
		List<Product> list3 = productService.getProducts3();
		List<Product> finalList = Stream.of(list1, list2, list3)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		return new ResponseEntity<List<Product>>(finalList,HttpStatus.OK);
	}

}
