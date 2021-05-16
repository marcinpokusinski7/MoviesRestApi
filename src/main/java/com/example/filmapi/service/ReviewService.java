package com.example.filmapi.service;

import com.example.filmapi.model.Review;
import com.example.filmapi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> displayReviews(){
        return reviewRepository.findAll();
    }

    public Review displayReviewById(@PathVariable Integer id){
        return reviewRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Nie istnieje"));
    }

    public List<String> displayMovieReviews(@PathVariable Integer id){
        return reviewRepository.getReviewByMovieId(id);
    }

    public Review addReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }

    public void dropReview(@PathVariable Integer id){
        reviewRepository.deleteById(id);
    }

}
