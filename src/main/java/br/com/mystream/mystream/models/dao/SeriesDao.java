package br.com.mystream.mystream.models.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDao(@JsonAlias("Title") String title,
                        @JsonAlias("Year") String year,
                        @JsonAlias("Genre") String genre,
                        @JsonAlias("totalSeasons") Integer totalSeasons,
                        @JsonAlias("imdbRating") String rating) {
}
