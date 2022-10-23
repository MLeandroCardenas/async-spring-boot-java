package com.example.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.async.model.Product;

public interface IProductAsyncService {
	
	CompletableFuture<List<Product>> getProducts1() throws InterruptedException;
	CompletableFuture<List<Product>> getProducts2() throws InterruptedException;
	CompletableFuture<List<Product>> getProducts3() throws InterruptedException;

}
