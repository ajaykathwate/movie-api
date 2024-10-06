package com.movieapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie's title!")
    private String title;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie's director's name!")
    private String director;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie's studio's name!")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie's release year!")
    private Integer releaseYear;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie's poster!")
    private String poster;

}
