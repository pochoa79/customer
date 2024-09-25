package com.global.customer.mapper;


import com.global.customer.api.CustomerResponse;
import com.global.customer.model.dto.CustomerDTO;
import com.global.customer.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "created", source = "created")
    @Mapping(target = "modified", source = "modified")
    @Mapping(target = "lastLogin", source = "lastLogin")
    @Mapping(target = "token", source = "token")
    @Mapping(target = "active", source = "active")
    CustomerResponse toResponse(Customer customer);

  //  Customer toDTO(CustomerDTO customerDTO);

  //  CustomerDTO toEntity(Customer customer);
}
