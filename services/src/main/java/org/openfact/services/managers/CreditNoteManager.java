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
package org.openfact.services.managers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.file.FileModel;
import org.openfact.file.FileMymeTypeModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.TypeToModel;
import org.openfact.models.SendException;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLCreditNoteProvider;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;

public class CreditNoteManager {

    protected static final Logger logger = Logger.getLogger(CreditNoteManager.class);

    protected OpenfactSession session;
    protected CreditNoteProvider model;
    protected UBLCreditNoteProvider ublProvider;

    public CreditNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.creditNotes();
        this.ublProvider = session.getProvider(UBLCreditNoteProvider.class);
    }

    public CreditNoteModel getCreditNoteByDocumentId(OrganizationModel organization, String ID) {
        return model.getCreditNoteByDocumentId(organization, ID);
    }

    public CreditNoteModel addCreditNote(OrganizationModel organization, CreditNoteType creditNoteType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = creditNoteType.getID();
        if (documentId == null) {
            String generatedId = ublProvider.idGenerator().generateID(organization, creditNoteType);
            documentId = new IDType(generatedId);
            creditNoteType.setID(documentId);
        }
        CreditNoteModel creditNoteModel = model.addCreditNote(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            creditNoteModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importCreditNote(session, organization, creditNoteModel, creditNoteType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> creditNoteModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, creditNoteType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, OpenfactModelUtils.generateId() + ".xml", signedDocumentBytes);
            creditNoteModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireCreditNotePostCreate(creditNoteModel);
        return creditNoteModel;
    }

    private void fireCreditNotePostCreate(CreditNoteModel creditNote) {
        session.getOpenfactSessionFactory().publish(new CreditNoteModel.CreditNotePostCreateEvent() {
            @Override
            public CreditNoteModel getCreatedCreditNote() {
                return creditNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
        return removeCreditNote(organization, creditNote, session.creditNotes());
    }

    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote, CreditNoteProvider creditNoteProvider) {
        if (model.removeCreditNote(organization, creditNote)) {
            session.getOpenfactSessionFactory().publish(new CreditNoteModel.CreditNoteRemovedEvent() {

                @Override
                public OrganizationModel getOrganization() {
                    return organization;
                }

                @Override
                public CreditNoteModel getCreditNote() {
                    return creditNote;
                }

                @Override
                public OpenfactSession getOpenfactSession() {
                    return session;
                }

            });
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
        return sendToCustomerParty(organization, creditNote, null);
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent) throws SendException {
        if (sendEvent == null) {
            return ublProvider.sender().sendToCustomer(organization, creditNote);
        } else {
            return ublProvider.sender().sendToCustomer(organization, creditNote, sendEvent);
        }
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, CreditNoteModel creditNote) throws SendException {
        return sendToTrirdParty(organization, creditNote, null);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent) throws SendException {
        if (sendEvent == null) {
            return ublProvider.sender().sendToThirdParty(organization, creditNote);
        } else {
            return ublProvider.sender().sendToThirdParty(organization, creditNote, sendEvent);
        }
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, CreditNoteModel creditNote, String email) throws SendException {
        return sendToThirdPartyByEmail(organization, creditNote, creditNote.addSendEvent(DestinyType.CUSTOMER), email);
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, CreditNoteModel creditNote, SendEventModel sendEvent, String email) throws SendException {
        sendEvent.setType("EMAIL");

        if (organization.getSmtpConfig().size() == 0) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Could not find a valid smtp configuration on organization.");
            return sendEvent;
        }

        // User where the email will be send
        UserSenderModel user = new UserSenderModel(email);

        try {
            FileProvider fileProvider = session.getProvider(FileProvider.class);

            // Attatchments
            FileModel xmlFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".xml", creditNote.getXmlAsFile().getFile());
            FileMymeTypeModel xmlFileMymeType = new FileMymeTypeModel(xmlFile, "application/xml");

            byte[] pdfFileBytes = session.getProvider(UBLReportProvider.class).creditNote().setOrganization(organization).getReport(creditNote, ExportFormat.PDF);
            FileModel pdfFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".pdf", pdfFileBytes);
            FileMymeTypeModel pdfFileMymeType = new FileMymeTypeModel(pdfFile, "application/pdf");

            session.getProvider(EmailTemplateProvider.class)
                    .setOrganization(organization).setUser(user)
                    .setAttachments(Arrays.asList(xmlFileMymeType, pdfFileMymeType))
                    .sendCreditNote(creditNote);

            // Write event to the database
            sendEvent.setDescription("Ivoice successfully sended");
            sendEvent.attachFile(xmlFile);
            sendEvent.attachFile(pdfFile);
            sendEvent.setResult(SendResultType.SUCCESS);

            sendEvent.setSingleDestinyAttribute("email", user.getEmail());

            return sendEvent;
        } catch (ReportException e) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Internal Server Error on generate report");
            throw new SendException("Could not generate pdf report", e);
        } catch (EmailException e) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Internal Server Error on send email");
            throw new SendException("Could not send email", e);
        }
    }

}
