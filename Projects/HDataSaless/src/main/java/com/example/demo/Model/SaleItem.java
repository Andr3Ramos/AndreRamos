package com.example.demo.Model;/*
 *SalesItem class if the one that will  be completing our sale
 * since a sale can have many products and quantities
 * here we provide methods for quantities, costs and profits
 */
import jakarta.persistence.*;

@Entity
@Table(name ="sale_items")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sale_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity_sold")
    private double quantitySold;

    private double totalCost;


    public SaleItem() {
    }
    public SaleItem(Product product, double quantitySold){
        this.product = product;
        this.quantitySold = quantitySold;
        this.product.setStock(product.getStock()-quantitySold);
        this.product.setStockSold(quantitySold);
        this.product.setStockSalesRecord(quantitySold);
        this.totalCost = (product.getSellPrice() * quantitySold);
    }


    public void setSale(Sale sale) {
        this.sale = sale;
    }
    public Product getProducts() {
        return product;
    }
    public double getQuantitySold() {
        return quantitySold;
    }
    public double getTotalCost(){
        return totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantitySold(double quantitySold) {
        this.quantitySold = quantitySold;
        product.setStockSold(quantitySold);
        product.setStock(quantitySold);
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


}