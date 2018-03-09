package com.stefano.learning.restgames.impl;

import com.google.gson.Gson;
import com.stefano.learning.restgames.model.Game;
import com.stefano.learning.restgames.model.Provider;
import com.stefano.learning.restgames.model.ProviderService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ProviderServiceImpl implements ProviderService {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderServiceImpl.class);

    private static final String ENDPOINT = "http://localhost:8181/cxf";
    private static final String RESOURCE_NAME = "/game";

    private List<Provider> providers;

    public ProviderServiceImpl() {
    }

    @Override
    public List<Provider> getAll() {
        WebClient client = WebClient.create(ENDPOINT + RESOURCE_NAME);
        String gamesString = client.get(String.class);

        Gson gson = new Gson();
        Game games[] = gson.fromJson(gamesString, Game[].class);

        // Group games by provider
        Map<String, List<Game>> gamesPerProvider = Arrays.asList(games).stream().collect(groupingBy(Game::getProvider));

        providers = new ArrayList<>();
        gamesPerProvider.entrySet().forEach(stringListEntry -> {
            providers.add(new Provider(stringListEntry.getKey(), stringListEntry.getValue().size()));
        });

        return providers;
    }
}
