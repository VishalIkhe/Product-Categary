package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BO.Response;
import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("rest/api/category/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("add-new-category")
	public Response addCategory(@RequestBody Category category) {
		Response response = new Response();
		try {
			return categoryService.addCategory(category);
		} catch (Exception e) {
			response.setResponseMessage("Insertion Failed:Something Error Occured Try Again Please...");
			response.setResponseStatus(false);
		}
		return response;
	}

	@PutMapping("edit-category")
	public Response updateCategory(@RequestBody Category category) {
		Response response = new Response();
		try {
			response = categoryService.updateCategory(category);
		} catch (Exception e) {
			response.setResponseMessage("Updation Failed:Something Error Occured Try Again Please...");
			response.setResponseStatus(false);
			e.printStackTrace();

		}
		return response;
	}

	@GetMapping("get-all-category")
	public Response getAllCategory() {
		Response response = new Response();
		try {
			response.setCategoryList(categoryService.getAllCategories());
			response.setCategoryListCount(categoryService.getAllCategoriesCount());
			response.setResponseMessage("Get Category List Sucessfully");
			response.setResponseStatus(true);

		} catch (Exception e) {
			response.setResponseMessage("Getting Data Failed:Due to some Error");
			response.setResponseStatus(false);
		}
		return response;
	}
}
