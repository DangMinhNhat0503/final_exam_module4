package com.example.final_exam_module4.service.impl;

import com.example.final_exam_module4.entity.Transaction;
import com.example.final_exam_module4.repository.ITransactionRepository;
import com.example.final_exam_module4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;


    @Override
    public List<Transaction> getAll() {
        return List.of();
    }

    @Override
    public void save(Transaction s) {

    }

    @Override
    public void update(long id, Transaction s) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Transaction findById(long id) {
        return null;
    }

    @Override
    public List<Transaction> findByName(String name) {
        return List.of();
    }

    @Override
    public Page<Transaction> findByCustomerNameContainingIgnoreCase(String name, Pageable pageable) {
        return transactionRepository.findByCustomer_CustomerNameContainingIgnoreCase(name, pageable);
    }
}
