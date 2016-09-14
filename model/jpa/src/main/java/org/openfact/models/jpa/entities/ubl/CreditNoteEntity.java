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
import javax.persistence.Transient;

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

	@Transient
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();

	@OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteBillingReferenceMappingEntity> billingReferences = new ArrayList<>();

	@OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteLineEntity> creditNoteLines = new ArrayList<>();

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private CustomerPartyEntity accountingCustomerParty;

	@Transient
	private CustomerPartyEntity buyerCustomerParty;

	@Transient
	private List<DeliveryEntity> deliveries = new ArrayList<>();

	@Transient
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity statementDocumentReference;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity originatorDocumentReference;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity contractDocumentReference;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity receiptDocumentReference;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity additionalDocumentReference;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteDocumentReferenceMappingEntity despatchDocumentReference;

	@Transient
	private ExchangeRateEntity paymentAlternativeExchangeRate;

	@Transient
	private ExchangeRateEntity paymentExchangeRate;

	@Transient
	private ExchangeRateEntity taxExchangeRate;

	@Transient
	private ExchangeRateEntity pricingExchangeRate;

	@OneToOne(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private CreditNoteMonetaryTotalMappingEntity legalMonetaryTotal;

	@Transient
	private List<OrderReferenceEntity> orderReferences = new ArrayList<>();

	@Transient
	private PartyEntity taxRepresentativeParty;

	@Transient
	private PartyEntity payeeParty;

	@Transient
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();

	@Transient
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();

	@Transient
	private PeriodEntity invoicePeriod;

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ResponseEntity discrepancyResponse;

	@OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteSignatureMappingEntity> signatures = new ArrayList<>();

	@Transient
	private SupplierPartyEntity sellerSupplierParty;

	@OneToOne(mappedBy = "creditNote", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private SupplierPartyEntity accountingSupplierParty;

	@OneToMany(mappedBy = "creditNote", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditNoteTaxTotalMappingEntity> taxTotals = new ArrayList<>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the accountingCost
	 */
	public TextType getAccountingCost() {
		return accountingCost;
	}

	/**
	 * @param accountingCost the accountingCost to set
	 */
	public void setAccountingCost(TextType accountingCost) {
		this.accountingCost = accountingCost;
	}

	/**
	 * @return the accountingCostCode
	 */
	public CodeType getAccountingCostCode() {
		return accountingCostCode;
	}

	/**
	 * @param accountingCostCode the accountingCostCode to set
	 */
	public void setAccountingCostCode(CodeType accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	/**
	 * @return the buyerReference
	 */
	public TextType getBuyerReference() {
		return buyerReference;
	}

	/**
	 * @param buyerReference the buyerReference to set
	 */
	public void setBuyerReference(TextType buyerReference) {
		this.buyerReference = buyerReference;
	}

	/**
	 * @return the copyIndicator
	 */
	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	/**
	 * @param copyIndicator the copyIndicator to set
	 */
	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	/**
	 * @return the creditNoteTypeCode
	 */
	public CodeType getCreditNoteTypeCode() {
		return creditNoteTypeCode;
	}

	/**
	 * @param creditNoteTypeCode the creditNoteTypeCode to set
	 */
	public void setCreditNoteTypeCode(CodeType creditNoteTypeCode) {
		this.creditNoteTypeCode = creditNoteTypeCode;
	}

	/**
	 * @return the customizationID
	 */
	public IdentifierType getCustomizationID() {
		return customizationID;
	}

	/**
	 * @param customizationID the customizationID to set
	 */
	public void setCustomizationID(IdentifierType customizationID) {
		this.customizationID = customizationID;
	}

	/**
	 * @return the documentCurrencyCode
	 */
	public CurrencyCodeType getDocumentCurrencyCode() {
		return documentCurrencyCode;
	}

	/**
	 * @param documentCurrencyCode the documentCurrencyCode to set
	 */
	public void setDocumentCurrencyCode(CurrencyCodeType documentCurrencyCode) {
		this.documentCurrencyCode = documentCurrencyCode;
	}

	/**
	 * @return the iD
	 */
	public IdentifierType getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(IdentifierType iD) {
		ID = iD;
	}

	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the issueTime
	 */
	public LocalTime getIssueTime() {
		return issueTime;
	}

	/**
	 * @param issueTime the issueTime to set
	 */
	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	/**
	 * @return the lineCountNumeric
	 */
	public BigDecimal getLineCountNumeric() {
		return lineCountNumeric;
	}

	/**
	 * @param lineCountNumeric the lineCountNumeric to set
	 */
	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	/**
	 * @return the note
	 */
	public TextType getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(TextType note) {
		this.note = note;
	}

	/**
	 * @return the paymentAlternativeCurrencyCode
	 */
	public CurrencyCodeType getPaymentAlternativeCurrencyCode() {
		return paymentAlternativeCurrencyCode;
	}

	/**
	 * @param paymentAlternativeCurrencyCode the paymentAlternativeCurrencyCode to set
	 */
	public void setPaymentAlternativeCurrencyCode(CurrencyCodeType paymentAlternativeCurrencyCode) {
		this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
	}

	/**
	 * @return the paymentCurrencyCode
	 */
	public CurrencyCodeType getPaymentCurrencyCode() {
		return paymentCurrencyCode;
	}

	/**
	 * @param paymentCurrencyCode the paymentCurrencyCode to set
	 */
	public void setPaymentCurrencyCode(CurrencyCodeType paymentCurrencyCode) {
		this.paymentCurrencyCode = paymentCurrencyCode;
	}

	/**
	 * @return the pricingCurrencyCode
	 */
	public CurrencyCodeType getPricingCurrencyCode() {
		return pricingCurrencyCode;
	}

	/**
	 * @param pricingCurrencyCode the pricingCurrencyCode to set
	 */
	public void setPricingCurrencyCode(CurrencyCodeType pricingCurrencyCode) {
		this.pricingCurrencyCode = pricingCurrencyCode;
	}

	/**
	 * @return the profileExecutionID
	 */
	public IdentifierType getProfileExecutionID() {
		return profileExecutionID;
	}

	/**
	 * @param profileExecutionID the profileExecutionID to set
	 */
	public void setProfileExecutionID(IdentifierType profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	/**
	 * @return the profileID
	 */
	public IdentifierType getProfileID() {
		return profileID;
	}

	/**
	 * @param profileID the profileID to set
	 */
	public void setProfileID(IdentifierType profileID) {
		this.profileID = profileID;
	}

	/**
	 * @return the taxCurrencyCode
	 */
	public CurrencyCodeType getTaxCurrencyCode() {
		return taxCurrencyCode;
	}

	/**
	 * @param taxCurrencyCode the taxCurrencyCode to set
	 */
	public void setTaxCurrencyCode(CurrencyCodeType taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
	}

	/**
	 * @return the taxPointDate
	 */
	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	/**
	 * @param taxPointDate the taxPointDate to set
	 */
	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	/**
	 * @return the uBLVersionID
	 */
	public IdentifierType getUBLVersionID() {
		return UBLVersionID;
	}

	/**
	 * @param uBLVersionID the uBLVersionID to set
	 */
	public void setUBLVersionID(IdentifierType uBLVersionID) {
		UBLVersionID = uBLVersionID;
	}

	/**
	 * @return the uUID
	 */
	public IdentifierType getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(IdentifierType uUID) {
		UUID = uUID;
	}

	/**
	 * @return the allowanceCharges
	 */
	public List<AllowanceChargeEntity> getAllowanceCharges() {
		return allowanceCharges;
	}

	/**
	 * @param allowanceCharges the allowanceCharges to set
	 */
	public void setAllowanceCharges(List<AllowanceChargeEntity> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	/**
	 * @return the billingReferences
	 */
	public List<CreditNoteBillingReferenceMappingEntity> getBillingReferences() {
		return billingReferences;
	}

	/**
	 * @param billingReferences the billingReferences to set
	 */
	public void setBillingReferences(List<CreditNoteBillingReferenceMappingEntity> billingReferences) {
		this.billingReferences = billingReferences;
	}

	/**
	 * @return the creditNoteLines
	 */
	public List<CreditNoteLineEntity> getCreditNoteLines() {
		return creditNoteLines;
	}

	/**
	 * @param creditNoteLines the creditNoteLines to set
	 */
	public void setCreditNoteLines(List<CreditNoteLineEntity> creditNoteLines) {
		this.creditNoteLines = creditNoteLines;
	}

	/**
	 * @return the accountingCustomerParty
	 */
	public CustomerPartyEntity getAccountingCustomerParty() {
		return accountingCustomerParty;
	}

	/**
	 * @param accountingCustomerParty the accountingCustomerParty to set
	 */
	public void setAccountingCustomerParty(CustomerPartyEntity accountingCustomerParty) {
		this.accountingCustomerParty = accountingCustomerParty;
	}

	/**
	 * @return the buyerCustomerParty
	 */
	public CustomerPartyEntity getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	/**
	 * @param buyerCustomerParty the buyerCustomerParty to set
	 */
	public void setBuyerCustomerParty(CustomerPartyEntity buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	/**
	 * @return the deliveries
	 */
	public List<DeliveryEntity> getDeliveries() {
		return deliveries;
	}

	/**
	 * @param deliveries the deliveries to set
	 */
	public void setDeliveries(List<DeliveryEntity> deliveries) {
		this.deliveries = deliveries;
	}

	/**
	 * @return the deliveriesTerms
	 */
	public List<DeliveryTermsEntity> getDeliveriesTerms() {
		return deliveriesTerms;
	}

	/**
	 * @param deliveriesTerms the deliveriesTerms to set
	 */
	public void setDeliveriesTerms(List<DeliveryTermsEntity> deliveriesTerms) {
		this.deliveriesTerms = deliveriesTerms;
	}

	/**
	 * @return the statementDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getStatementDocumentReference() {
		return statementDocumentReference;
	}

	/**
	 * @param statementDocumentReference the statementDocumentReference to set
	 */
	public void setStatementDocumentReference(CreditNoteDocumentReferenceMappingEntity statementDocumentReference) {
		this.statementDocumentReference = statementDocumentReference;
	}

	/**
	 * @return the originatorDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getOriginatorDocumentReference() {
		return originatorDocumentReference;
	}

	/**
	 * @param originatorDocumentReference the originatorDocumentReference to set
	 */
	public void setOriginatorDocumentReference(CreditNoteDocumentReferenceMappingEntity originatorDocumentReference) {
		this.originatorDocumentReference = originatorDocumentReference;
	}

	/**
	 * @return the contractDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getContractDocumentReference() {
		return contractDocumentReference;
	}

	/**
	 * @param contractDocumentReference the contractDocumentReference to set
	 */
	public void setContractDocumentReference(CreditNoteDocumentReferenceMappingEntity contractDocumentReference) {
		this.contractDocumentReference = contractDocumentReference;
	}

	/**
	 * @return the receiptDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getReceiptDocumentReference() {
		return receiptDocumentReference;
	}

	/**
	 * @param receiptDocumentReference the receiptDocumentReference to set
	 */
	public void setReceiptDocumentReference(CreditNoteDocumentReferenceMappingEntity receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}

	/**
	 * @return the additionalDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	/**
	 * @param additionalDocumentReference the additionalDocumentReference to set
	 */
	public void setAdditionalDocumentReference(CreditNoteDocumentReferenceMappingEntity additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	/**
	 * @return the despatchDocumentReference
	 */
	public CreditNoteDocumentReferenceMappingEntity getDespatchDocumentReference() {
		return despatchDocumentReference;
	}

	/**
	 * @param despatchDocumentReference the despatchDocumentReference to set
	 */
	public void setDespatchDocumentReference(CreditNoteDocumentReferenceMappingEntity despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}

	/**
	 * @return the paymentAlternativeExchangeRate
	 */
	public ExchangeRateEntity getPaymentAlternativeExchangeRate() {
		return paymentAlternativeExchangeRate;
	}

	/**
	 * @param paymentAlternativeExchangeRate the paymentAlternativeExchangeRate to set
	 */
	public void setPaymentAlternativeExchangeRate(ExchangeRateEntity paymentAlternativeExchangeRate) {
		this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
	}

	/**
	 * @return the paymentExchangeRate
	 */
	public ExchangeRateEntity getPaymentExchangeRate() {
		return paymentExchangeRate;
	}

	/**
	 * @param paymentExchangeRate the paymentExchangeRate to set
	 */
	public void setPaymentExchangeRate(ExchangeRateEntity paymentExchangeRate) {
		this.paymentExchangeRate = paymentExchangeRate;
	}

	/**
	 * @return the taxExchangeRate
	 */
	public ExchangeRateEntity getTaxExchangeRate() {
		return taxExchangeRate;
	}

	/**
	 * @param taxExchangeRate the taxExchangeRate to set
	 */
	public void setTaxExchangeRate(ExchangeRateEntity taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
	}

	/**
	 * @return the pricingExchangeRate
	 */
	public ExchangeRateEntity getPricingExchangeRate() {
		return pricingExchangeRate;
	}

	/**
	 * @param pricingExchangeRate the pricingExchangeRate to set
	 */
	public void setPricingExchangeRate(ExchangeRateEntity pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	/**
	 * @return the legalMonetaryTotal
	 */
	public CreditNoteMonetaryTotalMappingEntity getLegalMonetaryTotal() {
		return legalMonetaryTotal;
	}

	/**
	 * @param legalMonetaryTotal the legalMonetaryTotal to set
	 */
	public void setLegalMonetaryTotal(CreditNoteMonetaryTotalMappingEntity legalMonetaryTotal) {
		this.legalMonetaryTotal = legalMonetaryTotal;
	}

	/**
	 * @return the orderReferences
	 */
	public List<OrderReferenceEntity> getOrderReferences() {
		return orderReferences;
	}

	/**
	 * @param orderReferences the orderReferences to set
	 */
	public void setOrderReferences(List<OrderReferenceEntity> orderReferences) {
		this.orderReferences = orderReferences;
	}

	/**
	 * @return the taxRepresentativeParty
	 */
	public PartyEntity getTaxRepresentativeParty() {
		return taxRepresentativeParty;
	}

	/**
	 * @param taxRepresentativeParty the taxRepresentativeParty to set
	 */
	public void setTaxRepresentativeParty(PartyEntity taxRepresentativeParty) {
		this.taxRepresentativeParty = taxRepresentativeParty;
	}

	/**
	 * @return the payeeParty
	 */
	public PartyEntity getPayeeParty() {
		return payeeParty;
	}

	/**
	 * @param payeeParty the payeeParty to set
	 */
	public void setPayeeParty(PartyEntity payeeParty) {
		this.payeeParty = payeeParty;
	}

	/**
	 * @return the paymentMeanses
	 */
	public List<PaymentMeansEntity> getPaymentMeanses() {
		return paymentMeanses;
	}

	/**
	 * @param paymentMeanses the paymentMeanses to set
	 */
	public void setPaymentMeanses(List<PaymentMeansEntity> paymentMeanses) {
		this.paymentMeanses = paymentMeanses;
	}

	/**
	 * @return the paymentTermses
	 */
	public List<PaymentTermsEntity> getPaymentTermses() {
		return paymentTermses;
	}

	/**
	 * @param paymentTermses the paymentTermses to set
	 */
	public void setPaymentTermses(List<PaymentTermsEntity> paymentTermses) {
		this.paymentTermses = paymentTermses;
	}

	/**
	 * @return the invoicePeriod
	 */
	public PeriodEntity getInvoicePeriod() {
		return invoicePeriod;
	}

	/**
	 * @param invoicePeriod the invoicePeriod to set
	 */
	public void setInvoicePeriod(PeriodEntity invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	/**
	 * @return the discrepancyResponse
	 */
	public ResponseEntity getDiscrepancyResponse() {
		return discrepancyResponse;
	}

	/**
	 * @param discrepancyResponse the discrepancyResponse to set
	 */
	public void setDiscrepancyResponse(ResponseEntity discrepancyResponse) {
		this.discrepancyResponse = discrepancyResponse;
	}

	/**
	 * @return the signatures
	 */
	public List<CreditNoteSignatureMappingEntity> getSignatures() {
		return signatures;
	}

	/**
	 * @param signatures the signatures to set
	 */
	public void setSignatures(List<CreditNoteSignatureMappingEntity> signatures) {
		this.signatures = signatures;
	}

	/**
	 * @return the sellerSupplierParty
	 */
	public SupplierPartyEntity getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	/**
	 * @param sellerSupplierParty the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierPartyEntity sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	/**
	 * @return the accountingSupplierParty
	 */
	public SupplierPartyEntity getAccountingSupplierParty() {
		return accountingSupplierParty;
	}

	/**
	 * @param accountingSupplierParty the accountingSupplierParty to set
	 */
	public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
	}

	/**
	 * @return the taxTotals
	 */
	public List<CreditNoteTaxTotalMappingEntity> getTaxTotals() {
		return taxTotals;
	}

	/**
	 * @param taxTotals the taxTotals to set
	 */
	public void setTaxTotals(List<CreditNoteTaxTotalMappingEntity> taxTotals) {
		this.taxTotals = taxTotals;
	}


}
