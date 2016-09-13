package org.openfact.representations.idm.ubl;

import java.time.LocalDate;

import org.openfact.representations.idm.ubl.type.ChipCodeRepresentation;
import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;

/**
 * A class to define a credit card, debit card, or charge card account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccountRepresentation {

    /**
     * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
     */
    private ChipCodeRepresentation codeTypeCardChipCode;
    /**
     * A mutually agreed code signifying the type of card. Examples of types are
     * "debit", "credit" and "purchasing"
     */
    private CodeRepresentation cardTypeCode;
    /**
     * An identifier on the chip card for the application that provides the
     * quoted information; an AID (application ID).
     */
    private IdentifierRepresentation chipApplicationID;
    /**
     * An identifier for the Card Verification Value (often found on the reverse
     * of the card itself).
     */
    private IdentifierRepresentation CV2ID;
    /**
     * The date on which the card expires.
     */
    private LocalDate expiryDate;
    /**
     * The name of the cardholder.
     */
    private NameRepresentation holderName;
    /**
     * An identifier for the card, specified by the issuer.
     */
    private IdentifierRepresentation issueNumberID;
    /**
     * An identifier for the institution issuing the card.
     */
    private IdentifierRepresentation issuerID;
    /**
     * An identifier for the financial service network provider of the card.
     */
    private IdentifierRepresentation networkID;
    /**
     * An identifier of the card (e.g., the Primary Account Number (PAN)).
     */
    private IdentifierRepresentation primaryAccountNumberID;
    /**
     * The date from which the card is valid.
     */
    private LocalDate validityStartDate;

}
