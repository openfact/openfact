package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */

public class InvoiceLineEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as
	 * text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTING_COST_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTING_COST_LANGUAJE_ID")) })
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a
	 * code.
	 */
	private CodeType accountingCostCode;
	/**
	 * An indicator that this invoice line is free of charge (true) or not
	 * (false). The default is false.
	 */
	private boolean freeOfChargeIndicator;
	/**
	 * An identifier for this invoice line.
	 */
	private IdentifierType ID;
	/**
	 * The quantity (of items) on this invoice line.
	 */
	private QuantityType invoicedQuantity;
	/**
	 * The total amount for this invoice line, including allowance charges but
	 * net of taxes.
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
	 * The date of this invoice line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
	private List<ItemEntity> items = new ArrayList<>();
	private LineReferenceEntity despatchLineReference;
	private LineReferenceEntity receiptLineReference;
	private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
	private PartyEntity originatorParty;
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	private PeriodEntity invoicePeriod;
	private InvoiceLineEntity subInvoiceLine;
	private List<PriceEntity> prices = new ArrayList<>();
	private PriceExtensionEntity itemPriceExtension;
	private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
	private List<TaxTotalEntity> withholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
