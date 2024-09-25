package com.global.customer.service.impl;

import com.global.customer.api.CustomerResponse;
import com.global.customer.exception.CustomerAlreadyExistsException;
import com.global.customer.mapper.CustomerMapper;
import com.global.customer.model.dto.CustomerDTO;
import com.global.customer.model.dto.PhoneDTO;
import com.global.customer.model.entity.Customer;
import com.global.customer.model.entity.Phone;
import com.global.customer.repository.CustomerRepository;
import com.global.customer.repository.PhoneRepository;
import com.global.customer.service.CustomerService;
import com.global.customer.util.JwtUtil;
import com.global.customer.util.ValidationProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final PhoneRepository phoneRepository;
    private final JwtUtil jwtUtil;
    private final ValidationProperties validationProperties;
    private final CustomerMapper customerMapper;

    @SneakyThrows
    @Override
    public CustomerResponse createCustomer(CustomerDTO customerDTO) {

        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new CustomerAlreadyExistsException("El correo ya registrado");
        }

        if (!customerDTO.getEmail().matches(validationProperties.getEmailRegex())) {
            throw new IllegalArgumentException("Formato de correo inválido");

        }

        if (!customerDTO.getPassword().matches(validationProperties.getPasswordRegex())) {
           throw new IllegalArgumentException("Formato de contraseña inválido");
        }


        Phone phone;
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setToken(jwtUtil.generateToken(customer.getEmail()));
        customer.setCreated(LocalDateTime.now());
        customer.setModified(LocalDateTime.now());
        customer.setLastLogin(LocalDateTime.now());
        customer.setActive(true);

        CustomerResponse customerResponse = customerMapper.toResponse(customerRepository.save(customer));

        if (customerDTO.getPhones() != null) {
            List<PhoneDTO> phoneDTOList = customerDTO.getPhones();
            for (PhoneDTO phoneDTO : phoneDTOList) {
                phone = new Phone();
                phone.setCitycode(phoneDTO.getCitycode());
                phone.setNumber(phoneDTO.getNumber());
                phone.setContrycode(phoneDTO.getContrycode());
                phone.setCustomer(customer);
                phoneRepository.save(phone);
            }
        }
        return customerResponse;
    }

}
