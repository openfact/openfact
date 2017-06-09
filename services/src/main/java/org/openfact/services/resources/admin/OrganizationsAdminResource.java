package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.keycloak.KeyPairVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.common.util.PemUtils;
import org.openfact.Config;
import org.openfact.common.ClientConnection;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.jose.jws.AlgorithmType;
import org.openfact.keys.RsaKeyMetadata;
import org.openfact.models.*;
import org.openfact.models.types.InternetMediaType;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.models.utils.StripSecretsUtils;
import org.openfact.representations.idm.*;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ModelErrorResponseException;
import org.openfact.services.managers.EventStoreManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.managers.ScheduleOrganizations;
import org.openfact.services.resource.OrganizationAdminResourceProvider;
import org.openfact.services.resource.security.ClientUser;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
@Path("/admin/organizations")
public class OrganizationsAdminResource {

    private static final Logger logger = Logger.getLogger(OrganizationsAdminResource.class);

    @Context
    private UriInfo uriInfo;

    @Context
    private OpenfactSession session;

    @Context
    private ClientConnection clientConnection;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private EventStoreManager eventStoreManager;

    @Inject
    private KeyManager keystore;

    @Inject
    private StripSecretsUtils stripSecretsUtils;

    @Inject
    private EventStoreProvider eventStoreProvider;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private ComponentProvider componentProvider;

    @Inject
    private JobReportProvider jobReportProvider;

    @Inject
    private ModelToRepresentation modelToRepresentation;

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private ScheduleOrganizations scheduleOrganizations;

    @Inject
    private Instance<OrganizationScheduledTask> organizationScheduledTasks;

    @Inject
    private DocumentsAdminResource documentsAdminResource;

    @Inject
    @Any
    private Instance<OrganizationAdminResourceProvider> organizationAdminResourceProviders;

