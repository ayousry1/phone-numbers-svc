package com.jumia.phonenumber.customer;

import com.jumia.phonenumber.repositories.customer.boundary.CustomerRepository;
import com.jumia.phonenumber.repositories.customer.entity.Customer;
import com.jumia.phonenumber.resources.customer.control.CustomerServiceImpl;
import com.jumia.phonenumber.resources.customer.entity.CustomerModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    private static int CUSTOMER_ID = 1;
    private static int EXPECTED_LIST_SIZE = 1;
    private static String CUSTOMER_NAME = "Ahmed";
    private static String VALID_CUSTOMER_PHONE = "(212) 698054317";
    private static String INVALID_CUSTOMER_PHONE = "(256) 7503O6263";
    private static String UNKNOWN_CUSTOMER_PHONE = "01012345678";
    private static String EXPECTED_CUSTOMER_STATUS = "Valid";
    private static String VALID = "Valid";
    private static String INVALID = "Invalid";
    private static String UNKNOWN_STATUS = "Unknown";
    private static String UNKNOWN_COUNTRY = "UNKNOWN";
    private static String EXPECTED_CUSTOMER_COUNTRY_FOR_VALID_PHONE = "MOROCCO";
    private static String EXPECTED_CUSTOMER_COUNTRY_FOR_INVALID_PHONE = "UGANDA";




    @Before
    public void setUp() {
        Customer customerTestObj = new Customer(CUSTOMER_ID, CUSTOMER_NAME, VALID_CUSTOMER_PHONE);
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList.add(customerTestObj);

        doReturn(customersList).when(customerRepository).findAll();
    }

    @Test
    public void whenGetAllCustomers_thenReturnCustomersList() {
        List<CustomerModel> actual = customerServiceImpl.getAllCustomers();

        Assert.assertNotNull(actual);
        Assert.assertEquals(EXPECTED_LIST_SIZE, actual.size());
        Assert.assertEquals(CUSTOMER_ID, actual.get(0).getId());
        Assert.assertEquals(CUSTOMER_NAME, actual.get(0).getName());
        Assert.assertEquals(VALID_CUSTOMER_PHONE, actual.get(0).getPhone());
        Assert.assertEquals(EXPECTED_CUSTOMER_STATUS, actual.get(0).getStatus());
        Assert.assertEquals(EXPECTED_CUSTOMER_COUNTRY_FOR_VALID_PHONE, actual.get(0).getCountry());
    }

    @Test
    public void whenSetCountryAndStatus_withValidPhone_thenValidStatusAndCountry(){
        CustomerModel testObj = new CustomerModel(CUSTOMER_ID,CUSTOMER_NAME,VALID_CUSTOMER_PHONE);
        customerServiceImpl.setCountryAndStatus(testObj);

        Assert.assertEquals(VALID,testObj.getStatus());
        Assert.assertEquals(EXPECTED_CUSTOMER_COUNTRY_FOR_VALID_PHONE,testObj.getCountry());

    }

    @Test
    public void whenSetCountryAndStatus_withInvalidPhone_thenInvalidStatusAndCountry(){
        CustomerModel testObj = new CustomerModel(CUSTOMER_ID,CUSTOMER_NAME,INVALID_CUSTOMER_PHONE);
        customerServiceImpl.setCountryAndStatus(testObj);

        Assert.assertEquals(INVALID,testObj.getStatus());
        Assert.assertEquals(EXPECTED_CUSTOMER_COUNTRY_FOR_INVALID_PHONE,testObj.getCountry());

    }

    @Test
    public void whenSetCountryAndStatus_withUnknownPhone_thenUnknownStatusAndCountry(){
        CustomerModel testObj = new CustomerModel(CUSTOMER_ID,CUSTOMER_NAME,UNKNOWN_CUSTOMER_PHONE);
        customerServiceImpl.setCountryAndStatus(testObj);

        Assert.assertEquals(UNKNOWN_STATUS,testObj.getStatus());
        Assert.assertEquals(UNKNOWN_COUNTRY,testObj.getCountry());
    }
}
