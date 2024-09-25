package com.global.customer.web;

import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.api.annotations.ParameterObject;

public interface CustomerApi {

    @Operation(
            summary = "Created Customer",
            description = "Create user validating that no email exists",
            tags = {"Id Verification Transaction"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Created Customer",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerResponse.class))),
                    @ApiResponse(
                            responseCode = "401",
                            description =
                                    "HTTP Status 401 - Full authentication is required to access this resource",
                            content = @Content)
            })
    CustomerResponse createdCustomer(@ParameterObject CustomerDTO userRequest);
}
