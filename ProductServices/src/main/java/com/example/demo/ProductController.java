package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService ratingService; ///create  getall  get
    
    //@Autowired(required=false)
    //private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<ProductEntity> createUser(@RequestBody ProductEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(user));//user1);
    }

    @GetMapping("{id}")
   // public ResponseEntity<ProductEntity> createHotel(@PathVariable("id") Long productId) {
    @CircuitBreaker(name = "productCircuitBreaker", fallbackMethod = "ratingFallback")
    public ProductEntity createHotel(@PathVariable("id") Long productId) {
    	   RestTemplate restTemplate = new RestTemplate();
    	System.out.println("---line 40 CONTROLLER "+productId);
    	
    	ProductEntity product = this.ratingService.get(productId);
    	
    	CategoryEntity list = restTemplate.getForObject("http://localhost:8920/category/"+productId, CategoryEntity.class);
    	System.out.println("---line 42 CONTROLLER "+list);
    	product.setCategorylist(list);
        return product;
        //return ResponseEntity.status(HttpStatus.OK).body(ratingService.get(productId));
    }
    
    //Fallback mechanism
    public ProductEntity ratingFallback(Long productId, RuntimeException throwable) { //FALLBACK
         System.out.println(" Services is down");
         CategoryEntity categoryEntity = new CategoryEntity();
         return new ProductEntity(productId, "no data found" , "service down", "down", "no data" , categoryEntity); 
    }
    
  
    //single user get
    @GetMapping("/filter")//("")//{id}") //userId
   //public ResponseEntity<ProductEntity> getSingleUser(@RequestParam int pageNumber,
    public ResponseEntity<ProductEntity>  getSingleUser(@RequestParam int pageNumber,
		   @RequestParam int pageSize,   
		   @RequestParam(name="productName", required=false) String productName, 
		   @RequestParam(name="category", required=false) String category,
		   @RequestParam(name="price", required=false) String price,
		   @RequestParam(name="range", required=false) String range,
		   @RequestParam(name="productId", required=false) Long userId) {//@PathVariable("id") Long userId) {
    	System.out.println("==line37 controller =="+userId);
    // ProductEntity user = ratingService.get(userId);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(ratingService.get(pageNumber, pageSize, productName, category, price, range, userId));
   // return ResponseEntity.status(HttpStatus.OK).body(ratingService.get(userId));
    }
    
   
/*
    @ApiOperation(value = "Get All Posts REST API")
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }*/
    
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllUser() {
        List<ProductEntity> allUser = ratingService.getAll();
        System.out.println("==line48  allUser =="+allUser);
        return ResponseEntity.ok(allUser);
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<ProductEntity> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody ProductEntity user){
        user.setProductId(userId);
        ProductEntity updatedUser = ratingService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
    	ratingService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
    
 

}