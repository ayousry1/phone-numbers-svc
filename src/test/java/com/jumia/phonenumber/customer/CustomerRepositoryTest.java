package com.jumia.phonenumber.customer;

import com.jumia.phonenumber.repositories.customer.boundary.CustomerRepository;
import com.jumia.phonenumber.repositories.customer.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindAll_thenReturnPersistedCustomers() {

        // when
        ArrayList<Customer> found = new ArrayList<>();
        customerRepository.findAll().forEach(found::add);

        // then
        Assert.notEmpty(found ,"testing that persistence happened");
    }
}
