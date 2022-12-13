package br.com.app.buscacep.models.controllers;

import br.com.app.buscacep.models.Person;
import br.com.app.buscacep.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/person")
@CrossOrigin("*")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok().body(persons);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getById(@PathVariable UUID id) {
        Person person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Person person) {
        service.insertPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Person newPerson) {
        Person oldPerson = service.findById(id);
        service.updatePerson(oldPerson, newPerson);
        service.updateAndSavePerson(id, newPerson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }



}
