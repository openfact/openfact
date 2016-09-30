package org.openfact.models.utils;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
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

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.*;

import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_21.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.*;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.*;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

public class ModelToType {

    public static InvoiceType toType(InvoiceModel model) throws DatatypeConfigurationException {
        InvoiceType type = new InvoiceType();

        if (model.getUBLVersionID() != null) {
            type.setUBLVersionID(model.getUBLVersionID());
        }
        if (model.getCustomizationID() != null) {
            type.setCustomizationID(model.getCustomizationID());
        }

        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                type.addSignature(toType(item));
            }
        }

        if (model.getIssueDate() != null) {
            type.setIssueDate(toType(model.getIssueDate()));
        }

        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toType(model.getUBLExtensions()));
        }

        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
        }
        if (model.getInvoiceTypeCode() != null) {
            type.setInvoiceTypeCode(model.getInvoiceTypeCode());
        }
        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }
        if (model.getInvoiceLine() != null) {
            for (InvoiceLineModel item : model.getInvoiceLine()) {
                type.addInvoiceLine(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(
                    toType(model.getLegalMonetaryTotal(), model.getDocumentCurrencyCode()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        return type;
    }

    public static CreditNoteType toType(CreditNoteModel model) throws DatatypeConfigurationException {
        CreditNoteType type = new CreditNoteType();

        if (model.getUBLVersionID() != null) {
            type.setUBLVersionID(model.getUBLVersionID());
        }
        if (model.getCustomizationID() != null) {
            type.setCustomizationID(model.getCustomizationID());
        }
        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                type.addSignature(toType(item));
            }
        }

        if (model.getIssueDate() != null) {
            type.setIssueDate(toType(model.getIssueDate()));
        }
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toType(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(toType(item));
            }
        }
        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }

        if (model.getCreditNoteLine() != null) {
            for (CreditNoteLineModel item : model.getCreditNoteLine()) {
                type.addCreditNoteLine(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(
                    toType(model.getLegalMonetaryTotal(), model.getDocumentCurrencyCode()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                type.addBillingReference(toType(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(toType(item));
            }
        }
        return type;
    }

    public static DebitNoteType toType(DebitNoteModel model) throws DatatypeConfigurationException {
        DebitNoteType type = new DebitNoteType();

        if (model.getUBLVersionID() != null) {
            type.setUBLVersionID(model.getUBLVersionID());
        }
        if (model.getCustomizationID() != null) {
            type.setCustomizationID(model.getCustomizationID());
        }
        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                type.addSignature(toType(item));
            }
        }

        if (model.getIssueDate() != null) {
            type.setIssueDate(toType(model.getIssueDate()));
        }
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toType(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(toType(item));
            }
        }
        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }

        if (model.getDebitNoteLine() != null) {
            for (DebitNoteLineModel item : model.getDebitNoteLine()) {
                type.addDebitNoteLine(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, model.getDocumentCurrencyCode()));
            }
        }
        if (model.getRequestedMonetaryTotal() != null) {
            type.setRequestedMonetaryTotal(
                    toType(model.getRequestedMonetaryTotal(), model.getDocumentCurrencyCode()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                type.addBillingReference(toType(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(toType(item));
            }
        }
        return type;
    }

    public static InvoiceLineType toType(InvoiceLineModel model, String currencyID) {
        InvoiceLineType type = new InvoiceLineType();

        if (model.getInvoicedQuantity() != null) {
            type.setInvoicedQuantity(toType(model.getInvoicedQuantity(), InvoicedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice(), currencyID));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference(), currencyID));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, currencyID));
            }
        }
        if (model.getLineExtensionAmount() != null) {
            LineExtensionAmountType extensionAmount = new LineExtensionAmountType();
            extensionAmount.setCurrencyID(currencyID);
            extensionAmount.setValue(model.getLineExtensionAmount());
            type.setLineExtensionAmount(extensionAmount);
        }
        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getAllowanceCharge() != null) {
            for (AllowanceChargeModel item : model.getAllowanceCharge()) {
                type.addAllowanceCharge(toType(item));
            }
        }
        return type;
    }

    public static CreditNoteLineType toType(CreditNoteLineModel model, String currencyID) {
        CreditNoteLineType type = new CreditNoteLineType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getCreditedQuantity() != null) {
            type.setCreditedQuantity(toType(model.getCreditedQuantity(), CreditedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice(), currencyID));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference(), currencyID));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, currencyID));
            }
        }
        return type;
    }

    public static DebitNoteLineType toType(DebitNoteLineModel model, String currencyID) {
        DebitNoteLineType type = new DebitNoteLineType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getDebitedQuantity() != null) {
            type.setDebitedQuantity(toType(model.getDebitedQuantity(), DebitedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice(), currencyID));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference(), currencyID));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item, currencyID));
            }
        }
        return type;
    }

    private static SignatureType toType(SignatureModel model) {
        SignatureType type = new SignatureType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getSignatoryParty() != null) {
            type.setSignatoryParty(toType(model.getSignatoryParty()));
        }
        if (model.getDigitalSignatureAttachment() != null) {
            type.setDigitalSignatureAttachment(toType(model.getDigitalSignatureAttachment()));
        }
        return type;
    }

    private static AttachmentType toType(AttachmentModel model) {
        AttachmentType type = new AttachmentType();

        if (model.getExternalReference() != null) {
            type.setExternalReference(toType(model.getExternalReference()));
        }
        return type;
    }

    private static ExternalReferenceType toType(ExternalReferenceModel model) {
        ExternalReferenceType type = new ExternalReferenceType();

        if (model.getURI() != null) {
            type.setURI(model.getURI());
        }
        return type;
    }

    public static BillingReferenceType toType(BillingReferenceModel model) {
        BillingReferenceType type = new BillingReferenceType();

        if (model.getInvoiceDocumentReference() != null) {
            type.setInvoiceDocumentReference(toType(model.getInvoiceDocumentReference()));
        }
        return type;
    }

    public static DocumentReferenceType toType(DocumentReferenceModel model) {
        DocumentReferenceType type = new DocumentReferenceType();

        if (model.getDocumentCode() != null) {
            type.setDocumentTypeCode(model.getDocumentCode());
        }
        return type;
    }

    public static ResponseType toType(ResponseModel model) {
        ResponseType type = new ResponseType();

        if (model.getReferenceID() != null) {
            type.setReferenceID(model.getReferenceID());
        }
        if (model.getResponseCode() != null) {
            type.setResponseCode(model.getResponseCode());
        }
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                type.addDescription(new DescriptionType(item));
            }
        }
        return type;
    }

    public static MonetaryTotalType toType(MonetaryTotalModel model, String currencyID) {
        MonetaryTotalType type = new MonetaryTotalType();

        if (model.getChargeTotalAmount() != null) {
            ChargeTotalAmountType charge = new ChargeTotalAmountType();
            charge.setValue(model.getChargeTotalAmount());
            charge.setCurrencyID(currencyID);
            type.setChargeTotalAmount(charge);
        }
        if (model.getPayableAmount() != null) {
            PayableAmountType payable = new PayableAmountType();
            payable.setValue(model.getPayableAmount());
            payable.setCurrencyID(currencyID);
            type.setPayableAmount(payable);
        }
        if (model.getAllowanceTotalAmount() != null) {
            AllowanceTotalAmountType allowanceTotal = new AllowanceTotalAmountType();
            allowanceTotal.setValue(model.getAllowanceTotalAmount());
            allowanceTotal.setCurrencyID(currencyID);
            type.setAllowanceTotalAmount(allowanceTotal);
        }
        return type;
    }

    public static AllowanceChargeType toType(AllowanceChargeModel model) {
        AllowanceChargeType type = new AllowanceChargeType();

        if (model.getAmount() != null) {
            type.setAmount(model.getAmount());
        }
        type.setChargeIndicator(model.getChargeIndicator());
        return type;
    }

    public static PricingReferenceType toType(PricingReferenceModel model, String currencyID) {
        PricingReferenceType type = new PricingReferenceType();
        if (model.getAlternativeConditionPrice() != null) {
            for (PriceModel item : model.getAlternativeConditionPrice()) {
                type.addAlternativeConditionPrice(toType(item, currencyID));
            }
        }
        return type;
    }

    public static PriceType toType(PriceModel model, String currencyID) {
        PriceType type = new PriceType();

        if (model.getPriceAmount() != null) {
            PriceAmountType priceAmount = new PriceAmountType();
            priceAmount.setCurrencyID(currencyID);
            priceAmount.setValue(model.getPriceAmount());
            type.setPriceAmount(priceAmount);
        }
        if (model.getPriceTypeCode() != null) {
            type.setPriceTypeCode(model.getPriceTypeCode());
        }
        return type;
    }

    public static ItemType toType(ItemModel model) {
        ItemType type = new ItemType();

        for (String item : model.getDescription()) {
            type.addDescription(new DescriptionType(item));
        }
        if (model.getSellersItemIdentification() != null) {
            type.setSellersItemIdentification(toType(model.getSellersItemIdentification()));
        }
        return type;
    }

    public static ItemIdentificationType toType(ItemIdentificationModel model) {
        ItemIdentificationType type = new ItemIdentificationType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        return type;
    }

    public static TaxTotalType toType(TaxTotalModel model, String currencyID) {
        TaxTotalType type = new TaxTotalType();

        if (model.getTaxAmount() != null) {
            TaxAmountType taxAmount = new TaxAmountType();
            taxAmount.setValue(model.getTaxAmount());
            taxAmount.setCurrencyID(currencyID);
            type.setTaxAmount(taxAmount);
        }

        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                type.addTaxSubtotal(toType(item, currencyID));
            }
        }
        return type;
    }

    public static TaxSubtotalType toType(TaxSubtotalModel model, String currencyID) {
        TaxSubtotalType type = new TaxSubtotalType();

        if (model.getTaxAmount() != null) {
            TaxAmountType taxAmount = new TaxAmountType();
            taxAmount.setValue(model.getTaxAmount());
            taxAmount.setCurrencyID(currencyID);
            type.setTaxAmount(taxAmount);
        }

        type.setTaxCategory(toType(model.getTaxCategory()));
        return type;
    }

    public static TaxCategoryType toType(TaxCategoryModel model) {
        TaxCategoryType type = new TaxCategoryType();

        if (model.getTaxExemptionReasonCode() != null) {
            type.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
        }
        if (model.getTaxScheme() != null) {
            type.setTaxScheme(toType(model.getTaxScheme()));
        }
        if (model.getTierRange() != null) {
            type.setTierRange(model.getTierRange());
        }
        return type;
    }

    public static TaxSchemeType toType(TaxSchemeModel model) {
        TaxSchemeType type = new TaxSchemeType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getName() != null) {
            type.setName(model.getName());
        }
        if (model.getTaxCode() != null) {
            type.setTaxTypeCode(model.getTaxCode());
        }
        return type;
    }

    public static CustomerPartyType toType(CustomerPartyModel model) {
        CustomerPartyType type = new CustomerPartyType();

        if (model.getCustomerAssignedAccountID() != null) {
            type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        }
        for (String item : model.getAdditionalAccountID()) {
            type.addAdditionalAccountID(new AdditionalAccountIDType(item));
        }
        if (model.getParty() != null) {
            type.setParty(toType(model.getParty()));
        }
        return type;
    }

    public static SupplierPartyType toType(SupplierPartyModel model) {
        SupplierPartyType type = new SupplierPartyType();

        if (model.getParty() != null) {
            type.setParty(toType(model.getParty()));
        }
        if (model.getCustomerAssignedAccountID() != null) {
            type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        }
        for (String item : model.getAdditionalAccountID()) {
            type.addAdditionalAccountID(new AdditionalAccountIDType(item));
        }
        return type;
    }

    public static PartyType toType(PartyModel model) {
        PartyType type = new PartyType();

        for (PartyLegalModel item : model.getPartyLegalEntity()) {
            type.addPartyLegalEntity(toType(item));
        }
        for (String item : model.getPartyName()) {
            PartyNameType partyType = new PartyNameType();
            partyType.setName(item);
            type.addPartyName(partyType);
        }
        if (model.getPostalAddress() != null) {
            type.setPostalAddress(toType(model.getPostalAddress()));
        }
        return type;
    }

    public static PartyLegalEntityType toType(PartyLegalModel model) {
        PartyLegalEntityType type = new PartyLegalEntityType();

        if (model.getRegistrationName() != null) {
            type.setRegistrationName(model.getRegistrationName());
        }
        return type;
    }

    public static AddressType toType(AddressModel model) {
        AddressType type = new AddressType();

        if (model.getID() != null) {
            type.setID(model.getID());
        }
        if (model.getStreetName() != null) {
            type.setStreetName(model.getStreetName());
        }
        if (model.getCitySubdivisionName() != null) {
            type.setCitySubdivisionName(model.getCitySubdivisionName());
        }
        if (model.getCityName() != null) {
            type.setCityName(model.getCityName());
        }
        if (model.getCountrySubentity() != null) {
            type.setCountrySubentity(model.getCountrySubentity());
        }
        if (model.getDistrict() != null) {
            type.setDistrict(model.getDistrict());
        }
        if (model.getDepartment() != null) {
            type.setDepartment(model.getDepartment());
        }
        if (model.getCountry() != null) {
            type.setCountry(toType(model.getCountry()));
        }
        return type;
    }

    public static CountryType toType(CountryModel model) {
        CountryType type = new CountryType();

        if (model.getIdentificationCode() != null) {
            type.setIdentificationCode(model.getIdentificationCode());
        }
        return type;
    }

    public static <T> T toType(QuantityModel model, Class<T> t) {
        QuantityType type = null;
        if (t.equals(InvoicedQuantityType.class)) {
            type = new InvoicedQuantityType();
        } else if (t.equals(CreditedQuantityType.class)) {
            type = new CreditedQuantityType();
        } else if (t.equals(DebitedQuantityType.class)) {
            type = new DebitedQuantityType();
        } else {
            return null;
        }
        type.setUnitCode(model.getUnitCode());
        type.setValue(model.getValue());
        return (T) type;
    }

    public static UBLExtensionsType toType(UBLExtensionsModel model) {
        UBLExtensionsType type = new UBLExtensionsType();
        for (UBLExtensionModel item : model.getUBLExtension()) {
            type.addUBLExtension(toType(item));
        }
        return null;
    }

    public static UBLExtensionType toType(UBLExtensionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    public static XMLGregorianCalendar toType(LocalDate date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }
}
