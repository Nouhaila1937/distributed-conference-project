package org.example.keynoteservice.Service;

import org.example.keynoteservice.Entities.Keynote;
import org.example.keynoteservice.Repository.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeynoteService {

    private final KeynoteRepository repo;

    public KeynoteService(KeynoteRepository repo) {
        this.repo = repo;
    }

    public Keynote save(Keynote k) {
        return repo.save(k);
    }

    public List<Keynote> findAll() {
        return repo.findAll();
    }

    public Optional<Keynote> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
