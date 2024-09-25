package com.global.customer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Comment("Numero de telefono del Usuario")
    @Column(name = "number")
    private String number;
    @Comment("Codigo de la Ciudad")
    @Column(name = "citycode")
    private String citycode;
    @Comment("Codigo de del Pais")
    @Column(name = "contrycode")
    private String contrycode;


    @Comment("Llave foranea de la tabla customer")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id",
            foreignKey = @ForeignKey(name = "FK_phone_customer"), nullable = false)
    private Customer customer;





}
