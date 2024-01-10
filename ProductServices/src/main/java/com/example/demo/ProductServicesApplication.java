package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
//@EnableSwagger2
public class ProductServicesApplication {//extends SpringBootServletInitializer{

	/*@Bean
	@LoadBalanced
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}*/
	

	public static void main(String[] args) {
		SpringApplication.run(ProductServicesApplication.class, args);
	}
}
/* <!-- https://mvnrepository.com/artifact/io.github.resilience4j/resilience4j-spring-boot2 -->
<dependency>
<groupId>io.github.resilience4j</groupId>
<artifactId>resilience4j-spring-boot2</artifactId>
</dependency>
*/