package com.stefano.learning.restgames.impl;

import com.stefano.learning.restgames.model.Game;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GamesCSVReaderTest {
    @Test
    public void testLineRead() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("games.csv").getFile());
        try {
            FileInputStream fis = new FileInputStream(file);
            List<Game> games = GamesCSVReader.read(fis);
            Game firstGame = games.get(0);
            Assert.assertTrue(firstGame.getProvider().equals("BetGames"));
            Assert.assertTrue(firstGame.getGameName().equals("Baccarat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
