package org.c07.movie_booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.List;

public class MovieDTO implements Validator {

    private long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String nameMovie;

    @NotBlank(message = "Ngày phát hành không được để trống")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;

    private String durationMovie;

    @NotBlank(message = "Diễn viên không được bỏ trống")
    private String actor;

    @NotBlank(message = "Dạo diễn không được bỏ trống ")
    private String director;

    @NotBlank(message = "phòng chiếu không được bỏ trống")
    private String studio;

    @NotBlank(message = "Nội dung không được bỏ trống")
    private String content;

    @NotBlank(message = "Trailer không được bỏ trống")
    private String trailer;

    @NotBlank(message = "Avatar không được bỏ trống")
    private String avatar;

    @NotBlank(message = "Poster không được bỏ trống")
    private String poster;

    private Boolean isDelete = true;

    @NotBlank(message = "Trạng thái phim không được bỏ trống")
    private long statusFilm;

    @NotBlank(message = "Loại phim không được bỏ trống")
    private List<KindOfFilmDTO> kindOfFilm;

    public MovieDTO() {
    }

    public MovieDTO(long id, String nameMovie, LocalDate releaseDate, String durationMovie, String actor, String director, String studio, String content, String trailer, String avatar, String poster, Boolean isDelete, long statusFilm, List<KindOfFilmDTO> kindOfFilm) {
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
        this.kindOfFilm = kindOfFilm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Tên phim không được để trống") String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(@NotBlank(message = "Tên phim không được để trống") String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public @NotBlank(message = "Ngày phát hành không được để trống") LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotBlank(message = "Ngày phát hành không được để trống") LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDurationMovie() {
        return durationMovie;
    }

    public void setDurationMovie(String durationMovie) {
        this.durationMovie = durationMovie;
    }

    public @NotBlank(message = "Diễn viên không được bỏ trống") String getActor() {
        return actor;
    }

    public void setActor(@NotBlank(message = "Diễn viên không được bỏ trống") String actor) {
        this.actor = actor;
    }

    public @NotBlank(message = "Dạo diễn không được bỏ trống ") String getDirector() {
        return director;
    }

    public void setDirector(@NotBlank(message = "Dạo diễn không được bỏ trống ") String director) {
        this.director = director;
    }

    public @NotBlank(message = "phòng chiếu không được bỏ trống") String getStudio() {
        return studio;
    }

    public void setStudio(@NotBlank(message = "phòng chiếu không được bỏ trống") String studio) {
        this.studio = studio;
    }

    public @NotBlank(message = "Nội dung không được bỏ trống") String getContent() {
        return content;
    }

    public void setContent(@NotBlank(message = "Nội dung không được bỏ trống") String content) {
        this.content = content;
    }

    public @NotBlank(message = "Trailer không được bỏ trống") String getTrailer() {
        return trailer;
    }

    public void setTrailer(@NotBlank(message = "Trailer không được bỏ trống") String trailer) {
        this.trailer = trailer;
    }

    public @NotBlank(message = "Avatar không được bỏ trống") String getAvatar() {
        return avatar;
    }

    public void setAvatar(@NotBlank(message = "Avatar không được bỏ trống") String avatar) {
        this.avatar = avatar;
    }

    public @NotBlank(message = "Poster không được bỏ trống") String getPoster() {
        return poster;
    }

    public void setPoster(@NotBlank(message = "Poster không được bỏ trống") String poster) {
        this.poster = poster;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @NotBlank(message = "Trạng thái phim không được bỏ trống")
    public long getStatusFilm() {
        return statusFilm;
    }

    public void setStatusFilm(@NotBlank(message = "Trạng thái phim không được bỏ trống") long statusFilm) {
        this.statusFilm = statusFilm;
    }

    public @NotBlank(message = "Loại phim không được bỏ trống") List<KindOfFilmDTO> getKindOfFilm() {
        return kindOfFilm;
    }

    public void setKindOfFilm(@NotBlank(message = "Loại phim không được bỏ trống") List<KindOfFilmDTO> kindOfFilm) {
        this.kindOfFilm = kindOfFilm;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

