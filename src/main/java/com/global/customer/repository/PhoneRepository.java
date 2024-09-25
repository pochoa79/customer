package com.global.customer.repository;

import com.global.customer.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
