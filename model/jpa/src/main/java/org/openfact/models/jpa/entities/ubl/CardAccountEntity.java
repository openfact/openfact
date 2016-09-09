package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.ChipCodeType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;

/**
 * A class to define a credit card, debit card, or charge card account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccountEntity {

    /**
     * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
     */
    private ChipCodeType CodeTypeCardChipCode;
    /**
     * A mutually agreed code signifying the type of card. Examples of types are
     * "debit", "credit" and "purchasing"
     */
    private CodeType CardTypeCode;
    /**
     * An identifier on the chip card for the application that provides the
     * quoted information; an AID (application ID).
     */
    private IdentifierType ChipApplicationID;
    /**
     * An identifier for the Card Verification Value (often found on the reverse
     * of the card itself).
     */
    private IdentifierType CV2ID;
    /**
     * The date on which the card expires.
     */
    private DateType ExpiryDate;
    /**
     * The name of the cardholder.
     */
    private NameType HolderName;
    /**
     * An identifier for the card, specified by the issuer.
     */
    private IdentifierType IssueNumberID;
    /**
     * An identifier for the institution issuing the card.
     */
    private IdentifierType IssuerID;
    /**
     * An identifier for the financial service network provider of the card.
     */
    private IdentifierType NetworkID;
    /**
     * An identifier of the card (e.g., the Primary Account Number (PAN)).
     */
    private IdentifierType PrimaryAccountNumberID;
    /**
     * The date from which the card is valid.
     */
    private DateType ValidityStartDate;

}
