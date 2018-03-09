package com.stefano.learning.restgames.model;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public interface GameService {
    @GET
    @Path("/")
    public List<Game> getAll();
}
