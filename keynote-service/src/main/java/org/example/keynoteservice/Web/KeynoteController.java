package org.example.keynoteservice.Web;
import org.example.keynoteservice.DTO.KeynoteDTO;
import org.example.keynoteservice.Entities.Keynote;
import org.example.keynoteservice.Mapper.KeynoteMapper;
import org.example.keynoteservice.Service.KeynoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteController {

    private final KeynoteService service;

    public KeynoteController(KeynoteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<KeynoteDTO> create(@RequestBody KeynoteDTO dto) {
        Keynote entity = KeynoteMapper.toEntity(dto);
        Keynote saved = service.save(entity);
        return ResponseEntity.created(URI.create("/api/keynotes/" + saved.getId()))
                .body(KeynoteMapper.toDto(saved));
    }

    @GetMapping
    public List<KeynoteDTO> all() {
        return service.findAll().stream().map(KeynoteMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<KeynoteDTO> get(@PathVariable Long id) {
        return service.findById(id)
                .map(k -> ResponseEntity.ok(KeynoteMapper.toDto(k)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
