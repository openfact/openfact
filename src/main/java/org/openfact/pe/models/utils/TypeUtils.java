package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

public class TypeUtils {

    public TypeUtils() {
        // Util class
    }

    public static IDType buildIDType(String value) {
        IDType idType = new IDType();
        idType.setValue(value);
        return idType;
    }

    public static IssueDateType buildIssueDateType(XMLGregorianCalendar value) {
        IssueDateType issueDateType = new IssueDateType();
        issueDateType.setValue(value);
        return issueDateType;
    }

    public static PaymentDueDateType buildPaymentDueDateType(XMLGregorianCalendar value) {
        PaymentDueDateType paymentDueDateType = new PaymentDueDateType();
        paymentDueDateType.setValue(value);
        return paymentDueDateType;
    }

    public static StreetNameType buildStreetNameType(String value) {
        StreetNameType streetNameType = new StreetNameType();
        streetNameType.setValue(value);
        return streetNameType;
    }

    public static UBLVersionIDType buildUBLVersionID(String value) {
        UBLVersionIDType versionIDType = new UBLVersionIDType();
        versionIDType.setValue(value);
        return versionIDType;
    }

    public static CustomizationIDType buildCustomizationIDType(String value) {
        CustomizationIDType customizationIDType = new CustomizationIDType();
        customizationIDType.setValue(value);
        return customizationIDType;
    }

    public static CitySubdivisionNameType buildCitySubdivisionNameType(String value) {
        CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
        citySubdivisionNameType.setValue(value);
        return citySubdivisionNameType;
    }

    public static DocumentCurrencyCodeType buildDocumentCurrencyCodeType(String value) {
        DocumentCurrencyCodeType documentCurrencyCodeType = new DocumentCurrencyCodeType();
        documentCurrencyCodeType.setValue(value);
        return documentCurrencyCodeType;
    }

    public static CityNameType buildCityNameType(String value) {
        CityNameType cityNameType = new CityNameType();
        cityNameType.setValue(value);
        return cityNameType;
    }

    public static CountrySubentityType buildCountrySubEntityType(String value) {
        CountrySubentityType countrySubentityType = new CountrySubentityType();
        countrySubentityType.setValue(value);
        return countrySubentityType;
    }

    public static IdentificationCodeType buildIdentificationCodeType(String value) {
        IdentificationCodeType identificationCodeType = new IdentificationCodeType();
        identificationCodeType.setValue(value);
        return identificationCodeType;
    }

    public static NameType buildNameType(String value) {
        NameType nameType = new NameType();
        nameType.setValue(value);
        return nameType;
    }

    public static RegistrationNameType buildRegistrationNameType(String value) {
        RegistrationNameType registrationNameType = new RegistrationNameType();
        registrationNameType.setValue(value);
        return registrationNameType;
    }

    public static CustomerAssignedAccountIDType buildCustomerAssignedAccountIDType(String value) {
        CustomerAssignedAccountIDType customerAssignedAccountIDType = new CustomerAssignedAccountIDType();
        customerAssignedAccountIDType.setValue(value);
        return customerAssignedAccountIDType;
    }

    public static AdditionalAccountIDType buildAdditionalAccountIDType(String value) {
        AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
        additionalAccountIDType.setValue(value);
        return additionalAccountIDType;
    }

    public static InvoiceTypeCodeType buildInvoiceTypeCodeType(String value) {
        InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
        invoiceTypeCodeType.setValue(value);
        return invoiceTypeCodeType;
    }

    public static NoteType buildNoteType(String value) {
        NoteType noteType = new NoteType();
        noteType.setValue(value);
        return noteType;
    }

    public static AllowanceTotalAmountType buildAllowanceTotalAmountType(String currency, BigDecimal value) {
        AllowanceTotalAmountType allowanceTotalAmountType = new AllowanceTotalAmountType();
        allowanceTotalAmountType.setCurrencyID(CurrencyCodeContentType.fromValue(currency));
        allowanceTotalAmountType.setValue(value);
        return allowanceTotalAmountType;
    }

    public static ChargeTotalAmountType buildChargeTotalAmountType(String currency, BigDecimal value) {
        ChargeTotalAmountType chargeTotalAmountType = new ChargeTotalAmountType();
        chargeTotalAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        chargeTotalAmountType.setValue(value);
        return chargeTotalAmountType;
    }

    public static PayableAmountType buildPayableAmountType(String currency, BigDecimal value) {
        PayableAmountType payableAmountType = new PayableAmountType();
        payableAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        payableAmountType.setValue(value);
        return payableAmountType;
    }

    public static TaxAmountType buildTaxAmountType(String currency, BigDecimal value) {
        TaxAmountType taxAmountType = new TaxAmountType();
        taxAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        taxAmountType.setValue(value);
        return taxAmountType;
    }

    public static TaxTypeCodeType buildTaxTypeCodeType(String value) {
        TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
        taxTypeCodeType.setValue(value);
        return taxTypeCodeType;
    }

    public static InvoicedQuantityType buildInvoicedQuantityType(String unitCode, BigDecimal value) {
        InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType();
        invoicedQuantityType.setValue(value);
        invoicedQuantityType.setUnitCode(unitCode);
        return invoicedQuantityType;
    }

    public static CreditedQuantityType buildCreditedQuantityType(String unitCode, BigDecimal value) {
        CreditedQuantityType creditedQuantityType = new CreditedQuantityType();
        creditedQuantityType.setValue(value);
        creditedQuantityType.setUnitCode(unitCode);
        return creditedQuantityType;
    }

    public static DebitedQuantityType buildDebitedQuantityType(String unitCode, BigDecimal value) {
        DebitedQuantityType debitedQuantityType = new DebitedQuantityType();
        debitedQuantityType.setValue(value);
        debitedQuantityType.setUnitCode(unitCode);
        return debitedQuantityType;
    }

