package org.example.conferenceservice.Service;

import org.example.conferenceservice.DTO.ConferenceDTO;
import org.example.conferenceservice.DTO.ReviewDTO;
import org.example.conferenceservice.Entities.Conference;
import org.example.conferenceservice.Entities.Review;
import org.example.conferenceservice.Mapper.ConferenceMapper;
import org.example.conferenceservice.Repository.ConferenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConferenceService {
    private final ConferenceRepository repo;

    public ConferenceService(ConferenceRepository repo) {
        this.repo = repo;
    }

    // =======================
    // Conferences
    // =======================

    public ConferenceDTO save(ConferenceDTO dto) {
        Conference c = ConferenceMapper.toEntity(dto);
        Conference saved = repo.save(c);
        return ConferenceMapper.toDto(saved);
    }

    public List<ConferenceDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(ConferenceMapper::toDto)
                .collect(Collectors.toList());
    }

    public ConferenceDTO findById(Long id) {
        return repo.findById(id)
                .map(ConferenceMapper::toDto)
                .orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // =======================
    // Reviews
    // =======================

    public ReviewDTO addReview(Long conferenceId, ReviewDTO reviewDTO) {
        Conference c = repo.findById(conferenceId)
                .orElseThrow(() -> new IllegalArgumentException("Conference not found"));
        Review review = ConferenceMapper.toEntity(reviewDTO);
        c.getReviews().add(review);
        Conference saved = repo.save(c);
        return ConferenceMapper.toDto(saved.getReviews().get(saved.getReviews().size() - 1));
    }

    public List<ReviewDTO> getReviewsByConference(Long conferenceId) {
        Conference c = repo.findById(conferenceId)
                .orElseThrow(() -> new IllegalArgumentException("Conference not found"));
        return c.getReviews()
                .stream()
                .map(ConferenceMapper::toDto)
                .collect(Collectors.toList());
    }
}