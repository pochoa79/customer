package com.global.customer.service;

import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerResponse createCustomer(CustomerDTO customerDTO);
}
