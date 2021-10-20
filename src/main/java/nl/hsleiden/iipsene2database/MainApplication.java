package nl.hsleiden.iipsene2database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"nl.hsleiden.iipsene2database.DAO.Repository"})
//@ComponentScan(basePackages = {"nl.hsleiden.iipsene2database.DAO"})
//@EntityScan(basePackages = {"nl.hsleiden.iipsene2database.model"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MainApplication {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
