package org.example.conferenceservice.Repository;

import org.example.conferenceservice.Entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
