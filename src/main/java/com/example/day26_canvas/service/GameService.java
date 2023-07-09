package com.example.day26_canvas.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day26_canvas.model.Game;
import com.example.day26_canvas.repository.GameRepo;


@Service
public class GameService {
    

    @Autowired
    GameRepo gameRepo;

    // private Integer Gid;
    // private String name;
    // private Integer year;
    // private Integer ranking;
    // private Integer usersRated;
    // private String image;

    public List<Game> getAllGames(Integer limit, Integer offset) {
        return gameRepo.getAllGames(limit, offset).stream()
            .map(d -> 
                new Game(d.getInteger("gid"), 
                d.getString("name"), 
                d.getInteger("year"), 
                d.getInteger("ranking"), 
                d.getInteger("users_rated"), 
                d.getString("image"))
            )
            .toList();
    }

    public List<Game>getGamesByRanking(Integer limit, Integer offset) {
        return gameRepo.getGamesByRanking(limit, offset).stream()
            .map(d -> 
                new Game(d.getInteger("gid"), 
                d.getString("name"), 
                d.getInteger("year"), 
                d.getInteger("ranking"), 
                d.getInteger("users_rated"), 
                d.getString("image"))
            )
            .toList();
    }

    public List<Game>getGamesById(Integer gameId) {
        return gameRepo.getGamesById(gameId).stream()
            .map(d -> 
                new Game(d.getInteger("gid"), 
                d.getString("name"), 
                d.getInteger("year"), 
                d.getInteger("ranking"), 
                d.getInteger("users_rated"), 
                d.getString("image"))
            )
            .toList();
    }
}
