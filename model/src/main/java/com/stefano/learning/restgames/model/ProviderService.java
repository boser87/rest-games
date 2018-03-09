package com.stefano.learning.restgames.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public interface ProviderService {
    @GET
    @Path("/")
    public List<Provider> getAll();
}
