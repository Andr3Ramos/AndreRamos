package com.example.demo.Data;

import com.example.demo.Model.Product;
import com.example.demo.Model.Store;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {
    Store findStoreById(long id);

    List<Store> findAll();

    @Query("INSERT INTO Store (name,nif,address) VALUES(:name, :nif, :address)")
    @Modifying
    @Transactional
    void save(@Param("name")String name,@Param("nif") Integer nif ,@Param("address") String address);


    @Query("UPDATE Store s SET s.productList = :product WHERE s.id = :storeId")
    @Modifying
    void addProductToStore(@Param("storeId") long storeId, @Param("product")Product product);





}
