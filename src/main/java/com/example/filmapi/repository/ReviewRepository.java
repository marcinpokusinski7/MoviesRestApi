package com.example.filmapi.repository;

import com.example.filmapi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer > {
    @Query("Select review from Review where movie_id=?1")
    List<String> getReviewByMovieId(Integer searchKey);
}
