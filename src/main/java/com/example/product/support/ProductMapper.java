package com.example.product.support;

import com.example.product.api.request.ProductRequest;
import com.example.product.api.request.UpdateProductRequest;
import com.example.product.api.response.ProductResponse;
import com.example.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return new Product(request.getName());
    }

    public Product updateProduct(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
