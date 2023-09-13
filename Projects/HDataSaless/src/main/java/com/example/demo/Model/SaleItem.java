package com.example.demo.Model;/*
*SalesItem class if the one that will  be completing our sale
* since a sale can have many products and quantities
* here we provide methods for quantities, costs and profits
*/
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="sale_items")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantitySold;
    private double totalCost;

    public SaleItem() {
    }
    public SaleItem(Product product, int quantitySold){
        this.product = product;
        this.quantitySold = quantitySold;
        this.product.setStock(product.getStock()-quantitySold);
    }
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    public Product getProducts() {
        return product;
    }
    public int getQuantitySold() {
        return quantitySold;
    }
    public double getTotalCost(){
        return totalCost = product.getSellPrice() * quantitySold;
    }

}
