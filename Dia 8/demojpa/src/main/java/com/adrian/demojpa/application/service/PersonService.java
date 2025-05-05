package com.adrian.demojpa.application.service;

import java.util.List;


import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.dto.PersonRequest;

public interface PersonService {
    public List<Person> findAllUsersByFilter(String filter, String value);
    public Person patchPerson(Long id,PersonRequest personDto);
}
