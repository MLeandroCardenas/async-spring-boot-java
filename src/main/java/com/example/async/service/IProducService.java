package com.example.async.service;

import java.util.List;
import com.example.async.model.Product;

public interface IProducService {
	
	List<Product> getProducts1() throws InterruptedException;
	List<Product> getProducts2() throws InterruptedException;
	List<Product> getProducts3() throws InterruptedException;

}
