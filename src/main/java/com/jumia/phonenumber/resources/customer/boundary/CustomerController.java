package com.jumia.phonenumber.resources.customer.boundary;

import com.jumia.phonenumber.repositories.customer.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Ahmed Yousry
 *
 * this interface has all the customer controller configuration
 */

@RequestMapping("/customer")
public interface CustomerController {
    /**
     * <p>this method returns all customers
     * </p>
     * @return a list of customers
     */
    @GetMapping("/")
    List<Customer> getAllCustomers();
}
