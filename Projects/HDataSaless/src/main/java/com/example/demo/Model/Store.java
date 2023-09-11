package com.example.demo.Model;/*
* Here we get the core of the program with the store information
* The goal here is to store all the values of the store
* And make the bridge for the sales and the products.
* */
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private long id;
    private String name;
    private Integer nif;
    private String address;
    @OneToMany
    private List<Product> productList;


    public Store(String name, Integer nif, String address) {
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.productList = new ArrayList<>();
    }

    public Store() {

    }


    public void addProduct(Product product) {
        if (this.productList == null) {
            this.productList = new ArrayList<>();
        }
        this.productList.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
