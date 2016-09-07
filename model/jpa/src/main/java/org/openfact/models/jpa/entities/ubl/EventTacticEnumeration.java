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
	private String ConsumerIncentiveTacticTypeCode;
	/**
	 * A code signifying the type of display. Examples Include: ON_COUNTER_DISPLAY,
	 * FLOOR_GRAPHICS FLOOR_STACK_DISPLAY
	 */
	private String DisplayTacticTypeCode;
	/**
	 * A code signifying a special feature. Examples Include: BILLBOARD DIRECT_MAIL_AD,
	 * FLYER
	 */
	private String FeatureTacticTypeCode;
	/**
	 * A code signifying the type of trade item packing and labeling. Examples Include:
	 * BONUS_SIZE CO_BRANDED_TRADE_ITEM
	 */
	private String TradeItemPackingLabelingTypeCode;

	public Event Tactic Enumeration(){

	}

	public void finalize() throws Throwable {

	}
	public String getConsumerIncentiveTacticTypeCode(){
		return ConsumerIncentiveTacticTypeCode;
	}

	public String getDisplayTacticTypeCode(){
		return DisplayTacticTypeCode;
	}

	public String getFeatureTacticTypeCode(){
		return FeatureTacticTypeCode;
	}

	public String getTradeItemPackingLabelingTypeCode(){
		return TradeItemPackingLabelingTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumerIncentiveTacticTypeCode(String newVal){
		ConsumerIncentiveTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDisplayTacticTypeCode(String newVal){
		DisplayTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFeatureTacticTypeCode(String newVal){
		FeatureTacticTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTradeItemPackingLabelingTypeCode(String newVal){
		TradeItemPackingLabelingTypeCode = newVal;
	}
}//end Event Tactic Enumeration