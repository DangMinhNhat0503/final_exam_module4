package com.example.final_exam_module4.service.impl;

import com.example.final_exam_module4.entity.Customer;
import com.example.final_exam_module4.repository.ICustomerRepository;
import com.example.final_exam_module4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer s) {

    }

    @Override
    public void update(long id, Customer s) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return List.of();
    }



}
