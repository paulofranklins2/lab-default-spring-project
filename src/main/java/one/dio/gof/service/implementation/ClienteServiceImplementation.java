package one.dio.gof.service.implementation;

import one.dio.gof.model.Address;
import one.dio.gof.model.Client;
import one.dio.gof.repository.AddressRepository;
import one.dio.gof.repository.ClientRepository;
import one.dio.gof.service.ByZipCodeService;
import one.dio.gof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ByZipCodeService byZipCodeService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void add(Client client) {
        saveClientCep(client);
    }


    @Override
    public void update(Long id, Client client) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isPresent()) {
            saveClientCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isPresent()) {
            clientRepository.deleteById(id);
        }
    }

    private void saveClientCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = byZipCodeService.findByZipCode(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
