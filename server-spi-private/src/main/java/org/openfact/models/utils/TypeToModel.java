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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.xml.datatype.XMLGregorianCalendar;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import org.openfact.models.*;

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

    public static InvoiceModel importInvoice(OpenfactSession session, OrganizationModel organization, InvoiceModel model, InvoiceType type) {
        if (type.getInvoiceTypeCode() != null) {
            model.setInvoiceTypeCode(type.getInvoiceTypeCodeValue());
        }
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }
        if (type.getAccountingCustomerParty() != null) {
            CustomerPartyType customerPartyType = type.getAccountingCustomerParty();
            if(customerPartyType.getAdditionalAccountID() != null) {
                String customerAdditionalAccountId = customerPartyType.getAdditionalAccountID()
                        .stream()
                        .map(f -> f.getValue())
                        .filter(p -> p != null && !p.isEmpty())
                        .reduce((s, s2) -> s + "," + s2)
                        .get();
                model.setCustomerAdditionalAccountId(customerAdditionalAccountId);
            }
            if (customerPartyType.getCustomerAssignedAccountIDValue() != null) {
                model.setCustomerAssignedAccountId(customerPartyType.getCustomerAssignedAccountIDValue());
            }
            if (customerPartyType.getParty() != null) {
                PartyType partyType = customerPartyType.getParty();
                if (partyType.getPartyLegalEntity() != null) {
                    String registrationName = partyType.getPartyLegalEntity().stream().map(f -> f.getRegistrationNameValue()).reduce("", String::concat);
                    model.setCustomerRegistrationName(!registrationName.isEmpty() ? registrationName : null);
                }
                if (partyType.getContact() != null) {
                    ContactType contactType = partyType.getContact();
                    if(contactType.getElectronicMail() != null) {
                        model.setCustomerElectronicMail(contactType.getElectronicMailValue());
                    }
                }
            }
        }

        if (type.getLegalMonetaryTotal() != null) {
            MonetaryTotalType monetaryTotalType = type.getLegalMonetaryTotal();
            if(monetaryTotalType.getAllowanceTotalAmount() != null) {
                model.setAllowanceTotalAmount(monetaryTotalType.getAllowanceTotalAmountValue());
            }
            if(monetaryTotalType.getChargeTotalAmount() != null) {
                model.setChargeTotalAmount(monetaryTotalType.getChargeTotalAmountValue());
            }
            if(monetaryTotalType.getPayableAmount() != null) {
                model.setPayableAmount(monetaryTotalType.getPayableAmountValue());
            }
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

        return model;
    }

    public static CreditNoteModel importCreditNote(OpenfactSession session, OrganizationModel organization, CreditNoteModel model, CreditNoteType type) {
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }

        if (type.getAccountingCustomerParty() != null) {
            CustomerPartyType customerPartyType = type.getAccountingCustomerParty();
            if (customerPartyType.getCustomerAssignedAccountIDValue() != null) {
                model.setCustomerAssignedAccountId(customerPartyType.getCustomerAssignedAccountIDValue());
            }
            if (customerPartyType.getParty() != null) {
                PartyType partyType = customerPartyType.getParty();
                if (partyType.getPartyLegalEntity() != null) {
                    String registrationName = partyType.getPartyLegalEntity().stream().map(f -> f.getRegistrationNameValue()).reduce("", String::concat);
                    model.setCustomerRegistrationName(!registrationName.isEmpty() ? registrationName : null);
                }
            }
        }
        if (type.getLegalMonetaryTotal() != null) {
            MonetaryTotalType monetaryTotalType = type.getLegalMonetaryTotal();
            if(monetaryTotalType.getAllowanceTotalAmount() != null) {
                model.setAllowanceTotalAmount(monetaryTotalType.getAllowanceTotalAmountValue());
            }
            if(monetaryTotalType.getChargeTotalAmount() != null) {
                model.setChargeTotalAmount(monetaryTotalType.getChargeTotalAmountValue());
            }
            if(monetaryTotalType.getPayableAmount() != null) {
                model.setPayableAmount(monetaryTotalType.getPayableAmountValue());
            }
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

        return model;
    }

    public static DebitNoteModel importDebitNote(OpenfactSession session, OrganizationModel organization, DebitNoteModel model, DebitNoteType type) {
        if (type.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }

        if (type.getAccountingCustomerParty() != null) {
            CustomerPartyType customerPartyType = type.getAccountingCustomerParty();
            if (customerPartyType.getCustomerAssignedAccountIDValue() != null) {
                model.setCustomerAssignedAccountId(customerPartyType.getCustomerAssignedAccountIDValue());
            }
            if (customerPartyType.getParty() != null) {
                PartyType partyType = customerPartyType.getParty();
                if (partyType.getPartyLegalEntity() != null) {
                    String registrationName = partyType.getPartyLegalEntity().stream().map(f -> f.getRegistrationNameValue()).reduce("", String::concat);
                    model.setCustomerRegistrationName(!registrationName.isEmpty() ? registrationName : null);
                }
            }
        }

        if (type.getRequestedMonetaryTotal() != null) {
            MonetaryTotalType monetaryTotalType = type.getRequestedMonetaryTotal();
            if(monetaryTotalType.getAllowanceTotalAmount() != null) {
                model.setAllowanceTotalAmount(monetaryTotalType.getAllowanceTotalAmountValue());
            }
            if(monetaryTotalType.getChargeTotalAmount() != null) {
                model.setChargeTotalAmount(monetaryTotalType.getChargeTotalAmountValue());
            }
            if(monetaryTotalType.getPayableAmount() != null) {
                model.setPayableAmount(monetaryTotalType.getPayableAmountValue());
            }
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
        if(type.getContact() != null) {
            updateModel(model.getContactAsNotNull(), type.getContact());
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

    public static void updateModel(ContactModel model, ContactType type) {
        if (type.getElectronicMail() != null) {
            model.setElectronicMail(type.getElectronicMailValue());
        }
    }

}