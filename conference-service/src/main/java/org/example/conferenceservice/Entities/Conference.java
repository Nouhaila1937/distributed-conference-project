package org.example.conferenceservice.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Enumerated(EnumType.STRING)
    private ConferenceType  type; // académique ou commerciale
    private LocalDate date;
    private int duree;
    private int nbInscrits;
    private double score;

    @OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
    private List<Review> reviews;

    // Constructeur pratique sans reviews
    public Conference(Long id, String titre, ConferenceType type, LocalDate date,
                      int duree, int nbInscrits, double score) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.date = date;
        this.duree = duree;
        this.nbInscrits = nbInscrits;
        this.score = score;
        this.reviews = new ArrayList<>();
    }

}
