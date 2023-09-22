package com.example.demo.Model;


import jakarta.persistence.*;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="product_id")
    private Long id;

    @JoinColumn(name = "product_name")
    private String name;
    private String category;
    private double sellPrice;
    private double buyPrice;
    private double stock;
    private Double stockSold=0.0;
    private Double stockSalesRecord = 0.0;

    public Product(String name, String category, double sellPrice, double buyPrice, double stock) {
        this.name = name;
        this.category = category;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.stock = stock;
    }


    public Product() {

    }



    public double getStockSold() {
        return stockSold;
    }

    public double getSellPrice() {
        return sellPrice;
    }
    public double getStock() {
        return stock;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }
    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setStockSold(double stockSold) {
        this.stockSold = stockSold;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getStockSalesRecord() {
        return stockSalesRecord;
    }

    public void setStockSalesRecord(Double amountPfStockSoldRecord) {
        this.stockSalesRecord += amountPfStockSoldRecord;
    }
}