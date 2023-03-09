package com.example.dealership1.services;

import com.example.dealership1.domain.dto.ServiceDto;
import com.example.dealership1.domain.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    List<Transaction>allTransactions();
    Transaction addTransaction(ServiceDto map);

    Transaction findTransactionById(Long id);

    void deleteById(Long id);
}
