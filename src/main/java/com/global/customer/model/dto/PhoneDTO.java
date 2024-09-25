package com.global.customer.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
