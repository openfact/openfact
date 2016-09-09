package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class that outlines the telecommunication supply in details
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLineEntity {

    /**
     * The description of the telecommunication supply line
     */
    private TextType Description;
    /**
     * An identifier for this telecommunications supply line.
     */
    private IdentifierType ID;
    /**
     * An amount specifying the cost of this telecommunication line
     */
    private AmountType LineExtensionAmount;
    /**
     * The phone number used for this telecommunication supply line
     */
    private TextType PhoneNumber;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<ExchangeRateEntity> ExchangeRates = new ArrayList<>();
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();
    private List<TelecommunicationsServiceEntity> TelecommunicationsServices = new ArrayList<>();

}
