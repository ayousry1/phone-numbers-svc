package com.jumia.phonenumber.customer;

import com.jumia.phonenumber.constants.Countries;
import com.jumia.phonenumber.repositories.customer.entity.Customer;
import com.jumia.phonenumber.resources.customer.boundary.CustomerControllerImpl;
import com.jumia.phonenumber.resources.customer.control.CustomerServiceImpl;
import com.jumia.phonenumber.resources.customer.entity.CustomerModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerControllerImpl.class)
@AutoConfigureMockMvc(addFilters = false)
public class CustomerControllerTest {

    private CustomerModel customerModelDummyObject;
    private int customerModelDummyId = 1;
    private static String customerModelDummyName = "Ahmed";
    private static String customerModelDummyPhone = "(212) 698054317";
    private static String customerModelDummyStatus = "Valid";
    private static String customerModelDummyCountry = Countries.MOROCCO.toString();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceImpl customerServiceImpl;

    @Before
    public void setUp(){
        customerModelDummyObject = new CustomerModel(customerModelDummyId,customerModelDummyName,
                customerModelDummyPhone,customerModelDummyStatus,customerModelDummyCountry);
        List<CustomerModel> allCustomers = Arrays.asList(customerModelDummyObject);
        given(customerServiceImpl.getAllCustomers()).willReturn(allCustomers);
    }

    @Test
    public void whenGetAllCustomers_thenReturnJsonArray() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .get("/customer/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(customerModelDummyObject.getName()));
    }
}
