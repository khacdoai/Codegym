package org.c07.movie_booking.service;

import org.c07.movie_booking.dto.KindOfFilmDTO;
import org.c07.movie_booking.model.KindOfFilm;

import java.util.List;

public interface IKindOfFilmService {
    List<KindOfFilm> findAllKindOfFilm();
    KindOfFilmDTO convertToDTO(KindOfFilm kindOfFilm);
}
