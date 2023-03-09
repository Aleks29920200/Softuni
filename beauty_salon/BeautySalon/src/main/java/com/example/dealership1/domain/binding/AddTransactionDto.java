package com.example.dealership1.domain.binding;


import com.example.dealership1.domain.dto.BillDto;
import com.example.dealership1.domain.dto.ServiceDto;
import com.example.dealership1.domain.entity.Employee;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddTransactionDto {

    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private boolean cancelled;
    private String user;
    private ServiceDto serviceName;

    public AddTransactionDto() {
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ServiceDto getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceDto serviceName) {
        this.serviceName = serviceName;
    }

}
