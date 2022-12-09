package br.com.app.buscacep.models.controllers;

import br.com.app.buscacep.models.Person;
import br.com.app.buscacep.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAll() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok().body(persons);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable UUID id) {
        Person person = service.findById(id);
        return ResponseEntity.ok().body(person);

    }

}
