package org.c07.movie_booking.service.implement;

import org.c07.movie_booking.dto.KindOfFilmDTO;
import org.c07.movie_booking.model.KindOfFilm;
import org.c07.movie_booking.repository.IKindOfFilmRepository;
import org.c07.movie_booking.service.IKindOfFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindOfFilmService implements IKindOfFilmService {
    @Autowired
    private IKindOfFilmRepository iKindOfFilmRepository;

    @Override
    public List<KindOfFilm> findAllKindOfFilm() {
        return iKindOfFilmRepository.findAll();
    }

    @Override
    public KindOfFilmDTO convertToDTO(KindOfFilm kindOfFilm) {
        return new KindOfFilmDTO(kindOfFilm.getId(), kindOfFilm.getName());
    }
}
