package com.stefano.learning.restgames.impl;

import com.stefano.learning.restgames.model.Game;
import com.stefano.learning.restgames.model.GameService;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class GameServiceRestTest {

    private static final String GAMESERVICE_TESTURL = "http://localhost:8282/game";
    private static Server server;

    @BeforeClass
    public static void startServer() {
        GameService gameService = new GameServiceTestImpl();
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setAddress(GAMESERVICE_TESTURL);
        factory.setServiceBean(gameService);
        server = factory.create();
        server.start();
    }

    @Test
    public void testWebClientGetAll() {
        WebClient client = WebClient.create(GAMESERVICE_TESTURL);
        List<Game> games = client.get(new GenericType<List<Game>>(){});
        assertCorrectGame(games.get(0));
    }

    @AfterClass
    public static void stopServer() {
        server.stop();
    }


    private void assertCorrectGame(Game game) {
        Assert.assertNotNull(game);
        Assert.assertEquals("Baccarat", game.getGameName());
        Assert.assertEquals("BetGames", game.getProvider());
    }

}
