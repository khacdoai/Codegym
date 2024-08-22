package org.c07.movie_booking.service.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.c07.movie_booking.dto.KindOfFilmDTO;
import org.c07.movie_booking.dto.MovieDTO;
import org.c07.movie_booking.model.Movie;
import org.c07.movie_booking.repository.IMovieRepository;
import org.c07.movie_booking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository iMovieRepository;

    @Override
    public Movie findMovieById(Long id) {
        return iMovieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findCurrentlyShowingMovies() {
        return iMovieRepository.findCurrentlyShowingMovies();
    }

    @Override
    public void deleteById(Long id) {
        iMovieRepository.deleteById(id);
    }

    @Override
    public Page<Movie> findAllMovies(Pageable pageable) {
        return iMovieRepository.findAllMovies(pageable);
    }

    @Override
    public void createMovie(MovieDTO movieDTO) {
        iMovieRepository.createMovie(
                movieDTO.getNameMovie(),
                movieDTO.getReleaseDate(),
                movieDTO.getDurationMovie(),
                movieDTO.getActor(),
                movieDTO.getDirector(),
                movieDTO.getStudio(),
                movieDTO.getContent(),
                movieDTO.getTrailer(),
                movieDTO.getAvatar(),
                movieDTO.getPoster(),
                movieDTO.getDelete(),
                movieDTO.getStatusFilm()
        );

        // Retrieve the last inserted movie ID
        Long movieId = iMovieRepository.findLastInsertedMovieId();

        // Handle association with KindOfFilm
        if (movieDTO.getKindOfFilm() != null && !movieDTO.getKindOfFilm().isEmpty()) {
            for (KindOfFilmDTO kindOfFilmDTO : movieDTO.getKindOfFilm()) {
                iMovieRepository.insertKindOfFilmForMovie(movieId, kindOfFilmDTO.getId());
            }
        }
    }

    @Override
    public void updateMovie(MovieDTO movieDTO, Long id) {
        iMovieRepository.updateMovie(
                id,
                movieDTO.getNameMovie(),
                movieDTO.getReleaseDate(),
                movieDTO.getDurationMovie(),
                movieDTO.getActor(),
                movieDTO.getDirector(),
                movieDTO.getStudio(),
                movieDTO.getContent(),
                movieDTO.getTrailer(),
                movieDTO.getAvatar(),
                movieDTO.getPoster(),
                movieDTO.getStatusFilm()
        );
        iMovieRepository.deleteAllKindOfFilmByMovie(id);

        if (movieDTO.getKindOfFilm() != null && !movieDTO.getKindOfFilm().isEmpty()) {
            for (KindOfFilmDTO kindOfFilmDTO : movieDTO.getKindOfFilm()) {
                iMovieRepository.insertKindOfFilmForMovie(id, kindOfFilmDTO.getId());
            }
        }
    }

    @Override
    public MovieDTO convertToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setNameMovie(movie.getNameMovie());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setDurationMovie(movie.getDurationMovie());
        movieDTO.setActor(movie.getActor());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setStudio(movie.getStudio());
        movieDTO.setContent(movie.getContent());
        movieDTO.setTrailer(movie.getTrailer());
        movieDTO.setAvatar(movie.getAvatar());
        movieDTO.setPoster(movie.getPoster());
        movieDTO.setDelete(movie.isDelete());
        movieDTO.setStatusFilm(movie.getStatusFilm().getId());

        // Convert KindOfFilm to KindOfFilmDTO
        List<KindOfFilmDTO> kindOfFilmDTOs = movie.getKindOfFilms().stream()
                .map(kindOfFilm -> new KindOfFilmDTO(kindOfFilm.getId(), kindOfFilm.getName()))
                .collect(Collectors.toList());
        movieDTO.setKindOfFilm(kindOfFilmDTOs);
        return movieDTO;
    }
}
