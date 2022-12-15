package br.com.app.buscacep.models.person.controller;

import br.com.app.buscacep.models.person.entity.Person;
import br.com.app.buscacep.models.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Void> create(@Valid @RequestBody Person person) {
        service.insertPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Person newPerson) {
        Person oldPerson = service.findById(id);
        service.updatePerson(oldPerson, newPerson);
        service.updateAndSavePerson(id, newPerson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }



}
