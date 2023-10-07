package br.com.mystream.mystream.models;

import br.com.mystream.mystream.models.dao.EpisodesDao;

import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer year;
    private LocalDate released;
    private Integer numberEpisode;
    private String runtime;
    private Double rating;

    public Episode(Integer numberSeason, EpisodesDao episodesDao) {
        this.season = numberSeason;
        this.title = episodesDao.title();
        try {
            this.year = Integer.valueOf(episodesDao.year());
        } catch (NumberFormatException e) {
            this.year = LocalDate.parse(episodesDao.released()).getYear();
        }
        this.released = LocalDate.parse(episodesDao.released());
        this.numberEpisode = episodesDao.numberEpisode();
        this.runtime = episodesDao.runtime();
        try {
            this.rating = Double.valueOf(episodesDao.rating());
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }
    }

    @Override
    public String toString() {
        return "{season=" + season +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", released=" + released +
                ", numberEpisode=" + numberEpisode +
                ", runtime='" + runtime + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public Integer getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
