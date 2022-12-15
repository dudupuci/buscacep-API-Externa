package br.com.app.buscacep.models.address.repositories;

import br.com.app.buscacep.models.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
