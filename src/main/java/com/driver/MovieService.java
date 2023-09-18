package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository=new MovieRepository();

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName,directorName);

    }

    public Movie getMovieByName(String movieName) {
    return movieRepository.getmovieByName(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
    return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies() {
    return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String directorName) {

        return movieRepository.deleteDirectorByName(directorName);

    }



    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }
}
