package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.amountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.PercentType;
import org.openfact.models.jpa.entities.ublType.rateType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe subcontract terms for a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:55 a. m.
 */
public class SubcontractTermsEntity {

    /**
     * The monetary amount assigned to the subcontracted task.
     */
    private amountType amount;
    /**
     * Text describing the subcontract terms.
     */
    private TextType description;
    /**
     * The maximum percentage allowed to be subcontracted.
     */
    private PercentType maximumPercent;
    /**
     * The minimum percentage allowed to be subcontracted.
     */
    private PercentType minimumPercent;
    /**
     * MF: I agree with the query. rate?
     */
    private rateType rate;
    /**
     * A code specifying the conditions for subcontracting.
     */
    private CodeType subcontractingConditionsCode;
    /**
     * An indicator that the subcontract price is known (true) or not (false).
     */
    private IndicatorType unknownPriceIndicator;

}
