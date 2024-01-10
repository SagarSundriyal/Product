package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{

	//ProductEntity save(ProductEntity user);

	
}