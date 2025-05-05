package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.dto.PersonRequest;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository _roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = _roleRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if(filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public Person patchPerson(Long id, PersonRequest personDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el usuario solicitado."));

        if(personDto.getName() != null){
            person.setName((personDto.getName()));
        }

        if(personDto.getSurname() != null){
            person.setLastName((personDto.getSurname()));
        }

        if(personDto.getSkill() != null){
            person.setLanguage((personDto.getSkill()));
        }

        personRepository.save(person);
        
        return person;
    }
}