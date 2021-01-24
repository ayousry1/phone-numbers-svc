package com.jumia.phonenumber.resources.customer.control;

import com.jumia.phonenumber.repositories.customer.entity.Customer;
import com.jumia.phonenumber.resources.customer.entity.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> getAllCustomers();
}
