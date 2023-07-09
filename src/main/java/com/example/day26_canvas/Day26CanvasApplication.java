package com.example.day26_canvas;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.day26_canvas.repository.GameRepo;

@SpringBootApplication
public class Day26CanvasApplication implements CommandLineRunner {

	@Autowired
	GameRepo gameRepo;
	public static void main(String[] args) {
		SpringApplication.run(Day26CanvasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Document> getGames = gameRepo.getGamesById(20);

		for(Document d : getGames) {
			Integer gameID = d.getInteger("gid");
			String name = d.getString("name");
			Integer year = d.getInteger("year");
			Integer ranking = d.getInteger("ranking");
			Integer usersRated = d.getInteger("users_rated");
			String image = d.getString("image");

			System.out.printf(">>>> ID: %d, Name: %s, Year: %d, Ranking: %d, Users Rated: %d, Image: %s\n", gameID, name, year, ranking, usersRated, image);
		}
	}

}
