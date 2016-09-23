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
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
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
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;


import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.*;

import com.helger.xsds.ccts.cct.schemamodule.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.*;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.*;
import oasis.names.specification.ubl.schema.xsd.invoice_21.*;

public class ModelToType {

    public static InvoiceType toType(InvoiceModel model) throws DatatypeConfigurationException {
        InvoiceType type = new InvoiceType();
        type.setIssueDate(toType(model.getIssueDate()));
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toType(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
        }
        type.setInvoiceTypeCode(model.getInvoiceModelCode());
        type.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }
        if (model.getInvoiceLine() != null) {
            for (InvoiceLineModel item : model.getInvoiceLine()) {
                type.addInvoiceLine(toType(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(toType(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        return type;
    }

    public static CreditNoteType toType(CreditNoteModel model) throws DatatypeConfigurationException {
        CreditNoteType type = new CreditNoteType();
        type.setIssueDate(toType(model.getIssueDate()));
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
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }

        if (model.getCreditNoteLine() != null) {
            for (CreditNoteLineModel item : model.getCreditNoteLine()) {
                type.addCreditNoteLine(toType(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(toType(model.getLegalMonetaryTotal()));
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
        type.setIssueDate(toType(model.getIssueDate()));
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
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        }

        if (model.getDebitNoteLine() != null) {
            for (DebitNoteLineModel item : model.getDebitNoteLine()) {
                type.addDebitNoteLine(toType(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        if (model.getRequestedMonetaryTotal() != null) {
            type.setRequestedMonetaryTotal(toType(model.getRequestedMonetaryTotal()));
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

    public static InvoiceLineType toType(InvoiceLineModel model) {
        InvoiceLineType type = new InvoiceLineType();
        if (model.getInvoicedQuantity() != null) {
            type.setInvoicedQuantity(toType(model.getInvoicedQuantity(), InvoicedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        type.setLineExtensionAmount(model.getLineExtensionAmount());
        type.setID(model.getID());
        if (model.getAllowanceCharge() != null) {
            for (AllowanceChargeModel item : model.getAllowanceCharge()) {
                type.addAllowanceCharge(toType(item));
            }
        }
        return type;
    }

    public static CreditNoteLineType toType(CreditNoteLineModel model) {
        CreditNoteLineType type = new CreditNoteLineType();
        type.setID(model.getID());
        if (model.getCreditedQuantity() != null) {
            type.setCreditedQuantity(toType(model.getCreditedQuantity(), CreditedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        return type;
    }

    public static DebitNoteLineType toType(DebitNoteLineModel model) {
        DebitNoteLineType type = new DebitNoteLineType();
        type.setID(model.getID());
        if (model.getDebitedQuantity() != null) {
            type.setDebitedQuantity(toType(model.getDebitedQuantity(), DebitedQuantityType.class));
        }
        if (model.getItem() != null) {
            type.setItem(toType(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toType(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toType(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
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
        type.setDocumentTypeCode(model.getDocumentCode());
        return type;
    }

    public static ResponseType toType(ResponseModel model) {
        ResponseType type = new ResponseType();
        type.setReferenceID(model.getReferenceID());
        type.setResponseCode(model.getResponseCode());
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                type.addDescription(new DescriptionType(item));
            }
        }
        return type;
    }

    public static MonetaryTotalType toType(MonetaryTotalModel model) {
        MonetaryTotalType type = new MonetaryTotalType();
        type.setChargeTotalAmount(model.getChargeTotalAmount());
        type.setPayableAmount(model.getPayableAmount());
        type.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return type;
    }

    public static AllowanceChargeType toType(AllowanceChargeModel model) {
        AllowanceChargeType type = new AllowanceChargeType();
        type.setAmount(model.getAmount());
        type.setChargeIndicator(model.getChargeIndicator());
        return type;
    }

    public static PricingReferenceType toType(PricingReferenceModel model) {
        PricingReferenceType type = new PricingReferenceType();
        if (model.getAlternativeConditionPrice() != null) {
            for (PriceModel item : model.getAlternativeConditionPrice()) {
                type.addAlternativeConditionPrice(toType(item));
            }
        }
        return type;
    }

    public static PriceType toType(PriceModel model) {
        PriceType type = new PriceType();
        // if (model.getPriceAmount() != null) {
        // type.setPriceAmount(toType(model.getPriceAmount()));
        // }
        type.setPriceAmount(model.getPriceAmount());

        return type;
    }

    // public static PriceAmountType toType(PriceAmountModel model) {
    // PriceAmountType type = new PriceAmountType();
    // type.setCurrencyID(model.getCurrencyID());
    // type.setValue(model.getValue());
    // return type;
    // }

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
        type.setID(model.getID());
        return type;
    }

    public static TaxTotalType toType(TaxTotalModel model) {
        TaxTotalType type = new TaxTotalType();
        type.setTaxAmount(model.getTaxAmount());
        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                type.addTaxSubtotal(toType(item));
            }
        }
        return type;
    }

    public static TaxSubtotalType toType(TaxSubtotalModel model) {
        TaxSubtotalType type = new TaxSubtotalType();
        type.setTaxAmount(model.getTaxAmount());
        type.setTaxCategory(toType(model.getTaxCategory()));
        return type;
    }

    public static TaxCategoryType toType(TaxCategoryModel model) {
        TaxCategoryType type = new TaxCategoryType();
        type.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
        if (model.getTaxScheme() != null) {
            type.setTaxScheme(toType(model.getTaxScheme()));
        }
        type.setTierRange(model.getTierRange());
        return type;
    }

    public static TaxSchemeType toType(TaxSchemeModel model) {
        TaxSchemeType type = new TaxSchemeType();
        type.setID(model.getID());
        type.setName(model.getName());
        type.setTaxTypeCode(model.getTaxCode());
        return type;
    }

    public static CustomerPartyType toType(CustomerPartyModel model) {
        CustomerPartyType type = new CustomerPartyType();
        type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
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
        type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
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
        type.setRegistrationName(model.getRegistrationName());
        return type;
    }

    public static AddressType toType(AddressModel model) {
        AddressType type = new AddressType();
        type.setID(model.getID());
        type.setStreetName(model.getStreetName());
        type.setCitySubdivisionName(model.getCitySubdivisionName());
        type.setCityName(model.getCityName());
        type.setCountrySubentity(model.getCountrySubentity());
        type.setDistrict(model.getDistrict());
        type.setDepartment(model.getDepartment());
        if (model.getCountry() != null) {
            type.setCountry(toType(model.getCountry()));
        }
        return type;
    }

    public static CountryType toType(CountryModel model) {
        CountryType type = new CountryType();
        type.setIdentificationCode(model.getIdentificationCode());
        return type;
    }

    public static <T> T toType(QuantityModel model, Class<T> t) {
        QuantityType type = null;
        if (t.equals(CreditedQuantityType.class)) {
            type = new CreditedQuantityType();
        } else if (t.equals(InvoicedQuantityType.class)) {
            type = new DebitedQuantityType();
        } else if (t.equals(CreditedQuantityType.class)) {
            type = new CreditedQuantityType();
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
