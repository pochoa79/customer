package com.global.customer.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID customerId;

    @Comment("Correo del usuario")
    @Column(unique = true, name = "email")
    private String email;

    @Comment("Nombre del cliente")
    @Column(name = "name")
    private String name;
    @Comment("Password del cliente")
    @Column(name = "password")
    private String password;
    @Comment("Fecha en que se creo el cliente")
    @Column(name = "created")
    private LocalDateTime created;
    @Comment("Fecha de la ultima modificacion del cliente")
    @Column(name = "modified")
    private LocalDateTime modified;
    @Comment("Fecha de la ultimo inicio de session")
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    @Comment("Token del Usuario")
    @Column(name = "id_token", columnDefinition = "TEXT")
    private String token;
    @Comment("Estado del Usuario")
    @Column(name = "is_active")
    private boolean active;

    /*  public Customer() {
        this.customerId = UUID.randomUUID();
    }*/
}
