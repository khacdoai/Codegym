package org.c07.movie_booking.repository;

import org.c07.movie_booking.model.KindOfFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IKindOfFilmRepository extends JpaRepository<KindOfFilm, Long> {
}
