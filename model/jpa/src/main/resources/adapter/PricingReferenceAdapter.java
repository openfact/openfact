package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A reference to the basis for pricing. This may be based on a catalogue or a
 * quoted amount from a price list and include some alternative pricing conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:57 a. m.
 */
public class PricingReferenceAdapter{

	private ItemLocationQuantityAdapter originalItemLocationQuantity; 
	private PriceAdapter alternativeConditionPrice; 

}
