package com.microservices.CustomerData.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.CustomerData.Modal.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
