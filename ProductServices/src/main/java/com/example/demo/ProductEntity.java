package com.example.demo;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//@Column(name = "ID")
    private Long productId;

    private String productName;
    private String category;
    private String price;
    private String range;
    //other user properties that you want
    //private  String categoryId;
    
    @Transient
    CategoryEntity categorylist = new CategoryEntity();
   // List<CategoryEntity> categorylist=new ArrayList<>();
  //ratings.add(categoryId);
  
    
	public Long getProductId() {
		return productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public CategoryEntity getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(CategoryEntity categorylist) {
		this.categorylist = categorylist;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", range=" + range + ", categorylist=" + categorylist + "]";
	}

	public ProductEntity() {
		
	}

	public ProductEntity(Long productId, String productName, String category, String price, String range,
			CategoryEntity categorylist) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.range = range;
		this.categorylist = categorylist;
	}
	




}