package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsServiceRepresentation {

    /**
     * The amount to be payed as the base for one call
     */
    private BigDecimal callBaseAmount;
    /**
     * In the case of a telephone call, the date of the call.
     */
    private LocalDate callDate;
    /**
     * The amount to be payed for the call
     */
    private BigDecimal callExtensionAmount;
    /**
     * In the case of a telephone call, the time of the call.
     */
    private LocalTime callTime;
    /**
     * An identifier for this telecommunications service.
     */
    private IdentifierRepresentation ID;
    /**
     * The title of a movie delivered via this telecommunications service.
     */
    private TextRepresentation movieTitle;
    /**
     * A pay-per-view delivered via this telecommunications service.
     */
    private TextRepresentation payPerView;
    /**
     * The number of calls.
     */
    private QuantityRepresentation quantity;
    /**
     * StatementRepresentation of the roaming partner name.
     */
    private NameRepresentation roamingPartnerName;
    /**
     * In the case of a telephone call, the phone number called.
     */
    private TextRepresentation serviceNumberCalled;
    /**
     * The telecommunications call described as a text
     */
    private TextRepresentation telecommunicationsServiceCall;
    /**
     * The telecommunications call described as a code
     */
    private CodeRepresentation telecommunicationsServiceCallCode;
    /**
     * The telecommunications category, expressed as text.
     */
    private TextRepresentation telecommunicationsServiceCategory;
    /**
     * The telecommunications category, expressed as a code.
     */
    private CodeRepresentation telecommunicationsServiceCategoryCode;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<CountryRepresentation> countries = new ArrayList<>();
    private DutyRepresentation callDuty;
    private DutyRepresentation timeDuty;
    private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
    private List<PriceRepresentation> prices = new ArrayList<>();
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
