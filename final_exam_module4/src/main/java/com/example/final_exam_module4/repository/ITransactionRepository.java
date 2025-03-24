package com.example.final_exam_module4.repository;

import com.example.final_exam_module4.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByCustomer_CustomerNameContainingIgnoreCase(String name, Pageable pageable);

}
