package com.caseyscarborough.tutorial.testing;

import com.caseyscarborough.tutorial.testing.dao.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hardtotest")
public class HardResource {

    @GET
    public Response getDatabaseContent() {
        String content = new Dao().getDatabaseContent();
        return Response.ok(content).build();
    }
}
