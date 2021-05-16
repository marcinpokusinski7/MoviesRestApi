package com.example.filmapi.controller;

import com.example.filmapi.model.Movie;
import com.example.filmapi.service.MovieService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/filmy")
    public List<Movie> displayMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/filmy/{id}")
    public Movie getMovieById(@PathVariable Integer id) throws NotFoundException {
        return movieService.getMovieById(id);
    }

    @PostMapping("/filmy")
    public Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/filmy")
    public Movie editMovie(@RequestBody Movie movie) {
        return movieService.edit(movie);
    }

    @PatchMapping("/film/{id}/like")
    public ResponseEntity<?> addLike(@RequestBody Movie movieLike, @PathVariable Integer id) {
        return movieService.giveLike(movieLike,id);
    }
}
