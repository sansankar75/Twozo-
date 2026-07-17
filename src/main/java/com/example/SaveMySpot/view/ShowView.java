package com.example.SaveMySpot.view;

import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.Show;
import com.example.SaveMySpot.entity.ShowSeat;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShowView {

    public Show addShow() throws ParseException {
        Show show = new Show();
        ShowSeat showSeat = new ShowSeat();

        System.out.println("\n==========================================");
        System.out.println("                  SHOW");
        System.out.println("==========================================");
        System.out.print("Enter show date (yyyy-MM-dd): ");
        String dateStr = ConsoleReader.SCANNER.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        show.setShowDate(date);

        System.out.print("Start Time (HH:mm): ");
        show.setStartTime(Time.valueOf(ConsoleReader.SCANNER.nextLine()));
        System.out.print("Ticket Price      : ");
        showSeat.setPrice(BigDecimal.valueOf(Long.parseLong(ConsoleReader.SCANNER.nextLine())));
        System.out.println("==========================================\n");

        return show;
    }

    public int selectShow() {
        System.out.println("\n==========================================");
        System.out.print("Enter Show ID : ");
        return Integer.parseInt(ConsoleReader.SCANNER.nextLine());
    }

    public void displayShow(Show show, ShowSeat showSeat) {

        System.out.println("\n==========================================");
        System.out.println("              SHOW DETAILS");
        System.out.println("==========================================");
        System.out.println("Show ID      : " + show.getShowId());
        System.out.println("Movie ID     : " + show.getMovieId());
        System.out.println("Screen ID    : " + show.getScreenId());
        System.out.println("Show Date    : " + show.getShowDate());
        System.out.println("Start Time   : " + show.getStartTime());
        System.out.println("Ticket Price : ₹" + showSeat.getPrice());
        System.out.println("==========================================");
    }

    public void displayShows(List<Show> shows) {

        System.out.println("\n==============================================================");
        System.out.println("                         SHOW LIST");
        System.out.println("==============================================================");
        if (shows == null || shows.isEmpty()) {
            System.out.println("No shows available.");
            return;
        }
        System.out.printf("%-5s %-8s %-9s %-12s %-10s \n", "ID", "Movie", "Screen", "Date", "Start");
        System.out.println("--------------------------------------------------------------");
        for (Show show : shows) {
            System.out.printf("%-5d %-8d %-9d %-12s %-10s \n",
                    show.getShowId(),
                    show.getMovieId(),
                    show.getScreenId(),
                    show.getShowDate(),
                    show.getStartTime());
        }
        System.out.println("==============================================================");
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}