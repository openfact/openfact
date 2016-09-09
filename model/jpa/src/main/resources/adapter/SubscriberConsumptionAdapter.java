package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The consumption for a specific party for given consumption point provided by a
 * numbers of suppliers. An enterprise can have one utility statement for several
 * parties (e.g. a ministry of defence receiving a telephone bill). In this way
 * each subscriber cons
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:57 a. m.
 */
public class SubscriberConsumptionAdapter{

	/**
	 * The identifier tor this specification.
	 */
	private IdentifierType consumptionID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * The code which specifies the type of this specification, e.g. an on account
	 * specification or the yearly specification.
	 */
	private CodeType specificationTypeCode; 
	/**
	 * The total quantity consumed, as calculated from meter readings.
	 */
	private QuantityType totalMeteredQuantity; 
	private List<ConsumptionAdapter> consumptions = new ArrayList<>(); 
	private ConsumptionPointAdapter utilityConsumptionPoint; 
	private List<OnAccountPaymentAdapter> onAccountPayments = new ArrayList<>(); 
	private PartyAdapter subscriberParty; 
	private List<SupplierConsumptionAdapter> supplierconsumptions = new ArrayList<>(); 

}
