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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.models.enums.RequiredAction;
import org.openfact.provider.ProviderEvent;
import org.openfact.ubl.SendEventModel;

public interface CreditNoteModel {

    String DOCUMENT_ID = "documentId";
    String ISSUE_DATETIME = "issueDateTime";

    String getId();

    String getDocumentId();

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

    SupplierPartyModel getAccountingSupplierParty();

    SupplierPartyModel getAccountingSupplierPartyAsNotNull();

    CustomerPartyModel getAccountingCustomerParty();

    CustomerPartyModel getAccountingCustomerPartyAsNotNull();

    List<AllowanceChargeModel> getAllowanceCharge();

    AllowanceChargeModel addAllowanceCharge();

    List<TaxTotalModel> getTaxTotal();

    TaxTotalModel addTaxTotal();

    MonetaryTotalModel getLegalMonetaryTotal();

    MonetaryTotalModel getLegalMonetaryTotalAsNotNull();

    List<ResponseModel> getDiscrepancyResponse();

    ResponseModel addDiscrepancyResponse();

    /**
     * Xml
     */
    byte[] getXmlDocument();

    void setXmlDocument(byte[] value);

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
    List<SendEventModel> getSendEvents();

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
