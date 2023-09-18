package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movie_database = new HashMap<>();
    HashMap<String,Director> director_database = new HashMap<>();
    HashMap<String, ArrayList<Movie>> director_movie_database = new HashMap<>();

    public String addMovie(Movie movie) {
        movie_database.put(movie.getName(),movie);
        return "Success";
    }

    public String addDirector(Director director) {
        director_database.put(director.getName(),director);
        return "Success";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if(!director_database.containsKey(directorName)){
            director_movie_database.put(directorName,new ArrayList<>());
        }
        director_movie_database.get(directorName).add(getmovieByName(movieName));
        return "Success";

    }

    public Movie getmovieByName(String movieName) {
        return movie_database.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
    return director_database.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
    List<String> movie_list = new ArrayList<>();
    for(Movie movie : director_movie_database.get(directorName)){
        movie_list.add(movie.getName());
    }
    return movie_list;
    }

    public List<String> findAllMovies() {
    return new ArrayList<>(movie_database.keySet());
        }

    public String deleteDirectorByName(String directorName) throws NullPointerException {
        for(Movie movie:director_movie_database.get(directorName)){
            movie_database.remove(movie.getName());
        }
        director_movie_database.remove(directorName);
        director_database.remove(directorName);
        return "Success";
    }

    public String deleteAllDirectors() throws NullPointerException{
        for(String directorName : director_database.keySet()){
            for(Movie movie:director_movie_database.get(directorName)){
                movie_database.remove(movie.getName());
            }
            director_movie_database.remove(directorName);
        }
        director_database.clear();
        return "Success";
    }
}
