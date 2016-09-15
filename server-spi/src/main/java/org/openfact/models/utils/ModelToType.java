package org.openfact.models.utils;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.InvoicedQuantityModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalEntityModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PartyNameModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PricingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

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

    private static MonetaryTotalType toType(MonetaryTotalModel model) {
        MonetaryTotalType type = new MonetaryTotalType();
        type.setChargeTotalAmount(model.getChargeTotalAmount());
        type.setPayableAmount(model.getPayableAmount());
        type.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return type;
    }

    private static InvoiceLineType toType(InvoiceLineModel model) {
        InvoiceLineType type = new InvoiceLineType();
        if (model.getInvoicedQuantity() != null) {
            type.setInvoicedQuantity(toType(model.getInvoicedQuantity()));
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

    private static AllowanceChargeType toType(AllowanceChargeModel model) {
        AllowanceChargeType type = new AllowanceChargeType();
        type.setAmount(model.getAmount());
        type.setChargeIndicator(model.getChargeIndicator());
        return type;
    }

    private static PricingReferenceType toType(PricingReferenceModel model) {
        PricingReferenceType type = new PricingReferenceType();
        if (model.getAlternativeConditionPrice() != null) {
            for (PriceModel item : model.getAlternativeConditionPrice()) {
                type.addAlternativeConditionPrice(toType(item));
            }
        }
        return type;
    }

    private static PriceType toType(PriceModel model) {
        PriceType type = new PriceType();
        // if (model.getPriceAmount() != null) {
        // type.setPriceAmount(toType(model.getPriceAmount()));
        // }
        type.setPriceAmount(model.getPriceAmount());

        return type;
    }

    // private static PriceAmountType toType(PriceAmountModel model) {
    // PriceAmountType type = new PriceAmountType();
    // type.setCurrencyID(model.getCurrencyID());
    // type.setValue(model.getValue());
    // return type;
    // }

    private static ItemType toType(ItemModel model) {
        ItemType type = new ItemType();
        for (String item : model.getDescription()) {
            type.addDescription(new DescriptionType(item));
        }
        if (model.getSellersItemIdentification() != null) {
            type.setSellersItemIdentification(toType(model.getSellersItemIdentification()));
        }
        return type;
    }

    private static ItemIdentificationType toType(ItemIdentificationModel model) {
        ItemIdentificationType type = new ItemIdentificationType();
        type.setID(model.getID());
        return type;
    }

    private static InvoicedQuantityType toType(InvoicedQuantityModel model) {
        InvoicedQuantityType type = new InvoicedQuantityType();
        type.setUnitCode(model.getUnitCode());
        type.setValue(model.getValue());
        return type;
    }

    private static TaxTotalType toType(TaxTotalModel model) {
        TaxTotalType type = new TaxTotalType();
        type.setTaxAmount(model.getTaxAmount());
        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                type.addTaxSubtotal(toType(item));
            }
        }
        return type;
    }

    private static TaxSubtotalType toType(TaxSubtotalModel model) {
        TaxSubtotalType type = new TaxSubtotalType();
        type.setTaxAmount(model.getTaxAmount());
        type.setTaxCategory(toType(model.getTaxCategory()));
        return type;
    }

    private static TaxCategoryType toType(TaxCategoryModel model) {
        TaxCategoryType type = new TaxCategoryType();
        type.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
        if (model.getTaxScheme() != null) {
            type.setTaxScheme(toType(model.getTaxScheme()));
        }
        type.setTierRange(model.getTierRange());
        return type;
    }

    private static TaxSchemeType toType(TaxSchemeModel model) {
        TaxSchemeType type = new TaxSchemeType();
        type.setID(model.getID());
        type.setName(model.getName());
        type.setTaxTypeCode(model.getTaxModelCode());
        return type;
    }

    private static CustomerPartyType toType(CustomerPartyModel model) {
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

    private static UBLExtensionsType toType(UBLExtensionsModel model) {
        UBLExtensionsType type = new UBLExtensionsType();
        for (UBLExtensionModel item : model.getUBLExtension()) {
            type.addUBLExtension(toType(item));
        }
        return null;
    }

    private static UBLExtensionType toType(UBLExtensionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    private static SupplierPartyType toType(SupplierPartyModel model) {
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

    private static PartyType toType(PartyModel model) {
        PartyType type = new PartyType();
        for (PartyLegalEntityModel item : model.getPartyLegalEntity()) {
            type.addPartyLegalEntity(toType(item));
        }
        for (PartyNameModel item : model.getPartyName()) {
            type.addPartyName(toType(item));
        }
        if (model.getPostalAddress() != null) {
            type.setPostalAddress(toType(model.getPostalAddress()));
        }
        return type;
    }

    private static AddressType toType(AddressModel model) {
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

    private static CountryType toType(CountryModel model) {
        CountryType type = new CountryType();
        type.setIdentificationCode(model.getIdentificationCode());
        return type;
    }

    private static PartyNameType toType(PartyNameModel model) {
        PartyNameType type = new PartyNameType();
        type.setName(model.getName());
        return type;
    }

    private static PartyLegalEntityType toType(PartyLegalEntityModel model) {
        PartyLegalEntityType type = new PartyLegalEntityType();
        type.setRegistrationName(model.getRegistrationName());
        return type;
    }

    private static XMLGregorianCalendar toType(LocalDate date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }
}
