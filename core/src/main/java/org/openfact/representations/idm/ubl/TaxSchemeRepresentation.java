package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxSchemeRepresentation {

    /**
     * A code signifying the currency in which the tax is collected and
     * reported.
     */
    private CurrencyCodeRepresentation codeTypeCurrencyCode;
    /**
     * An identifier for this taxation scheme.
     */
    private IdentifierRepresentation ID;
    /**
     * The name of this taxation scheme.
     */
    private String name;
    /**
     * A code signifying the type of tax.
     */
    private CodeRepresentation taxTypeCode;
    private AddressRepresentation jurisdictionRegionAddress;

    /**
     * @return the codeTypeCurrencyCode
     */
    public CurrencyCodeRepresentation getCodeTypeCurrencyCode() {
        return codeTypeCurrencyCode;
    }

    /**
     * @param codeTypeCurrencyCode
     *            the codeTypeCurrencyCode to set
     */
    public void setCodeTypeCurrencyCode(CurrencyCodeRepresentation codeTypeCurrencyCode) {
        this.codeTypeCurrencyCode = codeTypeCurrencyCode;
    }

    /**
     * @return the iD
     */
    public IdentifierRepresentation getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierRepresentation iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the taxTypeCode
     */
    public CodeRepresentation getTaxTypeCode() {
        return taxTypeCode;
    }

    /**
     * @param taxTypeCode
     *            the taxTypeCode to set
     */
    public void setTaxTypeCode(CodeRepresentation taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    /**
     * @return the jurisdictionRegionAddress
     */
    public AddressRepresentation getJurisdictionRegionAddress() {
        return jurisdictionRegionAddress;
    }

    /**
     * @param jurisdictionRegionAddress
     *            the jurisdictionRegionAddress to set
     */
    public void setJurisdictionRegionAddress(AddressRepresentation jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

}
