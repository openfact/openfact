package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategoryRepresentation {

    /**
     * A Unit of Measures used as the basic for the tax calculation applied at a
     * certain rate per unit.
     */
    private MeasureType baseUnitMeasure;
    /**
     * An identifier for this tax category.
     */
    private IdentifierType ID;
    /**
     * The name of this tax category.
     */
    private NameType name;
    /**
     * The tax rate for this category, expressed as a percentage.
     */
    private BigDecimal percent;
    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    private BigDecimal perUnitAmount;
    /**
     * The reason for tax being exempted, expressed as text.
     */
    private TextType taxExemptionReason;
    /**
     * The reason for tax being exempted, expressed as a code.
     */
    private CodeType taxExemptionReasonCode;
    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax category.
     */
    private TextType tierRange;
    /**
     * Where a tax is tiered, the tax rate that applies within the specified
     * range of taxable amounts for this tax category.
     */
    private BigDecimal tierRatePercent;
    private List<TaxSchemeRepresentation> taxSchemes = new ArrayList<>();

}