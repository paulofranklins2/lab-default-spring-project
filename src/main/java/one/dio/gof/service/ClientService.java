package one.dio.gof.service;

import one.dio.gof.model.Client;
import org.springframework.stereotype.Service;

public interface ClientService {
    Iterable<Client> findAll();

    Client findById(Long id);

    void add(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
