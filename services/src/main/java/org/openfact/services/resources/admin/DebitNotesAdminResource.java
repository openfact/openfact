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

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.*;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.DocumentManager;
import org.openfact.ubl.UBLDebitNoteProvider;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

@Consumes(MediaType.APPLICATION_JSON)
public class DebitNotesAdminResource {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected AdminEventBuilder adminEvent;

    public DebitNotesAdminResource(OrganizationModel organization, OrganizationAuth auth, AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent.resource(ResourceType.DOCUMENT);

        auth.init(OrganizationAuth.Resource.DOCUMENT);
    }

//    @POST
//    @Path("upload")
//    @Consumes("multipart/form-data")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createDebitNoteFromXml(final MultipartFormDataInput input) {
//        auth.requireManage();
//
//        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
//        List<InputPart> inputParts = uploadForm.get("file");
//
//        for (InputPart inputPart : inputParts) {
//            try {
//                InputStream inputStream = inputPart.getBody(InputStream.class, null);
//                byte[] bytes = IOUtils.toByteArray(inputStream);
//
//                DebitNoteType debitNoteType = session.getProvider(UBLDebitNoteProvider.class).reader().read(bytes);
//                if (debitNoteType == null) {
//                    throw new ModelException("Invalid Debit Note Xml");
//                }
//
//                DocumentManager documentManager = new DocumentManager(session);
//
//                // Double-check duplicated documentId
//                if (debitNoteType.getIDValue() != null && documentManager.getDocumentByTypeAndDocumentId(DocumentType.DEBIT_NOTE, debitNoteType.getIDValue(), organization) != null) {
//                    throw new ModelDuplicateException("Debit Note exists with same documentId[" + debitNoteType.getIDValue() + "]");
//                }
//
//                DocumentModel document = documentManager.addDebitNote(debitNoteType, Collections.emptyMap(), organization);
//                adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, document.getId()).representation(debitNoteType).success();
//            } catch (IOException e) {
//                if (session.getTransactionManager().isActive()) {
//                    session.getTransactionManager().setRollbackOnly();
//                }
//                logger.error("Error reading input data", e);
//                return ErrorResponse.error("Error Reading data", Response.Status.BAD_REQUEST);
//            } catch (ModelDuplicateException e) {
//                if (session.getTransactionManager().isActive()) {
//                    session.getTransactionManager().setRollbackOnly();
//                }
//                return ErrorResponse.exists("Debit Note exists with same id or documentId");
//            } catch (ModelException me) {
//                if (session.getTransactionManager().isActive()) {
//                    session.getTransactionManager().setRollbackOnly();
//                }
//                return ErrorResponse.exists("Could not create Debit Note");
//            }
//        }
//
//        return Response.ok().build();
//    }

}
