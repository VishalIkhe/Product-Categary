package com.example.demo.BO;

import java.util.List;

import com.example.demo.entities.Category;

public class Response {

	private Boolean responseStatus;

	private String responseMessage;

	private List<Category> categoryList;

	private Long categoryListCount;

	public Boolean getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Response(Boolean responseStatus, String responseMessage) {
		super();
		this.responseStatus = responseStatus;
		this.responseMessage = responseMessage;
	}

	public Response() {
		super();

	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Long getCategoryListCount() {
		return categoryListCount;
	}

	public void setCategoryListCount(Long categoryListCount) {
		this.categoryListCount = categoryListCount;
	}

	@Override
	public String toString() {
		return "Response [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage + ", categoryList="
				+ categoryList + ", categoryListCount=" + categoryListCount + "]";
	}

	public Response(Boolean responseStatus, String responseMessage, List<Category> categoryList,
			Long categoryListCount) {
		super();
		this.responseStatus = responseStatus;
		this.responseMessage = responseMessage;
		this.categoryList = categoryList;
		this.categoryListCount = categoryListCount;
	}

}
