package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a set of codes that describes a retail tactic.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:59 a. m.
 */
public class EventTacticEnumeration {

	/**
	 * A code signifying the type of consumer incentive. Examples include:Free
	 * Item, Temporary Price reduction
	 */
	private String consumerIncentiveTacticTypeCode;
	/**
	 * A code signifying the type of display. Examples Include:
	 * ON_COUNTER_DISPLAY, FLOOR_GRAPHICS FLOOR_STACK_DISPLAY
	 */
	private String displayTacticTypeCode;
	/**
	 * A code signifying a special feature. Examples Include: BILLBOARD
	 * DIRECT_MAIL_AD, FLYER
	 */
	private String featureTacticTypeCode;
	/**
	 * A code signifying the type of trade item packing and labeling. Examples
	 * Include: BONUS_SIZE CO_BRANDED_TRADE_ITEM
	 */
	private String tradeItemPackingLabelingTypeCode;

	public String getConsumerIncentiveTacticTypeCode() {
		return consumerIncentiveTacticTypeCode;
	}

	public void setConsumerIncentiveTacticTypeCode(String consumerIncentiveTacticTypeCode) {
		this.consumerIncentiveTacticTypeCode = consumerIncentiveTacticTypeCode;
	}

	public String getDisplayTacticTypeCode() {
		return displayTacticTypeCode;
	}

	public void setDisplayTacticTypeCode(String displayTacticTypeCode) {
		this.displayTacticTypeCode = displayTacticTypeCode;
	}

	public String getFeatureTacticTypeCode() {
		return featureTacticTypeCode;
	}

	public void setFeatureTacticTypeCode(String featureTacticTypeCode) {
		this.featureTacticTypeCode = featureTacticTypeCode;
	}

	public String getTradeItemPackingLabelingTypeCode() {
		return tradeItemPackingLabelingTypeCode;
	}

	public void setTradeItemPackingLabelingTypeCode(String tradeItemPackingLabelingTypeCode) {
		this.tradeItemPackingLabelingTypeCode = tradeItemPackingLabelingTypeCode;
	}
}// end Event Tactic Enumeration