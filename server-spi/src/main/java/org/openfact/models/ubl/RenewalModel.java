package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the renewal of a commercial arrangement, such as a
 * contract or licence fee.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:26 a. m.
 */
public class RenewalModel {

    /**
     * The monetary amount of this renewal.
     */
    private BigDecimal amount;
    private List<PeriodModel> periods = new ArrayList<>();

}
