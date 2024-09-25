package com.global.customer.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import com.global.customer.model.dto.PhoneDTO;
import com.global.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerApiControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CustomerApiController customerApiController;

    @Mock
    private CustomerService customerService;

    @Test
    public void testCreateCustomer_Success() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(customerApiController).build();

        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Juan Perez")
                .email("jperez@gmail.com")
                .password("123eeddrrrTT")
                .phones(Collections.singletonList(
                        PhoneDTO.builder()
                                .number("7654321")
                                .citycode("1")
                                .contrycode("57")
                                .build()
                ))
                .build();

        when(customerService.createCustomer(customerDTO)).thenReturn(new CustomerResponse());

        String customerJson = new ObjectMapper().writeValueAsString(customerDTO);

        mockMvc.perform(post("/customer/onb/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isCreated());
    }
}
