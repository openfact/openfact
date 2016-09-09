package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a specific capability of an organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:15 a. m.
 */
public class CapabilityEntity {

    /**
     * This class can be used as Financial or Technical capabilities. For
     * instance, "Turnover" or "Qualified Engineers" are two possible codes.
     */
    private CodeType CapabilityTypeCode;
    /**
     * Text describing this capability.
     */
    private TextType Description;
    /**
     * A monetary amount as a measure of this capability.
     */
    private AmountType ValueAmount;
    /**
     * A quantity as a measure of this capability.
     */
    private QuantityType ValueQuantity;
    private List<EvidenceSuppliedEntity> EvidenceSupplieds = new ArrayList<>();
    private PeriodEntity ValidityPeriod;

}
