package com.example.cardealer.repositories;

import com.example.cardealer.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    @Query(value = "select * from car_dealer.parts order by RAND() limit 1",nativeQuery = true)
    Part randomParts();
}
