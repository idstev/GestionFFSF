package com.taller3.taller3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String area;
    private String computadora;
    private String codigocp;
    private String modelocp;
    private String marcacp;
    private String correoinsti;
    private String observacionescp;
    private String telefono;
    private String codigotf;
    private String marcatf;
    private String modelotf;
    private String chip;
    private String correotf;
    private String observacionestf;
}
