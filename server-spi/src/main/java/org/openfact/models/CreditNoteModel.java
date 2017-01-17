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
package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.json.JSONObject;
import org.openfact.file.FileModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.provider.ProviderEvent;
import org.w3c.dom.Document;

public interface CreditNoteModel {

    String DOCUMENT_ID = "documentId";
    String ISSUE_DATETIME = "issueDateTime";

    String getId();
    String getDocumentId();
    LocalDateTime getCreatedTimestamp();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * */

    LocalDateTime getIssueDateTime();
    void setIssueDateTime(LocalDateTime value);

    String getDocumentCurrencyCode();
    void setDocumentCurrencyCode(String value);

    String getCustomerRegistrationName();
    void setCustomerRegistrationName(String value);

    String getCustomerAssignedAccountId();
    String getCustomerElectronicMail();

    void setCustomerElectronicMail(String value);
    void setCustomerAssignedAccountId(String value);

    BigDecimal getAllowanceTotalAmount();
    void setAllowanceTotalAmount(BigDecimal value);

    BigDecimal getChargeTotalAmount();
    void setChargeTotalAmount(BigDecimal value);

    BigDecimal getPayableAmount();
    void setPayableAmount(BigDecimal value);

    CreditNoteType getCreditNoteType();

    /**
     * Xml
     */
    FileModel getXmlAsFile();
    void attachXmlFile(FileModel file);

    Document getXmlAsDocument();
    JSONObject getXmlAsJSONObject();

    /**
     * attributes
     */
    void setSingleAttribute(String name, String value);
    void setAttribute(String name, List<String> values);
    void removeAttribute(String name);
    String getFirstAttribute(String name);
    List<String> getAttribute(String name);
    Map<String, List<String>> getAttributes();

    /**
     * Required Actions
     */
    Set<String> getRequiredActions();
    void addRequiredAction(String action);
    void removeRequiredAction(String action);
    void addRequiredAction(RequiredAction action);
    void removeRequiredAction(RequiredAction action);
    
    /**
     * Send events*/
    String SEND_EVENT_DESTINY_TYPE = "destinyType";
    String SEND_EVENT_TYPE = "type";
    String SEND_EVENT_RESULT = "result";

    SendEventModel addSendEvent(DestinyType destinyType);
    SendEventModel getSendEventById(String id);
    boolean removeSendEvent(String id);
    boolean removeSendEvent(SendEventModel sendEvent);
    List<SendEventModel> getSendEvents();
    List<SendEventModel> getSendEvents(Integer firstResult, Integer maxResults);
    List<SendEventModel> searchForSendEvent(Map<String, String> params);
    List<SendEventModel> searchForSendEvent(Map<String, String> params, int firstResult, int maxResults);
    int sendEventCount();
    int sendEventCount(Map<String, String> params);

    /**
     * Attatched documents*/
    List<AttatchedDocumentModel> getAttatchedDocuments();
    AttatchedDocumentModel getAttatchedDocumentById(String id);
    AttatchedDocumentModel addAttatchedDocument(DocumentType documentType, String documentId);
    boolean removeAttatchedDocument(AttatchedDocumentModel attatchedDocument);

    /**
     * Events interfaces
     */
    interface CreditNoteCreationEvent extends ProviderEvent {
        CreditNoteModel getCreatedCreditNote();
    }

    interface CreditNotePostCreateEvent extends ProviderEvent {
        CreditNoteModel getCreatedCreditNote();

        OpenfactSession getOpenfactSession();
    }

    interface CreditNoteRemovedEvent extends ProviderEvent {
        CreditNoteModel getCreditNote();

        OpenfactSession getOpenfactSession();
    }

}
