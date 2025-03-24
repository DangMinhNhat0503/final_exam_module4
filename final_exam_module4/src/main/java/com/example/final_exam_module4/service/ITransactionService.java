package com.example.final_exam_module4.service;

import com.example.final_exam_module4.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionService extends IService <Transaction> {
    Page<Transaction> findByCustomerNameContainingIgnoreCase (String name, Pageable pageable);
}

