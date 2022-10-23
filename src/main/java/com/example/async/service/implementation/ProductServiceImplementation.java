package com.example.async.service.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.async.model.Product;
import com.example.async.service.IProducService;

@Service
public class ProductServiceImplementation implements IProducService {

	@Override
	public List<Product> getProducts1() {
		return Arrays.asList(
					new Product(1, "Product 1"),
					new Product(2, "Product 2"),
					new Product(3, "Product 3")
				);
	}

	@Override
	public List<Product> getProducts2() {
		return Arrays.asList(
				new Product(4, "Product 4"),
				new Product(5, "Product 5"),
				new Product(6, "Product 6")
			);
	}

	@Override
	public List<Product> getProducts3() {
		return Arrays.asList(
				new Product(7, "Product 7"),
				new Product(8, "Product 8"),
				new Product(9, "Product 9")
			);
	}

}
