/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server_elm_exercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("counter")
public class CounterResource {

    public static int counter = 10;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public CounterResource() {
    }

    @POST
    @Path("{count}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(@PathParam("count") int count) {
        counter = count;
        return gson.toJson(counter);
    }


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public String getJson() {
        counter++;
        return gson.toJson(counter);
    }

}
