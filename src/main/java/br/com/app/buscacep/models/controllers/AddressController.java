package br.com.app.buscacep.models.controllers;

import br.com.app.buscacep.models.Address;
import br.com.app.buscacep.models.Person;
import br.com.app.buscacep.repositories.AddressRepository;
import br.com.app.buscacep.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/address")
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> get() {
        List<Address> addresses = service.findAll();
        return ResponseEntity.ok().body(addresses);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getById(@PathVariable UUID id) {
        Address address = service.findById(id);
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Address address) {
        service.insertAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody Address newAddress) {
        Address oldAddress = service.findById(id);
        service.updateAddress(oldAddress, newAddress);
        service.updateAndSaveAddress(id, newAddress);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

}
