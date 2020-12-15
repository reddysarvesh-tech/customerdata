package com.microservices.CustomerData.Contoller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.CustomerData.Dao.CustomerRepository;
import com.microservices.CustomerData.Modal.Customer;

@RestController
public class CustomerDataController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping("/users")
	public List<Customer> getAllCustomer() {
		var iteratorList = customerRepository.findAll();
		var customers = new ArrayList<Customer>();
		iteratorList.forEach(it -> customers.add(it));
		return customers;
	}
	
	@RequestMapping("/user/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id).get();
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

}
