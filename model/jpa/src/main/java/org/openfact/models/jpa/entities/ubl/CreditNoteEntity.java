package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.CurrencyCodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A document used to specify credits due to the Debtor from the Creditor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:25 a. m.
 */
@Entity
@Table(name = "CREDIT_NOTE")
public class CreditNoteEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The buyer's accounting code, applied to the CreditNoteEntity as a whole,
	 * expressed as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOST_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOST_LANGUAGEID")) })
	private TextType accountingCost;
	/**
	 * The buyer's accounting code, applied to the CreditNoteEntity as a whole.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOSTCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ACCOUNTINGCOSTCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOSTCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTSCHEMEURI")) })
	private CodeType accountingCostCode;
	/**
	 * A reference provided by the buyer used for internal routing of the
	 * document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BUYREFERENCE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "BUYREFERENCE_ID")) })
	private TextType buyerReference;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "COPY_INDICATOR")
	private boolean copyIndicator;
	/**
	 * A code signifying the type of the CreditNote.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CREDITNOTETYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "CREDITNOTETYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "CREDITNOTETYPECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "CREDITNOTETYPECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "CREDITNOTETYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "CREDITNOTETYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "CREDITNOTETYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CREDITNOTETYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "CREDITNOTETYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "CREDITNOTETYPECODE_LISTSCHEMEURI")) })
	private CodeType creditNoteTypeCode;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CUSTOMIZATIONID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "CUSTOMIZATIONID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "CUSTOMIZATIONID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "CUSTOMIZATIONID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "CUSTOMIZATIONID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "CUSTOMIZATIONID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "CUSTOMIZATIONID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "CUSTOMIZATIONID_SCHEMEURI")) })
	private IdentifierType customizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTCURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "DOCUMENTCURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "DOCUMENTCURRENCYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "DOCUMENTCURRENCYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "DOCUMENTCURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "DOCUMENTCURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "DOCUMENTCURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTCURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "DOCUMENTCURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "DOCUMENTCURRENCYCODE_SCHEMEURI")) })
	private CurrencyCodeType documentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "ISSUE_DATE")
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	@Type(type = "org.hibernate.type.LocalTimeType")
	@Column(name = "ISSUE_TIME")
	private LocalTime issueTime;
	/**
	 * The number of creditNoteLines in the document.
	 */
	@Column(name = "LINE_COUNT_NUMERIC")
	private BigDecimal lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NOTE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NOTE_LANGUAGE")) })
	private TextType note;
	/**
	 * A code signifying the alternative currency used for payment in the
	 * CreditNote.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PAYMENTALTERNATIVECURRENCYCODE_SCHEMEURI")) })
	private CurrencyCodeType paymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the CreditNote.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTCURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PAYMENTCURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PAYMENTCURRENCYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PAYMENTCURRENCYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PAYMENTCURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PAYMENTCURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PAYMENTCURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTCURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PAYMENTCURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PAYMENTCURRENCYCODE_SCHEMEURI")) })
	private CurrencyCodeType paymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the CreditNote.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PEPRICINGCURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PEPRICINGCURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PEPRICINGCURRENCYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PEPRICINGCURRENCYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PEPRICINGCURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PEPRICINGCURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PEPRICINGCURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PEPRICINGCURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PEPRICINGCURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PEPRICINGCURRENCYCODE_SCHEMEURI")) })
	private CurrencyCodeType pricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PROFILEEXECUTIONID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "PROFILEEXECUTIONID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "PROFILEEXECUTIONID_SCHEMEURI")) })
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PROFILEID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "PROFILEID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "PROFILEID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "PROFILEID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "PROFILEID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "PROFILEID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "PROFILEID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "PROFILEID_SCHEMEURI")) })
	private IdentifierType profileID;
	/**
	 * A code signifying the currency used for tax amounts in the CreditNote.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "TAXCURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "TAXCURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "TAXCURRENCYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "TAXCURRENCYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "TAXCURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "TAXCURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "TAXCURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "TAXCURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "TAXCURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "TAXCURRENCYCODE_SCHEMEURI")) })
	private CurrencyCodeType taxCurrencyCode;
	/**
	 * The date of the CreditNote, used to indicate the point at which tax
	 * becomes applicable.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "TAX_POINT_DATE")
	private LocalDate taxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "UBLVERSIONID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "UBLVERSIONID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "UBLVERSIONID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "UBLVERSIONID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "UBLVERSIONID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "UBLVERSIONID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "UBLVERSIONID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "UBLVERSIONID_SCHEMEURI")) })
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "UUID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "UUID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "UUID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "UUID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "UUID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "UUID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "UUID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "UUID_SCHEMEURI")) })
	private IdentifierType UUID;

	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	
	@OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteLineEntity> creditNoteLines = new ArrayList<>();

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private CustomerPartyEntity accountingCustomerParty;

	private CustomerPartyEntity buyerCustomerParty;
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceEntity statementDocumentReference;
	private DocumentReferenceEntity originatorDocumentReference;
	private DocumentReferenceEntity contractDocumentReference;
	private DocumentReferenceEntity receiptDocumentReference;
	private DocumentReferenceEntity additionalDocumentReference;
	private DocumentReferenceEntity despatchDocumentReference;
	private ExchangeRateEntity paymentAlternativeExchangeRate;
	private ExchangeRateEntity paymentExchangeRate;
	private ExchangeRateEntity taxExchangeRate;
	private ExchangeRateEntity pricingExchangeRate;
	private MonetaryTotalEntity legalMonetaryTotal;
	private List<OrderReferenceEntity> orderReferences = new ArrayList<>();
	private PartyEntity taxRepresentativeParty;
	private PartyEntity payeeParty;
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	private PeriodEntity invoicePeriod;

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ResponseEntity discrepancyResponse;

	private List<SignatureEntity> signatures = new ArrayList<>();
	private SupplierPartyEntity sellerSupplierParty;

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private SupplierPartyEntity accountingSupplierParty;

	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
