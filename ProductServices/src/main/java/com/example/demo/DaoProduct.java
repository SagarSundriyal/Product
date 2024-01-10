package com.example.demo;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DaoProduct {

	List<Map<Object,String>> items;
	int totalResult;
	int pageNumber;
	int pageSize;
	
	public DaoProduct() {
		
	}

	public List<Map<Object, String>> getItems() {
		return items;
	}

	public void setItems(List<Map<Object, String>> items) {
		this.items = items;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
