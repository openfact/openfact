package org.openfact;

import org.openfact.models.FileProvider;
import org.openfact.models.FileProviderVendor;
import org.openfact.models.files.FileException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("documents")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentsResource {

    @Inject
    @FileProviderVendor(type = FileProviderVendor.Type.FILESYSTEM)
    private FileProvider fileProvider;

    @Inject
    @FileProviderVendor(type = FileProviderVendor.Type.DROPBOX)
    private FileProvider drpopbox;

    @GET
    public String test() {
        String result = null;
        try {
            result = fileProvider.addFile("carlos.txt", new byte[]{0, 1, 2, 3, 4, 5}, "ahren");
            String ahren = drpopbox.addFile("carlos.txt", new byte[]{0, 1, 2, 3, 4, 5}, "ahren");
        } catch (FileException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result;
    }
}
