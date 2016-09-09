package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A scheduled prepayment (on-account payment) for a estimated utility consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class OnAccountPaymentEntity{

	/**
	 * The estimated consumed quantity covered by the payment.
	 */
	private QuantityType estimatedConsumedQuantity; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>(); 

}
