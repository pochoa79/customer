package com.global.customer.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Schema(name = "ErrorDetails", description = "Details Exception Error")
@Data
@Builder
public class ErrorDetails {
    @Schema(
            description = "Message description.",
            example = "Problems with validation"
    )
    private String message;
    @Schema(
            description = "Identifier URI.",
            example = "uri=/customer/onb/account"
    )
    private String details;

}
