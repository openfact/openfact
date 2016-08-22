package org.openfact.services.resources.admin;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;
import java.util.List;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface CertifiedsAdminResource {
    /**
     * @param certefiedId The certefiedId of the Certified
     */
    @Path("{certefiedId}")
    CertifiedAdminResource getCertifiedAdmin(@PathParam("certefiedId") final String certefiedId);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<CertifiedRepresentation> getCertifieds(@QueryParam("filterText") String filterText,
                                                @QueryParam("alias") String alias, @QueryParam("first") Integer firstResult,
                                                @QueryParam("max") Integer maxResults);

    @GET
    @Path("/searchEnabled")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    CertifiedRepresentation getCertifiedEnabeld();

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createCertified(@Valid final CertifiedRepresentation rep);
    
    @POST
    @Path("upload")
	/*@Consumes(MediaType.MULTIPART_FORM_DATA)  */
    @Consumes("multipart/form-data")
    Response uploadCertified(final MultipartFormDataInput input);

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<CertifiedRepresentation> search(final SearchCriteriaRepresentation criteria);


}
