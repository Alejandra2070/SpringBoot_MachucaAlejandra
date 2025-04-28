package com.example.demo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //crear una entidad
@Table(name = "personas") //crear tabla

//Bidireccional
//ManyToONe
//OneToMany
//OneToOne
//ManyToMany (Llaves compuestas)
//Embeddable - Qué son y cuándo usarlas?
public class Person {
    
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generar automaticamente
    private Long id;

    private String name;
    private String lastName;

    @Column(name = "programming_language") //renombrar una columna
    private String language;

    @OneToMany
    private List<Rol> role;

    public Person() {
    }

    public Person(Long id, String name, String lastName, String language) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Rol> getRole() {
        return role;
    }

    public void setRole(List<Rol> role) {
        this.role = role;
    }
}
