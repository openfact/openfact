package org.openfact;

import org.openfact.models.FileProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("profile")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    private FileProvider fileProvider;

    @GET
    public String test() {
        String result = fileProvider.addFile("carlos.txt", new byte[]{0, 1, 2, 3, 4, 5});
        System.out.println(result);
        return result;
    }
}
