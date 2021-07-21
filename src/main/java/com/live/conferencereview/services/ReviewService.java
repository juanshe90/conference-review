package com.live.conferencereview.services;

import com.live.conferencereview.models.Review;
import com.live.conferencereview.repositories.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review getById(Long id) {
        return reviewRepository.findById(id).get();
    }

    public Review createReview(final Review review) {

        return reviewRepository.saveAndFlush(review);
    }

    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id).get();
        BeanUtils.copyProperties(review, existingReview, "review_id");
        return reviewRepository.saveAndFlush(existingReview);
    }


}
