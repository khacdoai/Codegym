package org.c07.movie_booking.service;

import org.c07.movie_booking.model.StatusFilm;

public interface IStatusFilmService {
    StatusFilm findByName(String name);
}
