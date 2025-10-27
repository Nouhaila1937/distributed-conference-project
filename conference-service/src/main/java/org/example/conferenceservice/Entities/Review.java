package org.example.conferenceservice.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private LocalDate date;
     private String texte;
     private int note;

    @ManyToOne
    private Conference conference;
}
