package com.live.conferencereview.ControllerMvcTest;

import com.live.conferencereview.controllers.ReviewsController;
import com.live.conferencereview.models.Review;
import com.live.conferencereview.models.ReviewType;
import com.live.conferencereview.services.ReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ReviewsController.class)
public class ReviewsControllerTest {

   @MockBean
   ReviewService reviewService;


   @Autowired
   private MockMvc mockMvc;

   @Test
    public void getAllReviews() throws Exception {
       mockMvc.perform(get("/api/v1/reviews"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"));

      // Verify the number of times a mock method has been called
      verify(reviewService, Mockito.times(1)).findAll();
   }

   @Test
   public void getReview() throws Exception {
      when(reviewService.getById(1L)).thenReturn(new Review());
      mockMvc.perform(get("/api/v1/reviews/{id}", 1))
              .andExpect(status().isOk())
              .andExpect(content().json("{}"));

      Mockito.verify(reviewService, times(1)).getById(1L);
   }

   @Test
   public void createReview() throws Exception {
      when(reviewService.getById(1L)).thenReturn(new Review());
      mockMvc.perform(post("/api/v1/reviews/{id}", 1))
              .andExpect(status().isOk())
              .andExpect(content().json("{}"));

      Mockito.verify(reviewService, times(1)).getById(1L);
   }

   @Test
   public void deleteReview() throws Exception {
      when(reviewService.getById(1L)).thenReturn(new Review());
      mockMvc.perform(delete("/api/v1/reviews/{id}", 1))
              .andExpect(status().isOk());


     // Mockito.verify(reviewService, times(1)).getById(1L);
   }

   // Failed because reviewtype is not good
   @Test
   public void updateReview() throws Exception {
      Review review = new Review();
      Long review_id = 1L;
      ReviewType review_type = ReviewType.SPEAKERS;
      Long review_reference = 1L;
      String review_title = "testing1";

      Mockito.when(reviewService.getById(review_id)).thenReturn(review);
      mockMvc.perform(put("/api/v1/reviews/{id}", 1))
              .andExpect(status().isOk());
      // Mockito.verify(reviewService, times(1)).getById(1L);
   }





}
