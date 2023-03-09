package com.example.cardealer.repositories;

import com.example.cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "select * from car_dealer.suppliers order by RAND() limit 1",nativeQuery = true)
Supplier randomSupplier();

}
