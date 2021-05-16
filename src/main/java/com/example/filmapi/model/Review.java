package com.example.filmapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
public class Review {
        @Id
        private Integer id;
        private Integer movie_id;
        private String review;
}
