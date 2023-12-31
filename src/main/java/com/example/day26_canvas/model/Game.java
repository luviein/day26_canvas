package com.example.day26_canvas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game implements Serializable {
    private Integer Gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer usersRated;
    private String image;


   public JsonObject toJson() {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          String formattedTimestamp = LocalDateTime.now().format(formatter);
        return Json.createObjectBuilder()
        .add("Gid", this.getGid())
        .add("name", this.getName())
        .add("year", this.getYear())
        .add("ranking", this.getRanking())
        .add("users_rated", this.getUsersRated())
        .add("image", this.getImage())
        .add("timestamp", formattedTimestamp)
        .build();
   }


     // @Override
     // public String toString() {
     //      return "Game [Gid=" + Gid + ", name=" + name + ", year=" + year + ", ranking=" + ranking + ", usersRated="
     //                + usersRated + ", image=" + image + "]";
     // }
   


    
}
