package com.example.filmapi.controller;


import com.example.filmapi.model.Review;
import com.example.filmapi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/recenzja/{id}")
    private Review findReview(@PathVariable Integer id) {
        return reviewService.displayReviewById(id);
    }
    @GetMapping("/recenzja")
    private List<Review> findReview(){
        return reviewService.displayReviews();
    }

    @GetMapping("/film/{id}/recenzja")
    public List<String> findReviewByMovieId(@PathVariable Integer id){
        return reviewService.displayMovieReviews(id);
    }

    @PostMapping("/recenzja")
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }

    @DeleteMapping("/recenzja/{id}")
    public void dropReview(@PathVariable Integer id){
         reviewService.dropReview(id);
    }

}