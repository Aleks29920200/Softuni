package com.example.dealership1.services;

import com.example.dealership1.domain.dto.ServiceDto;
import com.example.dealership1.domain.entity.Transaction;
import com.example.dealership1.repositories.TransactionRepo;
import com.example.dealership1.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private LoggedUser loggedUser;
    private TransactionRepo transactionRepo;
    private ModelMapper mapper;

    private ServiceImpl service;
    private BillServiceImpl billService;
    private UserServiceImpl userService;
    public TransactionServiceImpl(LoggedUser loggedUser, TransactionRepo transactionRepo, ModelMapper mapper, ServiceImpl service, BillServiceImpl billService, UserServiceImpl userService) {
        this.loggedUser = loggedUser;
        this.transactionRepo = transactionRepo;
        this.mapper = mapper;
        this.service = service;
        this.billService = billService;
        this.userService = userService;
    }

    @Override
    public List<Transaction> allTransactions() {
        return this.transactionRepo.findAll();
    }

    @Override
    public Transaction addTransaction(ServiceDto map) {
        Transaction transaction=new Transaction();
        transaction.setStartDate(LocalDateTime.now());
        transaction.setExpirationDate(LocalDateTime.of(LocalDate.now(),LocalTime.MIDNIGHT));
        transaction.setService(this.service.findServiceByName(map.getName()));
        transaction.setBill(this.billService.addBill(map));
        transaction.setUser(this.userService.findUserByUsername(loggedUser.getUsername()));
        return transactionRepo.saveAndFlush(transaction);
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return this.transactionRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.transactionRepo.deleteById(id);
    }
}
