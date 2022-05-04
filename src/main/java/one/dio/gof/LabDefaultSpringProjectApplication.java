package one.dio.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Data - JPA
 * Spring Web
 * H2 Database
 * OpenFeign
 *
 * @author Paulo
 */
@EnableFeignClients
@SpringBootApplication
public class LabDefaultSpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabDefaultSpringProjectApplication.class, args);
    }

}
