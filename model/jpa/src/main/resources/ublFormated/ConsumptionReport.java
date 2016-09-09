package org.openfact.models.jpa.entities.ubl;
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
public class ConsumptionReport{

	/**
	 * The basic quantity consumed, excluding additional consumption.
	 */
	private QuantityType BasicConsumedQuantity;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as text.
	 */
	private TextType ConsumersEnergyLevel;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as a code.
	 */
	private CodeType ConsumersEnergyLevelCode;
	/**
	 * The type of consumption, expressed as text.
	 */
	private TextType ConsumptionType;
	/**
	 * The type of consumption, expressed as a code.
	 */
	private CodeType ConsumptionTypeCode;
	/**
	 * Text reporting utility consumption.
	 */
	private TextType Description;
	/**
	 * The type of heating in the residence covered in this report, expressed as text.
	 */
	private TextType HeatingType;
	/**
	 * The type of heating in the residence covered in this report, expressed as a
	 * code.
	 */
	private CodeType HeatingTypeCode;
	/**
	 * An identifier for this consumption report.
	 */
	private IdentifierType ID;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as text.
	 */
	private TextType ResidenceType;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as a code.
	 */
	private CodeType ResidenceTypeCode;
	/**
	 * The number of people occupying the residence covered by this report.
	 */
	private NumericType ResidentOccupantsNumeric;
	/**
	 * The total quantity consumed.
	 */
	private QuantityType TotalConsumedQuantity;
	private List<ConsumptionHistory> ConsumptionHistories = new ArrayList<>();
	private List<ConsumptionReport> ReferenceConsumptionReportReferences = new ArrayList<>();
	private List<DocumentReference> GuidanceDocumentReference = new ArrayList<>();
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<Period> Periods = new ArrayList<>();

}
