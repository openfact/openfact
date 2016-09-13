package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the terms and conditions, set by the contracting
 * authority, under which an appeal can be lodged for a tender award.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:45 a. m.
 */
public class AppealTermsModel {

    /**
     * Text describing the terms of an appeal.
     */
    private TextModel description;
    private PartyModel appealInformationParty;
    private PartyModel mediationParty;
    private PartyModel appealReceiverParty;
    private PeriodModel presentationPeriod;

}
