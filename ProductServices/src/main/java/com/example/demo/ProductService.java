package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@Service
public interface ProductService {

	
    //create
     ProductEntity create(ProductEntity user);

    //get all user
    List<ProductEntity> getAll();

    //get single user of given userId
   ProductEntity get(Long userId); 

    ProductEntity updateUser(ProductEntity user);

    void deleteUser(Long userId);
    
   //public DaoProduct 
    ProductEntity get(int pageNumber, int pageSize, String productName, String category, String price, String range, 
    		Long userId);
    

}  