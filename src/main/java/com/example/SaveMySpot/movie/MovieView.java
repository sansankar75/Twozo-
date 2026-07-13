package com.example.SaveMySpot.movie;

import com.example.SaveMySpot.common.ConsoleReader;

import java.time.LocalDate;
import java.util.List;

public class MovieView {

    public Movie addMovie() {
        Movie movie = new Movie();

        System.out.println("\n==========================================");
        System.out.println("                 MOVIE");
        System.out.println("==========================================");
        System.out.print("Title          : ");
        movie.setTitle(ConsoleReader.SCANNER.nextLine());
        System.out.print("Description    : ");
        movie.setDescription(ConsoleReader.SCANNER.nextLine());
        System.out.print("Language       : ");
        movie.setLanguage(ConsoleReader.SCANNER.nextLine());
        System.out.print("Duration (Min) : ");
        movie.setDuration(ConsoleReader.SCANNER.nextInt());
        System.out.print("Release Date (yyyy-MM-dd) : ");
        movie.setReleaseDate(LocalDate.parse(ConsoleReader.SCANNER.nextLine()));
        System.out.print("Poster URL     : ");
        movie.setPosterUrl(ConsoleReader.SCANNER.nextLine());
        System.out.println("==========================================\n");

        return movie;
    }

    public int selectMovie() {
        System.out.println("\n==========================================");
        System.out.print("Enter Movie ID : ");
        return ConsoleReader.SCANNER.nextInt();
    }

    public void displayMovie(Movie movie) {

        System.out.println("\n========================================");
        System.out.println("Movie Details");
        System.out.println("==========================================");
        System.out.println("ID           : " + movie.getMovieId());
        System.out.println("Title        : " + movie.getTitle());
        System.out.println("Description  : " + movie.getDescription());
        System.out.println("Language     : " + movie.getLanguage());
        System.out.println("Duration     : " + movie.getDuration() + " Min");
        System.out.println("Release Date : " + movie.getReleaseDate());
        System.out.println("Poster URL   : " + movie.getPosterUrl());
        System.out.println("==========================================");
    }

    public void displayMovies(List<Movie> movies) {

        System.out.println("\n==========================================");
        System.out.println("Movie List");
        System.out.println("==========================================");
        if (movies == null || movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        System.out.printf("%-5s %-25s %-15s %-10s%n", "ID", "Title", "Language", "Duration");
        System.out.println("----------------------------------------------------------");
        for (Movie movie : movies) {
            System.out.printf("%-5d %-25s %-15s %-10d%n ",
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getLanguage(),
                    movie.getDuration());
        }
        System.out.println("==========================================");
    }
}