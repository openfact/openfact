package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.ChipCodeType;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;

/**
 * A class to define a credit card, debit card, or charge card account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
@Entity
@Table(name = "CARD_ACCOUNT")
public class CardAccountEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;
    /**
     * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CARDCHIPCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CARDCHIPCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CARDCHIPCODE_LISTAGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CARDCHIPCODE_LISTAGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CARDCHIPCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CARDCHIPCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CARDCHIPCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CARDCHIPCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CARDCHIPCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CARDCHIPCODE_LISTSCHEMEURI")) })
    private ChipCodeType cardChipCode;
    /**
     * A mutually agreed code signifying the type of card. Examples of types are
     * "debit", "credit" and "purchasing"
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CARDTYPECODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CARDTYPECODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CARDTYPECODE_LISTAGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CARDTYPECODE_LISTAGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CARDTYPECODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CARDTYPECODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CARDTYPECODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CARDTYPECODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CARDTYPECODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CARDTYPECODE_LISTSCHEMEURI")) })
    private CodeType cardTypeCode;
    /**
     * An identifier on the chip card for the application that provides the
     * quoted information; an AID (application ID).
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CHIPAPPLICATIONID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "CHIPAPPLICATIONID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "CHIPAPPLICATIONID_SCHEMEURI")) })
    private IdentifierType chipApplicationID;
    /**
     * An identifier for the Card Verification Value (often found on the reverse
     * of the card itself).
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CV2ID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "CV2ID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "CV2ID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "CV2ID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "CV2ID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "CV2ID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "CV2ID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "CV2ID_SCHEMEURI")) })
    private IdentifierType CV2ID;
    /**
     * The date on which the card expires.
     */
    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;
    /**
     * The name of the cardholder.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "HOLDERNAME_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "HOLDERNAME_LANGUAGE_ID")) })
    private NameType holderName;
    /**
     * An identifier for the card, specified by the issuer.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ISSUENUMBERID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "ISSUENUMBERID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "ISSUENUMBERID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ISSUENUMBERID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ISSUENUMBERID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "ISSUENUMBERID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "ISSUENUMBERID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "ISSUENUMBERID_SCHEMEURI")) })
    private IdentifierType issueNumberID;
    /**
     * An identifier for the institution issuing the card.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ISSUERID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "ISSUERID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "ISSUERID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ISSUERID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ISSUERID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "ISSUERID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "ISSUERID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "ISSUERID_SCHEMEURI")) })
    private IdentifierType issuerID;
    /**
     * An identifier for the financial service network provider of the card.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NETWORKID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "NETWORKID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "NETWORKID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "NETWORKID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "NETWORKID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "NETWORKID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "NETWORKID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "NETWORKID_SCHEMEURI")) })
    private IdentifierType networkID;
    /**
     * An identifier of the card (e.g., the Primary Account Number (PAN)).
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "PRIMARYACCOUNTNUMBERID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEDATAURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "PRIMARYACCOUNTNUMBERID_SCHEMEURI")) })
    private IdentifierType primaryAccountNumberID;
    /**
     * The date from which the card is valid.
     */
    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "VALIDITY_START_DATE")
    private LocalDate validityStartDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "PAYMENT_MEANS_ID")
    private PaymentMeansEntity paymentMeans;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChipCodeType getCardChipCode() {
        return cardChipCode;
    }

    public void setCardChipCode(ChipCodeType cardChipCode) {
        this.cardChipCode = cardChipCode;
    }

    public CodeType getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(CodeType cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    public IdentifierType getChipApplicationID() {
        return chipApplicationID;
    }

    public void setChipApplicationID(IdentifierType chipApplicationID) {
        this.chipApplicationID = chipApplicationID;
    }

    public IdentifierType getCV2ID() {
        return CV2ID;
    }

    public void setCV2ID(IdentifierType cV2ID) {
        CV2ID = cV2ID;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public NameType getHolderName() {
        return holderName;
    }

    public void setHolderName(NameType holderName) {
        this.holderName = holderName;
    }

    public IdentifierType getIssueNumberID() {
        return issueNumberID;
    }

    public void setIssueNumberID(IdentifierType issueNumberID) {
        this.issueNumberID = issueNumberID;
    }

    public IdentifierType getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(IdentifierType issuerID) {
        this.issuerID = issuerID;
    }

    public IdentifierType getNetworkID() {
        return networkID;
    }

    public void setNetworkID(IdentifierType networkID) {
        this.networkID = networkID;
    }

    public IdentifierType getPrimaryAccountNumberID() {
        return primaryAccountNumberID;
    }

    public void setPrimaryAccountNumberID(IdentifierType primaryAccountNumberID) {
        this.primaryAccountNumberID = primaryAccountNumberID;
    }

    public LocalDate getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(LocalDate validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public PaymentMeansEntity getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(PaymentMeansEntity paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

}
