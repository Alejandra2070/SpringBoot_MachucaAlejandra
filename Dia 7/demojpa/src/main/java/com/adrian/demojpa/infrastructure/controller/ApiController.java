package com.adrian.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.application.service.ProjectService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.domain.RoleRequest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    private final ProjectService projectService;
    //@Qualifier("personServicePImpl") 
    public ApiController(PersonService personService, ProjectService projectService) {
        this.personService = personService;
        this.projectService = projectService;
    }

    @GetMapping("/users")    
    public List<Person> findAllUser(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Person> results = personService.findAllUsersByFilter(filter, value);

        return results;
    }

    @GetMapping("/roles")    
    public ResponseEntity<List<Rol>> findAllRoles(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Rol> results = personService.findAllRolesByFilter(filter, value);

        return ResponseEntity.ok(results);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol newRole(@Valid @RequestBody RoleRequest role){
        return personService.createNewRol(role.getName());
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRole(@PathVariable Long id, @RequestBody Rol rolUp) {
        try {
            Rol rolU = personService.updateRol(id, rolUp.getName());
            return ResponseEntity.ok(rolU);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id){
        try {
            personService.deleteRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/projects")    
    public List<Project> findAllProjects(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Project> results = projectService.findAllProjects();

        return results;
    }

    /*@PostMapping("/projects")
    public Project newProject(@RequestBody String project) {
        
        return project;
    }*/
    
}