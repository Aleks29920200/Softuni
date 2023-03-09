package com.example.springfundamentalsexam.domain.entity;


import com.example.springfundamentalsexam.domain.enums.ConditionName;
import jakarta.persistence.*;

@Entity
@Table(name="conditions")
public class Condition extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private ConditionName conditionName;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Condition() {

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConditionName getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionName conditionName) {
        this.conditionName = conditionName;
    }
}
