package com.example.demo.Data;

import com.example.demo.Model.Sale;
import com.example.demo.Model.SaleItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale,Long> {

  //  void makeSale();
/*
    @Query("INSERT INTO  Sales(clientid,storeId,productIds) VALUES (:client_Id, :store_Id , :items)")
    @Modifying
    @Transactional
    void makeSale(@Param("clientId") long clientId, @Param("storeId") long storeId, @Param("productIds") List<SaleItem> items );
*/



}
