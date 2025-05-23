package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);
}