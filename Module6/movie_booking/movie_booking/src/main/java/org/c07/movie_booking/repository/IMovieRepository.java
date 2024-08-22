package org.c07.movie_booking.repository;

import jakarta.transaction.Transactional;
import org.c07.movie_booking.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    //Select phim
    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    Page<Movie> findAllMovies(Pageable pageable);

    //Tìm kiếm phim theo id
    @Query(value = "SELECT * FROM movie WHERE id = :id", nativeQuery = true)
    Optional<Movie> findMovieById(@Param("id") Long id);

    //Query tìm kiếm phim đang chiếu
    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.kindOfFilms k WHERE m.statusFilm.id = 1")
    List<Movie> findCurrentlyShowingMovies();

    // Query tạo mới phim
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO movie (name_movie, release_date, duration_movie, actor, director, studio, content, trailer, avatar, poster, is_delete, status_movie_id) VALUES (:nameMovie, :releaseDate, :durationMovie, :actor, :director, :studio, :content, :trailer, :avatar, :poster, :isDelete, :statusFilmId)", nativeQuery = true)
    void createMovie(
            @Param("nameMovie") String nameMovie,
            @Param("releaseDate") LocalDate releaseDate,
            @Param("durationMovie") String durationMovie,
            @Param("actor") String actor,
            @Param("director") String director,
            @Param("studio") String studio,
            @Param("content") String content,
            @Param("trailer") String trailer,
            @Param("avatar") String avatar,
            @Param("poster") String poster,
            @Param("isDelete") boolean isDelete,
            @Param("statusFilmId") long statusFilmId
    );
    //Query lấy bản ghi vừa thêm
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long findLastInsertedMovieId();

    @Modifying
    @Transactional
    @Query(value = "UPDATE movie SET name_movie = :nameMovie, release_date = :releaseDate, duration_movie = :durationMovie, actor = :actor, director = :director, studio = :studio, content = :content, trailer = :trailer, avatar = :avatar, poster = :poster, status_movie_id = :statusFilmId WHERE id = :id", nativeQuery = true)
    void updateMovie(
            @Param("id") long id,
            @Param("nameMovie") String nameMovie,
            @Param("releaseDate") LocalDate releaseDate,
            @Param("durationMovie") String durationMovie,
            @Param("actor") String actor,
            @Param("director") String director,
            @Param("studio") String studio,
            @Param("content") String content,
            @Param("trailer") String trailer,
            @Param("avatar") String avatar,
            @Param("poster") String poster,
            @Param("statusFilmId") long statusFilmId
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM movie_kind_of_film where movie_id= :movieId",nativeQuery = true)
    void deleteAllKindOfFilmByMovie(@Param("movieId") Long movieId);


    //Query thêm mới giữa hai bảng movie và kind_of_film
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO movie_kind_of_film (movie_id,kind_of_film_id) VALUES (:movieId, :kindOfFilmId)",nativeQuery = true)
    void insertKindOfFilmForMovie(@Param("movieId") Long movieId, @Param("kindOfFilmId") Long kindOfFilmId);
}
