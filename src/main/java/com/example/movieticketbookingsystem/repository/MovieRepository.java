package com.example.movieticketbookingsystem.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class MovieRepository {
    private static final Map<Integer, String> movie = new HashMap<>();
    private static final Map<Integer, String> actor = new HashMap<>();
    private static final Map<Integer, List<Integer>> movieActor = new HashMap<>();
    private static final Map<Integer, List<String>> seats = new HashMap<>();
    private static final Map<Integer, String> movieInfo = new HashMap<>();

    private static int movieID = 4;
    private static int actorID = 1006;

    static{

        // Sample fake data
        movie.put(1, "Inception | A thief who steals corporate secrets through dream-sharing technology");
        movie.put(2, "Avatar | A paraplegic marine on an alien planet torn between orders and the native people");
        movie.put(3, "Interstellar | A team of explorers travel through a wormhole in space to save humanity");

        actor.put(1000, "Leonardo DiCaprio");
        actor.put(1001, "Joseph Gordon-Levitt");
        actor.put(1002, "Sam Worthington");
        actor.put(1003, "Zoe Saldana");
        actor.put(1004, "Matthew McConaughey");
        actor.put(1005, "Anne Hathaway");

        movieActor.put(1, new ArrayList<>(Arrays.asList(1000, 1001)));
        movieActor.put(2, new ArrayList<>(Arrays.asList(1002, 1003)));
        movieActor.put(3, new ArrayList<>(Arrays.asList(1004, 1005)));

        movieInfo.put(1, "18:00 | 150 | 4ABCD");
        movieInfo.put(2, "20:00 | 200 | 5ABCDE");
        movieInfo.put(3, "17:00 | 180 | 3ABC");

        seats.put(1, new ArrayList<>(Arrays.asList("A1", "A2", "B3")));
        seats.put(2, new ArrayList<>(Arrays.asList("A1", "B2", "D5")));
        seats.put(3, new ArrayList<>(Arrays.asList("A2", "C1")));

    }
}
