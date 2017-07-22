package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by PC on 15/07/2017.
 */
@Entity
public class Propietario {
    private String cantidad;
    private String nombre;
    private String edad;
    private String sexo;
    private Long id;


    public Propietario() {this.nombre = nombre;}

    @Id@GeneratedValue(strategy = GenerationType.AUTO)

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Propietario(String cantidad, String nombre, String edad, String sexo, Long id) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.id = id;
    }

    public String getCantidad() {return cantidad;}

    public void setCantidad(String cantidad) {this.cantidad = cantidad;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEdad() {return edad;}

    public void setEdad(String edad) {this.edad = edad;}

}
