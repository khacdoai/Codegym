package org.c07.movie_booking.repository;


import org.c07.movie_booking.model.StatusFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieStatusRepository extends JpaRepository<StatusFilm, Long> {
}
