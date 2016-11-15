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
package org.openfact.models.utils;

import java.time.LocalDateTime;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.ArrayUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.BinaryObjectModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.w3c.dom.Element;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.DebitNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PricingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ResponseType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SignatureType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DebitedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_21.BinaryObjectType;

public class TypeToModel {

    public static LocalDateTime toDateTime(XMLGregorianCalendar date) {
        return date.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }

    public static InvoiceModel importInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceModel model, InvoiceType type) {
        if (type.getUBLVersionID() != null) {
            model.setUBLVersionID(type.getUBLVersionIDValue());
        }
        if (type.getCustomizationIDValue() != null) {
            model.setCustomizationID(type.getCustomizationIDValue());
        }
        if (type.getSignature() != null) {
            for (SignatureType item : type.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDateValue() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
        }
        if (type.getIssueDateValue() != null && type.getIssueTimeValue() != null) {
            LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
            issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), type.getAccountingSupplierParty());
        }
        if (type.getInvoiceTypeCodeValue() != null) {
            model.setInvoiceTypeCode(type.getInvoiceTypeCodeValue());
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), type.getAccountingCustomerParty());
        }
        if (type.getInvoiceLine() != null) {
            for (InvoiceLineType item : type.getInvoiceLine()) {
                updateModel(model.addInvoiceLine(), item);
            }
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), type.getLegalMonetaryTotal());
        }
        model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());

        if (type.getUBLExtensions() != null) {
            updateModel(model.getUBLExtensions(), type.getUBLExtensions());
        }

        return model;
    }

    public static CreditNoteModel importCreditNote(OpenfactSession session, OrganizationModel organization,
            CreditNoteModel model, CreditNoteType type) {
        if (type.getUBLVersionIDValue() != null) {
            model.setUBLVersionID(type.getUBLVersionIDValue());
        }
        if (type.getCustomizationIDValue() != null) {
            model.setCustomizationID(type.getCustomizationIDValue());
        }
        if (type.getSignature() != null) {
            for (SignatureType item : type.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDateValue() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
        }
        if (type.getIssueDateValue() != null && type.getIssueTimeValue() != null) {
            LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
            issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), type.getAccountingSupplierParty());
        }
        if (type.getDiscrepancyResponse() != null) {
            for (ResponseType item : type.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getCreditNoteLine() != null) {
            for (CreditNoteLineType item : type.getCreditNoteLine()) {
                updateModel(model.addCreditNoteLine(), item);
            }
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }

        if (type.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), type.getLegalMonetaryTotal());
        }

        if (type.getDocumentCurrencyCodeValue() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }
        if (type.getDespatchDocumentReference() != null) {
            for (DocumentReferenceType item : type.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
        return model;
    }

    public static DebitNoteModel importDebitNote(OpenfactSession session, OrganizationModel organization,
            DebitNoteModel model, DebitNoteType type) {
        if (type.getUBLVersionIDValue() != null) {
            model.setUBLVersionID(type.getUBLVersionIDValue());
        }
        if (type.getCustomizationIDValue() != null) {
            model.setCustomizationID(type.getCustomizationIDValue());
        }
        if (type.getSignature() != null) {
            for (SignatureType item : type.getSignature()) {
                updateModel(model.addSignature(), item);
            }
        }

        LocalDateTime issueDateTime = null;
        if (type.getIssueDateValue() != null) {
            issueDateTime = toDateTime(type.getIssueDateValue());
        }
        if (type.getIssueDateValue() != null && type.getIssueTimeValue() != null) {
            LocalDateTime issueTime = toDateTime(type.getIssueTimeValue());
            issueDateTime = LocalDateTime.of(issueDateTime.toLocalDate(), issueTime.toLocalTime());
        }
        model.setIssueDateTime(issueDateTime);

        if (type.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), type.getAccountingSupplierParty());
        }
        if (type.getDiscrepancyResponse() != null) {
            for (ResponseType item : type.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), type.getAccountingCustomerParty());
        }
        if (type.getDebitNoteLine() != null) {
            for (DebitNoteLineType item : type.getDebitNoteLine()) {
                updateModel(model.addDebitNoteLine(), item);
            }
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getRequestedMonetaryTotal() != null) {
            updateModel(model.getRequestedMonetaryTotal(), type.getRequestedMonetaryTotal());
        }
        if (type.getDocumentCurrencyCodeValue() != null) {
            model.setDocumentCurrencyCode(type.getDocumentCurrencyCodeValue());
        }
        if (type.getBillingReference() != null) {
            for (BillingReferenceType item : type.getBillingReference()) {
                updateModel(model.addBillingReference(), item);
            }
        }
        if (type.getDespatchDocumentReference() != null) {
            for (DocumentReferenceType item : type.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
        return model;
    }

    public static void updateModel(UBLExtensionsModel model, UBLExtensionsType type) {
        if (type.getUBLExtension() != null) {
            for (UBLExtensionType item : type.getUBLExtension()) {
                updateModel(model.addUblExtension(), item);
            }
        }
    }

    public static void updateModel(UBLExtensionModel model, UBLExtensionType type) {
        if (type.getExtensionAgencyIDValue() != null) {
            model.setExtensionAgencyID(type.getExtensionAgencyIDValue());
        }
        if (type.getExtensionAgencyNameValue() != null) {
            model.setExtensionAgencyName(type.getExtensionAgencyNameValue());
        }
        if (type.getExtensionAgencyURIValue() != null) {
            model.setExtensionAgencyURI(type.getExtensionAgencyURIValue());
        }
        if (type.getExtensionReasonValue() != null) {
            model.setExtensionReason(type.getExtensionReasonValue());
        }
        if (type.getExtensionReasonCodeValue() != null) {
            model.setExtensionReasonCode(type.getExtensionReasonCodeValue());
        }
        if (type.getExtensionURIValue() != null) {
            model.setExtensionURI(type.getExtensionURIValue());
        }
        if (type.getExtensionVersionIDValue() != null) {
            model.setExtensionVersionID(type.getExtensionVersionIDValue());
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getNameValue() != null) {
            model.setName(type.getNameValue());
        }
        if (type.getExtensionContent() != null) {
            updateModel(model.getExtensionContent(), type.getExtensionContent());
        }
    }

    public static void updateModel(ExtensionContentModel model, ExtensionContentType type) {
        /*
         * if (type.getAnyItem() != null) { model.setAnyItem(type.getAnyItem());
         * }
         */
        if (type.getAny() != null) {
            model.setAny((Element) type.getAny());
        }
    }

    public static void updateModel(InvoiceLineModel model, InvoiceLineType type) {
        if (type.getInvoicedQuantity() != null) {
            updateModel(model.getInvoicedQuantity(), type.getInvoicedQuantity());
        }
        if (type.getItem() != null) {
            updateModel(model.getItem(), type.getItem());
        }
        if (type.getPrice() != null) {
            updateModel(model.getPrice(), type.getPrice());
        }
        if (type.getPricingReference() != null) {
            updateModel(model.getPricingReference(), type.getPricingReference());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getLineExtensionAmountValue() != null) {
            model.setLineExtensionAmount(type.getLineExtensionAmountValue());
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getAllowanceCharge() != null) {
            for (AllowanceChargeType item : type.getAllowanceCharge()) {
                updateModel(model.addAllowanceCharge(), item);
            }
        }
    }

    public static void updateModel(CreditNoteLineModel model, CreditNoteLineType type) {
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getCreditedQuantity() != null) {
            updateModel(model.getCreditedQuantity(), type.getCreditedQuantity());
        }
        if (type.getItem() != null) {
            updateModel(model.getItem(), type.getItem());
        }
        if (type.getPrice() != null) {
            updateModel(model.getPrice(), type.getPrice());
        }
        if (type.getPricingReference() != null) {
            updateModel(model.getPricingReference(), type.getPricingReference());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getLineExtensionAmountValue() != null) {
            model.setLineExtensionAmount(type.getLineExtensionAmountValue());
        }
    }

    public static void updateModel(DebitNoteLineModel model, DebitNoteLineType type) {
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getDebitedQuantity() != null) {
            updateModel(model.getDebitedQuantity(), type.getDebitedQuantity());
        }
        if (type.getItem() != null) {
            updateModel(model.getItem(), type.getItem());
        }
        if (type.getPrice() != null) {
            updateModel(model.getPrice(), type.getPrice());
        }
        if (type.getPricingReference() != null) {
            updateModel(model.getPricingReference(), type.getPricingReference());
        }
        if (type.getTaxTotal() != null) {
            for (TaxTotalType item : type.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (type.getLineExtensionAmountValue() != null) {
            model.setLineExtensionAmount(type.getLineExtensionAmountValue());
        }
    }

    public static void updateModel(BillingReferenceModel model, BillingReferenceType type) {
        if (type.getInvoiceDocumentReference() != null) {
            updateModel(model.getInvoiceDocumentReference(), type.getInvoiceDocumentReference());
        }
    }

    public static void updateModel(DocumentReferenceModel model, DocumentReferenceType type) {
        if (type.getDocumentTypeCodeValue() != null) {
            model.setDocumentCode(type.getDocumentTypeCodeValue());
        }
    }

    public static void updateModel(ResponseModel model, ResponseType type) {
        if (type.getReferenceIDValue() != null) {
            model.setReferenceID(type.getReferenceIDValue());
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
        if (type.getChargeIndicator() != null) {
            model.setChargeIndicator(type.getChargeIndicator().isValue());
        }
    }

    public static void updateModel(PricingReferenceModel model, PricingReferenceType type) {
        if (type.getAlternativeConditionPrice() != null) {
            for (PriceType item : type.getAlternativeConditionPrice()) {
                updateModel(model.addAlternativeConditionPrice(), item);
            }
        }
    }

    public static void updateModel(PriceModel model, PriceType type) {
        if (type.getPriceAmountValue() != null) {
            model.setPriceAmount(type.getPriceAmountValue());
        }
        if (type.getPriceTypeCodeValue() != null) {
            model.setPriceTypeCode(type.getPriceTypeCodeValue());
        }
    }

    public static void updateModel(ItemModel model, ItemType type) {
        if (type.getDescription() != null) {
            for (DescriptionType item : type.getDescription()) {
                model.getDescription().add(item.getValue());
            }
        }
        if (type.getSellersItemIdentification() != null) {
            updateModel(model.getSellersItemIdentification(), type.getSellersItemIdentification());
        }
    }

    public static void updateModel(ItemIdentificationModel model, ItemIdentificationType type) {
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
    }

    public static void updateModel(TaxTotalModel model, TaxTotalType type) {
        if (type.getTaxAmountValue() != null) {
            model.setTaxAmount(type.getTaxAmountValue());
        }
        if (type.getTaxSubtotal() != null) {
            for (TaxSubtotalType item : type.getTaxSubtotal()) {
                updateModel(model.addTaxSubtotal(), item);
            }
        }
    }

    public static void updateModel(TaxSubtotalModel model, TaxSubtotalType type) {
        if (type.getTaxAmountValue() != null) {
            model.setTaxAmount(type.getTaxAmountValue());
        }
        if (type.getTaxCategory() != null) {
            updateModel(model.getTaxCategory(), type.getTaxCategory());
        }
    }

    public static void updateModel(TaxCategoryModel model, TaxCategoryType type) {
        if (type.getTaxExemptionReasonCodeValue() != null) {
            model.setTaxExemptionReasonCode(type.getTaxExemptionReasonCodeValue());
        }
        if (type.getTaxScheme() != null) {
            updateModel(model.getTaxScheme(), type.getTaxScheme());
        }
        if (type.getTierRangeValue() != null) {
            model.setTierRange(type.getTierRangeValue());
        }
    }

    public static void updateModel(TaxSchemeModel model, TaxSchemeType type) {
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getNameValue() != null) {
            model.setName(type.getNameValue());
        }
        if (type.getTaxTypeCodeValue() != null) {
            model.setTaxTypeCode(type.getTaxTypeCodeValue());
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
            updateModel(model.getParty(), type.getParty());
        }
    }

    public static void updateModel(SupplierPartyModel model, SupplierPartyType type) {
        if (type.getParty() != null) {
            updateModel(model.getParty(), type.getParty());
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
        if (type.getPartyIdentification() != null) {
            for (PartyIdentificationType item : type.getPartyIdentification()) {
                model.getPartyIdentification().add(item.getIDValue());
            }
        }
        if (type.getPartyName() != null) {
            for (PartyNameType item : type.getPartyName()) {
                model.getPartyName().add(item.getNameValue());
            }
        }
        if (type.getPostalAddress() != null) {
            updateModel(model.getPostalAddress(), type.getPostalAddress());
        }
    }

    public static void updateModel(PartyLegalModel model, PartyLegalEntityType type) {
        if (type.getRegistrationNameValue() != null) {
            model.setRegistrationName(type.getRegistrationNameValue());
        }
    }

    public static void updateModel(AddressModel model, AddressType type) {
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        if (type.getStreetNameValue() != null) {
            model.setStreetName(type.getStreetNameValue());
        }
        if (type.getCitySubdivisionNameValue() != null) {
            model.setCitySubdivisionName(type.getCitySubdivisionNameValue());
        }
        if (type.getCityNameValue() != null) {
            model.setCityName(type.getCityNameValue());
        }
        if (type.getCountrySubentityValue() != null) {
            model.setCountrySubentity(type.getCountrySubentityValue());
        }
        if (type.getDistrictValue() != null) {
            model.setDistrict(type.getDistrictValue());
        }
        if (type.getDepartmentValue() != null) {
            model.setDepartment(type.getDepartmentValue());
        }
        if (type.getCountry() != null) {
            updateModel(model.getCountry(), type.getCountry());
        }
    }

    public static void updateModel(CountryModel model, CountryType type) {
        if (type.getIdentificationCodeValue() != null) {
            model.setIdentificationCode(type.getIdentificationCodeValue());
        }
    }

    public static void updateModel(QuantityModel model, InvoicedQuantityType type) {
        if (type.getUnitCode() != null) {
            model.setUnitCode(type.getUnitCode());
        }
        if (type.getValue() != null) {
            model.setValue(type.getValue());
        }
    }

    public static void updateModel(QuantityModel model, CreditedQuantityType type) {
        if (type.getUnitCode() != null) {
            model.setUnitCode(type.getUnitCode());
        }
        if (type.getValue() != null) {
            model.setValue(type.getValue());
        }
    }

    public static void updateModel(QuantityModel model, DebitedQuantityType type) {
        if (type.getUnitCode() != null) {
            model.setUnitCode(type.getUnitCode());
        }
        if (type.getValue() != null) {
            model.setValue(type.getValue());
        }
    }

    public static void updateModel(SignatureModel model, SignatureType type) {
        if (type.getCanonicalizationMethodValue() != null) {
            model.setCanonicalizationMethod(type.getCanonicalizationMethodValue());
        }
        if (type.getIDValue() != null) {
            model.setID(type.getIDValue());
        }
        /*
         * if (type.getNote() != null) { model.setNote(type.getNote()); }
         */
        if (type.getSignatureMethodValue() != null) {
            model.setSignatureMethod(type.getSignatureMethodValue());
        }
        if (type.getValidationDateValue() != null) {
            model.setValidationDate(toDateTime(type.getValidationDateValue()).toLocalDate());
        }
        if (type.getValidationTimeValue() != null) {
            model.setValidationTime(toDateTime(type.getValidationTimeValue()).toLocalTime());
        }
        if (type.getValidatorIDValue() != null) {
            model.setValidatorID(type.getValidatorIDValue());
        }
        if (type.getSignatoryParty() != null) {
            updateModel(model.getSignatoryParty(), type.getSignatoryParty());
        }
        if (type.getDigitalSignatureAttachment() != null) {
            updateModel(model.getDigitalSignatureAttachment(), type.getDigitalSignatureAttachment());
        }
    }

    public static void updateModel(AttachmentModel model, AttachmentType type) {
        if (type.getExternalReference() != null) {
            updateModel(model.getExternalReference(), type.getExternalReference());
        }
        if (type.getEmbeddedDocumentBinaryObject() != null) {
            updateModel(model.getEmbeddedDocumentBinaryObject(), type.getEmbeddedDocumentBinaryObject());
        }
    }

    public static void updateModel(ExternalReferenceModel model, ExternalReferenceType type) {
        if (type.getDocumentHashValue() != null) {
            model.setDocumentHash(type.getDocumentHashValue());
        }
        if (type.getExpiryDateValue() != null) {
            model.setExpiryDate(toDateTime(type.getExpiryDateValue()).toLocalDate());
        }
        if (type.getExpiryTimeValue() != null) {
            model.setExpiryTime(toDateTime(type.getExpiryTimeValue()).toLocalTime());
        }
        if (type.getURIValue() != null) {
            model.setURI(type.getURIValue());
        }
    }

    public static void updateModel(BinaryObjectModel model, BinaryObjectType type) {
        if (type.getCharacterSetCode() != null) {
            model.setCharacterSetCode(type.getCharacterSetCode());
        }
        if (type.getEncodingCode() != null) {
            model.setEncodingCode(type.getEncodingCode());
        }
        if (type.getFilename() != null) {
            model.setFilename(type.getFilename());
        }
        if (type.getFormat() != null) {
            model.setFormat(type.getFormat());
        }
        if (type.getMimeCode() != null) {
            model.setMimeCode(type.getMimeCode());
        }
        if (type.getUri() != null) {
            model.setUri(type.getUri());
        }
        if (type.getValue() != null) {
            model.setValue(ArrayUtils.toObject(type.getValue()));
        }
    }

}