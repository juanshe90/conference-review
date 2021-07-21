package com.live.conferencereview.controllers;

import com.live.conferencereview.models.Review;
import com.live.conferencereview.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods={RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/api/v1/reviews")
public class ReviewsController {


    // private RestTemplate restTemplate;

    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> list() {

        return reviewService.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Review get(@PathVariable Long id) throws NoSuchElementException {
        return reviewService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Review> create(@Valid @RequestBody final Review review) throws MethodArgumentNotValidException, HttpMessageNotReadableException {
        if (isValidReference(review))
            return new ResponseEntity(reviewService.createReview(review), HttpStatus.OK);
         else
            throw new ValidationException();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) throws NoSuchElementException {
        reviewService.deleteReview(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Review> update(@PathVariable Long id,@Valid @RequestBody Review review) throws MethodArgumentNotValidException, NoSuchElementException {
        if (isValidReference(review))
            return new ResponseEntity(reviewService.createReview(review), HttpStatus.OK);
        else throw new ValidationException();
    }

    public boolean isValidReference (Review review){
        RestTemplate restTemplate = new RestTemplate();
        String sessionsUrl = "http://apisesspeak:8090/api/v1/";
        try {
            restTemplate.getForEntity(sessionsUrl + review.getReview_type().toString().toLowerCase() + "/" + review.getReview_reference().toString(), String.class);
            return true;

        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
