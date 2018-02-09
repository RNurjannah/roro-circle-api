package com.circle.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 
@Path("/circle")
public class CircleService {

	@GET 
	@Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Circle produceJSON( @PathParam("name") String name ) {
        Circle st = new Circle(name, "Sutomo", 22, 1);
        return st;
    }	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createJsonCircle(Circle circle, @Context UriInfo uriInfo) {
		Circle newCircle = new Circle(circle.getFirstName(), circle.getLastName(), 22, 2);
		return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), newCircle.getId())).build();
	}
}
