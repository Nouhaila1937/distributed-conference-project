package org.example.conferenceservice.Repository;

import org.example.conferenceservice.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
