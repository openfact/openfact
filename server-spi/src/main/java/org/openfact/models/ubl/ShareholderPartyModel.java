package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a shareholder party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:42 a. m.
 */
public class ShareholderPartyModel {

    /**
     * The shareholder participation, expressed as a percentage.
     */
    private BigDecimal partecipationPercent;
    private List<PartyModel> parties = new ArrayList<>();

}
