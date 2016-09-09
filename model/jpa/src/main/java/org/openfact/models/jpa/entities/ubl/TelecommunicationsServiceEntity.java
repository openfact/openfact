package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

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
    private AmountType callBaseAmount;
    /**
     * In the case of a telephone call, the date of the call.
     */
    private DateType callDate;
    /**
     * The amount to be payed for the call
     */
    private AmountType callExtensionAmount;
    /**
     * In the case of a telephone call, the time of the call.
     */
    private TimeType callTime;
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
    private quantityType quantity;
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
