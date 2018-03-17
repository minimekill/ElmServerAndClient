/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("generic")
public class GenereicResource {

    DB db;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenereicResource
     */
    public GenereicResource() {
        db = new DB();
    }

    /**
     * Retrieves representation of an instance of server.GenereicResource
     *
     * @return an instance of java.lang.String
     */
    @Path("number")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return Integer.toString(DB.number);
    }

    /**
     * PUT method for updating or creating an instance of GenereicResource
     *
     * @param content representation for the resource
     * @return 
     */
    @Path("update")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String putXml(String content) {
        DB.number = (Integer.parseInt(content));
        return content;
    }
}
