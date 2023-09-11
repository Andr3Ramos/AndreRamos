package com.example.demo.Data;

import com.example.demo.Model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Modifying
    @Query("UPDATE Product product SET product.stock = product.stock + :stockToAdd WHERE product.id = :productId")
    int addStockToProductById(long productId, double stockToAdd);

    Product findProductById(long productId);

    void removeProductById(long productId);
    List<Product> findAll();

   @Query(value = "SELECT * FROM Product product ORDER BY stockSold DESC LIMIT 1", nativeQuery= true )
   Product productWithMostSells();

   @Query("insert into Product (name,category,sellPrice,buyPrice,stock) VALUES (:name,:category,:sellPrice,:buyPrice,:stock)")
   @Modifying
   @Transactional
   void saveProduct(@Param("name")String name,
             @Param("category") String category,
             @Param("sellPrice") double sellPrice,
             @Param("buyPrice") double buyPrice,
             @Param("stock") double stock);




}
