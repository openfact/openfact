package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a specific capability of an organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:15 a. m.
 */
public class CapabilityModel {

    /**
     * This class can be used as Financial or Technical capabilities. For
     * instance, "Turnover" or "Qualified Engineers" are two possible codes.
     */
    private CodeModel capabilityTypeCode;
    /**
     * Text describing this capability.
     */
    private TextModel description;
    /**
     * A monetary amount as a measure of this capability.
     */
    private BigDecimal valueAmount;
    /**
     * A quantity as a measure of this capability.
     */
    private QuantityModel valueQuantity;
    private List<EvidenceSuppliedModel> evidenceSupplieds = new ArrayList<>();
    private PeriodModel validityPeriod;

}
