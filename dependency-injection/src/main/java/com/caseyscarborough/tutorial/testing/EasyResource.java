package com.caseyscarborough.tutorial.testing;

import com.caseyscarborough.tutorial.testing.dao.Dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/easytotest")
public class EasyResource {

    private Dao dao;

    public EasyResource(Dao dao) {
        this.dao = dao;
    }

    @GET
    public Response getDatabaseContent() {
        String content = dao.getDatabaseContent();
        return Response.ok(content).build();
    }
}
