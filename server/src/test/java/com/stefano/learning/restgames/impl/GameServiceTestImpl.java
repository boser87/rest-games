package com.stefano.learning.restgames.impl;

import com.stefano.learning.restgames.model.Game;
import com.stefano.learning.restgames.model.GameService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GameServiceTestImpl implements GameService {

    private static final String GAMES_CSV_FILENAME = "games.csv";
    private List<Game> games;

    GameServiceTestImpl() {
        ClassLoader classLoader = GameServiceRestTest.class.getClassLoader();
        File file = new File(classLoader.getResource(GAMES_CSV_FILENAME).getFile());
        try {
            FileInputStream fis = new FileInputStream(file);
            games = GamesCSVReader.read(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Game> getAll() {
        return games;
    }
}
