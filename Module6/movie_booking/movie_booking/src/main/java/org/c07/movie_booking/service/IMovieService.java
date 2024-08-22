package org.c07.movie_booking.service;

import org.c07.movie_booking.dto.MovieDTO;
import org.c07.movie_booking.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IMovieService {
    // Tìm kiếm phim theo ID
    Movie findMovieById(Long id);

    // Tìm kiếm danh sách phim theo trạng thái
    List<Movie> findCurrentlyShowingMovies();

    // Xóa phim theo ID
    void deleteById(Long id);

    // Lấy tất cả phim
    Page<Movie> findAllMovies(Pageable pageable);

    void createMovie(MovieDTO movieDTO);

    void updateMovie(MovieDTO movieDTO, Long id);

    MovieDTO convertToDTO(Movie movie);
}
