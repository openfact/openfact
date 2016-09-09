package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a hazardous item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItemAdapter{

	/**
	 * Text providing further information about the hazardous substance.
	 */
	private TextType additionalInformation; 
	/**
	 * The name of the category of hazard that applies to the Item.
	 */
	private NameType categoryName; 
	/**
	 * A code signifying the emergency procedures for this hazardous item.
	 */
	private CodeType emergencyProceduresCode; 
	/**
	 * An identifier for the hazard class applicable to this hazardous item as defined
	 * by the relevant regulation authority (e.g., the IMDG Class Number of the SOLAS
	 * Convention of IMO and the ADR/RID Class Number for the road/rail environment).
	 */
	private IdentifierType hazardClassID; 
	/**
	 * A code signifying a kind of hazard for a material.
	 */
	private CodeType hazardousCategoryCode; 
	/**
	 * An identifier for this hazardous item.
	 */
	private IdentifierType ID; 
	/**
	 * The number for the lower part of the orange hazard placard required on the
	 * means of transport.
	 */
	private IdentifierType lowerOrangeHazardPlacardID; 
	/**
	 * An identifier to the marking of the HazardousItem
	 */
	private IdentifierType markingID; 
	/**
	 * A code signifying a medical first aid guide appropriate to this hazardous item.
	 */
	private CodeType medicalFirstAidGuideCode; 
	/**
	 * The volume of this hazardous item, excluding packaging and transport equipment.
	 */
	private MeasureType netVolumeMeasure; 
	/**
	 * The net weight of this hazardous item, excluding packaging.
	 */
	private MeasureType netWeightMeasure; 
	/**
	 * Text of the placard endorsement that is to be shown on the shipping papers for
	 * this hazardous item. Can also be used for the number of the orange placard
	 * (lower part) required on the means of transport.
	 */
	private TextType placardEndorsement; 
	/**
	 * Text of the placard notation corresponding to the hazard class of this
	 * hazardous item. Can also be the hazard identification number of the orange
	 * placard (upper part) required on the means of transport.
	 */
	private TextType placardNotation; 
	/**
	 * The quantity of goods items in this hazardous item that are hazardous.
	 */
	private QuantityType quantity; 
	/**
	 * The full technical name of a specific hazardous substance contained in this
	 * goods item.
	 */
	private NameType technicalName; 
	/**
	 * The UN code for this kind of hazardous item.
	 */
	private CodeType UNDGCode; 
	/**
	 * The number for the upper part of the orange hazard placard required on the
	 * means of transport.
	 */
	private IdentifierType upperOrangeHazardPlacardID; 
	private List<HazardousGoodsTransitAdapter> hazardousGoodsTransits = new ArrayList<>(); 
	private PartyAdapter contactParty; 
	private List<SecondaryHazardAdapter> secondaryHazards = new ArrayList<>(); 
	private TemperatureAdapter emergencyTemperature; 
	private TemperatureAdapter additionalTemperature; 
	private TemperatureAdapter flashpointTemperature; 

}
