package com.jumia.phonenumber.repositories.customer.boundary;

import com.jumia.phonenumber.repositories.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
