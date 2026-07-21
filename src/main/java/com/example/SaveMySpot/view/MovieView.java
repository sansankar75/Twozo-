package com.example.SaveMySpot.view;

import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public class MovieView {

    public Movie addMovie() {
        Movie movie = new Movie();

        ConsoleReader.SCANNER.nextLine();
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
        ConsoleReader.SCANNER.nextLine();
        System.out.print("Release Date (yyyy-MM-dd) : ");
        movie.setReleaseDate(LocalDate.parse(ConsoleReader.SCANNER.nextLine()));
        System.out.print("Poster URL     : ");
        movie.setPosterUrl(ConsoleReader.SCANNER.nextLine());
        System.out.println("==========================================\n");

        return movie;
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
            if(movie.getStatus().equals("Active")) {
                System.out.printf("%-5d %-25s %-15s %-10d%n ",
                        movie.getMovieId(),
                        movie.getTitle(),
                        movie.getLanguage(),
                        movie.getDuration());
            }
        }
        System.out.println("==========================================");
    }

    public void displayMovieActors(List<Actor> actors) {

        System.out.println("\n==========================================");
        System.out.println("Your favorite Movie Actor's List !");
        System.out.println("==========================================");
        if (actors == null || actors.isEmpty()) {
            System.out.println("No Actors available.");
            return;
        }
        System.out.printf("%-25s %-25s %-25s %n", "Actor", "ImageURL", "DOB");
        System.out.println("----------------------------------------------------------");
        for (Actor actor : actors) {
            System.out.printf("%-25s %-25s %-25s %n",
                    actor.getActorName(),
                    actor.getImageUrl(),
                    actor.getDateOfBirth());
        }
        System.out.println("==========================================");
    }
}