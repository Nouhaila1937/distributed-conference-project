package org.example.conferenceservice.Web;
import org.example.conferenceservice.DTO.ConferenceDTO;
import org.example.conferenceservice.DTO.ReviewDTO;
import org.example.conferenceservice.Service.ConferenceService;
import org.example.conferenceservice.feign.KeynoteRestClient;
import org.example.conferenceservice.feign.dto.keynoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    private final ConferenceService service;
    private final KeynoteRestClient keynoteRestClient;

    public ConferenceController(ConferenceService service, KeynoteRestClient keynoteRestClient) {
        this.service = service;
        this.keynoteRestClient = keynoteRestClient;
    }

    // =======================
    // CRUD Conferences
    // =======================

    @PostMapping
    public ResponseEntity<ConferenceDTO> create(@RequestBody ConferenceDTO dto) {
        ConferenceDTO saved = service.save(dto);
        return ResponseEntity.created(URI.create("/api/conferences/" + saved.id))
                .body(saved);
    }

    @GetMapping
    public List<ConferenceDTO> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> get(@PathVariable Long id) {
        ConferenceDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // =======================
    // Reviews
    // =======================

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> addReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDto) {
        ReviewDTO saved = service.addReview(id, reviewDto);
        return ResponseEntity.created(URI.create("/api/conferences/" + id + "/reviews"))
                .body(saved);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long id) {
        List<ReviewDTO> reviews = service.getReviewsByConference(id);
        return ResponseEntity.ok(reviews);
    }


    @GetMapping("/with-keynotes")
    public List<keynoteDTO> getKeynotesFromKeynoteService() {
        return keynoteRestClient.getAllKeynotes();
    }
}
