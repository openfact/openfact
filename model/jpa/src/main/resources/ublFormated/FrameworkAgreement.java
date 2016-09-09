package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a tendering framework agreement.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreement{

	/**
	 * The number of economic operators expected to participate in this framework
	 * agreement.
	 */
	private QuantityType ExpectedOperatorQuantity;
	/**
	 * Text describing the frequency with which subsequent contracts will be awarded.
	 */
	private TextType Frequency;
	/**
	 * Text describing the justification for this framework agreement.
	 */
	private TextType Justification;
	/**
	 * The maximum number of economic operators allowed to participate in this
	 * framework agreement.
	 */
	private QuantityType MaximumOperatorQuantity;
	private Period DurationPeriod;
	private TenderRequirement SubsequentProcessTenderRequirement;

}
