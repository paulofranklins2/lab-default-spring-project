package one.dio.gof.service;

import one.dio.gof.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "byzipcode", url = "https://viacep.com.br/ws")
public interface ByZipCodeService {

    @GetMapping(value = "/{cep}/json/")
    Address findByZipCode(@PathVariable("cep") String cep);

}
