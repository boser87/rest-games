package com.stefano.learning.restgames.impl;

import com.stefano.learning.restgames.model.Game;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GamesCSVReader {

    public static List<Game> read(InputStream inputStream) throws IOException {

        List<Game> games = new ArrayList<>();

        CSVParser csvParser = getCsvRecords(inputStream);

        Iterator<CSVRecord> iterator = csvParser.iterator();
        iterator.next(); // skip header

        while (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            String[] gamesInALine = parseGames(record.get(1));

            for (String gameInLine : gamesInALine) {
                Game game = new Game(record.get(0), gameInLine);
                games.add(game);
            }
        }

        return games;
    }

    private static CSVParser getCsvRecords(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        return new CSVParser(in, CSVFormat.EXCEL);
    }

    private static String[] parseGames(String gamesString) {
        return gamesString.split(",");
    }

    public static InputStream getGamesCSVInputStreamFromBundle(String fileName) throws IOException {
        Bundle bundle = FrameworkUtil.getBundle(GamesCSVReader.class);
        URL fileURL = bundle.getEntry(fileName);
        return fileURL.openConnection().getInputStream();
    }
}
