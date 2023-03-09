package com.example.dealership1.domain.dto;

import com.example.dealership1.domain.entity.ServiceCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDto {
    private String name;
    private float price;
    private String category;
}
