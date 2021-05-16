package com.example.filmapi.controller;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Integer id){
        super("Movies not found " +id);
    }
}
