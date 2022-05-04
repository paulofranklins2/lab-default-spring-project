package one.dio.gof.repository;

import one.dio.gof.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
