package com.jumia.phonenumber.resources.customer.boundary;

import com.jumia.phonenumber.repositories.customer.entity.Customer;
import com.jumia.phonenumber.resources.customer.control.CustomerServiceImpl;
import com.jumia.phonenumber.resources.customer.entity.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerControllerImpl implements CustomerController{

    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerControllerImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }
}
