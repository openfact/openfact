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
import org.openfact.ubl.UBLDebitNoteProvider;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DebitNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected DebitNoteProvider model;
    protected UBLDebitNoteProvider ublProvider;

    public DebitNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.debitNotes();
        this.ublProvider = session.getProvider(UBLDebitNoteProvider.class);
    }

    public DebitNoteModel getDebitNoteByDocumentId(OrganizationModel organization, String ID) {
        return model.getDebitNoteByDocumentId(organization, ID);
    }

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteType debitNoteType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = debitNoteType.getID();
        if (documentId == null) {
            String newDocumentId = ublProvider.idGenerator().generateID(organization, debitNoteType);
            documentId = new IDType(newDocumentId);
            debitNoteType.setID(documentId);
        }
        DebitNoteModel debitNoteModel = model.addDebitNote(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            debitNoteModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importDebitNote(session, organization, debitNoteModel, debitNoteType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> debitNoteModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, debitNoteType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, OpenfactModelUtils.generateId() + ".xml", signedDocumentBytes);
            debitNoteModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireDebitNotePostCreate(debitNoteModel);
        return debitNoteModel;
    }

    private void fireDebitNotePostCreate(DebitNoteModel debitNote) {
        session.getOpenfactSessionFactory().publish(new DebitNoteModel.DebitNotePostCreateEvent() {
            @Override
            public DebitNoteModel getCreatedDebitNote() {
                return debitNote;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        if (model.removeDebitNote(organization, debitNote)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
        return sendToCustomerParty(organization, debitNote, null);
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DebitNoteModel debitNote, SendEventModel sendEvent) throws SendException {
        if (sendEvent == null) {
            return ublProvider.sender().sendToCustomer(organization, debitNote);
        } else {
            return ublProvider.sender().sendToCustomer(organization, debitNote, sendEvent);
        }
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, DebitNoteModel debitNote) throws SendException {
        return sendToTrirdParty(organization, debitNote, null);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, DebitNoteModel debitNote, SendEventModel sendEvent) throws SendException {
        if (sendEvent == null) {
            return ublProvider.sender().sendToThirdParty(organization, debitNote);
        } else {
            return ublProvider.sender().sendToThirdParty(organization, debitNote, sendEvent);
        }
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, DebitNoteModel debitNote, String email) throws SendException {
        return sendToThirdPartyByEmail(organization, debitNote, debitNote.addSendEvent(DestinyType.CUSTOMER), email);
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, DebitNoteModel debitNote, SendEventModel sendEvent, String email) throws SendException {
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
            FileModel xmlFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".xml", debitNote.getXmlAsFile().getFile());
            FileMymeTypeModel xmlFileMymeType = new FileMymeTypeModel(xmlFile, "application/xml");

            byte[] pdfFileBytes = session.getProvider(UBLReportProvider.class).invoice().setOrganization(organization).getReport(debitNote, ExportFormat.PDF);
            FileModel pdfFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".pdf", pdfFileBytes);
            FileMymeTypeModel pdfFileMymeType = new FileMymeTypeModel(pdfFile, "application/pdf");

            session.getProvider(EmailTemplateProvider.class)
                    .setOrganization(organization).setUser(user)
                    .setAttachments(Arrays.asList(xmlFileMymeType, pdfFileMymeType))
                    .sendDebitNote(debitNote);

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
