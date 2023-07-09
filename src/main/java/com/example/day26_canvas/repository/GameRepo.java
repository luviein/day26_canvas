package com.example.day26_canvas.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class GameRepo {
    
    @Autowired
    MongoTemplate template;

    public static final String DB_NAME = "game";
    public static final String A_RANKING = "ranking";
    public static final String A_GAMEID = "gid";


    // returning List of Document with limit and offset

    public List<Document> getAllGames(Integer limit, Integer offset) {
    

        Query query = new Query().limit(limit).skip(offset);

        return template.find(query, Document.class, DB_NAME);
        
    }


    public List<Document>getGamesByRanking(Integer limit, Integer offset) {

        Query query = new Query()
            .skip(offset)
            .limit(limit)
            .with(Sort.by(Direction.ASC, A_RANKING));

        return template.find(query, Document.class, DB_NAME);
    }

    public List<Document> getGamesById(Integer gameId) {
        
        // Create filter
        Criteria criteria = Criteria.where(A_GAMEID).is(gameId);
        
        Query query = new Query(criteria);

        return template.find(query, Document.class, DB_NAME);
    }


}
