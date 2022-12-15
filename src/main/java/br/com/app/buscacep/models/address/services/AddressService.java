package br.com.app.buscacep.models.address.services;

import br.com.app.buscacep.models.address.entity.Address;
import br.com.app.buscacep.models.address.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
       return repository.findAll();
    }

    public Address findById(UUID id) {
        return repository.findById(id).get();
    }

    public Address insertAddress(Address address) {
        try {
            return repository.save(address);
        } catch (Exception e) {
            throw new RuntimeException("err" + e.getMessage());
        }
    }

    public void updateAndSaveAddress(UUID oldAddressId, Address newAddress) {
        try {
            Address oldAddress = repository.findById(oldAddressId).get();
            updateAddress(oldAddress, newAddress);
            repository.save(newAddress);
        } catch (Exception err) {
            throw new RuntimeException("");
        }
    }

    public void deleteAddress(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("err" + e.getMessage());
        }

    }

    public void updateAddress(Address oldAddress, Address newAddress) {
        oldAddress.setId(newAddress.getId());
        oldAddress.setStreet(newAddress.getStreet());
        oldAddress.setDistrict(newAddress.getDistrict());
        oldAddress.setComplement(newAddress.getComplement());
        oldAddress.setNumber(newAddress.getNumber());
        oldAddress.setPostalCode(newAddress.getPostalCode());


}



}
