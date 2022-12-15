package br.com.app.buscacep.models.person.repositories;

import br.com.app.buscacep.models.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
    public interface PersonRepository extends JpaRepository<Person, UUID > {
}
