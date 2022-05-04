package one.dio.gof.controller;

import one.dio.gof.model.Client;
import one.dio.gof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Client> add(@RequestBody Client client) {
        clientService.add(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
