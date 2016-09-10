package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private CodeType capabilityTypeCode;
    /**
     * Text describing this capability.
     */
    private TextType description;
    /**
     * A monetary amount as a measure of this capability.
     */
    private BigDecimal valueAmount;
    /**
     * A quantity as a measure of this capability.
     */
    private QuantityType valueQuantity;
    private List<EvidenceSuppliedRepresentation> evidenceSupplieds = new ArrayList<>();
    private PeriodRepresentation validityPeriod;

}
