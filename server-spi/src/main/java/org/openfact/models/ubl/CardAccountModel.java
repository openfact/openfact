package org.openfact.models.ubl;

import java.time.LocalDate;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a credit card, debit card, or charge card account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:16 a. m.
 */
public class CardAccountModel {

    /**
     * A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.
     */
    private ChipCodeModel codeTypeCardChipCode;
    /**
     * A mutually agreed code signifying the type of card. Examples of types are
     * "debit", "credit" and "purchasing"
     */
    private CodeModel cardTypeCode;
    /**
     * An identifier on the chip card for the application that provides the
     * quoted information; an AID (application ID).
     */
    private IdentifierModel chipApplicationID;
    /**
     * An identifier for the Card Verification Value (often found on the reverse
     * of the card itself).
     */
    private IdentifierModel CV2ID;
    /**
     * The date on which the card expires.
     */
    private LocalDate expiryDate;
    /**
     * The name of the cardholder.
     */
    private NameModel holderName;
    /**
     * An identifier for the card, specified by the issuer.
     */
    private IdentifierModel issueNumberID;
    /**
     * An identifier for the institution issuing the card.
     */
    private IdentifierModel issuerID;
    /**
     * An identifier for the financial service network provider of the card.
     */
    private IdentifierModel networkID;
    /**
     * An identifier of the card (e.g., the Primary Account Number (PAN)).
     */
    private IdentifierModel primaryAccountNumberID;
    /**
     * The date from which the card is valid.
     */
    private LocalDate validityStartDate;

}
