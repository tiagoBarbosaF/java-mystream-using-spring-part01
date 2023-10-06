package br.com.mystream.mystream.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonDao(@JsonAlias("Title") String title,
                        @JsonAlias("Season") Integer season,
                        @JsonAlias("totalSeasons") Integer totalSeasons,
                        @JsonAlias("Episodes") List<EpisodesDao> episodes) {
}
