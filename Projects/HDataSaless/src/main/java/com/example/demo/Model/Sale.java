package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
/*
 * The com.example.demo.Model.Sale class with be hold all of our data
 */

@Entity
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sale_id")
    private long id;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private double totalCost;
    public Sale(Client client, Store store, double totalCost,List<SaleItem> items) {
        this.client = client;
        this.store = store;
        this.totalCost = totalCost;
        this.items = items;
    }

    public Sale() {

    }

    public List<SaleItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (SaleItem item : items) {
            total += item.getProducts().getSellPrice() * item.getQuantitySold();
        }
        return total;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }



}
