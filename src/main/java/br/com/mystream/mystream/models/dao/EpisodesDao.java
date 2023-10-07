package br.com.mystream.mystream.models.dao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodesDao(@JsonAlias("Title") String title,
                          @JsonAlias("Year") String year,
                          @JsonAlias("Released") String released,
                          @JsonAlias("Episode") Integer numberEpisode,
                          @JsonAlias("Runtime") String runtime,
                          @JsonAlias("imdbRating") String rating) {
}
