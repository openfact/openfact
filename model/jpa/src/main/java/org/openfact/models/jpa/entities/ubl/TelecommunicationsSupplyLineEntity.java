package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

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
    private TextType description;
    /**
     * An identifier for this telecommunications supply line.
     */
    private IdentifierType ID;
    /**
     * An amount specifying the cost of this telecommunication line
     */
    private BigDecimal lineExtensionAmount;
    /**
     * The phone number used for this telecommunication supply line
     */
    private TextType phoneNumber;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<ExchangeRateEntity> exchangeRates = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();
    private List<TelecommunicationsServiceEntity> telecommunicationsServices = new ArrayList<>();

}
