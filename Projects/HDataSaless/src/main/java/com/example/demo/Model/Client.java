package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "client_id")
    private long id;

   @Column(name= "name")
    private String name;
    private static int idCounter;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> sales;

    public Client(String name) {
        this.name = name;
        id = generateSerialNumber();
    }

    public Client() {

    }

    public static int generateSerialNumber() {
        return idCounter++;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
