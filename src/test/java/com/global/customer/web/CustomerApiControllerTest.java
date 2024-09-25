package com.global.customer.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import com.global.customer.repository.CustomerRepository;
import com.global.customer.service.CustomerService;
import com.global.customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testCreateCustomer_Success() throws Exception {
        // Crear un mock de un objeto Customer
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("test@example.com");
        customerDTO.setName("John Doe");

        // Configurar el comportamiento simulado del servicio
        when(customerService.createCustomer(customerDTO)).thenReturn(new CustomerResponse());

        // Hacer la solicitud POST con MockMvc
        mockMvc.perform(post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDTO)))  // Aquí convertimos el objeto a JSON
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    // Test cuando el cliente ya existe
   /* @Test
    public void testCreateCustomer_AlreadyExists() throws Exception {


        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("test@example.com");
        customerDTO.setName("John Doe");

        // Configurar el servicio para lanzar la excepción cuando el cliente ya exista
        when(customerService.createCustomer(customerDTO))
                .thenThrow(new CustomerAlreadyExistsException("El correo ya registrado: " + customerDTO.getEmail()));

        // Hacer la solicitud POST con MockMvc
        mockMvc.perform((RequestBuilder) post("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) jsonPath("$.message").value("El correo ya registrado: test@example.com"));
    }
    */

}
