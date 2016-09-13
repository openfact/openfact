package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the terms to be fulfilled by tenderers if an auction is
 * to be executed before the awarding of a tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:49 a. m.
 */
public class AuctionTermsRepresentation {

    /**
     * Indicates whether an electronic auction will be used before the awarding
     * of a contract (true) or not (false).
     */
    private boolean auctionConstraintIndicator;
    /**
     * The Uniform Resource Identifier (URI) of the electronic device used for
     * the auction.
     */
    private IdentifierRepresentation auctionURIID;
    /**
     * Text describing the conditions under which the tenderers will be able to
     * bid as part of the auction.
     */
    private TextRepresentation conditionsDescription;
    /**
     * Text for tenderers describing terms governing the auction.
     */
    private TextRepresentation description;
    /**
     * Text describing an electronic device used for the auction, including
     * associated connectivity specifications.
     */
    private TextRepresentation electronicDeviceDescription;
    /**
     * Text describing a justification for the use of an auction in awarding the
     * tender.
     */
    private TextRepresentation justificationDescription;
    /**
     * Text describing the auction process.
     */
    private TextRepresentation processDescription;

}
