package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a set of codes that describes a retail tactic.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:59 a. m.
 */
public class EventTacticEnumerationAdapter{

	/**
	 * A code signifying the type of consumer incentive. Examples include:Free Item,
	 * Temporary PriceAdapter reduction
	 */
	private CodeType consumerIncentiveTacticTypeCode;
	/**
	 * A code signifying the type of display. Examples Include: ON_COUNTER_DISPLAY,
	 * FLOOR_GRAPHICS FLOOR_STACK_DISPLAY
	 */
	private CodeType displayTacticTypeCode;
	/**
	 * A code signifying a special feature. Examples Include: BILLBOARD DIRECT_MAIL_AD,
	 * FLYER
	 */
	private CodeType featureTacticTypeCode;
	/**
	 * A code signifying the type of trade item packing and labeling. Examples Include:
	 * BONUS_SIZE CO_BRANDED_TRADE_ITEM
	 */
	private CodeType tradeItemPackingLabelingTypeCode;

}
