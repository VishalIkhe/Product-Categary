package com.example.demo.service;

import com.example.demo.BO.Response;
import com.example.demo.entities.*;
public interface ProductService {

	public Response addProduct(Product product) throws Exception;
	
	public Response updateProduct(Product product) throws Exception;
}
