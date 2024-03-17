package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BO.Response;
import com.example.demo.dao.ProductDao;
import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Response addProduct(Product product) throws Exception {
		Response response = new Response();
		try {
			productDao.save(product);
			response.setResponseStatus(true);
			response.setResponseMessage("Product Saved Succesfully...");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public Response updateProduct(Product product) throws Exception {
		Response response=new Response();
		try {
			if (null != product.getProductId() && product.getProductId() > 0) {
				Optional<Product> existingProductOptional = productDao.findById(product.getProductId());
				if(null!=existingProductOptional && !existingProductOptional.isEmpty()) {
					existingProductOptional.get().setCategory(product.getCategory());
					existingProductOptional.get().setDescription(product.getDescription());
					existingProductOptional.get().setExpiryDate(product.getExpiryDate());
					existingProductOptional.get().setPrice(product.getPrice());
					existingProductOptional.get().setManufacturedDate(product.getManufacturedDate());
					productDao.save(existingProductOptional.get());
					response.setResponseStatus(true);
					response.setResponseMessage("Product Updated Succesfully...");
				}
				else {
					response.setResponseStatus(false);
					response.setResponseMessage("Product Not Present With Given Product Id");
				}
				
			}else {
				response.setResponseStatus(false);
				response.setResponseMessage("Product Id is Null:Provide correct Product Id");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
