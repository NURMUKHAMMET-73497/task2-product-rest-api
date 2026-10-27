package com.example.product.service;

import com.example.product.api.request.ProductRequest;
import com.example.product.api.request.UpdateProductRequest;
import com.example.product.api.response.ProductResponse;
import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.support.ProductExceptionSupplier;
import com.example.product.support.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductExceptionSupplier exceptionSupplier;

    public ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper,
            ProductExceptionSupplier exceptionSupplier
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.exceptionSupplier = exceptionSupplier;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        return productMapper.toProductResponse(findEntity(id));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = findEntity(id);
        Product updatedProduct = productMapper.updateProduct(product, request);
        Product savedProduct = productRepository.save(updatedProduct);
        return productMapper.toProductResponse(savedProduct);
    }

    public void delete(Long id) {
        // Verify that the product exists first so a missing id results in HTTP 404.
        findEntity(id);
        productRepository.deleteById(id);
    }

    private Product findEntity(Long id) {
        return productRepository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
    }
}
