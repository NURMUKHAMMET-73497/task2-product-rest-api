package com.example.product.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProductResponse {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "Laptop")
    private String name;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
