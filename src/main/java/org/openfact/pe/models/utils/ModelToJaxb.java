package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.types.TipoDocumentoEntidad;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ModelToJaxb {

    private ModelToJaxb() {
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

    private static CustomerAssignedAccountIDType buildCustomerAssignedAccountIDType(String value) {
        CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
        customerAssignedAccountIDType.setValue(value);
        return customerAssignedAccountIDType;
    }

    private static AdditionalAccountIDType buildAdditionalAccountIDType(String value) {
        AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
        additionalAccountIDType.setValue(value);
        return additionalAccountIDType;
    }

    private static SupplierPartyType buildSupplierPartyType(InformacionAdicionalModel model) {
        SupplierPartyType supplierPartyType = new SupplierPartyType();

        // Numero DNI/RUC
        supplierPartyType.setCustomerAssignedAccountID(buildCustomerAssignedAccountIDType(model.getAssignedId()));

        // Codigo de DNI/RUC
        supplierPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(model.getAdditionalAssignedId()));

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

    private static CustomerPartyType buildCustomerPartyType(ClienteModel cliente) {
        CustomerPartyType customerPartyType = new CustomerPartyType();

        // Numero DNI/RUC
        customerPartyType.setCustomerAssignedAccountID(buildCustomerAssignedAccountIDType(cliente.getNumeroDocumento()));

        // Codigo de DNI/RUC
        switch (cliente.getTipoDocumento()) {
            case DOC_TRIB_NO_DOM_SIN_RUC:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.DOC_TRIB_NO_DOM_SIN_RUC.getCodigo()));
                break;
            case DNI:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.DNI.getCodigo()));
                break;
            case EXTRANJERIA:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.EXTRANJERIA.getCodigo()));
                break;
            case RUC:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.RUC.getCodigo()));
                break;
            case PASAPORTE:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.PASAPORTE.getCodigo()));
                break;
            case DEC_DIPLOMATICA:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.DEC_DIPLOMATICA.getCodigo()));
                break;
            case NO_IDENTIFICADO_EXPORTACION:
                customerPartyType.getAdditionalAccountID().add(buildAdditionalAccountIDType(TipoDocumentoEntidad.NO_IDENTIFICADO_EXPORTACION.getCodigo()));
                break;
            default:
                throw new IllegalStateException("Tipo de documento invalido en customer");
        }

        // Party
        PartyType partyType = new PartyType();

        // Party Name
        partyType.getPartyName().add(buildPartyNameType(cliente.getNombre()));

        // Party Legal Entity
        partyType.getPartyLegalEntity().add(buildPartyLegalEntityType(cliente.getNombre()));

        // Party Address
        AddressType addressType = new AddressType();
        addressType.setStreetName(buildStreetNameType(cliente.getDireccion()));

        customerPartyType.setParty(partyType);
        return customerPartyType;
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

    public static InvoiceType toInvoiceType(OrganizationModel organizacion, InformacionAdicionalModel informacionAdicional, FacturaModel boletaFactura) {
        InvoiceType invoice = new InvoiceType();

        // General config
        invoice.setUBLVersionID(buildUBLVersionID("2.0"));
        invoice.setCustomizationID(buildCustomizationIDType("1.0"));

        // documentId
//        invoice.setID(buildIDType(boletaFactura.getIdAsignado()));

        // Fechas
        invoice.setIssueDate(buildIssueDateType(boletaFactura.getFechaEmision(), organizacion.getTimeZone()));
        if (boletaFactura.getFechaVencimiento() != null) {
            invoice.getPaymentMeans().add(buildPaymentMeansType(boletaFactura.getFechaVencimiento(), organizacion.getTimeZone()));
        }

        // Moneda
        invoice.setDocumentCurrencyCode(buildDocumentCurrencyCodeType(boletaFactura.getMoneda()));

        // Proveedor
        invoice.setAccountingSupplierParty(buildSupplierPartyType(informacionAdicional));

        // Cliente
        invoice.setAccountingCustomerParty(buildCustomerPartyType(boletaFactura.getCliente()));

        // Total impuestos IGV/ISC
//        invoice.getTaxTotal().add();
//
//        // Totales pagar/descuentos
//        invoice.setLegalMonetaryTotal(toLegalMonetaryTotalType(rep));

        // Codigo Invoice BOLETA/FACTURA
//        switch (boletaFactura.getTipoInvoice()) {
//            case BOLETA:
//                invoice.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.BOLETA.getCodigo()));
//                break;
//            case FACTURA:
//                invoice.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.FACTURA.getCodigo()));
//                break;
//            default:
//                throw new IllegalStateException("Tipo Invoice invalido:" + boletaFactura.getTipoInvoice());
//        }

        // Observaciones
        invoice.getNote().add(buildNoteType(boletaFactura.getObservaciones()));
//
//        // Firma Digital
//        invoice.setSignature(Arrays.asList(toSignatureType(organization)));
//
//        // Extensiones SUNAT
//        invoice.setUBLExtensions(toUBLExtensionsType(rep));
//
//        // Detalle Lines
//        if (rep.getDetalle() != null) {
//            invoice.setInvoiceLine(toInvoiceLineType(rep));
//        }

        return invoice;
    }

    public static CreditNoteType toCreditNoteType() {
        return null;
    }

    public static DebitNoteLineType toDebitNoteType() {
        return null;
    }
}
