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
package org.openfact.models.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.PartyModel;
import org.openfact.models.ResponseModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ResponseType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class TypeToModel {

    public static LocalDate toDate(XMLGregorianCalendar date) {
        return date.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    public static LocalTime toTime(XMLGregorianCalendar date) {
        return date.toGregorianCalendar().toZonedDateTime().toLocalTime();
    }

    public static LocalDateTime toDateTime(XMLGregorianCalendar date) {
        return date.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }

    public static InvoiceModel importInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceModel model, InvoiceType type) {
        if (type.getInvoiceTypeCode() != null) {
            model.setInvoiceTypeCode(type.getInvoiceTypeCodeValue());
        }
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDate() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
            if (type.getIssueTime() != null) {
                LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
                issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
            }
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierPartyAsNotNull(), type.getAccountingSupplierParty());
        }
        if (type.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerPartyAsNotNull(), type.getAccountingCustomerParty());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotalAsNotNull(), type.getLegalMonetaryTotal());
        }

        return model;
    }

    public static CreditNoteModel importCreditNote(OpenfactSession session, OrganizationModel organization,
            CreditNoteModel model, CreditNoteType type) {
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDate() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
            if (type.getIssueTime() != null) {
                LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
                issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
            }
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierPartyAsNotNull(), type.getAccountingSupplierParty());
        }
        if (type.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerPartyAsNotNull(), type.getAccountingCustomerParty());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getAllowanceCharge() != null) {
            for (AllowanceChargeType item : type.getAllowanceCharge()) {
                updateModel(model.addAllowanceCharge(), item);
            }
        }
        if (type.getDiscrepancyResponse() != null) {
            for (ResponseType item : type.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (type.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotalAsNotNull(), type.getLegalMonetaryTotal());
        }
        return model;
    }

    public static DebitNoteModel importDebitNote(OpenfactSession session, OrganizationModel organization,
            DebitNoteModel model, DebitNoteType type) {
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDate() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
            if (type.getIssueTime() != null) {
                LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
                issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
            }
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierPartyAsNotNull(), type.getAccountingSupplierParty());
        }

        if (type.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerPartyAsNotNull(), type.getAccountingCustomerParty());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getAllowanceCharge() != null) {
            for (AllowanceChargeType item : type.getAllowanceCharge()) {
                updateModel(model.addAllowanceCharge(), item);
            }
        }
        if (type.getRequestedMonetaryTotal() != null) {
            updateModel(model.getRequestedMonetaryTotalAsNotNull(), type.getRequestedMonetaryTotal());
        }
        return model;
    }

    public static void updateModel(ResponseModel model, ResponseType type) {
        if (type.getReferenceIDValue() != null) {
            model.setReferenceID(type.getReferenceIDValue());
        }
        if (type.getResponseCode() != null) {
            model.setResponseCode(type.getResponseCodeValue());
        }
        if (type.getDescription() != null) {
            for (DescriptionType item : type.getDescription()) {
                model.getDescription().add(item.getValue());
            }
        }
    }

    public static void updateModel(MonetaryTotalModel model, MonetaryTotalType type) {
        if (type.getChargeTotalAmountValue() != null) {
            model.setChargeTotalAmount(type.getChargeTotalAmountValue());
        }
        if (type.getPayableAmountValue() != null) {
            model.setPayableAmount(type.getPayableAmountValue());
        }
        if (type.getAllowanceTotalAmountValue() != null) {
            model.setAllowanceTotalAmount(type.getAllowanceTotalAmountValue());
        }
    }

    public static void updateModel(AllowanceChargeModel model, AllowanceChargeType type) {
        if (type.getAmountValue() != null) {
            model.setAmount(type.getAmountValue());
        }
    }

    public static void updateModel(TaxTotalModel model, TaxTotalType type) {
        if (type.getTaxAmountValue() != null) {
            model.setTaxAmount(type.getTaxAmountValue());
        }
    }

    public static void updateModel(CustomerPartyModel model, CustomerPartyType type) {
        if (type.getCustomerAssignedAccountIDValue() != null) {
            model.setCustomerAssignedAccountID(type.getCustomerAssignedAccountIDValue());
        }
        if (type.getAdditionalAccountID() != null) {
            for (AdditionalAccountIDType item : type.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item.getValue());
            }
        }
        if (type.getParty() != null) {
            updateModel(model.getPartyAsNotNull(), type.getParty());
        }
    }

    public static void updateModel(SupplierPartyModel model, SupplierPartyType type) {
        if (type.getParty() != null) {
            updateModel(model.getPartyAsNotNull(), type.getParty());
        }
        if (type.getCustomerAssignedAccountIDValue() != null) {
            model.setCustomerAssignedAccountID(type.getCustomerAssignedAccountIDValue());
        }
        if (type.getAdditionalAccountID() != null) {
            for (AdditionalAccountIDType item : type.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item.getValue());
            }
        }
    }

    public static void updateModel(PartyModel model, PartyType type) {
        if (type.getPartyLegalEntity() != null) {
            for (PartyLegalEntityType item : type.getPartyLegalEntity()) {
                updateModel(model.addPartyLegalEntity(), item);
            }
        }
    }

    public static void updateModel(PartyLegalEntityModel model, PartyLegalEntityType type) {
        if (type.getCompanyID() != null) {
            model.setCompanyID(type.getCompanyIDValue());
        }
        if (type.getRegistrationNameValue() != null) {
            model.setRegistrationName(type.getRegistrationNameValue());
        }
    }

}