package com.movieapi.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class MovieDTO {
    private Integer movieId;


    @NotBlank(message = "Please provide movie's title!")
    private String title;

    @NotBlank(message = "Please provide movie's director's name!")
    private String director;

    @NotBlank(message = "Please provide movie's studio's name!")
    private String studio;

    private Set<String> movieCast;

    private Integer releaseYear;

    @NotBlank(message = "Please provide movie's poster!")
    private String poster;

    @NotBlank(message = "Please provide poster's URL!")
    private String posterUrl;


}
