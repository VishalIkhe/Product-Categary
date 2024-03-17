package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.*;

public interface CategoryDao extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.categoryName = :name")
	public Category getCategoryByName(@Param("name") String name);

}
