package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.MeasureType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.PercentType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategoryEntity {

    /**
     * A Unit of Measures used as the basic for the tax calculation applied at a
     * certain rate per unit.
     */
    private MeasureType BaseUnitMeasure;
    /**
     * An identifier for this tax category.
     */
    private IdentifierType ID;
    /**
     * The name of this tax category.
     */
    private NameType Name;
    /**
     * The tax rate for this category, expressed as a percentage.
     */
    private PercentType Percent;
    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    private AmountType PerUnitAmount;
    /**
     * The reason for tax being exempted, expressed as text.
     */
    private TextType TaxExemptionReason;
    /**
     * The reason for tax being exempted, expressed as a code.
     */
    private CodeType TaxExemptionReasonCode;
    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax category.
     */
    private TextType TierRange;
    /**
     * Where a tax is tiered, the tax rate that applies within the specified
     * range of taxable amounts for this tax category.
     */
    private PercentType TierRatePercent;
    private List<TaxSchemeEntity> TaxSchemes = new ArrayList<>();

}
