package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;

/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or
 * a change in inventory policy) upon supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpactEntity {

    /**
     * Estimated monetary value of the planned event as an impact
     */
    private AmountType Amount;
    /**
     * It will have impact on either Sales forecast or OrderEntity Forecast
     */
    private CodeType ForecastPurposeCode;
    /**
     * A code signifying the type of forecast. Examples of values are: BASE
     * PROMOTIONAL SEASONAL TOTAL
     */
    private CodeType ForecastTypeCode;
    private List<PeriodEntity> Periods = new ArrayList<>();

}
