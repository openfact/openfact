package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * The charging rate used for both call charging and time dependent charging
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class DutyEntity {

    /**
     * The amount of this duty.
     */
    private AmountType Amount;
    /**
     * Text describing this duty.
     */
    private TextType Duty;
    /**
     * The type of this charge rate, expressed as a code.
     */
    private CodeType DutyCode;
    private List<TaxCategoryEntity> TaxCategories = new ArrayList<>();

}
