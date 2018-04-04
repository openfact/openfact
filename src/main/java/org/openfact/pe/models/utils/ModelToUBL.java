package org.openfact.pe.models.utils;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.BoletaFacturaPEModel;
import org.openfact.pe.models.InformacionAdicionalPEModel;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.ubl20.xsd.commonaggregatecomponents_2.*;
import org.openfact.pe.ubl20.xsd.commonbasiccomponents_2.*;
import org.openfact.pe.ubl20.xsd.creditnote_2.CreditNoteType;
import org.openfact.pe.ubl20.xsd.invoice_2.InvoiceType;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ModelToUBL {

    private ModelToUBL() {
        // Just util class
    }

    private static UBLVersionIDType buildUBLVersionID(String value) {
        UBLVersionIDType versionIDType = new UBLVersionIDType();
        versionIDType.setValue(value);
        return versionIDType;
    }

    private static CustomizationIDType buildCustomizationIDType(String value) {
        CustomizationIDType customizationIDType = new CustomizationIDType();
        customizationIDType.setValue(value);
        return customizationIDType;
    }

    private static IDType buildIDType(String value) {
        IDType idType = new IDType();
        idType.setValue(value);
        return idType;
    }

    private static IssueDateType buildIssueDateType(Date date, TimeZone timeZone) {
        IssueDateType issueDateType = new IssueDateType();
        issueDateType.setValue(toGregorianCalendar(date, timeZone));
        return issueDateType;
    }

    private static PaymentMeansType buildPaymentMeansType(Date date, TimeZone zone) {
        PaymentMeansType paymentMeansType = new PaymentMeansType();

        PaymentDueDateType paymentDueDateType = new PaymentDueDateType();
        paymentDueDateType.setValue(toGregorianCalendar(date, zone));

        paymentMeansType.setPaymentDueDate(paymentDueDateType);
        return paymentMeansType;
    }

    private static XMLGregorianCalendar toGregorianCalendar(Date date, TimeZone zone) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.setTimeZone(zone);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentCurrencyCodeType buildDocumentCurrencyCodeType(String value) {
        DocumentCurrencyCodeType documentCurrencyCodeType = new DocumentCurrencyCodeType();
        documentCurrencyCodeType.setValue(value);
        return documentCurrencyCodeType;
    }

    private static StreetNameType buildStreetNameType(String value) {
        StreetNameType streetNameType = new StreetNameType();
        streetNameType.setValue(value);
        return streetNameType;
    }

    private static CitySubdivisionNameType buildCitySubdivisionNameType(String value) {
        CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
        citySubdivisionNameType.setValue(value);
        return citySubdivisionNameType;
    }

    private static CityNameType buildCityNameType(String value) {
        CityNameType cityNameType = new CityNameType();
        cityNameType.setValue(value);
        return cityNameType;
    }

    private static CountrySubentityType buildCountrySubentityType(String value) {
        CountrySubentityType countrySubentityType = new CountrySubentityType();
        countrySubentityType.setValue(value);
        return countrySubentityType;
    }

    private static CountryType buildCountryType(String value) {
        CountryType countryType = new CountryType();
        IdentificationCodeType identificationCodeType = new IdentificationCodeType();
        identificationCodeType.setValue(value);
        countryType.setIdentificationCode(identificationCodeType);
        return countryType;
    }

    private static PartyNameType buildPartyNameType(String value) {
        PartyNameType partyNameType = new PartyNameType();
        NameType nameType = new NameType();
        nameType.setValue(value);
        partyNameType.setName(nameType);
        return partyNameType;
    }

    private static PartyLegalEntityType buildPartyLegalEntityType(String value) {
        PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
        RegistrationNameType registrationNameType = new RegistrationNameType();
        registrationNameType.setValue(value);
        partyLegalEntityType.setRegistrationName(registrationNameType);
        return partyLegalEntityType;
    }

    private static SupplierPartyType buildSupplierPartyType(InformacionAdicionalPEModel model) {
        SupplierPartyType supplierPartyType = new SupplierPartyType();

        // Numero DNI/RUC
        CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
        customerAssignedAccountIDType.setValue(model.getAssignedId());
        supplierPartyType.setCustomerAssignedAccountID(customerAssignedAccountIDType);

        // Codigo de DNI/RUC
        AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
        additionalAccountIDType.setValue(model.getAdditionalAssignedId());
        supplierPartyType.getAdditionalAccountID().add(additionalAccountIDType);

        // Party
        PartyType partyType = new PartyType();

        // Party Name
        partyType.getPartyName().add(buildPartyNameType(model.getNombreComercial()));

        // Party Legal Entity
        partyType.getPartyLegalEntity().add(buildPartyLegalEntityType(model.getRazonSocial()));

        // Party Address
        AddressType addressType = new AddressType();
        addressType.setID(buildIDType(model.getCodigoPostal()));
        addressType.setStreetName(buildStreetNameType(model.getDireccion()));
        addressType.setCitySubdivisionName(buildCitySubdivisionNameType(model.getProvincia()));
        addressType.setCityName(buildCityNameType(model.getDistrito()));
        addressType.setCountrySubentity(buildCountrySubentityType(model.getRegion()));
        addressType.setCountry(buildCountryType(model.getCodigoPais()));
        partyType.setPostalAddress(addressType);

        supplierPartyType.setParty(partyType);
        return supplierPartyType;
    }

    private static InvoiceTypeCodeType buildInvoiceTypeCodeType(String value) {
        InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
        invoiceTypeCodeType.setValue(value);
        return invoiceTypeCodeType;
    }

    private static NoteType buildNoteType(String value) {
        NoteType noteType = new NoteType();
        noteType.setValue(value);
        return noteType;
    }

    public static InvoiceType toInvoiceType(OrganizationModel organizacion, InformacionAdicionalPEModel informacionAdicional, BoletaFacturaPEModel model) {
        InvoiceType invoice = new InvoiceType();

        // General config
        invoice.setUBLVersionID(buildUBLVersionID("2.0"));
        invoice.setCustomizationID(buildCustomizationIDType("1.0"));

        // documentId
        invoice.setID(buildIDType(model.getIdAsignado()));

        // Fechas
        invoice.setIssueDate(buildIssueDateType(model.getFechaEmision(), organizacion.getTimeZone()));
        if (model.getFechaVencimiento() != null) {
            invoice.getPaymentMeans().add(buildPaymentMeansType(model.getFechaVencimiento(), organizacion.getTimeZone()));
        }

        // Moneda
        invoice.setDocumentCurrencyCode(buildDocumentCurrencyCodeType(model.getMoneda()));

        // Proveedor
        invoice.setAccountingSupplierParty(buildSupplierPartyType(informacionAdicional));

        // Cliente
        invoice.setAccountingCustomerParty(toCustomerPartyType(rep));

        // Total impuestos IGV/ISC
        invoice.getTaxTotal().add();

        // Totales pagar/descuentos
        invoice.setLegalMonetaryTotal(toLegalMonetaryTotalType(rep));

        // Codigo Invoice BOLETA/FACTURA
        switch (model.getTipoInvoice()) {
            case BOLETA:
                invoice.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.BOLETA.getCodigo()));
                break;
            case FACTURA:
                invoice.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.FACTURA.getCodigo()));
                break;
            default:
                throw new IllegalStateException("Tipo Invoice invalido:" + model.getTipoInvoice());
        }

        // Notes type
        invoice.getNote().add(buildNoteType(model.getObservacion()));

        // Signature
        invoice.setSignature(Arrays.asList(toSignatureType(organization)));

        // Extensions
        invoice.setUBLExtensions(toUBLExtensionsType(rep));

        // Lines
        if (rep.getDetalle() != null) {
            invoice.setInvoiceLine(toInvoiceLineType(rep));
        }

        return invoice;
    }

    public static CreditNoteType toCreditNoteType() {

    }

    public static DebitNoteLineType toDebitNoteType() {

    }
}
