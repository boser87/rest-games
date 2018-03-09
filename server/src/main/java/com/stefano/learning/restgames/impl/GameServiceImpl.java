package com.stefano.learning.restgames.impl;

import com.stefano.learning.restgames.model.Game;
import com.stefano.learning.restgames.model.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    private static final Logger LOG = LoggerFactory.getLogger(GameServiceImpl.class);
    public static final String GAMES_CSV_FILE_NAME = "games.csv";

    private List<Game> games;

    public GameServiceImpl() {
        try (InputStream inputStream = GamesCSVReader.getGamesCSVInputStreamFromBundle(GAMES_CSV_FILE_NAME)) {
            games = GamesCSVReader.read(inputStream);
        } catch (IOException e) {
            games = new ArrayList<>();
            LOG.error("Cannot read games from CSV file", e);
        }
    }

    @Override
    public List<Game> getAll() {
        return games;
    }
}
