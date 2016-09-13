package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class that outlines the telecommunication supply in details
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLineModel {

    /**
     * The description of the telecommunication supply line
     */
    private TextModel description;
    /**
     * An identifier for this telecommunications supply line.
     */
    private IdentifierModel ID;
    /**
     * An amount specifying the cost of this telecommunication line
     */
    private BigDecimal lineExtensionAmount;
    /**
     * The phone number used for this telecommunication supply line
     */
    private TextModel phoneNumber;
    private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
    private List<ExchangeRateModel> exchangeRates = new ArrayList<>();
    private List<TaxTotalModel> taxTotals = new ArrayList<>();
    private List<TelecommunicationsServiceModel> telecommunicationsServices = new ArrayList<>();

}
