package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A scheduled prepayment (on-account payment) for a estimated utility
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class OnAccountPaymentModel {

    /**
     * The estimated consumed quantity covered by the payment.
     */
    private QuantityModel estimatedConsumedQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();

}
