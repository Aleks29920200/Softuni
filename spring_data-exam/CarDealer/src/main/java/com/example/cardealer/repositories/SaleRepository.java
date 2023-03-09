package com.example.cardealer.repositories;

import com.example.cardealer.dto.SaleInputDto;
import com.example.cardealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{
    @Query("select count(s.car) from Sale s")
    List<Sale> CustomerWithTotalSales();
}
