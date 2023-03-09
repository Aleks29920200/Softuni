package com.example.springfundamentalsexam.repository;

import com.example.springfundamentalsexam.domain.entity.Condition;
import com.example.springfundamentalsexam.domain.enums.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepo extends JpaRepository<Condition, Long> {
    Condition findByConditionName(ConditionName conditionName);
}
