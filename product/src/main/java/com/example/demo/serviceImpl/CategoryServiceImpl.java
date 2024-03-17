package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BO.Response;
import com.example.demo.dao.CategoryDao;
import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Response addCategory(Category category) throws Exception {
		Response response = new Response();
		try {
			Category existingCategoryByName = categoryDao.getCategoryByName(category.getCategoryName());
			System.out.println(existingCategoryByName);
			if (null != existingCategoryByName) {
				response.setResponseMessage("Category Saving Failed: Category Name Already Present...");
				response.setResponseStatus(false);

			} else {
				categoryDao.save(category);
				response.setResponseMessage("Category Saved Successfully...");
				response.setResponseStatus(true);
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public Response updateCategory(Category category) throws Exception {
		Response response = new Response();
		try {

			if (null != category.getCategoryId()) {
				Optional<Category> cat = categoryDao.findById(category.getCategoryId());
				Category catById = null;
				if (null != cat && !cat.isEmpty()) {
					catById = new Category();
					catById = cat.get();
				}
				Category exstingCategoryByName = categoryDao.getCategoryByName(category.getCategoryName());
				if (null != exstingCategoryByName) {
					response.setResponseMessage("Updation Failed:Provided Category Name Already Exist");
					response.setResponseStatus(false);
				} else {
					if (null != catById) {
						catById.setCategoryName(category.getCategoryName());
						catById.setDescription(category.getDescription());
						categoryDao.save(catById);
						response.setResponseMessage("Updation Done Sucessfully...");
						response.setResponseStatus(true);
					} else {
						response.setResponseMessage("Updation Failed:Provided Category Id not Present");
						response.setResponseStatus(false);
					}
				}
			}
		} catch (Exception e) {
			throw e;

		}
		return response;
	}

	@Override
	public List<Category> getAllCategories() throws Exception {
		List<Category> categoryList = new ArrayList<>();
		try {
			categoryList = categoryDao.findAll();
			if (null != categoryList && !categoryList.isEmpty()) {
				return categoryList;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Long getAllCategoriesCount() throws Exception {
		try {
			return categoryDao.count();
		} catch (Exception e) {
			throw e;
		}
	}

}
