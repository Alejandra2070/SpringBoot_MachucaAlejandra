package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.infrastructure.error.RolDuplicateException;

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
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name){
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateException("El Rol " +name+ " ya está registrado", 
            HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);
    }

    private Optional<Rol> getRolByName(String rolName){
        return roleRepository.findByName(rolName);
    }

    //put
    @Override
    public Rol updateRol(Long id, String name){
        Optional<Rol> findRol = roleRepository.findById(id);

        if (findRol.isPresent()) {
            Rol existRol = findRol.get();
            existRol.setName(name);

            return roleRepository.save(existRol);
        }
        else{
            throw new RuntimeException("El rol con id" + id + " no existe");
        }
    }

    //delete
    @Override
    public void deleteRol(Long id){
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol con id " + id + " no existe");
        }
    }
}