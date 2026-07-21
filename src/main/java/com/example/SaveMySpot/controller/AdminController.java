package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.Enum.SeatType;
import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.*;
import com.example.SaveMySpot.service.*;
import com.example.SaveMySpot.view.AdminView;
import com.example.SaveMySpot.view.MovieView;
import com.example.SaveMySpot.view.TheaterView;

import java.text.ParseException;
import java.util.List;

public class AdminController {
    private final AdminView adminView;
    private final AdminService adminService;
    private final TheaterService theaterService;
    private final ShowService showService;
    private final TheaterView theaterView;
    private final MovieView movieView;

    private boolean running = true;

    public AdminController(AdminView adminView,
                           TheaterView theaterView,
                           AdminService adminService,
                           TheaterService theaterService,
                           ShowService showService,
                           MovieView movieView) {

        this.adminView = adminView;
        this.adminService = adminService;
        this.theaterService = theaterService;
        this.showService = showService;
        this.theaterView = theaterView;
        this.movieView = movieView;
    }

    public void showAdminMenu(){
        adminView.showMessage("===========Welcome Admin========");
        while (running) {
            adminChoice(adminView.showMenu());
        }
    }

    private void adminChoice(int choice) {
        try {
            switch (choice) {
                case 1 -> addMovie(movieView.addMovie());
                case 2 -> updateMovie(movieView.addMovie());
                case 3 -> deleteMovie();
                case 4 -> addTheater();
                case 5 -> handleAddScreen();
                case 6 -> handleAddSeat();
                case 7 -> handleCreateShow();
                case 8 -> handleUpdateShow();
                case 9 -> handleDeleteShow();
                case 0 -> logout();
                default -> adminView.showError("Invalid choice. Please try again.");
            }
        } catch (Exception exception) {
            adminView.showError(exception.getMessage());
        }
    }

    public void addMovie(Movie movie) {
        adminService.addMovie(movie);
        adminView.showMessage("Movie added successfully.");
    }

    public void updateMovie(Movie movie) {
        adminService.updateMovie(movie);
        adminView.showMessage("Movie updated successfully.");
    }

    public void deleteMovie() {
        System.out.print("Movie ID to delete: ");
        int movieIds = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();

        if (adminView.confirmAction()) {
            adminService.deleteMovie(movieIds);
            adminView.showMessage("Movie deleted successfully.");
        } else {
            adminView.showMessage("Delete cancelled.");
        }
    }

    // ---------- THEATER | SCREEN | SEAT ----------

    private void handleAddScreen() {
        System.out.print("Theater ID: ");
        int theaterId = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();
        System.out.print("Screen Name: ");
        String screenName = ConsoleReader.SCANNER.nextLine();
        System.out.print("Total Seats: ");
        int totalSeats = ConsoleReader.SCANNER.nextInt();

        Screen screen = new Screen();
        screen.setTheaterId(theaterId);
        screen.setScreenName(screenName);
        screen.setTotalSeats(totalSeats);

        addScreen(screen);
    }

    private void handleAddSeat() {
        System.out.print("Screen ID: ");
        int screenId = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();
        System.out.print("Row Name: ");
        String rowName = ConsoleReader.SCANNER.nextLine();
        System.out.print("Seat Number: ");
        int seatNumber = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();
        System.out.print("Seat Type (SILVER/GOLD/PLATINUM/RECLINER/VIP): ");
        SeatType seatType = SeatType.valueOf(ConsoleReader.SCANNER.nextLine().toUpperCase());

        Seat seat = new Seat();
        seat.setScreenId(screenId);
        seat.setRowName(rowName);
        seat.setSeatNumber(seatNumber);
        seat.setSeatType(seatType);

        addSeat(seat);
    }

    public void addTheater() {
        theaterService.addTheater(theaterView.addTheater());
        adminView.showMessage("Theater added successfully.");
    }

    public void addScreen(Screen screen) {
        theaterService.addScreen(screen);
        adminView.showMessage("Screen added successfully.");
    }

    public void addSeat(Seat seat) {
        theaterService.addSeat(seat);
        adminView.showMessage("Seat added successfully.");
    }

    // ---------- SHOW ----------
    private void handleCreateShow() throws ParseException {
        System.out.print("Movie ID: ");
        int movieId = ConsoleReader.SCANNER.nextInt();
        System.out.print("Screen ID: ");
        int screenId = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();
        System.out.print("Show Date (yyyy-MM-dd): ");
        String dateStr = ConsoleReader.SCANNER.nextLine();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date showDate = sdf.parse(dateStr);
        System.out.print("Start Time (HH:mm:ss): ");
        java.sql.Time startTime = java.sql.Time.valueOf(ConsoleReader.SCANNER.nextLine());

        Show show = new Show();
        show.setMovieId(movieId);
        show.setScreenId(screenId);
        show.setShowDate(showDate);
        show.setStartTime(startTime);

        createShow(show);
    }

    private void handleUpdateShow() throws ParseException {
        System.out.print("Show ID to update: ");
        int showId = ConsoleReader.SCANNER.nextInt();
        ConsoleReader.SCANNER.nextLine();
        System.out.print("New Show Date (yyyy-MM-dd): ");
        String dateStr = ConsoleReader.SCANNER.nextLine();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date showDate = sdf.parse(dateStr);
        System.out.print("New Start Time (HH:mm:ss): ");
        java.sql.Time startTime = java.sql.Time.valueOf(ConsoleReader.SCANNER.nextLine());

        Show show = new Show();
        show.setShowId(showId);
        show.setShowDate(showDate);
        show.setStartTime(startTime);

        showService.updateShow(show);
        adminView.showMessage("Show updated successfully.");
    }

    private void handleDeleteShow() {
        System.out.print("Show ID to delete: ");
        int showId = ConsoleReader.SCANNER.nextInt();

        if (adminView.confirmAction()) {
            showService.deleteShow(showId);
            adminView.showMessage("Show deleted successfully.");
        } else {
            adminView.showMessage("Delete cancelled.");
        }
    }

    public void createShow(Show show) {
        showService.createShow(show);
        adminView.showMessage("Show created successfully.");
        showService.generateShowSeats(show.getShowId());
        adminView.showMessage("Show seats generated successfully.");
    }

    public List<Show> getShowsByMovie(int movieId) {
        return showService.getShowsByMovie(movieId);
    }

    public void generateShowSeats(int showId) {
        showService.generateShowSeats(showId);
    }

    // ---------- LOGOUT ----------

    private void logout() {
        adminView.showMessage("Logged out successfully.");
        running = false;
    }
}