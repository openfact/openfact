package org.openfact.ubl.data.xml;

import org.json.JSONObject;
import org.openfact.JSONObjectUtils;
import org.openfact.ubl.data.xml.entity.XmlCreditNoteDocumentLineEntity;
import org.openfact.ubl.data.xml.entity.XmlDebitNoteDocumentLineEntity;
import org.openfact.ubl.data.xml.entity.XmlInvoiceDocumentLineEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static com.google.common.base.Verify.verifyNotNull;

public enum XmlSupportedAttribute {

    OF_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "ID")),

    OF_ISSUE_DATE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "IssueDate")),

    OF_INVOICE_TYPE_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "InvoiceTypeCode")),

    OF_DOCUMENT_CURRENCY_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "DocumentCurrencyCode")),

    /**
     * Supplier party SP
     */
    OF_SP_ASSIGNED_ACCOUNT_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "CustomerAssignedAccountID")),

    OF_SP_ADDITIONAL_ACCOUNT_ID(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "AdditionalAccountID")),

    OF_SP_POSTAL_ADDRESS_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "ID")),

    OF_SP_POSTAL_ADDRESS_STREET_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "StreetName")),

    OF_SP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CitySubdivisionName")),

    OF_SP_POSTAL_ADDRESS_CITY_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CityName")),

    OF_SP_POSTAL_ADDRESS_CITY_SUBENTITY(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CountrySubentity")),

    OF_SP_POSTAL_ADDRESS_DISTRICT(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "District")),

    OF_SP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "Country", "IdentificationCode")),

    OF_SP_LEGAL_ENTITY_REGISTRATION_NAME(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null, 2,
            "AccountingSupplierParty", "Party", "PartyLegalEntity", "RegistrationName")),

    /**
     * Customer party CP
     */
    OF_CP_ASSIGNED_ACCOUNT_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "CustomerAssignedAccountID")),

    OF_CP_ADDITIONAL_ACCOUNT_ID(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "AdditionalAccountID")),

    OF_CP_POSTAL_ADDRESS_STREET_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "StreetName")),

    OF_CP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CitySubdivisionName")),

    OF_CP_POSTAL_ADDRESS_CITY_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CityName")),

    OF_CP_POSTAL_ADDRESS_CITY_SUBENTITY(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CountrySubentity")),

    OF_CP_POSTAL_ADDRESS_DISTRICT(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "District")),

    OF_CP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "Country", "IdentificationCode")),

    OF_CP_LEGAL_ENTITY_REGISTRATION_NAME(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null, 2,
            "AccountingCustomerParty", "Party", "PartyLegalEntity", "RegistrationName")),

    /**
     * Tax Total
     */
    OF_TT_TAX_AMOUNT(XMLAttributeContainer.arrayKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "TaxTotal", "TaxAmount")),

    /**
     * Legal Monetary Total
     */
    OF_LMT_PAYABLE_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "PayableAmount")),

    OF_LMT_CHARGE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "ChargeTotalAmount")),

    OF_LMT_ALLOWANCE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "AllowanceTotalAmount")),

    /**
     * Requested Monetary Total
     */
    OF_RMT_PAYABLE_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "RequestedMonetaryTotal", "PayableAmount")),

    OF_RMT_CHARGE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "RequestedMonetaryTotal", "ChargeTotalAmount")),

    OF_RMT_ALLOWANCE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "RequestedMonetaryTotal", "AllowanceTotalAmount")),

    /**
     * Billing reference
     */
    OF_BR_INVOICE_DOCUMENT_REFERENCE_ID(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null,
            0, "BillingReference", "InvoiceDocumentReference", "ID")),

    /**
     * Invoice Line
     */
    OF_INVOICE_LINE(XMLAttributeContainer.objectArrayKey(XmlInvoiceDocumentLineEntity.class, "InvoiceLine")),
    OF_CREDIT_NOTE_LINE(XMLAttributeContainer.objectArrayKey(XmlCreditNoteDocumentLineEntity.class, "CreditNoteLine")),
    OF_DEBIT_NOTE_LINE(XMLAttributeContainer.objectArrayKey(XmlDebitNoteDocumentLineEntity.class, "DebitNoteLine"));

    private XmlConverter converter;

    XmlSupportedAttribute(XmlConverter converter) {
        this.converter = converter;
    }

    public Object asObject(JSONObject json) {
        verifyNotNull(converter);
        return converter.asObject(json);
    }

    public static XmlSupportedAttribute fromString(String text) {
        Optional<XmlSupportedAttribute> op = Arrays.stream(XmlSupportedAttribute.values())
                .filter(p -> p.toString().equals(text))
                .findFirst();
        return op.isPresent() ? op.get() : null;
    }

}
