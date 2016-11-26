/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.provider.ProviderEvent;
import org.openfact.models.enums.RequiredAction;

public interface InvoiceModel {

    String ID = "ID";
    String INVOICE_TYPE_CODE = "invoiceTypeCode";
    String ISSUE_DATETIME = "issueDateTime";

    String getId();

    String getDocumentId();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * */
    String getInvoiceTypeCode();

    void setInvoiceTypeCode(String value);

    LocalDateTime getIssueDateTime();

    void setIssueDateTime(LocalDateTime value);

    String getDocumentCurrencyCode();

    void setDocumentCurrencyCode(String value);

    SupplierPartyModel getAccountingSupplierParty();

    SupplierPartyModel getAccountingSupplierPartyAsNotNull();

    CustomerPartyModel getAccountingCustomerParty();

    CustomerPartyModel getAccountingCustomerPartyAsNotNull();

    MonetaryTotalModel getLegalMonetaryTotal();

    MonetaryTotalModel getLegalMonetaryTotalAsNotNull();

    List<TaxTotalModel> getTaxTotal();

    TaxTotalModel addTaxTotal();

    /**
     * Xml
     */
    byte[] getXmlDocument();

    void setXmlDocument(byte[] value);

    /**
     * attributes
     */
    void setAttribute(String name, String value);

    void removeAttribute(String name);

    String getAttribute(String name);

    Map<String, String> getAttributes();

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
    List<SendEventModel> getSendEvents();
    
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
