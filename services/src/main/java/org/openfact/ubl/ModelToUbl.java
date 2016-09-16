package org.openfact.ubl;

import java.util.Arrays;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.InvoiceModel;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class ModelToUbl {

    public static InvoiceType getInvoiceType(OrganizationModel organization, InvoiceModel invoice) {
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setAccountingSupplierParty(getSupplierPartyType(organization));
        invoiceType.setInvoiceTypeCode(invoice.getTypeId());
        invoiceType.setID(invoice.getSeriesAndNumberAsId());
        invoiceType.setAccountingCustomerParty(getCustomerPartyType(invoice.getCustomer()));

        invoiceType.setUBLExtensions(getUBLExtensionsType(invoice));
        return invoiceType;
    }

    public static UBLExtensionsType getUBLExtensionsType(InvoiceModel invoice) {
        UBLExtensionsType ublExtensionsType = new UBLExtensionsType();
        ublExtensionsType.setUBLExtension(Arrays.asList(getUBLExtensionType(invoice)));
        return ublExtensionsType;
    }

    public static UBLExtensionType getUBLExtensionType(InvoiceModel invoice) {
        UBLExtensionType ublExtensionType = new UBLExtensionType();
        return ublExtensionType;
    }

    public static CustomerPartyType getCustomerPartyType(CustomerModel customer) {
        CustomerPartyType customerPartyType = new CustomerPartyType();
        customerPartyType.setCustomerAssignedAccountID(customer.getAssignedIdentificationId());
        customerPartyType.setAdditionalAccountID(Arrays.asList(getAdditionalAccountIDType(customer)));
        customerPartyType.setParty(getPartyType(customer));
        return customerPartyType;
    }

    public static SupplierPartyType getSupplierPartyType(OrganizationModel organization) {
        SupplierPartyType supplierPartyType = new SupplierPartyType();
        supplierPartyType.setCustomerAssignedAccountID(organization.getAssignedIdentificationId());
        supplierPartyType.setAdditionalAccountID(Arrays.asList(getAdditionalAccountIDType(organization)));
        supplierPartyType.setParty(getPartyType(organization));
        return supplierPartyType;
    }

    public static AdditionalAccountIDType getAdditionalAccountIDType(OrganizationModel organization) {
        AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
        additionalAccountIDType.setValue(organization.getAdditionalAccountId().getCode());
        return additionalAccountIDType;
    }

    public static AdditionalAccountIDType getAdditionalAccountIDType(CustomerModel customer) {
        AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
        additionalAccountIDType.setValue(customer.getAdditionalAccountId_Id());
        return additionalAccountIDType;
    }

    public static PartyType getPartyType(OrganizationModel organization) {
        PartyType partyType = new PartyType();
        partyType.setPartyName(Arrays.asList(getPartyNameType(organization)));
        partyType.setPostalAddress(getAddressType(organization));
        partyType.setPartyLegalEntity(Arrays.asList(getPartyLegalEntityType(organization)));
        return partyType;
    }

    public static PartyType getPartyType(CustomerModel customer) {
        PartyType partyType = new PartyType();
        partyType.setPartyLegalEntity(Arrays.asList(getPartyLegalEntityType(customer)));
        return partyType;
    }

    public static PartyNameType getPartyNameType(OrganizationModel organization) {
        PartyNameType partyNameType = new PartyNameType();
        partyNameType.setName(organization.getSupplierName());
        return partyNameType;
    }

    public static AddressType getAddressType(OrganizationModel organization) {
        AddressType address = new AddressType();
        address.setID(organization.getPostalAddressId());
        address.setStreetName(organization.getStreetName());
        address.setCitySubdivisionName(organization.getCitySubdivisionName());
        address.setCityName(organization.getCityName());
        address.setCountrySubentity(organization.getCountrySubentity());
        address.setDistrict(organization.getDistrict());

        CountryType countryType = new CountryType();
        countryType.setIdentificationCode(organization.getCountryIdentificationCode());
        address.setCountry(countryType);

        return address;
    }

    public static PartyLegalEntityType getPartyLegalEntityType(OrganizationModel organization) {
        PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
        partyLegalEntityType.setRegistrationName(organization.getRegistrationName());
        return partyLegalEntityType;
    }

    public static PartyLegalEntityType getPartyLegalEntityType(CustomerModel customer) {
        PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
        partyLegalEntityType.setRegistrationName(customer.getRegistrationName());
        return partyLegalEntityType;
    }

}
