package org.example.keynoteservice;

import org.example.keynoteservice.Entities.Keynote;
import org.example.keynoteservice.Repository.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    // Pour initialiser quelques keynotes au démarrage
    @Bean
    CommandLineRunner runner(KeynoteRepository repository) {
        return args -> {
            repository.save(Keynote.builder()
                    .title("Opening Keynote")
                    .description("Introduction to the conference")
                    .dateTime(LocalDateTime.now().plusDays(1))
                    .duration(60)
                    .location("Main Hall")
                    .build());

            repository.save(Keynote.builder()
                    .title("Cloud Trends")
                    .description("Latest in Cloud Computing")
                    .dateTime(LocalDateTime.now().plusDays(1).plusHours(2))
                    .duration(45)
                    .location("Room A")
                    .build());
        };
    }
}