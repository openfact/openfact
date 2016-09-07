package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a set of codes that describes a retail tactic.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:59 a. m.
 */
public class EventTacticEnumeration {

	/**
	 * A code signifying the type of consumer incentive. Examples include:Free Item,
	 * Temporary Price reduction
	 */
	private Code. Type ConsumerIncentiveTacticTypeCode;
	/**
	 * A code signifying the type of display. Examples Include: ON_COUNTER_DISPLAY,
	 * FLOOR_GRAPHICS FLOOR_STACK_DISPLAY
	 */
	private Code. Type DisplayTacticTypeCode;
	/**
	 * A code signifying a special feature. Examples Include: BILLBOARD DIRECT_MAIL_AD,
	 * FLYER
	 */
	private Code. Type FeatureTacticTypeCode;
	/**
	 * A code signifying the type of trade item packing and labeling. Examples Include:
	 * BONUS_SIZE CO_BRANDED_TRADE_ITEM
	 */
	private Code. Type TradeItemPackingLabelingTypeCode;

	public Event Tactic Enumeration(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getConsumerIncentiveTacticTypeCode(){
		return ConsumerIncentiveTacticTypeCode;
	}

	public Code. Type getDisplayTacticTypeCode(){
		return DisplayTacticTypeCode;
	}

	public Code. Type getFeatureTacticTypeCode(){
		return FeatureTacticTypeCode;
	}

	public Code. Type getTradeItemPackingLabelingTypeCode(){
		return TradeItemPackingLabelingTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumerIncentiveTacticTypeCode(Code. Type newVal){
		ConsumerIncentiveTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDisplayTacticTypeCode(Code. Type newVal){
		DisplayTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeatureTacticTypeCode(Code. Type newVal){
		FeatureTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTradeItemPackingLabelingTypeCode(Code. Type newVal){
		TradeItemPackingLabelingTypeCode = newVal;
	}
}//end Event Tactic Enumeration