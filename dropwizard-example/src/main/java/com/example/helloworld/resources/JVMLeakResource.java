package com.example.helloworld.resources;


import com.example.helloworld.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/jvm_leak")
@Produces(MediaType.APPLICATION_JSON)
public class JVMLeakResource {
    public static List<Double> list = new ArrayList<>();

    public JVMLeakResource() {

    }

    @GET
    @Path("/start")
    public String startJVMLeak(Saying saying) {
        populateList();
        return "Check metrics for memory leak";
    }

    private void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
    }
}
