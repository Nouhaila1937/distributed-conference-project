package org.example.keynoteservice.Repository;

import org.example.keynoteservice.Entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}
