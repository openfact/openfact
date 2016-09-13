package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a specific capability of an organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:15 a. m.
 */
public class CapabilityRepresentation {

    /**
     * This class can be used as Financial or Technical capabilities. For
     * instance, "Turnover" or "Qualified Engineers" are two possible codes.
     */
    private CodeRepresentation capabilityTypeCode;
    /**
     * Text describing this capability.
     */
    private TextRepresentation description;
    /**
     * A monetary amount as a measure of this capability.
     */
    private BigDecimal valueAmount;
    /**
     * A quantity as a measure of this capability.
     */
    private QuantityRepresentation valueQuantity;
    private List<EvidenceSuppliedRepresentation> evidenceSupplieds = new ArrayList<>();
    private PeriodRepresentation validityPeriod;

}
