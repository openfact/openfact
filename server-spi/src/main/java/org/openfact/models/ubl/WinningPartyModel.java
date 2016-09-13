package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A party that is identified as the awarded by a tender result.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:59 a. m.
 */
public class WinningPartyModel {

    /**
     * Indicates the rank obtained in the award.
     */
    private TextModel rank;
    private List<PartyModel> parties = new ArrayList<>();

}
