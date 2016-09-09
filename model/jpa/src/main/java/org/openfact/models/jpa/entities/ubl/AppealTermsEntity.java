package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe the terms and conditions, set by the contracting
 * authority, under which an appeal can be lodged for a tender award.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:45 a. m.
 */
public class AppealTermsEntity {

    /**
     * Text describing the terms of an appeal.
     */
    private TextType Description;
    private PartyEntity AppealInformationParty;
    private PartyEntity MediationParty;
    private PartyEntity AppealReceiverParty;
    private PeriodEntity PresentationPeriod;

}
