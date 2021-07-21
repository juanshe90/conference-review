package com.live.conferencereview.repositories;

import com.live.conferencereview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
