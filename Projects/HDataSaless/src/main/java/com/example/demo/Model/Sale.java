package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.List;
/*
 * The com.example.demo.Model.Sale class with be hold all of our data
 */

@Entity
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private double totalprice;
    public Sale(Client client, Store store,List<SaleItem> items,double totalprice) {
        this.client = client;
        this.store = store;
        this.items = items;
        this.totalprice = totalprice;
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
