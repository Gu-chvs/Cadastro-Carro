package com.empresa.cadastro_carro.infrasctruture.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "carro")
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "placa", unique = true)
    private String placa;

    @Column(name = "ano")
    private Integer ano;
}
