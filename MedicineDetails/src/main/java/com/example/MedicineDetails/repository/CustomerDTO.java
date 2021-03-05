package com.example.MedicineDetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MedicineDetails.Model.Customer;
@Repository
public interface CustomerDTO extends CrudRepository<Customer,Integer>{
	Customer findById(int id); 
    List<Customer> findAll(); 
}