    private OrganizationModel getOrganizationModel(String organizationName) {
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization " + organizationName + " not found.");
        }
        session.getContext().setOrganization(organization);
        return organization;
    }

    private OrganizationAuth getAuth(OrganizationModel organization) {
        return getAuth(organization, Resource.ORGANIZATION);
    }

    private OrganizationAuth getAuth(OrganizationModel organization, Resource resource) {
        List<OrganizationModel> permittedOrganizations = securityContext.getPermittedOrganizations(session);
        if (!securityContext.getClientUser(session).hasAppRole(AdminRoles.ADMIN) && !permittedOrganizations.contains(organization)) {
            throw new ForbiddenException();
        }
        return securityContext.getClientUser(session).organizationAuth(resource);
    }

    private AdminEventBuilder getAdminEvent(OrganizationModel organization) {
        return getAdminEvent(organization, ResourceType.ORGANIZATION);
    }

    private AdminEventBuilder getAdminEvent(OrganizationModel organization, ResourceType resource) {
        return new AdminEventBuilder(organization, securityContext.getClientUser(session), session, clientConnection).resource(resource);
    }

    /**
     * Create a new organization.
     *
     * @param rep The representation of the organization that will be created
     * @return The organization created on Response format
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response importOrganization(@Valid final OrganizationRepresentation rep) throws ModelErrorResponseException {
        if (!securityContext.getClientUser(session).hasAppRole(AdminRoles.CREATE_ORGANIZATION)) {
            throw new ForbiddenException();
        }

        logger.debugv("importOrganization: {0}", rep.getOrganization());

        try {
            OrganizationModel organization = organizationManager.importOrganization(rep);

            URI location = uriInfo.getBaseUriBuilder().path(organization.getName()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            throw new ModelErrorResponseException("Organization with same name exists", Response.Status.CONFLICT);
        } catch (ModelException e) {
            throw new ModelErrorResponseException("Could not create organization", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all organizations.
     *
     * @return All organizations
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrganizationRepresentation> getOrganizations() {
        List<OrganizationRepresentation> reps = new ArrayList<>();

        List<OrganizationModel> permittedOrganizations = securityContext.getPermittedOrganizations(session);
        if (securityContext.getClientUser(session).hasAppRole(AdminRoles.ADMIN)) {
            List<OrganizationModel> organizations = organizationManager.getOrganizations();
            addOrganizationRep(reps, organizations);
        } else if (permittedOrganizations != null && !permittedOrganizations.isEmpty()) {
            addOrganizationRep(reps, permittedOrganizations);
        }

        if (reps.isEmpty()) {
            throw new ForbiddenException();
        }

        logger.debug(("getOrganizations()"));
        return reps;
    }

    private void addOrganizationRep(List<OrganizationRepresentation> reps, List<OrganizationModel> organizations) {
        ClientUser contextUser = securityContext.getClientUser(session);
        if (contextUser.hasAppRole(AdminRoles.VIEW_ORGANIZATION)) {
            organizations.forEach(organization -> reps.add(modelToRepresentation.toRepresentation(organization, false)));
        } else if (contextUser.hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            organizations.forEach(organization -> {
                OrganizationRepresentation rep = new OrganizationRepresentation();
                rep.setOrganization(organization.getName());
                reps.add(rep);
            });
        }
    }

    /**
     * Get the organization with the specified organization name.
     *
     * @return The organization with the specified name
     */
    @GET
    @Path("/{organization}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationRepresentation getOrganization(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        if (auth.hasView()) {
            return modelToRepresentation.toRepresentation(organization, true);
        } else {
            auth.requireAny();

            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setOrganization(organization.getName());
            return rep;
        }
    }

    /**
     * Update organization information.
     *
     * @param rep The representation of the organization to be changed
     * @return Generic Response object
     */
    @PUT
    @Path("/{organization}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganization(@PathParam("organization") final String organizationName, @Valid final OrganizationRepresentation rep) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();

        logger.debug("updating organization: " + organization.getName());

        if (Config.getAdminOrganization().equals(organization.getName()) && (rep.getOrganization() != null && !rep.getOrganization().equals(Config.getAdminOrganization()))) {
            return ErrorResponse.error("Can't rename master organization", Response.Status.BAD_REQUEST);
        }

        try {
            if (!Constants.GENERATE.equals(rep.getPublicKey()) && (rep.getPrivateKey() != null && rep.getPublicKey() != null)) {
                try {
                    KeyPairVerifier.verify(rep.getPrivateKey(), rep.getPublicKey());
                } catch (VerificationException e) {
                    return ErrorResponse.error(e.getMessage(), Response.Status.BAD_REQUEST);
                }
            }

            if (!Constants.GENERATE.equals(rep.getPublicKey()) && (rep.getCertificate() != null)) {
                try {
                    X509Certificate cert = PemUtils.decodeCertificate(rep.getCertificate());
                    if (cert == null) {
                        return ErrorResponse.error("Failed to decode certificate", Response.Status.BAD_REQUEST);
                    }
                } catch (Exception e) {
                    return ErrorResponse.error("Failed to decode certificate", Response.Status.BAD_REQUEST);
                }
            }

            representationToModel.updateOrganization(rep, organization);

            // Refresh periodic tasks for send documents
            organizationManager.updatePeriodicTask(organization);

            eventStoreManager.send(organization, getAdminEvent(organization)
                    .operation(OperationType.UPDATE)
                    .representation(rep)
                    .getEvent());
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            throw new ModelErrorResponseException("Organization with same name exists", Response.Status.CONFLICT);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ModelErrorResponseException("Failed to update organization", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes organization with given name.
     */
    @DELETE
    @Path("/{organization}")
    public void deleteOrganization(@PathParam("organization") final String organizationName) throws ModelErrorResponseException {
        if (!securityContext.getClientUser(session).hasAppRole(AdminRoles.ADMIN)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = getOrganizationModel(organizationName);
        if (Config.getAdminOrganization().equals(organization.getName())) {
            throw new ModelErrorResponseException("Master organization could not be deleted");
        }

        if (!organizationManager.removeOrganization(organization)) {
            throw new NotFoundException("Organization doesn't exist");
        }
    }

    @GET
    @Path("/{organization}/keys")
    @Produces(MediaType.APPLICATION_JSON)
    public KeysMetadataRepresentation getKeyMetadata(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();

        Map<String, String> active = new HashMap<>();
        active.put(AlgorithmType.RSA.name(), keystore.getActiveRsaKey(organization).getKid());
        keys.setActive(active);

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (RsaKeyMetadata m : keystore.getRsaKeys(organization, true)) {
            KeysMetadataRepresentation.KeyMetadataRepresentation r = new KeysMetadataRepresentation.KeyMetadataRepresentation();
            r.setProviderId(m.getProviderId());
            r.setProviderPriority(m.getProviderPriority());
            r.setKid(m.getKid());
            r.setStatus(m.getStatus() != null ? m.getStatus().name() : null);
            r.setType(AlgorithmType.RSA.name());
            r.setPublicKey(PemUtils.encodeKey(m.getPublicKey()));
            r.setCertificate(PemUtils.encodeCertificate(m.getCertificate()));
            l.add(r);
        }

        keys.setKeys(l);

        return keys;
    }

    @GET
    @Path("/{organization}/components")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComponentRepresentation> getComponents(@PathParam("organization") final String organizationName,
                                                       @QueryParam("parent") String parent,
                                                       @QueryParam("type") String type) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        List<ComponentModel> components;
        if (parent == null && type == null) {
            components = componentProvider.getComponents(organization);
        } else if (type == null) {
            components = componentProvider.getComponents(organization, parent);
        } else if (parent == null) {
            components = componentProvider.getComponents(organization, organization.getId(), type);
        } else {
            components = componentProvider.getComponents(organization, parent, type);
        }
        List<ComponentRepresentation> reps = new LinkedList<>();
        for (ComponentModel component : components) {
            ComponentRepresentation rep = modelToRepresentation.toRepresentation(component, false);
            reps.add(rep);
        }
        return reps;
    }

    @POST
    @Path("/{organization}/components")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("organization") final String organizationName, ComponentRepresentation rep) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();
        try {
            ComponentModel model = representationToModel.toModel(rep);
            if (model.getParentId() == null) model.setParentId(organization.getId());

            model = componentProvider.addComponentModel(organization, model);

            eventStoreManager.send(organization, getAdminEvent(organization)
                    .operation(OperationType.CREATE)
                    .resourcePath(uriInfo, model.getId())
                    .representation(stripSecretsUtils.strip(rep))
                    .getEvent());
            return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build()).build();
        } catch (ComponentValidationException e) {
            throw new ModelErrorResponseException("Component validation exception", Response.Status.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            throw new ModelErrorResponseException(e.getMessage(), Response.Status.BAD_REQUEST);
        } catch (ModelException e) {
            throw new ModelErrorResponseException(e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("/{organization}/components/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ComponentRepresentation getComponent(@PathParam("organization") final String organizationName,
                                                @PathParam("id") String id) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();
        ComponentModel model = componentProvider.getComponent(organization, id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        return modelToRepresentation.toRepresentation(model, false);
    }

    @PUT
    @Path("/{organization}/components/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateComponent(@PathParam("organization") final String organizationName,
                                    @PathParam("id") String id, ComponentRepresentation rep) throws ModelErrorResponseException {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();
        try {
            ComponentModel model = componentProvider.getComponent(organization, id);
            if (model == null) {
                throw new NotFoundException("Could not find component");
            }
            representationToModel.updateComponent(rep, model, false);

            eventStoreManager.send(organization, getAdminEvent(organization)
                    .operation(OperationType.UPDATE)
                    .resourcePath(uriInfo, model.getId())
                    .representation(stripSecretsUtils.strip(rep))
                    .getEvent());
            componentProvider.updateComponent(organization, model);
            return Response.noContent().build();
        } catch (ComponentValidationException e) {
            throw new ModelErrorResponseException("Component validation exception", Response.Status.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            throw new ModelErrorResponseException(e.getMessage(), Response.Status.BAD_REQUEST);
        } catch (ModelException e) {
            throw new ModelErrorResponseException(e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("/{organization}/components/{id}")
    public void removeComponent(@PathParam("organization") final String organizationName,
                                @PathParam("id") String id) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireManage();
        ComponentModel model = componentProvider.getComponent(organization, id);
        if (model == null) {
            throw new NotFoundException("Could not find component");
        }

        eventStoreManager.send(organization, getAdminEvent(organization)
                .operation(OperationType.DELETE)
                .resourcePath(uriInfo, model.getId())
                .getEvent());
        componentProvider.removeComponent(organization, model);
    }

    @GET
    @Path("/{organization}/files/{id}")
    public Response getFile(
            @PathParam("organization") final String organizationName,
            @PathParam("id") String idFile) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        FileModel file = fileProvider.getFileById(organization, idFile);
        if (file == null) {
            throw new NotFoundException("File not found");
        }

        Response.ResponseBuilder response = Response.ok(file.getFile());
        response.type(InternetMediaType.getMymeTypeFromExtension(file.getExtension()));
        response.header("content-disposition", "attachment; filename=\"" + file.getFileName() + "\"");

        return response.build();
    }

    @GET
    @Path("/{organization}/job-reports")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobReportRepresentation> getReports(
            @PathParam("organization") final String organizationName,
            @QueryParam("jobName") List<String> jobNames,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        JobReportQuery query = jobReportProvider.createQuery(organization);

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
                .map(f -> modelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{organization}/job-reports/{jobReportId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JobReportRepresentation findReport(
            @PathParam("organization") final String organizationName,
            @PathParam("jobReportId") final String jobReportId) {

        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        JobReportModel jobReport = jobReportProvider.getJobReportById(organization, jobReportId);
        if (jobReport == null) {
            throw new NotFoundException("Job report not found");
        }

        return modelToRepresentation.toRepresentation(jobReport);
    }

    @GET
    @Path("/{organization}/job-reports/providers")
    @Produces(MediaType.APPLICATION_JSON)
    public ScheduledTaskRepresentation getFile(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization);

        auth.requireView();

        List<OrganizationScheduledTaskRepresentation> tasks = new ArrayList<>();
        for (OrganizationScheduledTask next : organizationScheduledTasks) {
            OrganizationScheduledTaskRepresentation rep = new OrganizationScheduledTaskRepresentation();
            rep.setName(next.getName());
            rep.setDescription(next.getDescription());
            rep.setEnabled(next.isEnabled());
            tasks.add(rep);
        }

        long remainingTime = scheduleOrganizations.remainingTime(organization);

        ScheduledTaskRepresentation result = new ScheduledTaskRepresentation();
        result.setRemainingTime(remainingTime);
        result.setTasks(tasks);
        return result;
    }

    /**
     * Get the events provider configuration
     * <p>
     * Returns JSON object with events provider configuration
     */
    @GET
    @Path("/{organization}/events/config")
    @Produces(MediaType.APPLICATION_JSON)
    public OrganizationEventsConfigRepresentation getOrganizationEventsConfig(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization, Resource.EVENTS);

        auth.requireView();

        OrganizationEventsConfigRepresentation config = modelToRepresentation.toEventsConfigReprensetation(organization);
//        if (config.getEnabledEventTypes() == null || config.getEnabledEventTypes().isEmpty()) {
//            config.setEnabledEventTypes(new LinkedList<>());
//            for (EventType e : EventType.values()) {
//                if (e.isSaveByDefault()) {
//                    config.getEnabledEventTypes().add(e.name());
//                }
//            }
//        }
        return config;
    }

    /**
     * Update the events provider
     * <p>
     * Change the events provider and/or its configuration
     */
    @PUT
    @Path("/{organization}/events/config")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrganizationEventsConfig(@PathParam("organization") final String organizationName, @Valid final OrganizationEventsConfigRepresentation rep) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization, Resource.EVENTS);

        auth.requireManage();

        logger.debug("updating organization events config: " + organization.getName());

        organizationManager.updateOrganizationEventsConfig(rep, organization);
    }

    /**
     * Get admin events
     * <p>
     * Returns all admin events, or filters events based on URL createQuery parameters
     * listed here
     */
    @GET
    @Path("/{organization}/admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getEvents(@PathParam("organization") final String organizationName,
                                                    @QueryParam("operationTypes") List<String> operationTypes,
                                                    @QueryParam("authOrganization") String authOrganization,
                                                    @QueryParam("authUser") String authUser,
                                                    @QueryParam("authIpAddress") String authIpAddress,
                                                    @QueryParam("resourcePath") String resourcePath,
                                                    @QueryParam("dateFrom") String dateFrom,
                                                    @QueryParam("dateTo") String dateTo,
                                                    @QueryParam("first") Integer firstResult,
                                                    @QueryParam("max") Integer maxResults,
                                                    @QueryParam("resourceTypes") List<String> resourceTypes) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization, Resource.EVENTS);

        auth.requireView();

        AdminEventQuery query = eventStoreProvider.createQuery().organization(organization.getId());

        if (authOrganization != null) {
            query.authOrganization(authOrganization);
        }

        if (authUser != null) {
            query.authUser(authUser);
        }

        if (authIpAddress != null) {
            query.authIpAddress(authIpAddress);
        }

        if (resourcePath != null) {
            query.resourcePath(resourcePath);
        }

        if (operationTypes != null && !operationTypes.isEmpty()) {
            OperationType[] t = new OperationType[operationTypes.size()];
            for (int i = 0; i < t.length; i++) {
                t[i] = OperationType.valueOf(operationTypes.get(i));
            }
            query.operation(t);
        }

        if (resourceTypes != null && !resourceTypes.isEmpty()) {
            String[] t = new String[resourceTypes.size()];
            for (int i = 0; i < t.length; i++) {
                t[i] = resourceTypes.get(i);
            }
            query.resourceType(t);
        }

        if (dateFrom != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date from;
            try {
                from = df.parse(dateFrom);
            } catch (ParseException e) {
                throw new BadRequestException(
                        "Invalid value for 'Date(From)', expected format is yyyy-MM-dd");
            }
            query.fromTime(from);
        }

        if (dateTo != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date to;
            try {
                to = df.parse(dateTo);
            } catch (ParseException e) {
                throw new BadRequestException("Invalid value for 'Date(To)', expected format is yyyy-MM-dd");
            }
            query.toTime(to);
        }

        if (firstResult != null) {
            query.firstResult(firstResult);
        }
        if (maxResults != null) {
            query.maxResults(maxResults);
        }

        return toAdminEventRep(query.getResultList());
    }

    private List<AdminEventRepresentation> toAdminEventRep(List<AdminEvent> events) {
        List<AdminEventRepresentation> reps = new ArrayList<>();
        for (AdminEvent event : events) {
            reps.add(modelToRepresentation.toRepresentation(event));
        }

        return reps;
    }

    /**
     * Delete all events
     */
    @DELETE
    @Path("/{organization}/events")
    public void clearEvents(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization, Resource.EVENTS);

        auth.requireManage();

        eventStoreProvider.clear(organization.getId());
    }

    /**
     * Delete all admin events
     */
    @Path("/{organization}/admin-events")
    @DELETE
    public void clearAdminEvents(@PathParam("organization") final String organizationName) {
        OrganizationModel organization = getOrganizationModel(organizationName);
        OrganizationAuth auth = getAuth(organization, Resource.EVENTS);

        auth.requireManage();

        eventStoreProvider.clearAdmin(organization.getId());
    }

    @Path("{organization}/documents")
    public DocumentsAdminResource documents() {
        return documentsAdminResource;
    }

    /**
     * A JAX-RS sub-resource locator that uses the
     * {@link OrganizationAdminResourceProvider} to resolve
     * sub-resources instances given an <code>unknownPath</code>.
     *
     * @param extension a path that could be to a REST extension
     * @return a JAX-RS sub-resource instance for the REST extension if found.
     * Otherwise null is returned.
     */
    @Path("{organization}/{extension}")
    public Object resolveOrganizationAdminExtension(@PathParam("organization") String organizationName,
                                                    @PathParam("extension") String extension) {

        Iterator<OrganizationAdminResourceProvider> iterator = organizationAdminResourceProviders.iterator();
        while (iterator.hasNext()) {
            OrganizationAdminResourceProvider provider = iterator.next();
            if (provider.getPath().equals(extension)) {
                getOrganizationModel(organizationName);
                Object resource = provider.getResource();
                if (resource != null) {
                    return resource;
                }
            }
        }

        throw new NotFoundException();
    }

}
