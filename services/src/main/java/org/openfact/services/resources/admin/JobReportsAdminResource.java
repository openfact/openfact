package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.OpenfactClientConnection;
import org.openfact.models.Constants;
import org.openfact.models.JobReportQuery;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.JobReportRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("/admin/organizations/{organization}/job-reports")
public class JobReportsAdminResource {

    protected static final Logger logger = Logger.getLogger(JobReportsAdminResource.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    @Inject
    private AdminEventBuilder adminEvent;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private JobReportQuery jobReportQuery;

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobReportRepresentation> getReports(
            @PathParam("organization") String organizationName,
            @QueryParam("jobName") List<String> jobNames,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        JobReportQuery query = jobReportQuery.organization(organization.getId());

        if (jobNames != null & !jobNames.isEmpty()) {
            jobNames.stream().forEach(c -> query.jobName(c));
        }

        if (dateFrom != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date from = null;
            try {
                from = df.parse(dateFrom);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(From)', expected format is yyyy-MM-dd");
            }
            query.fromDate(from);
        }

        if (dateTo != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date to = null;
            try {
                to = df.parse(dateTo);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(To)', expected format is yyyy-MM-dd");
            }
            query.toDate(to);
        }

        if (firstResult != null) {
            query.firstResult(firstResult);
        }
        if (maxResults != null) {
            query.maxResults(maxResults);
        }

        return query.getResultList().stream()
                .map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @GET
    @Path("providers")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getFile() {
        /*auth.requireView();

        return session.getAllProviders(OrganizationScheduleTaskProvider.class).stream()
                .filter(p -> p.isActive()).map(f -> f.getClass().getSimpleName())
                .collect(Collectors.toList());*/
        return Collections.EMPTY_LIST;
    }

}
