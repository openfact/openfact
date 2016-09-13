package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class for describing the terms and conditions applying to the delivery of
 * goods.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:23 a. m.
 */
public class DeliveryTermsRepresentation {

    /**
     * The monetary amount covered by these delivery terms.
     */
    private BigDecimal amount;
    /**
     * An identifier for this description of delivery terms.
     */
    private IdentifierRepresentation ID;
    /**
     * A description of responsibility for risk of loss in execution of the
     * delivery, expressed as text.
     */
    private TextRepresentation lossRisk;
    /**
     * A code that identifies one of various responsibilities for loss risk in
     * the execution of the delivery.
     */
    private CodeRepresentation lossRiskResponsibilityCode;
    /**
     * A description of any terms or conditions relating to the delivery items.
     */
    private TextRepresentation specialTerms;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private LocationRepresentation deliveryLocation;

}
