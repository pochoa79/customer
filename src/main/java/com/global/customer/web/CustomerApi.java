package com.global.customer.web;

import com.global.customer.api.CustomerResponse;
import com.global.customer.exception.ErrorDetails;
import com.global.customer.model.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;

public interface CustomerApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario Creado",
                    content = @Content(schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "400", description = "Formato de correo inválido",
                    content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "400", description = "Formato de contraseña inválido",
                    content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "409", description = "El correo ya registrado:",
                    content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    CustomerResponse createdCustomer(@ParameterObject CustomerDTO customerDTO);
}
