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

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;

import java.util.List;
import java.util.stream.Collectors;

public class TypeToModel {

    public static final String ISSUE_DATE = "issueDate";

    public static final String INVOICE_TYPE_CODE = "invoiceTypeCode";
    public static final String CREDIT_NOTE_TYPE_CODE = "creditNoteTypeCode";

    public static final String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";

    public static final String SUPPLIER_ASSIGNED_ACCOUNT_ID = "supplierAssignedAccountID";
    public static final String SUPPLIER_PARTY_ASSIGNED_ACCOUNT_ID = "supplierPartyAssignedAccountID";
    public static final String SUPPLIER_PARTY_ADDITIONAL_ACCOUNT_ID = "supplierPartyAdditionalAccountID";
    public static final String SUPPLIER_PARTY_REGISTRATION_NAME = "supplierPartyRegistrationName";

    public static final String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountID";
    public static final String CUSTOMER_PARTY_ASSIGNED_ACCOUNT_ID = "customerPartyAssignedAccountID";
    public static final String CUSTOMER_PARTY_ADDITIONAL_ACCOUNT_ID = "customerPartyAdditionalAccountID";
    public static final String CUSTOMER_PARTY_REGISTRATION_NAME = "customerPartyRegistrationName";
    public static final String CUSTOMER_PARTY_CONTACT_ELECTRONIC_MAIL = "customerPartyContactMail";

    public static final String TAX_TOTAL_AMOUNT = "taxTotalAmount";

    public static final String LEGAL_MONETARY_TOTAL_PAYABLE_AMOUNT = "legalMonetaryTotalPayableAmount";
    public static final String LEGAL_MONETARY_TOTAL_CHARGE_TOTAL_AMOUNT = "legalMonetaryTotalChargeTotalAmount";
    public static final String LEGAL_MONETARY_TOTAL_ALLOWANCE_TOTAL = "legalMonetaryTotalAllowanceTotal";

    public static final String REQUESTED_MONETARY_TOTAL_PAYABLE_AMOUNT = "requestedMonetaryTotalPayableAmount";
    public static final String REQUESTED_MONETARY_TOTAL_CHARGE_TOTAL_AMOUNT = "requestedMonetaryTotalChargeTotalAmount";
    public static final String REQUESTED_MONETARY_TOTAL_ALLOWANCE_TOTAL = "requestedMonetaryTotalAllowanceTotal";

    public static void importInvoice(OrganizationModel organization, DocumentModel model, InvoiceType type) {
        model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());

        if (type.getIssueDate() != null) {
            model.setSingleAttribute(ISSUE_DATE, type.getIssueDateValue().toString());
        }
        if (type.getInvoiceTypeCode() != null) {
            model.setSingleAttribute(INVOICE_TYPE_CODE, type.getInvoiceTypeCodeValue());
        }
        if (type.getDocumentCurrencyCode() != null) {
            model.setSingleAttribute(DOCUMENT_CURRENCY_CODE, type.getDocumentCurrencyCodeValue());
        }

