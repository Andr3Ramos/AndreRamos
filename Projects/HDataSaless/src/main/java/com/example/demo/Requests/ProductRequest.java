package com.example.demo.Requests;

public class ProductRequest {

    private Long productId;
    private Double quantitySold;

    public Long getProductId() {
        return productId;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Double quantitySold) {
        this.quantitySold = quantitySold;
    }
}
