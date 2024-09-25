package com.global.customer.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PhoneDTO {
    @Schema(
            description = "Number de telf del customerID.",
            example = "412654556722"
    )
    private String number;
    @Schema(
            description = "Number de telf del customerID.",
            example = "412654556722"
    )
    private String citycode;
    @Schema(
            description = "Customer country codes.",
            example = "412654556722"
    )
    private String contrycode;
}
