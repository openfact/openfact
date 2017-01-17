package org.openfact.ubl;

import org.json.JSONObject;
import org.openfact.JSONObjectUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static com.google.common.base.Verify.verifyNotNull;

public enum XMLSupportedAttribute {

    ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "ID")),

    ISSUE_DATE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "IssueDate")),

    INVOICE_TYPE_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "InvoiceTypeCode")),

    DOCUMENT_CURRENCY_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "DocumentCurrencyCode")),

    /**
     * Supplier party SP
     */
    SP_ASSIGNED_ACCOUNT_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "CustomerAssignedAccountID")),

    SP_ADDITIONAL_ACCOUNT_ID(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "AdditionalAccountID")),

    SP_POSTAL_ADDRESS_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "ID")),

    SP_POSTAL_ADDRESS_STREET_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "StreetName")),

    SP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CitySubdivisionName")),

    SP_POSTAL_ADDRESS_CITY_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CityName")),

    SP_POSTAL_ADDRESS_CITY_SUBENTITY(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "CountrySubentity")),

    SP_POSTAL_ADDRESS_DISTRICT(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "District")),

    SP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingSupplierParty", "Party", "PostalAddress", "Country", "IdentificationCode")),

    SP_LEGAL_ENTITY_REGISTRATION_NAME(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null, 2,
            "AccountingSupplierParty", "Party", "PartyLegalEntity", "RegistrationName")),

    /**
     * Customer party CP
     */
    CP_ASSIGNED_ACCOUNT_ID(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "CustomerAssignedAccountID")),

    CP_ADDITIONAL_ACCOUNT_ID(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "AdditionalAccountID")),

    CP_POSTAL_ADDRESS_STREET_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "StreetName")),

    CP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CitySubdivisionName")),

    CP_POSTAL_ADDRESS_CITY_NAME(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CityName")),

    CP_POSTAL_ADDRESS_CITY_SUBENTITY(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "CountrySubentity")),

    CP_POSTAL_ADDRESS_DISTRICT(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "District")),

    CP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE(XMLAttributeContainer.simpleKey(value -> value != null ? String.valueOf(value) : null,
            "AccountingCustomerParty", "Party", "PostalAddress", "Country", "IdentificationCode")),

    CP_LEGAL_ENTITY_REGISTRATION_NAME(XMLAttributeContainer.arrayKey(value -> value != null ? String.valueOf(value) : null, 2,
            "AccountingCustomerParty", "Party", "PartyLegalEntity", "RegistrationName")),

    /**
     * Tax Total
     */
    TT_TAX_AMOUNT(XMLAttributeContainer.arrayKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
        return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "TaxTotal", "TaxAmount")),

    /**
     * Legal Monetary Total
     */
    LMT_PAYABLE_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
       return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "PayableAmount")),

    LMT_CHARGE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
       return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "ChargeTotalAmount")),

    LMT_ALLOWANCE_TOTAL_AMOUNT(XMLAttributeContainer.simpleKey(value -> {
        if (value instanceof JSONObject) {
            value = JSONObjectUtils.getObject((JSONObject) value, "content");
        }
       return value != null ? new BigDecimal(String.valueOf(value)) : null;
    }, "LegalMonetaryTotal", "AllowanceTotalAmount"));

    /**
     * Invoice Line
     */
    //INVOICE_LINE(XMLAttributeContainer.idContainer());

    private JSONObjectToObjectConverter converter;

    XMLSupportedAttribute(JSONObjectToObjectConverter converter) {
        this.converter = converter;
    }

    public Object asObject(JSONObject json) {
        verifyNotNull(converter);
        return converter.asObject(json);
    }

    public static XMLSupportedAttribute fromString(String text) {
        Optional<XMLSupportedAttribute> op = Arrays.stream(XMLSupportedAttribute.values())
                .filter(p -> p.toString().equals(text))
                .findFirst();
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

}
