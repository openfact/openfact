package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
@Entity
@Table(name = "TAX_SCHEME")
public class TaxSchemeEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    /**
     * A code signifying the currency in which the tax is collected and
     * reported.
     */
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPECURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPECURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPECURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPECURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPECURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPECURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPECURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPECURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPECURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPECURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypeCurrencyCode;

    /**
     * An identifier for this taxation scheme.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
    private IdentifierType ID;

    /**
     * The name of this taxation scheme.
     */
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGEID")) })
    private NameType name;

    /**
     * A code signifying the type of tax.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "TAXTYPECODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "TAXTYPECODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "TAXTYPECODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "TAXTYPECODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "TAXTYPECODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "TAXTYPECODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "TAXTYPECODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "TAXTYPECODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "TAXTYPECODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "TAXTYPECODE_SCHEMEURI")) })
    private CodeType taxTypeCode;

    @Transient
    private AddressEntity jurisdictionRegionAddress;

    /**
     * ForeignKey
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "TAX_CATEGORY_ID")
    private TaxCategoryEntity taxCategory;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the codeTypeCurrencyCode
     */
    public CurrencyCodeType getCodeTypeCurrencyCode() {
        return codeTypeCurrencyCode;
    }

    /**
     * @param codeTypeCurrencyCode
     *            the codeTypeCurrencyCode to set
     */
    public void setCodeTypeCurrencyCode(CurrencyCodeType codeTypeCurrencyCode) {
        this.codeTypeCurrencyCode = codeTypeCurrencyCode;
    }

    /**
     * @return the iD
     */
    public IdentifierType getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierType iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public NameType getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(NameType name) {
        this.name = name;
    }

    /**
     * @return the taxTypeCode
     */
    public CodeType getTaxTypeCode() {
        return taxTypeCode;
    }

    /**
     * @param taxTypeCode
     *            the taxTypeCode to set
     */
    public void setTaxTypeCode(CodeType taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    /**
     * @return the jurisdictionRegionAddress
     */
    public AddressEntity getJurisdictionRegionAddress() {
        return jurisdictionRegionAddress;
    }

    /**
     * @param jurisdictionRegionAddress
     *            the jurisdictionRegionAddress to set
     */
    public void setJurisdictionRegionAddress(AddressEntity jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

    /**
     * @return the taxCategory
     */
    public TaxCategoryEntity getTaxCategory() {
        return taxCategory;
    }

    /**
     * @param taxCategory
     *            the taxCategory to set
     */
    public void setTaxCategory(TaxCategoryEntity taxCategory) {
        this.taxCategory = taxCategory;
    }
}
