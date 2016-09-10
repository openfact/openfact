package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsServiceEntity {

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
    private IdentifierType ID;
    /**
     * The title of a movie delivered via this telecommunications service.
     */
    private TextType movieTitle;
    /**
     * A pay-per-view delivered via this telecommunications service.
     */
    private TextType payPerView;
    /**
     * The number of calls.
     */
    private QuantityType quantity;
    /**
     * StatementEntity of the roaming partner name.
     */
    private NameType roamingPartnerName;
    /**
     * In the case of a telephone call, the phone number called.
     */
    private TextType serviceNumberCalled;
    /**
     * The telecommunications call described as a text
     */
    private TextType telecommunicationsServiceCall;
    /**
     * The telecommunications call described as a code
     */
    private CodeType telecommunicationsServiceCallCode;
    /**
     * The telecommunications category, expressed as text.
     */
    private TextType telecommunicationsServiceCategory;
    /**
     * The telecommunications category, expressed as a code.
     */
    private CodeType telecommunicationsServiceCategoryCode;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<CountryEntity> countries = new ArrayList<>();
    private DutyEntity callDuty;
    private DutyEntity timeDuty;
    private List<ExchangeRateEntity> exchangeRates = new ArrayList<>();
    private List<PriceEntity> prices = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
