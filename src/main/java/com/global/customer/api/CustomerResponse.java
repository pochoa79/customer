package com.global.customer.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;


@Schema(name = "CustomerResponse", description = "Customer Transaction Response")
@Data
public class CustomerResponse {

    @Schema(
            description = "Unique identifier del customerId.",
            example = "d8b67ecb-c48a-4e72-b807-4c4b205b0b6f"
    )
    private UUID customerId;;
    @Schema(
            description = "Unique email del customerId.",
            example = "jalvare79@gmail.com")
    private String email;
    @Schema(
            description = "Name del customerID.",
            example = "Juan Alvarez")
    private String name;

    @Schema(
            description = "Date created del customerId.",
            example = "2024-09-24T13:04:11.6917954")
    private String created;
    @Schema(
            description = "Date modified del customerId.",
            example = "2024-09-24T13:04:11.6917954")
    private String modified;
    @Schema(
            description = "Date lastLogin del customerId.",
            example = "2024-09-24T13:04:11.6917954")
    private String lastLogin;
    @Schema(
            description = "Generate token para customerId.",
            example = "eyJhbGciOiJub25lIn0.eyJzdWIiOiJwb2Nob2E3NUBnb29nbGUub3JnIiwiaWF0IjoxNzI3MTk3NDUxLCJleHAiOjE3MjcyMzM0NTF9")
    private String token;
    @Schema(
            description = "Status del customerId.",
            example = "true")
    private boolean isActive;

}
