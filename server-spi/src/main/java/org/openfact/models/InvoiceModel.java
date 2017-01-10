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

import org.openfact.file.FileModel;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderEvent;
import org.openfact.models.enums.RequiredAction;

public interface InvoiceModel {

    String DOCUMENT_ID = "documentId";
    String INVOICE_TYPE_CODE = "invoiceTypeCode";
    String ISSUE_DATETIME = "issueDateTime";
    String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";
    String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    String PAYABLE_AMOUNT = "payableAmount";

    String getId();
    String getDocumentId();
    LocalDateTime getCreatedTimestamp();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * Document information*/
    String getInvoiceTypeCode();
    void setInvoiceTypeCode(String value);

    LocalDateTime getIssueDateTime();
    void setIssueDateTime(LocalDateTime value);

    String getDocumentCurrencyCode();
    void setDocumentCurrencyCode(String value);

    String getCustomerRegistrationName();
    void setCustomerRegistrationName(String value);

    String getCustomerAdditionalAccountId();
    void setCustomerAdditionalAccountId(String customerAdditionalAccountId);

    String getCustomerAssignedAccountId();
    void setCustomerAssignedAccountId(String value);

    String getCustomerElectronicMail();
    void setCustomerElectronicMail(String value);

    BigDecimal getAllowanceTotalAmount();
    void setAllowanceTotalAmount(BigDecimal value);

    BigDecimal getChargeTotalAmount();
    void setChargeTotalAmount(BigDecimal value);

    BigDecimal getPayableAmount();
    void setPayableAmount(BigDecimal value);

    /**
     * Xml
     */
    @Deprecated
    byte[] getXmlDocument();

    @Deprecated
    void setXmlDocument(byte[] value);

    FileModel getXmlFile();
    void attachXmlFile(FileModel file);

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
    SendEventModel addSendEvent(DestinyType destinyType);
    SendEventModel getSendEventById(String id);
    boolean removeSendEvent(OrganizationModel organization, String id);
    boolean removeSendEvent(OrganizationModel organization, SendEventModel sendEvent);
    List<SendEventModel> getSendEvents();
    List<SendEventModel> getSendEvents(Integer firstResult, Integer maxResults);

    /**
     * Attatched documents*/
    List<AttatchedDocumentModel> getAttatchedDocuments();
    AttatchedDocumentModel addAttatchedDocument(DocumentType documentType, String documentId);

    /**
     * Events interfaces
     */
    interface InvoiceCreationEvent extends ProviderEvent {
        InvoiceModel getCreatedInvoice();
    }

    interface InvoicePostCreateEvent extends ProviderEvent {
        InvoiceModel getCreatedInvoice();

        OpenfactSession getOpenfactSession();
    }

    interface InvoiceRemovedEvent extends ProviderEvent {
        InvoiceModel getInvoice();

        OpenfactSession getOpenfactSession();
    }

}
