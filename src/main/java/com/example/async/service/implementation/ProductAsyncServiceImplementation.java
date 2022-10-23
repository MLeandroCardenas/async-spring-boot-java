package com.example.async.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.async.model.Product;
import com.example.async.service.IProductAsyncService;

@Service
public class ProductAsyncServiceImplementation implements IProductAsyncService {

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts1() throws InterruptedException {
		Thread.sleep(1000);
		List<Product> listProducts = Arrays.asList(
					new Product(1, "Product 1"),
					new Product(2, "Product 2"),
					new Product(3, "Product 3")
				);
		return CompletableFuture.completedFuture(listProducts);
	}

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts2() throws InterruptedException {
		Thread.sleep(3000);
		List<Product> listProducts = Arrays.asList(
				new Product(4, "Product 4"),
				new Product(5, "Product 5"),
				new Product(6, "Product 6")
			);
		return CompletableFuture.completedFuture(listProducts);
	}

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Product>> getProducts3() throws InterruptedException {
		Thread.sleep(2000);
		List<Product> listProducts = Arrays.asList(
				new Product(7, "Product 7"),
				new Product(8, "Product 8"),
				new Product(9, "Product 9")
			);
		return CompletableFuture.completedFuture(listProducts);
	}

}
