package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BO.Response;

import com.example.demo.entities.*;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("rest/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@PostMapping("/add-new-product")
	public Response addProduct(@RequestBody Product product) {
		Response response=new Response();
		try {
			response= productService.addProduct(product);
		}
		catch(Exception e) {
			response.setResponseMessage("Product Insertion Failed Due to Some Error");
			response.setResponseStatus(false);
		}
		return response;
	}
	@PostMapping("/edit-product")
	public Response editProduct(@RequestBody Product product) {
		Response response=new Response();
		try {
			response= productService.updateProduct(product);
		}
		catch(Exception e) {
			response.setResponseMessage("Product Updation Failed Due to Some Error");
			response.setResponseStatus(false);
		}
		return response;
	}
}
