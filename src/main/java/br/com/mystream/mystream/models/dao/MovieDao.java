package br.com.mystream.mystream.models.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDao(@JsonAlias("Title") String title,
                       @JsonAlias("Year") Integer releasedYear,
                       @JsonAlias("Released") String released,
                       @JsonAlias("Genre") String genre,
                       @JsonAlias("Runtime") String runtime,
                       @JsonAlias("imdbRating") String rating) {
}
