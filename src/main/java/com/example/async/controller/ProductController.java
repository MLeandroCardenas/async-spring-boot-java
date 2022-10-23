package com.example.async.controller;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.model.Product;
import com.example.async.service.IProducService;
import com.example.async.service.IProductAsyncService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private IProducService productService;
	
	@Autowired
	private IProductAsyncService productServiceAsync;
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() throws Exception {
		long startTime = System.currentTimeMillis();
		
		List<Product> list1 = productService.getProducts1();
		List<Product> list2 = productService.getProducts2();
		List<Product> list3 = productService.getProducts3();
		List<Product> finalList = Stream.of(list1, list2, list3)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		long endTime = System.currentTimeMillis();
		log.info("Time: ", endTime - startTime);
		return new ResponseEntity<List<Product>>(finalList,HttpStatus.OK);
	}
	
	@GetMapping("/async")
	public ResponseEntity<List<Product>> getAllProductsAsync() throws Exception {
		long startTime = System.currentTimeMillis();
		
		CompletableFuture<List<Product>> c1 = productServiceAsync.getProducts1();
		CompletableFuture<List<Product>> c2 = productServiceAsync.getProducts2();
		CompletableFuture<List<Product>> c3 = productServiceAsync.getProducts3();
		
		CompletableFuture.allOf(c1, c2, c3).join();
		
		List<Product> finalList = Stream.of(c1.get(), c2.get(), c3.get())
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		long endTime = System.currentTimeMillis();
		log.info("Time: ", endTime - startTime);
		return new ResponseEntity<List<Product>>(finalList,HttpStatus.OK);
	}

}
