package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
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
    private AmountType CallBaseAmount;
    /**
     * In the case of a telephone call, the date of the call.
     */
    private DateType CallDate;
    /**
     * The amount to be payed for the call
     */
    private AmountType CallExtensionAmount;
    /**
     * In the case of a telephone call, the time of the call.
     */
    private TimeType CallTime;
    /**
     * An identifier for this telecommunications service.
     */
    private IdentifierType ID;
    /**
     * The title of a movie delivered via this telecommunications service.
     */
    private TextType MovieTitle;
    /**
     * A pay-per-view delivered via this telecommunications service.
     */
    private TextType PayPerView;
    /**
     * The number of calls.
     */
    private QuantityType Quantity;
    /**
     * StatementEntity of the roaming partner name.
     */
    private NameType RoamingPartnerName;
    /**
     * In the case of a telephone call, the phone number called.
     */
    private TextType ServiceNumberCalled;
    /**
     * The telecommunications call described as a text
     */
    private TextType TelecommunicationsServiceCall;
    /**
     * The telecommunications call described as a code
     */
    private CodeType TelecommunicationsServiceCallCode;
    /**
     * The telecommunications category, expressed as text.
     */
    private TextType TelecommunicationsServiceCategory;
    /**
     * The telecommunications category, expressed as a code.
     */
    private CodeType TelecommunicationsServiceCategoryCode;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<CountryEntity> Countries = new ArrayList<>();
    private DutyEntity CallDuty;
    private DutyEntity TimeDuty;
    private List<ExchangeRateEntity> ExchangeRates = new ArrayList<>();
    private List<PriceEntity> Prices = new ArrayList<>();
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
