package com.example.filmapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Movie {
    @Id
    private Integer id;
    private String name;
    private String description;
    private int grade;
    private int likes;
}
