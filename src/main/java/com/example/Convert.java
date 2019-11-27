package com.example;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/convert")
public class Convert {

    @Inject
    @ConfigProperty(name = "myJson")
    JsonObject json;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyObject hello() {
        MyObject myObject = JsonbBuilder.create().fromJson(json.toString(), MyObject.class);
        // Do something interesting with myObject ...
        return myObject;

    }
}