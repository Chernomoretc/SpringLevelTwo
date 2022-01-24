package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.repositories.ProductsRepository;
import com.geekbrains.spring.web.soap.ProductSoap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceSoap {
    private final ProductsRepository productsRepository;

    public static final Function <Product, ProductSoap> functionEntityToSoap = se->{
        ProductSoap productSoap = new ProductSoap();
        productSoap.setId(se.getId());
        productSoap.setName(se.getTitle());
        productSoap.setPrice(se.getPrice());
        return productSoap;
    };

    public List<ProductSoap> getAllProducts()
    {
        return productsRepository.findAll().stream()
                .map(functionEntityToSoap).collect(Collectors.toList());
    }


    public ProductSoap geById(Long id)
    {
        return productsRepository.findById(id).map(functionEntityToSoap).get();
    }
}
