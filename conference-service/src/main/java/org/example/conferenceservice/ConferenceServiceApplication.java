package org.example.conferenceservice;

import org.example.conferenceservice.Entities.Conference;
import org.example.conferenceservice.Entities.ConferenceType;
import org.example.conferenceservice.Entities.Review;
import org.example.conferenceservice.Repository.ConferenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ConferenceRepository repository) {
        return args -> {
            if (repository.count() == 0) {

                // Conférence académique
                Conference c1 = new Conference(
                        null,
                        "Microservices 101",
                        ConferenceType.ACADEMIQUE,
                        LocalDate.now().plusDays(10),
                        90,
                        120,
                        4.5
                );
                // Initialiser la liste de reviews si besoin
                c1.setReviews(Arrays.asList(
                        new Review(null, LocalDate.now(), "Très instructif", 5, c1)
                ));

                // Conférence commerciale
                Conference c2 = new Conference(
                        null,
                        "Selling with APIs",
                        ConferenceType.COMMERCIALE,
                        LocalDate.now().plusDays(20),
                        60,
                        80,
                        4.0
                );
                c2.setReviews(Arrays.asList()); // pas de review pour l'instant

                repository.saveAll(Arrays.asList(c1, c2));
            }

            // Affichage dans la console
            repository.findAll().forEach(System.out::println);
        };
    }
}
