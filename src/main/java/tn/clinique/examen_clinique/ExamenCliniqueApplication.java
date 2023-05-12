package tn.clinique.examen_clinique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExamenCliniqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenCliniqueApplication.class, args);
    }

}
