package org.c07.movie_booking.controller;

import org.c07.movie_booking.dto.KindOfFilmDTO;
import org.c07.movie_booking.dto.MovieDTO;
import org.c07.movie_booking.model.KindOfFilm;
import org.c07.movie_booking.model.Movie;
import org.c07.movie_booking.service.IKindOfFilmService;
import org.c07.movie_booking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private IMovieService iMovieService;

    @Autowired
    private IKindOfFilmService iKindOfFilmService;
    //Hiển thị danh sách phim
    @GetMapping("/private/list-movie")
    public ResponseEntity<?> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> moviePage = iMovieService.findAllMovies(pageable);
        Page<MovieDTO> movieDTOPage = moviePage.map(iMovieService::convertToDTO);
        return ResponseEntity.ok(movieDTOPage);
    }

    //Tạo mới phim
    @PostMapping("private/create")
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO, BindingResult bindingResult){
        new MovieDTO().validate(movieDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            iMovieService.createMovie(movieDTO);
            return new ResponseEntity<>("Tạo mới thành công",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Tạo mới thất bại"+ e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    //cập nhật phim
    @PutMapping("private/update/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDTO movieDTO,@PathVariable long id,BindingResult bindingResult){
        new MovieDTO().validate(movieDTO,bindingResult);
        try {
            iMovieService.updateMovie(movieDTO,id);
            return new ResponseEntity<>("Cập nhật thành công",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("cập nhật thất bại" + e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //xem chi tiết phim
    @GetMapping("/private/movie-detail/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        Movie movie = iMovieService.findMovieById(id);
        if (movie != null) {
            MovieDTO movieDTO = iMovieService.convertToDTO(movie);
            return ResponseEntity.ok(movieDTO);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/private/currently-showing")
    public ResponseEntity<?> getCurrentlyShowingMovies() {
        try {
            List<Movie> movies = iMovieService.findCurrentlyShowingMovies();
            List<MovieDTO> movieDTOs = movies.stream()
                    .map(iMovieService::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(movieDTOs);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/private/list-kind-of-film")
    public ResponseEntity<?> getAllKindOfFilm() {
        try {
            List<KindOfFilm> kindOfFilms = iKindOfFilmService.findAllKindOfFilm();
            List<KindOfFilmDTO> kindOfFilmDTOs = kindOfFilms.stream()
                    .map(iKindOfFilmService::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(kindOfFilmDTOs);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
