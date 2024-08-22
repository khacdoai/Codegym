package org.c07.movie_booking.repository;

import org.c07.movie_booking.model.StatusFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusFilmRepository extends JpaRepository<StatusFilm, Long> {
    StatusFilm findByName(String name);
}
