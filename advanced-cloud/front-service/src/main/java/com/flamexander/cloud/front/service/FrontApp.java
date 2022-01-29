package com.flamexander.cloud.front.service;

import com.flamexander.cloud.common.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class FrontApp {
    @Autowired
    private RestTemplate restTemplate;



    public static void main(String[] args) {
        SpringApplication.run(FrontApp.class, args);
    }

//    @GetMapping("/api/v1/front")
//    public List<ProductDto> getAllProducts()
//    {
//        return restTemplate.getForObject("http://products-service/api/v1/products",List.class);
//    }

}
