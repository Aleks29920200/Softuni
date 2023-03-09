package com.example.dealership1.web;

import com.example.dealership1.domain.dto.ServiceDto;
import com.example.dealership1.domain.entity.Service;
import com.example.dealership1.domain.entity.Transaction;
import com.example.dealership1.services.BillServiceImpl;
import com.example.dealership1.services.ServiceImpl;
import com.example.dealership1.services.TransactionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class TransactionController {
    private ServiceImpl service;
    private TransactionServiceImpl transactionService;
    private ModelMapper mapper;
    private BillServiceImpl billService;
    private QRCodeController qrCodeController;

    public TransactionController(ServiceImpl service, TransactionServiceImpl transactionService, ModelMapper mapper, BillServiceImpl billService, QRCodeController qrCodeController) {
        this.service = service;
        this.transactionService = transactionService;
        this.mapper = mapper;
        this.billService = billService;
        this.qrCodeController = qrCodeController;
    }
    @PostMapping("/add-transaction/cosmeticService/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String select(@PathVariable Long id, ModelAndView model){
        Service serviceById = this.service.findServiceById(id);
        Transaction transaction = transactionService.addTransaction(mapper.map(serviceById, ServiceDto.class));
        model.setViewName("add-transaction");
        model.addObject("transaction",transaction);
        return "redirect:/all-transactions";
    }
    @GetMapping("/all-transactions")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String allTransactions(Model model){
        List<Transaction> all = this.transactionService.allTransactions();
        model.addAttribute("transactions",all);
        return "all-transactions";
    }
    @GetMapping("/all-transactions/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView deleteTransaction(@PathVariable Long id, ModelAndView model){
        Transaction transactionById = this.transactionService.findTransactionById(id);
        model.setViewName("delete-transaction");
        model.addObject("transaction",transactionById);
        return model;
    }
    @PostMapping("/all-transactions/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String deleteTransaction(@PathVariable Long id){
        this.transactionService.deleteById(id);
        return "redirect:/all-transactions";
    }
    @ModelAttribute(name="allTransactions")
    public List<Transaction> allTransactions() {
        return this.transactionService.allTransactions();
    }
}
