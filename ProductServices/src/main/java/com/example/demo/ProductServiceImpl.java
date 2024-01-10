package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository userRepository;

   /* @Autowired(required=false)
    private RestTemplate restTemplate;  
    /*public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

 // private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private static final String SERVICE1_URL = "http://localhost:8920/category";


    @Override
    public ProductEntity create(ProductEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<ProductEntity> getAll() {
   	 System.out.println("==-------------line45----------------==");
     System.out.println("=user line 46 = "+userRepository.findAll());
        return userRepository.findAll();
    }

  
    @Override
    public ProductEntity get(Long id) {
   	 return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category with given id not found !!"));
    }

    @Override
	public ProductEntity updateUser(ProductEntity user) {
    	ProductEntity existingUser = userRepository.findById(user.getProductId()).get();
	        existingUser.setProductName(user.getProductName());
	        existingUser.setCategory(user.getCategory());
	        existingUser.setPrice(user.getPrice());
	        existingUser.setRange(user.getRange());
	        ProductEntity updatedUser = userRepository.save(existingUser);
	        return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public ProductEntity get(int pageNumber, int pageSize, String productName, String category, String price,
			String range, Long userId) {
		// TODO Auto-generated method stub
	 	 return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("category with given id not found !!"));
	}

}