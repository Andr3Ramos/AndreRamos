package com.example.demo.Data;

import com.example.demo.Model.SaleItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository extends CrudRepository<SaleItem, Long> {


}