        if (type.getAccountingSupplierParty() != null) {
            addAccountingSupplierAttributes(type.getAccountingSupplierParty(), model);
        }
        if (type.getAccountingCustomerParty() != null) {
            addAccountingCustomerAttributes(type.getAccountingCustomerParty(), model);
        }
        if (type.getTaxTotal() != null && !type.getTaxTotal().isEmpty()) {
            addTaxTotalAttributes(type.getTaxTotal(), model);
        }
        if (type.getLegalMonetaryTotal() != null) {
            addLegalMonetaryTotalAttributes(type.getLegalMonetaryTotal(), model);
        }
    }

    public static void importCreditNote(OrganizationModel organization, DocumentModel model, CreditNoteType type) {
        model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());

        if (type.getIssueDate() != null) {
            model.setSingleAttribute(ISSUE_DATE, type.getIssueDateValue().toString());
        }
        if (type.getCreditNoteTypeCode() != null) {
            model.setSingleAttribute(CREDIT_NOTE_TYPE_CODE, type.getCreditNoteTypeCodeValue());
        }
        if (type.getDocumentCurrencyCode() != null) {
            model.setSingleAttribute(DOCUMENT_CURRENCY_CODE, type.getDocumentCurrencyCodeValue());
        }

        if (type.getAccountingSupplierParty() != null) {
            addAccountingSupplierAttributes(type.getAccountingSupplierParty(), model);
        }
        if (type.getAccountingCustomerParty() != null) {
            addAccountingCustomerAttributes(type.getAccountingCustomerParty(), model);
        }
        if (type.getTaxTotal() != null && !type.getTaxTotal().isEmpty()) {
            addTaxTotalAttributes(type.getTaxTotal(), model);
        }
        if (type.getLegalMonetaryTotal() != null) {
            addLegalMonetaryTotalAttributes(type.getLegalMonetaryTotal(), model);
        }
    }

    public static void importDebitNote(OrganizationModel organization, DocumentModel model, DebitNoteType type) {
        model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());

        if (type.getIssueDate() != null) {
            model.setSingleAttribute(ISSUE_DATE, type.getIssueDateValue().toString());
        }
        if (type.getDocumentCurrencyCode() != null) {
            model.setSingleAttribute(DOCUMENT_CURRENCY_CODE, type.getDocumentCurrencyCodeValue());
        }

        if (type.getAccountingSupplierParty() != null) {
            addAccountingSupplierAttributes(type.getAccountingSupplierParty(), model);
        }
        if (type.getAccountingCustomerParty() != null) {
            addAccountingCustomerAttributes(type.getAccountingCustomerParty(), model);
        }
        if (type.getTaxTotal() != null && !type.getTaxTotal().isEmpty()) {
            addTaxTotalAttributes(type.getTaxTotal(), model);
        }
        if (type.getRequestedMonetaryTotal() != null) {
            addRequestedMonetaryTotalAttributes(type.getRequestedMonetaryTotal(), model);
        }
    }

    public static void addAccountingSupplierAttributes(SupplierPartyType supplierPartyType, DocumentModel documentModel) {

        if (supplierPartyType.getCustomerAssignedAccountID() != null) {
            documentModel.setSingleAttribute(SUPPLIER_ASSIGNED_ACCOUNT_ID, supplierPartyType.getCustomerAssignedAccountIDValue());
        }
        if (supplierPartyType.getCustomerAssignedAccountID() != null) {
            documentModel.setSingleAttribute(SUPPLIER_PARTY_ASSIGNED_ACCOUNT_ID, supplierPartyType.getCustomerAssignedAccountIDValue());
        }
        if (supplierPartyType.getAdditionalAccountID() != null && !supplierPartyType.getAdditionalAccountID().isEmpty()) {
            List<String> supplierAdditionalAccountID = supplierPartyType.getAdditionalAccountID().stream().map(f -> f.getValue()).collect(Collectors.toList());
            documentModel.setAttribute(SUPPLIER_PARTY_ADDITIONAL_ACCOUNT_ID, supplierAdditionalAccountID);
        }
        if (supplierPartyType.getParty() != null) {
            PartyType partyType = supplierPartyType.getParty();
            if (partyType.getPartyLegalEntity() != null && !partyType.getPartyLegalEntity().isEmpty()) {
                List<String> supplierAdditionalAccountID = partyType.getPartyLegalEntity().stream().map(f -> f.getRegistrationNameValue()).collect(Collectors.toList());
                documentModel.setAttribute(SUPPLIER_PARTY_REGISTRATION_NAME, supplierAdditionalAccountID);
            }
        }
    }

    public static void addAccountingCustomerAttributes(CustomerPartyType customerPartyType, DocumentModel documentModel) {
        if (customerPartyType.getCustomerAssignedAccountID() != null) {
            documentModel.setSingleAttribute(CUSTOMER_ASSIGNED_ACCOUNT_ID, customerPartyType.getCustomerAssignedAccountIDValue());
        }
        if (customerPartyType.getCustomerAssignedAccountID() != null) {
            documentModel.setSingleAttribute(CUSTOMER_PARTY_ASSIGNED_ACCOUNT_ID, customerPartyType.getCustomerAssignedAccountIDValue());
            documentModel.setCustomerAssignedAccountId(customerPartyType.getCustomerAssignedAccountIDValue());
        }
        if (customerPartyType.getAdditionalAccountID() != null && !customerPartyType.getAdditionalAccountID().isEmpty()) {
            List<String> customerAdditionalAccountID = customerPartyType.getAdditionalAccountID().stream().map(f -> f.getValue()).collect(Collectors.toList());
            documentModel.setAttribute(CUSTOMER_PARTY_ADDITIONAL_ACCOUNT_ID, customerAdditionalAccountID);
        }
        if (customerPartyType.getParty() != null) {
            PartyType partyType = customerPartyType.getParty();
            if (partyType.getPartyLegalEntity() != null && !partyType.getPartyLegalEntity().isEmpty()) {
                List<String> supplierAdditionalAccountID = partyType.getPartyLegalEntity().stream().map(f -> f.getRegistrationNameValue()).collect(Collectors.toList());
                documentModel.setAttribute(CUSTOMER_PARTY_REGISTRATION_NAME, supplierAdditionalAccountID);
                documentModel.setCustomerRegistrationName(supplierAdditionalAccountID.stream().reduce(",", String::concat));
            }
            if (partyType.getContact() != null) {
                ContactType contactType = partyType.getContact();
                if (contactType.getElectronicMail() != null) {
                    documentModel.setSingleAttribute(CUSTOMER_PARTY_CONTACT_ELECTRONIC_MAIL, contactType.getElectronicMailValue());
                    documentModel.setCustomerElectronicMail(contactType.getElectronicMailValue());
                }
            }
        }
    }

    public static void addTaxTotalAttributes(List<TaxTotalType> taxTotalType, DocumentModel documentModel) {
        List<String> taxTotal = taxTotalType.stream().map(f -> f.getTaxAmountValue().toString()).collect(Collectors.toList());
        documentModel.setAttribute(TAX_TOTAL_AMOUNT, taxTotal);
    }

    public static void addLegalMonetaryTotalAttributes(MonetaryTotalType monetaryTotalType, DocumentModel documentModel) {
        if (monetaryTotalType.getPayableAmount() != null) {
            documentModel.setSingleAttribute(LEGAL_MONETARY_TOTAL_PAYABLE_AMOUNT, monetaryTotalType.getPayableAmountValue().toString());
        }
        if (monetaryTotalType.getChargeTotalAmount() != null) {
            documentModel.setSingleAttribute(LEGAL_MONETARY_TOTAL_CHARGE_TOTAL_AMOUNT, monetaryTotalType.getChargeTotalAmountValue().toString());
        }
        if (monetaryTotalType.getAllowanceTotalAmount() != null) {
            documentModel.setSingleAttribute(LEGAL_MONETARY_TOTAL_ALLOWANCE_TOTAL, monetaryTotalType.getAllowanceTotalAmountValue().toString());
        }
    }

    public static void addRequestedMonetaryTotalAttributes(MonetaryTotalType monetaryTotalType, DocumentModel documentModel) {
        if (monetaryTotalType.getPayableAmount() != null) {
            documentModel.setSingleAttribute(REQUESTED_MONETARY_TOTAL_PAYABLE_AMOUNT, monetaryTotalType.getPayableAmountValue().toString());
        }
        if (monetaryTotalType.getChargeTotalAmount() != null) {
            documentModel.setSingleAttribute(REQUESTED_MONETARY_TOTAL_CHARGE_TOTAL_AMOUNT, monetaryTotalType.getChargeTotalAmountValue().toString());
        }
        if (monetaryTotalType.getAllowanceTotalAmount() != null) {
            documentModel.setSingleAttribute(REQUESTED_MONETARY_TOTAL_ALLOWANCE_TOTAL, monetaryTotalType.getAllowanceTotalAmountValue().toString());
        }
    }

}