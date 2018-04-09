package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoDocumentoEntidad;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.types.TipoTributo;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.*;

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

    private static SupplierPartyType buildSupplierPartyType(OrganizacionInformacionAdicionalModel model) {
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

    private static AllowanceTotalAmountType buildAllowanceTotalAmountType(String currency, BigDecimal value) {
        AllowanceTotalAmountType allowanceTotalAmountType = new AllowanceTotalAmountType();
        allowanceTotalAmountType.setCurrencyID(CurrencyCodeContentType.fromValue(currency));
        allowanceTotalAmountType.setValue(value);
        return allowanceTotalAmountType;
    }

    private static ChargeTotalAmountType buildChargeTotalAmountType(String currency, BigDecimal value) {
        ChargeTotalAmountType chargeTotalAmountType = new ChargeTotalAmountType();
        chargeTotalAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        chargeTotalAmountType.setValue(value);
        return chargeTotalAmountType;
    }

    private static PayableAmountType buildPayableAmountType(String currency, BigDecimal value) {
        PayableAmountType payableAmountType = new PayableAmountType();
        payableAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        payableAmountType.setValue(value);
        return payableAmountType;
    }

    private static MonetaryTotalType buildMonetaryTotalType(String currency, TotalModel total) {
        MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
        monetaryTotalType.setAllowanceTotalAmount(buildAllowanceTotalAmountType(currency, total.getDescuentoGlobal()));
        monetaryTotalType.setChargeTotalAmount(buildChargeTotalAmountType(currency, total.getOtrosCargos()));
        monetaryTotalType.setPayableAmount(buildPayableAmountType(currency, total.getTotalPagar()));
        return monetaryTotalType;
    }

    private static TaxAmountType buildTaxAmountType(String currency, BigDecimal value) {
        TaxAmountType taxAmountType = new TaxAmountType();
        taxAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        taxAmountType.setValue(value);
        return taxAmountType;
    }

    private static NameType buildNameType(String value) {
        NameType nameType = new NameType();
        nameType.setValue(value);
        return nameType;
    }

    private static TaxTypeCodeType buildTaxTypeCodeType(String value) {
        TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
        taxTypeCodeType.setValue(value);
        return taxTypeCodeType;
    }

    private static TaxSchemeType buildTaxSchemeType(String ID, String name, String code) {
        TaxSchemeType taxSchemeType = new TaxSchemeType();
        taxSchemeType.setID(buildIDType(ID));
        taxSchemeType.setName(buildNameType(name));
        taxSchemeType.setTaxTypeCode(buildTaxTypeCodeType(code));
        return taxSchemeType;
    }

    private static TaxCategoryType buildTaxCategoryType(String ID, String name, String code) {
        TaxCategoryType taxCategoryType = new TaxCategoryType();
        taxCategoryType.setTaxScheme(buildTaxSchemeType(ID, name, code));
        return taxCategoryType;
    }

    private static TaxSubtotalType buildTaxSubtotalType(String currency, BigDecimal value, TipoTributo tipoTributo) {
        TaxSubtotalType taxSubtotalType = new TaxSubtotalType();
        taxSubtotalType.setTaxAmount(buildTaxAmountType(currency, value));
        taxSubtotalType.setTaxCategory(buildTaxCategoryType(tipoTributo.getId(), tipoTributo.getAbreviatura(), tipoTributo.getCodigo()));
        return taxSubtotalType;
    }

    private static List<TaxTotalType> buildTaxTotalType(String currency, ImpuestosModel impuestos) {
        List<TaxTotalType> result = new ArrayList<>();

        if (impuestos.getIGV() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(buildTaxAmountType(currency, impuestos.getIGV()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getIGV(), TipoTributo.IGV));

            result.add(taxTotalType);
        }
        if (impuestos.getISC() != null) {
            TaxTotalType taxTotalType = new TaxTotalType();
            taxTotalType.setTaxAmount(buildTaxAmountType(currency, impuestos.getISC()));
            taxTotalType.getTaxSubtotal().add(buildTaxSubtotalType(currency, impuestos.getISC(), TipoTributo.ISC));

            result.add(taxTotalType);
        }

        return result;
    }

    private static ExtensionContentType buildExtensionContentType() {
        return new ExtensionContentType();
    }

    private static UBLExtensionType buildUBLExtensionType() {
        UBLExtensionType ublExtensionType = new UBLExtensionType();
        ublExtensionType.setExtensionContent(buildExtensionContentType());
        return ublExtensionType;
    }

    private static UBLExtensionsType buildUBLExtensionsType() {
        UBLExtensionsType ublExtensionsType = new UBLExtensionsType();

        // Totales
//        UBLExtensionType ublExtensionType = buildUBLExtensionType();
//        ublExtensionType.setExtensionContent();
//        ublExtensionsType.getUBLExtension().add(ublExtensionType)
//
//        // Firma Digital
//        invoiceType.setSignature(Arrays.asList(toSignatureType(organization)));

        return ublExtensionsType;
    }

    private static InvoiceType toInvoiceType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, AbstractInvoiceModel invoiceModel) {
        InvoiceType invoiceType = new InvoiceType();

        // General config
        invoiceType.setUBLVersionID(buildUBLVersionID("2.0"));
        invoiceType.setCustomizationID(buildCustomizationIDType("1.0"));

        // documentId
        invoiceType.setID(buildIDType(invoiceModel.getSerie() + invoiceModel.getNumero()));

        // Fechas
        invoiceType.setIssueDate(buildIssueDateType(invoiceModel.getFecha().getEmision(), organization.getTimeZone()));
        if (invoiceModel.getFecha().getVencimiento() != null) {
            invoiceType.getPaymentMeans().add(buildPaymentMeansType(invoiceModel.getFecha().getVencimiento(), organization.getTimeZone()));
        }

        // Proveedor
        invoiceType.setAccountingSupplierParty(buildSupplierPartyType(informacionAdicional));

        // Cliente
        invoiceType.setAccountingCustomerParty(buildCustomerPartyType(invoiceModel.getCliente()));

        // Moneda
        invoiceType.setDocumentCurrencyCode(buildDocumentCurrencyCodeType(invoiceModel.getMoneda().getMoneda()));

        // Totales pagar/descuentos/otros cargos
        invoiceType.setLegalMonetaryTotal(buildMonetaryTotalType(invoiceModel.getMoneda().getMoneda(), invoiceModel.getTotal()));

        // Total impuestos IGV/ISC
        invoiceType.getTaxTotal().addAll(buildTaxTotalType(invoiceModel.getMoneda().getMoneda(), invoiceModel.getImpuestos()));

        // SUNAT y Firma
        invoiceType.setUBLExtensions(buildUBLExtensionsType());

        // Observaciones
        invoiceType.getNote().add(buildNoteType(invoiceModel.getObservaciones()));

        return invoiceType;
    }

    public static InvoiceType toBoletaType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, BoletaModel boleta) {
        InvoiceType invoiceType = toInvoiceType(organization, informacionAdicional, boleta);
        invoiceType.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.BOLETA.getCodigo()));

        return invoiceType;
    }

    public static InvoiceType toFacturaType(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        InvoiceType invoiceType = toInvoiceType(organization, informacionAdicional, factura);
        invoiceType.setInvoiceTypeCode(buildInvoiceTypeCodeType(TipoInvoice.FACTURA.getCodigo()));

//        // Detalle Lines
//        if (rep.getDetalle() != null) {
//            invoiceType.setInvoiceLine(toInvoiceLineType(rep));
//        }

        return invoiceType;
    }

    public static CreditNoteType toCreditNoteType() {
        return null;
    }

    public static DebitNoteLineType toDebitNoteType() {
        return null;
    }
}
