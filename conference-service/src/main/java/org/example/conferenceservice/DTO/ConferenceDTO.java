package org.example.conferenceservice.DTO;
import org.example.conferenceservice.Entities.ConferenceType;
import java.time.LocalDate;
import java.util.List;

public class ConferenceDTO {
    public Long id;
    public String titre;
    public ConferenceType type;
    public LocalDate date;
    public int duree;
    public int nbInscrits;
    public double score;
    public List<ReviewDTO> reviews; // Liste des reviews associées
}
