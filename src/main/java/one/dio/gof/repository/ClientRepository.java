package one.dio.gof.repository;

import one.dio.gof.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
