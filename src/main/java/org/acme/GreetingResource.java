package org.acme;

import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    public UriInfo uriInfo = null;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() throws Exception {
        return Response.ok(
            "UriInfo.resolve: " + uriInfo.resolve(new URI("/test")) + "\n" +
            "UriInfo.getBaseUri().resolve: " + uriInfo.getBaseUri().resolve(new URI("/test"))
        ).build();
    }
}
