package com.example.demo.Data;

import com.example.demo.Model.SaleItem;
import org.springframework.data.repository.CrudRepository;

public interface SaleItemRepository extends CrudRepository<SaleItem, Long> {


    SaleItem findById(long id);
}