    public static LineExtensionAmountType buildLineExtensionAmountType(String currency, BigDecimal value) {
        LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
        lineExtensionAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        lineExtensionAmountType.setValue(value);
        return lineExtensionAmountType;
    }

    public static PriceAmountType buildPriceAmountType(String currency, BigDecimal value) {
        PriceAmountType priceAmountType = new PriceAmountType();
        priceAmountType.setCurrencyID(CurrencyCodeContentType.valueOf(currency));
        priceAmountType.setValue(value);
        return priceAmountType;
    }

    public static PriceTypeCodeType buildPriceTypeCodeType(String value) {
        PriceTypeCodeType priceTypeCodeType = new PriceTypeCodeType();
        priceTypeCodeType.setValue(value);
        return priceTypeCodeType;
    }

    public static DescriptionType buildDescriptionType(String value) {
        DescriptionType descriptionType = new DescriptionType();
        descriptionType.setValue(value);
        return descriptionType;
    }

    public static TaxExemptionReasonCodeType buildTaxExemptionReasonCodeType(String value) {
        TaxExemptionReasonCodeType taxExemptionReasonCodeType = new TaxExemptionReasonCodeType();
        taxExemptionReasonCodeType.setValue(value);
        return taxExemptionReasonCodeType;
    }

    public static ItemType buildItemType(String description) {
        ItemType itemType = new ItemType();
        itemType.getDescription().add(buildDescriptionType(description));
        return itemType;
    }

    public static PaymentMeansType buildPaymentMeansType(XMLGregorianCalendar value) {
        PaymentMeansType paymentMeansType = new PaymentMeansType();
        paymentMeansType.setPaymentDueDate(buildPaymentDueDateType(value));
        return paymentMeansType;
    }

    public static PartyNameType buildPartyNameType(String value) {
        PartyNameType partyNameType = new PartyNameType();
        partyNameType.setName(buildNameType(value));
        return partyNameType;
    }

    public static PartyLegalEntityType buildPartyLegalEntityType(String value) {
        PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
        partyLegalEntityType.setRegistrationName(buildRegistrationNameType(value));
        return partyLegalEntityType;
    }


    public static TaxSchemeType buildTaxSchemeType(String ID, String name, String code) {
        TaxSchemeType taxSchemeType = new TaxSchemeType();
        taxSchemeType.setID(buildIDType(ID));
        taxSchemeType.setName(buildNameType(name));
        taxSchemeType.setTaxTypeCode(buildTaxTypeCodeType(code));
        return taxSchemeType;
    }

    public static TaxCategoryType buildTaxCategoryType(String ID, String name, String code) {
        TaxCategoryType taxCategoryType = new TaxCategoryType();
        taxCategoryType.setTaxScheme(buildTaxSchemeType(ID, name, code));
        return taxCategoryType;
    }

    public static PriceType buildPriceType(String currency, BigDecimal value, String priceTypeCode) {
        PriceType priceType = new PriceType();
        priceType.setPriceAmount(buildPriceAmountType(currency, value));
        priceType.setPriceTypeCode(buildPriceTypeCodeType(priceTypeCode));
        return priceType;
    }

    public static PriceType buildPriceType(String currency, BigDecimal value) {
        PriceType priceType = new PriceType();
        priceType.setPriceAmount(buildPriceAmountType(currency, value));
        return priceType;
    }

    public static CountryType buildCountryType(String value) {
        CountryType countryType = new CountryType();
        countryType.setIdentificationCode(buildIdentificationCodeType(value));
        return countryType;
    }

    public static URIType buildURIType(String value) {
        URIType uriType = new URIType();
        uriType.setValue(value);
        return uriType;
    }

    public static ExternalReferenceType buildExternalReferenceType(String value) {
        ExternalReferenceType externalReferenceType = new ExternalReferenceType();
        externalReferenceType.setURI(TypeUtils.buildURIType(value));
        return externalReferenceType;
    }

    public static PartyIdentificationType buildPartyIdentificationType(String ID) {
        PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
        partyIdentificationType.setID(buildIDType(ID));
        return partyIdentificationType;
    }

    public static ValueType buildValueType(String value) {
        ValueType valueType = new ValueType();
        valueType.setValue(value);
        return valueType;
    }

    public static ReferenceIDType buildReferenceIDType(String value) {
        ReferenceIDType referenceIDType = new ReferenceIDType();
        referenceIDType.setValue(value);
        return referenceIDType;
    }

    public static ResponseCodeType buildResponseCodeType(String value) {
        ResponseCodeType responseCodeType = new ResponseCodeType();
        responseCodeType.setValue(value);
        return responseCodeType;
    }

    public static ResponseType buildResponseType(String referenecID, String responseCode, String descripcion) {
        ResponseType responseType = new ResponseType();
        responseType.setReferenceID(TypeUtils.buildReferenceIDType(referenecID));
        responseType.setResponseCode(TypeUtils.buildResponseCodeType(responseCode));
        responseType.getDescription().add(TypeUtils.buildDescriptionType(descripcion));
        return responseType;
    }

    public static DocumentTypeCodeType buildDocumentTypeCodeType(String value) {
        DocumentTypeCodeType documentTypeCodeType = new DocumentTypeCodeType();
        documentTypeCodeType.setValue(value);
        return documentTypeCodeType;
    }

    public static DocumentReferenceType buildDocumentReferenceType(String ID, String documentTypeCode) {
        DocumentReferenceType documentReferenceType = new DocumentReferenceType();
        documentReferenceType.setID(buildIDType(ID));
        documentReferenceType.setDocumentTypeCode(buildDocumentTypeCodeType(documentTypeCode));
        return documentReferenceType;
    }

}
