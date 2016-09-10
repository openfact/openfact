package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * The charging rate used for both call charging and time dependent charging
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class DutyRepresentation {

    /**
     * The amount of this duty.
     */
    private BigDecimal amount;
    /**
     * Text describing this duty.
     */
    private TextType duty;
    /**
     * The type of this charge rate, expressed as a code.
     */
    private CodeType dutyCode;
    private List<TaxCategoryRepresentation> taxCategories = new ArrayList<>();

}
