package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class for describing the terms and conditions applying to the delivery of
 * goods.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:23 a. m.
 */
public class DeliveryTermsEntity {

    /**
     * The monetary amount covered by these delivery terms.
     */
    private AmountType Amount;
    /**
     * An identifier for this description of delivery terms.
     */
    private IdentifierType ID;
    /**
     * A description of responsibility for risk of loss in execution of the
     * delivery, expressed as text.
     */
    private TextType LossRisk;
    /**
     * A code that identifies one of various responsibilities for loss risk in
     * the execution of the delivery.
     */
    private CodeType LossRiskResponsibilityCode;
    /**
     * A description of any terms or conditions relating to the delivery items.
     */
    private TextType SpecialTerms;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private LocationEntity DeliveryLocation;

}
