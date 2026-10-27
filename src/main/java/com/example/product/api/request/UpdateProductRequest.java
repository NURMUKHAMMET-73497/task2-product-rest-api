package com.example.product.api.request;

public class UpdateProductRequest extends ProductRequest {
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
