package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A reference to the basis for pricing. This may be based on a catalogue or a
 * quoted amount from a price list and include some alternative pricing
 * conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:57 a. m.
 */
public class PricingReference {

	private ItemLocationQuantity originalItemLocationQuantity;
	private Price alternativeConditionPrice;

	public PricingReference() {

	}

	public void finalize() throws Throwable {

	}

	public ItemLocationQuantity getOriginalItemLocationQuantity() {
		return originalItemLocationQuantity;
	}

	public void setOriginalItemLocationQuantity(ItemLocationQuantity originalItemLocationQuantity) {
		this.originalItemLocationQuantity = originalItemLocationQuantity;
	}

	public Price getAlternativeConditionPrice() {
		return alternativeConditionPrice;
	}

	public void setAlternativeConditionPrice(Price alternativeConditionPrice) {
		this.alternativeConditionPrice = alternativeConditionPrice;
	}
}// end Pricing Reference