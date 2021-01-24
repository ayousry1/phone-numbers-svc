package com.jumia.phonenumber.resources.customer.control;

import com.jumia.phonenumber.constants.Countries;
import com.jumia.phonenumber.constants.Patterns;
import com.jumia.phonenumber.repositories.customer.boundary.CustomerRepository;
import com.jumia.phonenumber.repositories.customer.entity.Customer;
import com.jumia.phonenumber.resources.customer.entity.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        ArrayList<CustomerModel> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> {
            customers.add(getModelFromEntity(customer));
        });
        return customers;
    }


    public CustomerModel getModelFromEntity(Customer customer){
        CustomerModel model = new CustomerModel();
        model.setId(customer.getId());
        model.setName(customer.getName());
        model.setPhone(customer.getPhone());
        setCountryAndStatus(model);
        return model;
    }

    public void setCountryAndStatus(CustomerModel model){
        if(Pattern.matches(Patterns.CAMEROON_COUNTRY_CODE_REGEX, model.getPhone())){
            model.setCountry(Countries.CAMEROON.toString());
            model.setStatus(Pattern.matches(Patterns.CAMEROON_NUMBER_REGEX, model.getPhone()));
        }else if(Pattern.matches(Patterns.ETHIOPIA_COUNTRY_CODE_REGEX, model.getPhone())){
            model.setCountry(Countries.ETHIOPIA.toString());
            model.setStatus(Pattern.matches(Patterns.ETHIOPIA_NUMBER_REGEX, model.getPhone()));
        } else if(Pattern.matches(Patterns.MOROCCO_COUNTRY_CODE_REGEX, model.getPhone())){
            model.setCountry(Countries.MOROCCO.toString());
            model.setStatus(Pattern.matches(Patterns.MOROCCO_NUMBER_REGEX, model.getPhone()));
        }else if(Pattern.matches(Patterns.MOZAMBIQUE_COUNTRY_CODE_REGEX, model.getPhone())){
            model.setCountry(Countries.MOZAMBIQUE.toString());
            model.setStatus(Pattern.matches(Patterns.MOZAMBIQUE_NUMBER_REGEX, model.getPhone()));
        }else if(Pattern.matches(Patterns.UGANDA_COUNTRY_CODE_REGEX, model.getPhone())){
            model.setCountry(Countries.UGANDA.toString());
            model.setStatus(Pattern.matches(Patterns.UGANDA_NUMBER_REGEX, model.getPhone()));
        }
    }
}
