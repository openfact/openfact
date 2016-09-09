package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe possible extensions to a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:03 a. m.
 */
public class ContractExtensionEntity {

    /**
     * The maximum allowed number of contract extensions.
     */
    private NumericType MaximumNumberNumeric;
    /**
     * The fixed minimum number of contract extensions or renewals.
     */
    private NumericType MinimumNumberNumeric;
    /**
     * A description for the possible options that can be carried out during the
     * execution of the contract.
     */
    private TextType OptionsDescription;
    private PeriodEntity OptionValidityPeriod;
    private List<RenewalEntity> Renewals = new ArrayList<>();

}
