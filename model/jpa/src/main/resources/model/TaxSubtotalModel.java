package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
public class TaxSubtotalModel{

	/**
	 * The unit of measure on which the tax calculation is based
	 */
	private MeasureType baseUnitMeasure; 
	/**
	 * The number of this tax subtotal in the sequence of subtotals corresponding to
	 * the order in which multiple taxes are applied. If all taxes are applied to the
	 * same taxable amount (i.e., their order of application is inconsequential), then
	 * CalculationSequenc
	 */
	private BigDecimal calculationSequenceNumeric; 
	/**
	 * The tax rate of the tax category applied to this tax subtotal, expressed as a
	 * percentage.
	 */
	private BigDecimal percent; 
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private BigDecimal perUnitAmount; 
	/**
	 * The net amount to which the tax percent (rate) is applied to calculate the tax
	 * amount.
	 */
	private BigDecimal taxableAmount; 
	/**
	 * The amount of this tax subtotal.
	 */
	private BigDecimal taxAmount; 
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax subtotal.
	 */
	private TextType tierRange; 
	/**
	 * Where a tax is tiered, the tax rate that applies within a specified range of
	 * taxable amounts for this tax subtotal.
	 */
	private BigDecimal tierRatePercent; 
	/**
	 * The amount of this tax subtotal, expressed in the currency used for invoicing.
	 */
	private BigDecimal transactionCurrencyTaxAmount; 
	private List<TaxCategoryModel> taxCategories = new ArrayList<>(); 

}
