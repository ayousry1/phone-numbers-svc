package com.jumia.phonenumber.resources.customer.control;

import com.jumia.phonenumber.repositories.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
}
