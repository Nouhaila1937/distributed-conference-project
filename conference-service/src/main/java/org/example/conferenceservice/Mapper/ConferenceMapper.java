package org.example.conferenceservice.Mapper;

import org.example.conferenceservice.DTO.ConferenceDTO;
import org.example.conferenceservice.DTO.ReviewDTO;
import org.example.conferenceservice.Entities.Conference;
import org.example.conferenceservice.Entities.ConferenceType;
import org.example.conferenceservice.Entities.Review;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConferenceMapper {

    // =======================
    // Entity -> DTO
    // =======================

    public static ConferenceDTO toDto(Conference c) {
        if (c == null) return null;

        ConferenceDTO dto = new ConferenceDTO();
        dto.id = c.getId();
        dto.titre = c.getTitre();
        dto.type = c.getType();
        dto.date = c.getDate();
        dto.duree = c.getDuree();
        dto.nbInscrits = c.getNbInscrits();
        dto.score = c.getScore();

        dto.reviews = (c.getReviews() == null) ?
                Collections.emptyList() :
                c.getReviews().stream()
                        .map(ConferenceMapper::toDto)
                        .collect(Collectors.toList());

        return dto;
    }

    public static ReviewDTO toDto(Review r) {
        if (r == null) return null;
        ReviewDTO dto = new ReviewDTO();
        dto.id = r.getId();
        dto.date = r.getDate();
        dto.texte = r.getTexte();
        dto.note = r.getNote();
        return dto;
    }

    // =======================
    // DTO -> Entity
    // =======================

    public static Conference toEntity(ConferenceDTO dto) {
        if (dto == null) return null;

        Conference c = new Conference(null, "Microservices 101", ConferenceType.ACADEMIQUE, LocalDate.now().plusDays(10), 90, 120, 4.5);
        c.setId(dto.id);
        c.setTitre(dto.titre);
        c.setType(dto.type);
        c.setDate(dto.date);
        c.setDuree(dto.duree);
        c.setNbInscrits(dto.nbInscrits);
        c.setScore(dto.score);

        if (dto.reviews != null) {
            List<Review> reviews = dto.reviews.stream()
                    .map(ConferenceMapper::toEntity)
                    .collect(Collectors.toList());
            c.setReviews(reviews);
        }

        return c;
    }

    public static Review toEntity(ReviewDTO dto) {
        if (dto == null) return null;
        Review r = new Review();
        r.setId(dto.id);
        r.setDate(dto.date);
        r.setTexte(dto.texte);
        r.setNote(dto.note);
        return r;
    }
}
