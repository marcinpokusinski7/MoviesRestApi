package com.example.filmapi.service;

import com.example.filmapi.controller.MovieNotFoundException;
import com.example.filmapi.model.Movie;
import com.example.filmapi.repository.MovieRepository;
import com.example.filmapi.repository.ReviewRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(@PathVariable Integer id) throws NotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Movie edit(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    public ResponseEntity<?> giveLike(@RequestBody Movie movieLike, @PathVariable Integer id) {
        int likeCount = movieLike.getLikes();
        movieLike.setLikes(likeCount + 1);
        movieRepository.save(movieLike);
        return ResponseEntity.ok("Like added");
    }

}
