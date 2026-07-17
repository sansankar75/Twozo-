package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Theater;

import java.util.List;

public interface TheaterRepository {

    void save(Theater theater);
    Theater findById(int theaterId);
    List<Theater> getAllTheater();
}
//select m.movie_name,th.city  from theater th
//join screen sc
//on sc.theater_id = th.theater_id
//join show sh
//on sh.screen_id = sc.screen_id
//join movie m
//on m.movie_id = sh.movie_id
//where sh.show_date >= CURRENT_DATE and th.city = 'Tirunelveli' ;