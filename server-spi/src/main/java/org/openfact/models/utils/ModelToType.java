package org.openfact.models.utils;

import java.time.LocalDate;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.*;
import org.openfact.models.ubl.common.*;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
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
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toType(item));
            }
        }
        return type;
    }

    private static TaxTotalType toType(TaxTotalModel model) {
        TaxTotalType type = new TaxTotalType();
        if (model.getTaxAmount() != null) {
            type.setTaxAmount(model.getTaxAmount());
        }
        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                type.addTaxSubtotal(toType(item));
            }
        }
        return type;
    }

    private static TaxSubtotalType toType(TaxSubtotalModel model) {
        TaxSubtotalType type = new TaxSubtotalType();
        if (model.getTaxAmount() != null) {
            type.setTaxAmount(model.getTaxAmount());
        }
        if (model.getTaxCategory() != null) {
            type.setTaxCategory(toType(model.getTaxCategory()));
        }
        return type;
    }

    private static TaxCategoryType toType(TaxCategoryModel model) {
        TaxCategoryType type = new TaxCategoryType();
        if (model.getTaxScheme() != null) {
            type.setTaxScheme(toType(model.getTaxScheme()));
        }
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

    private static CountryType toType(CountryModel model) {
        CountryType type = new CountryType();
        if (model.getIdentificationCode() != null) {
            type.setIdentificationCode(model.getIdentificationCode());
        }
        return type;
    }

    private static PartyNameType toType(PartyNameModel model) {
        PartyNameType type = new PartyNameType();
        if (model.getName() != null) {
            type.setName(model.getName());
        }
        return type;
    }

    private static PartyLegalEntityType toType(PartyLegalEntityModel model) {
        PartyLegalEntityType type = new PartyLegalEntityType();
        if (model.getRegistrationName() != null) {
            type.setRegistrationName(model.getRegistrationName());
        }
        return type;
    }

    private static XMLGregorianCalendar toType(LocalDate date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }
}
