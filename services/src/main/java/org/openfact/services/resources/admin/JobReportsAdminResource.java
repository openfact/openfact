/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.common.ClientConnection;
import org.openfact.models.Constants;
import org.openfact.models.JobReportQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.JobReportRepresentation;
import org.openfact.services.resources.OpenfactSession;

public class JobReportsAdminResource {
    
    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public JobReportsAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.REPORTS);
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobReportRepresentation> getReports(
            @QueryParam("jobName") List<String> jobNames,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo,
            @QueryParam("first") Integer firstResult,
            @QueryParam("max") Integer maxResults) {

        /*auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : Constants.DEFAULT_MAX_RESULTS;

        JobReportQuery query = session.jobReports().createQuery().organization(organization.getId());

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
                .collect(Collectors.toList());*/
        return null;
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
        return null;
    }

}
