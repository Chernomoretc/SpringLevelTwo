package com.geekbrains.spring.web.endpoints;

import com.geekbrains.spring.web.services.ProductServiceSoap;
import com.geekbrains.spring.web.soap.GetAllProductsRequest;
import com.geekbrains.spring.web.soap.GetAllProductsResponse;
import com.geekbrains.spring.web.soap.GetProductByIdRequest;
import com.geekbrains.spring.web.soap.GetProductByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.com/spring/web/productsSoap";
    private final ProductServiceSoap productServiceSoap;

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById (@RequestPayload GetProductByIdRequest request)
    {
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setProduct(productServiceSoap.geById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts (@RequestPayload GetAllProductsRequest request)
    {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productServiceSoap.getAllProducts().forEach(response.getProducts()::add);
        return response;
    }
}
