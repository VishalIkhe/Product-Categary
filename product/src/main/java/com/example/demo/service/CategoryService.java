package com.example.demo.service;

import com.example.demo.BO.Response;
import com.example.demo.entities.Category;
import java.util.List;

public interface CategoryService {

	public Response addCategory(Category category) throws Exception;

	public Response updateCategory(Category category) throws Exception;

	public List<Category> getAllCategories() throws Exception;
	
	public Long getAllCategoriesCount() throws Exception;
}
