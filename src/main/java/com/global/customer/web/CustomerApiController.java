package com.global.customer.web;


import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import com.global.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customer/onb")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CustomerApiController implements CustomerApi {

    private final CustomerService customerService;

    @Override
    @Operation(summary = "Crearcion de un nuevo usuario")
    @PostMapping("/account")
    public CustomerResponse createdCustomer(@RequestBody @Valid CustomerDTO userRequest) {

        log.info("Start POST request /customer/onb/account");
        CustomerResponse userResponse = customerService.createCustomer(userRequest);
        log.info("End POST request /customer/onb/account");
        return userResponse;

    }
}

