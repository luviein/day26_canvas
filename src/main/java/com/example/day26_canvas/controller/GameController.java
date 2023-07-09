package com.example.day26_canvas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day26_canvas.model.Game;
import com.example.day26_canvas.service.GameService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping
public class GameController {
    
    @Autowired
    GameService gameSvc;
    

    @GetMapping(produces="application/json")
    public ResponseEntity<String> getAllGames(@RequestParam(name="limit", defaultValue="25") int limit, @RequestParam(name="offset", defaultValue="0") int offset) {
        List<Game> gameList = gameSvc.getAllGames(limit, offset);
        JsonArrayBuilder gameArrayBuilder = Json.createArrayBuilder();
        for (Game game : gameList) {
            // Create current Game's json object
            JsonObjectBuilder gameBuilder = Json.createObjectBuilder()
                    .add("id", game.getGid())
                    .add("name", game.getName())
                    ;

            // Add jsonobject to jsonarray
            gameArrayBuilder.add(gameBuilder);
        }
        String jsonResponse = 
            Json.createObjectBuilder()
            .add("games", gameArrayBuilder)
            .add("offset", offset)
            .add("limit", limit)
            .add("total", gameList.size())
            .add("timestamp", LocalDate.now().toString())
            .build()
            .toString();

        return ResponseEntity.ok().body(jsonResponse);
    }

    @GetMapping(path="/ranking",produces="application/json")
    public ResponseEntity<String> getGamesByRanking(@RequestParam(name="limit", defaultValue="25") int limit, @RequestParam(name="offset", defaultValue="0") int offset) {
        List<Game> gameList = gameSvc.getGamesByRanking(limit, offset);
        JsonArrayBuilder gameArrayBuilder = Json.createArrayBuilder();
        for (Game game : gameList) {
            // Create current Game's json object
            JsonObjectBuilder gameBuilder = Json.createObjectBuilder()
                    .add("id", game.getGid())
                    .add("name", game.getName())
                    .add("ranking", game.getRanking())
                    ;

            // Add jsonobject to jsonarray
            gameArrayBuilder.add(gameBuilder);
        }
        String jsonResponse = 
            Json.createObjectBuilder()
            .add("games", gameArrayBuilder)
            .add("offset", offset)
            .add("limit", limit)
            .add("total", gameList.size())
            .add("timestamp", LocalDate.now().toString())
            .build()
            .toString();

        return ResponseEntity.ok().body(jsonResponse);
    }

    @GetMapping(path="/{gameID}",produces="application/json")
    public ResponseEntity<String>getGamesById(@PathVariable int gameID) {
        List<Game> game = gameSvc.getGamesById(gameID);
        return ResponseEntity.ok().body(
            game.get(0).toJson().toString()
        );
    }
    
}
