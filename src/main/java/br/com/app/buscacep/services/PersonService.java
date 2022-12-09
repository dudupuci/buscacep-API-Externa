package br.com.app.buscacep.services;

import br.com.app.buscacep.models.Person;
import br.com.app.buscacep.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(UUID id) {
        return repository.findById(id).get();
    }

    public Person insertPerson(Person person) {
        try {
            return repository.save(person);
        } catch (Exception e) {
            throw new RuntimeException("err" + e.getMessage());
        }

    }

    public void deletePerson(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("");

        }

    }

}