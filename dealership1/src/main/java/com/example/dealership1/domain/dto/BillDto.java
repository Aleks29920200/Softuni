package com.example.dealership1.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class BillDto {
    private BigDecimal amount;
    private java.math.BigDecimal price;
}
