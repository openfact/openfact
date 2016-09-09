package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to define a line in a CreditNoteEntity or SelfBilledCreditNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineEntity {

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as text.
	 */
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed
	 * as a code.
	 */
	private CodeType accountingCostCode;
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private QuantityType creditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not
	 * (false). The default is false.
	 */
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this credit note line, including allowance charges
	 * but exclusive of taxes.
	 */
	private BigDecimal lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType paymentPurposeCode;
	/**
	 * The date of this credit note line, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	private CreditNoteLineEntity subCreditNoteLine;
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
	private List<ItemEntity> items = new ArrayList<>();
	private LineReferenceEntity receiptLineReference;
	private LineReferenceEntity despatchLineReference;
	private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
	private PartyEntity originatorParty;
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	private PeriodEntity invoicePeriod;
	private List<PriceEntity> prices = new ArrayList<>();
	private PriceExtensionEntity itemPriceExtension;
	private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
	private ResponseEntity discrepancyResponse;
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
