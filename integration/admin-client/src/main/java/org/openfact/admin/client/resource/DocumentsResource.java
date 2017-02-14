/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.admin.client.resource;

import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface DocumentsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<DocumentRepresentation> search(@QueryParam("documentType") String documentType,
                                        @QueryParam("documentId") String documentId,
                                        @QueryParam("first") Integer firstResult,
                                        @QueryParam("max") Integer maxResults);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<DocumentRepresentation> search(@QueryParam("filterText") String filterText,
                                        @QueryParam("first") Integer firstResult,
                                        @QueryParam("max") Integer maxResults);

    @Path("search")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<DocumentRepresentation> search(SearchCriteriaRepresentation criteria);

    @Path("{documentId}")
    DocumentResource get(@PathParam("documentId") String documentId);

}
