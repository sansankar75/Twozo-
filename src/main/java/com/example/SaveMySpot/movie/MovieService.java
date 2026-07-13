package com.example.SaveMySpot.movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieDetails(int movieId);

}
