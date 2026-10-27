package com.example.product.support;

import com.example.product.support.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class ProductExceptionSupplier {
    public Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
