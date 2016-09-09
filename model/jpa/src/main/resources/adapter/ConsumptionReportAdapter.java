package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe utility consumption, including details of the environment
 * in which consumption takes place.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:55 a. m.
 */
public class ConsumptionReportAdapter{

	/**
	 * The basic quantity consumed, excluding additional consumption.
	 */
	private QuantityType basicConsumedQuantity; 
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as text.
	 */
	private TextType consumersEnergyLevel; 
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as a code.
	 */
	private CodeType consumersEnergyLevelCode; 
	/**
	 * The type of consumption, expressed as text.
	 */
	private TextType consumptionType; 
	/**
	 * The type of consumption, expressed as a code.
	 */
	private CodeType consumptionTypeCode; 
	/**
	 * Text reporting utility consumption.
	 */
	private TextType description; 
	/**
	 * The type of heating in the residence covered in this report, expressed as text.
	 */
	private TextType heatingType; 
	/**
	 * The type of heating in the residence covered in this report, expressed as a
	 * code.
	 */
	private CodeType heatingTypeCode; 
	/**
	 * An identifier for this consumption report.
	 */
	private IdentifierType ID; 
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as text.
	 */
	private TextType residenceType; 
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as a code.
	 */
	private CodeType residenceTypeCode; 
	/**
	 * The number of people occupying the residence covered by this report.
	 */
	private BigDecimal residentOccupantsNumeric; 
	/**
	 * The total quantity consumed.
	 */
	private QuantityType totalConsumedQuantity; 
	private List<ConsumptionHistoryAdapter> consumptionHistories = new ArrayList<>(); 
	private List<ConsumptionReportAdapter> referenceConsumptionReportReferences = new ArrayList<>(); 
	private List<DocumentReferenceAdapter> guidanceDocumentReference = new ArrayList<>(); 
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>(); 
	private List<PeriodAdapter> periods = new ArrayList<>(); 

}
