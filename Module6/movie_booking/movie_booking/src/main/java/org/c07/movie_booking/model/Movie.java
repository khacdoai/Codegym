package org.c07.movie_booking.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String nameMovie;
    private LocalDate releaseDate;
    private String durationMovie;
    private String actor;
    private String director;
    private String studio;
    private String content;
    private String trailer;
    private String avatar;
    private String poster;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "status_movie_id")
    private StatusFilm statusFilm;

    @ManyToMany
    @JoinTable(
            name = "movie_kind_of_film",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "kind_of_film_id")
    )
    private Set<KindOfFilm> kindOfFilms = new HashSet<>();

    public Movie() {
    }

    public Movie(long id, String nameMovie, LocalDate releaseDate, String durationMovie, String actor, String director, String studio, String content, String trailer, String avatar, String poster, boolean isDelete, StatusFilm statusFilm, Set<KindOfFilm> kindOfFilms) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.releaseDate = releaseDate;
        this.durationMovie = durationMovie;
        this.actor = actor;
        this.director = director;
        this.studio = studio;
        this.content = content;
        this.trailer = trailer;
        this.avatar = avatar;
        this.poster = poster;
        this.isDelete = isDelete;
        this.statusFilm = statusFilm;
        this.kindOfFilms = kindOfFilms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDurationMovie() {
        return durationMovie;
    }

    public void setDurationMovie(String durationMovie) {
        this.durationMovie = durationMovie;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public StatusFilm getStatusFilm() {
        return statusFilm;
    }

    public void setStatusFilm(StatusFilm statusFilm) {
        this.statusFilm = statusFilm;
    }

    public Set<KindOfFilm> getKindOfFilms() {
        return kindOfFilms;
    }

    public void setKindOfFilms(Set<KindOfFilm> kindOfFilms) {
        this.kindOfFilms = kindOfFilms;
    }
}
