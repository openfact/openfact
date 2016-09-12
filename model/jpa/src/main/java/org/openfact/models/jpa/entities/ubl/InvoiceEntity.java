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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.CurrencyCodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A document used to request payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */

@Entity
@Table(name = "INVOICE")
public class InvoiceEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    /**
     * The buyer's accounting code, applied to the InvoiceEntity as a whole,
     * expressed as text.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOST_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOST_LANGUAGE")) })
    private TextType accountingCost;

    /**
     * The buyer's accounting code, applied to the InvoiceEntity as a whole.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTINGCOSTCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "ACCOUNTINGCOSTCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "ACCOUNTINGCOSTCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "ACCOUNTINGCOSTCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTINGCOSTCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "ACCOUNTINGCOSTCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "ACCOUNTINGCOSTCODE_SCHEMEURI")) })
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
     * Identifies a user-defined customization of UBL for a specific use.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CUSTOMIZATIONID_VALUE")),
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
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPEDOCUMENTCURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypeDocumentCurrencyCode;

    /**
     * The date on which InvoiceEntity is due.
     */
    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

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
     * A code signifying the type of the Invoice.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "INVOICETYPECODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "INVOICETYPECODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "INVOICETYPECODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "INVOICETYPECODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "INVOICETYPECODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "INVOICETYPECODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "INVOICETYPECODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "INVOICETYPECODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "INVOICETYPECODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "INVOICETYPECODE_SCHEMEURI")) })
    private CodeType invoiceTypeCode;

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
     * The number of lines in the document.
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
     * Invoice.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPEPAYMENTALTERNATIVECURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode;

    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPEPAYMENTCURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypePaymentCurrencyCode;

    /**
     * A code signifying the currency used for prices in the Invoice.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPEPRICINGCURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypePricingCurrencyCode;

    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "PROFILEEXECUTIONID_VALUE")),
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
     * A code signifying the currency used for tax amounts in the Invoice.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "CODETYPETAXCURRENCYCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "CODETYPETAXCURRENCYCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "CODETYPETAXCURRENCYCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "CODETYPETAXCURRENCYCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "CODETYPETAXCURRENCYCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "CODETYPETAXCURRENCYCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "CODETYPETAXCURRENCYCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "CODETYPETAXCURRENCYCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "CODETYPETAXCURRENCYCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "CODETYPETAXCURRENCYCODE_SCHEMEURI")) })
    private CurrencyCodeType codeTypeTaxCurrencyCode;

    /**
     * The date of the Invoice, used to indicate the point at which tax becomes
     * applicable.
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

    @Transient
    private List<BillingReferenceEntity> billingReferences = new ArrayList<>();

    @Transient
    private CustomerPartyEntity accountingCustomerParty;

    @Transient
    private CustomerPartyEntity buyerCustomerParty;

    @Transient
    private List<DeliveryEntity> deliveries = new ArrayList<>();

    @Transient
    private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();

    @Transient
    private DocumentReferenceEntity statementDocumentReference;

    @Transient
    private DocumentReferenceEntity receiptDocumentReference;

    @Transient
    private DocumentReferenceEntity despatchDocumentReference;

    @Transient
    private DocumentReferenceEntity originatorDocumentReference;

    @Transient
    private DocumentReferenceEntity contractDocumentReference;

    @Transient
    private DocumentReferenceEntity additionalDocumentReference;

    @Transient
    private ExchangeRateEntity taxExchangeRate;

    @Transient
    private ExchangeRateEntity pricingExchangeRate;

    @Transient
    private ExchangeRateEntity paymentExchangeRate;

    @Transient
    private ExchangeRateEntity paymentAlternativeExchangeRate;

    @Transient
    private List<InvoiceLineEntity> invoiceLines = new ArrayList<>();

    @Transient
    private MonetaryTotalEntity legalMonetaryTotal;

    @Transient
    private List<OrderReferenceEntity> orderReferences = new ArrayList<>();

    @Transient
    private PartyEntity taxRepresentativeParty;

    @Transient
    private PartyEntity payeeParty;

    @Transient
    private PaymentEntity prepaidPayment;

    @Transient
    private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();

    @Transient
    private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();

    @Transient
    private PeriodEntity invoicePeriod;

    @Transient
    private List<ProjectReferenceEntity> projectReferences = new ArrayList<>();

    @Transient
    private List<SignatureEntity> signatures = new ArrayList<>();

    @Transient
    private SupplierPartyEntity accountingSupplierParty;

    @Transient
    private SupplierPartyEntity sellerSupplierParty;

    @Transient
    private List<TaxTotalEntity> withholdingTaxTotal = new ArrayList<>();

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceTaxTotalMappingEntity> taxTotalsMappings = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
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
     * @param accountingCost
     *            the accountingCost to set
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
     * @param accountingCostCode
     *            the accountingCostCode to set
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
     * @param buyerReference
     *            the buyerReference to set
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
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public IdentifierType getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(IdentifierType customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the codeTypeDocumentCurrencyCode
     */
    public CurrencyCodeType getCodeTypeDocumentCurrencyCode() {
        return codeTypeDocumentCurrencyCode;
    }

    /**
     * @param codeTypeDocumentCurrencyCode
     *            the codeTypeDocumentCurrencyCode to set
     */
    public void setCodeTypeDocumentCurrencyCode(CurrencyCodeType codeTypeDocumentCurrencyCode) {
        this.codeTypeDocumentCurrencyCode = codeTypeDocumentCurrencyCode;
    }

    /**
     * @return the dueDate
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate
     *            the dueDate to set
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the iD
     */
    public IdentifierType getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierType iD) {
        ID = iD;
    }

    /**
     * @return the invoiceTypeCode
     */
    public CodeType getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * @param invoiceTypeCode
     *            the invoiceTypeCode to set
     */
    public void setInvoiceTypeCode(CodeType invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
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
     * @param issueTime
     *            the issueTime to set
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
     * @param lineCountNumeric
     *            the lineCountNumeric to set
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
     * @param note
     *            the note to set
     */
    public void setNote(TextType note) {
        this.note = note;
    }

    /**
     * @return the codeTypePaymentAlternativeCurrencyCode
     */
    public CurrencyCodeType getCodeTypePaymentAlternativeCurrencyCode() {
        return codeTypePaymentAlternativeCurrencyCode;
    }

    /**
     * @param codeTypePaymentAlternativeCurrencyCode
     *            the codeTypePaymentAlternativeCurrencyCode to set
     */
    public void setCodeTypePaymentAlternativeCurrencyCode(
            CurrencyCodeType codeTypePaymentAlternativeCurrencyCode) {
        this.codeTypePaymentAlternativeCurrencyCode = codeTypePaymentAlternativeCurrencyCode;
    }

    /**
     * @return the codeTypePaymentCurrencyCode
     */
    public CurrencyCodeType getCodeTypePaymentCurrencyCode() {
        return codeTypePaymentCurrencyCode;
    }

    /**
     * @param codeTypePaymentCurrencyCode
     *            the codeTypePaymentCurrencyCode to set
     */
    public void setCodeTypePaymentCurrencyCode(CurrencyCodeType codeTypePaymentCurrencyCode) {
        this.codeTypePaymentCurrencyCode = codeTypePaymentCurrencyCode;
    }

    /**
     * @return the codeTypePricingCurrencyCode
     */
    public CurrencyCodeType getCodeTypePricingCurrencyCode() {
        return codeTypePricingCurrencyCode;
    }

    /**
     * @param codeTypePricingCurrencyCode
     *            the codeTypePricingCurrencyCode to set
     */
    public void setCodeTypePricingCurrencyCode(CurrencyCodeType codeTypePricingCurrencyCode) {
        this.codeTypePricingCurrencyCode = codeTypePricingCurrencyCode;
    }

    /**
     * @return the profileExecutionID
     */
    public IdentifierType getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
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
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(IdentifierType profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the codeTypeTaxCurrencyCode
     */
    public CurrencyCodeType getCodeTypeTaxCurrencyCode() {
        return codeTypeTaxCurrencyCode;
    }

    /**
     * @param codeTypeTaxCurrencyCode
     *            the codeTypeTaxCurrencyCode to set
     */
    public void setCodeTypeTaxCurrencyCode(CurrencyCodeType codeTypeTaxCurrencyCode) {
        this.codeTypeTaxCurrencyCode = codeTypeTaxCurrencyCode;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
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
     * @param uBLVersionID
     *            the uBLVersionID to set
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
     * @param uUID
     *            the uUID to set
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
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceChargeEntity> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the billingReferences
     */
    public List<BillingReferenceEntity> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReferenceEntity> billingReferences) {
        this.billingReferences = billingReferences;
    }

    /**
     * @return the accountingCustomerParty
     */
    public CustomerPartyEntity getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    /**
     * @param accountingCustomerParty
     *            the accountingCustomerParty to set
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
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
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
     * @param deliveries
     *            the deliveries to set
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
     * @param deliveriesTerms
     *            the deliveriesTerms to set
     */
    public void setDeliveriesTerms(List<DeliveryTermsEntity> deliveriesTerms) {
        this.deliveriesTerms = deliveriesTerms;
    }

    /**
     * @return the statementDocumentReference
     */
    public DocumentReferenceEntity getStatementDocumentReference() {
        return statementDocumentReference;
    }

    /**
     * @param statementDocumentReference
     *            the statementDocumentReference to set
     */
    public void setStatementDocumentReference(DocumentReferenceEntity statementDocumentReference) {
        this.statementDocumentReference = statementDocumentReference;
    }

    /**
     * @return the receiptDocumentReference
     */
    public DocumentReferenceEntity getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    /**
     * @param receiptDocumentReference
     *            the receiptDocumentReference to set
     */
    public void setReceiptDocumentReference(DocumentReferenceEntity receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    /**
     * @return the despatchDocumentReference
     */
    public DocumentReferenceEntity getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    /**
     * @param despatchDocumentReference
     *            the despatchDocumentReference to set
     */
    public void setDespatchDocumentReference(DocumentReferenceEntity despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    /**
     * @return the originatorDocumentReference
     */
    public DocumentReferenceEntity getOriginatorDocumentReference() {
        return originatorDocumentReference;
    }

    /**
     * @param originatorDocumentReference
     *            the originatorDocumentReference to set
     */
    public void setOriginatorDocumentReference(DocumentReferenceEntity originatorDocumentReference) {
        this.originatorDocumentReference = originatorDocumentReference;
    }

    /**
     * @return the contractDocumentReference
     */
    public DocumentReferenceEntity getContractDocumentReference() {
        return contractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(DocumentReferenceEntity contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReferenceEntity getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReferenceEntity additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the taxExchangeRate
     */
    public ExchangeRateEntity getTaxExchangeRate() {
        return taxExchangeRate;
    }

    /**
     * @param taxExchangeRate
     *            the taxExchangeRate to set
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
     * @param pricingExchangeRate
     *            the pricingExchangeRate to set
     */
    public void setPricingExchangeRate(ExchangeRateEntity pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    /**
     * @return the paymentExchangeRate
     */
    public ExchangeRateEntity getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    /**
     * @param paymentExchangeRate
     *            the paymentExchangeRate to set
     */
    public void setPaymentExchangeRate(ExchangeRateEntity paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    /**
     * @return the paymentAlternativeExchangeRate
     */
    public ExchangeRateEntity getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    /**
     * @param paymentAlternativeExchangeRate
     *            the paymentAlternativeExchangeRate to set
     */
    public void setPaymentAlternativeExchangeRate(ExchangeRateEntity paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
    }

    /**
     * @return the invoiceLines
     */
    public List<InvoiceLineEntity> getInvoiceLines() {
        return invoiceLines;
    }

    /**
     * @param invoiceLines
     *            the invoiceLines to set
     */
    public void setInvoiceLines(List<InvoiceLineEntity> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    /**
     * @return the legalMonetaryTotal
     */
    public MonetaryTotalEntity getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * @param legalMonetaryTotal
     *            the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotalEntity legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    /**
     * @return the orderReferences
     */
    public List<OrderReferenceEntity> getOrderReferences() {
        return orderReferences;
    }

    /**
     * @param orderReferences
     *            the orderReferences to set
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
     * @param taxRepresentativeParty
     *            the taxRepresentativeParty to set
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
     * @param payeeParty
     *            the payeeParty to set
     */
    public void setPayeeParty(PartyEntity payeeParty) {
        this.payeeParty = payeeParty;
    }

    /**
     * @return the prepaidPayment
     */
    public PaymentEntity getPrepaidPayment() {
        return prepaidPayment;
    }

    /**
     * @param prepaidPayment
     *            the prepaidPayment to set
     */
    public void setPrepaidPayment(PaymentEntity prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    /**
     * @return the paymentMeanses
     */
    public List<PaymentMeansEntity> getPaymentMeanses() {
        return paymentMeanses;
    }

    /**
     * @param paymentMeanses
     *            the paymentMeanses to set
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
     * @param paymentTermses
     *            the paymentTermses to set
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
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(PeriodEntity invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the projectReferences
     */
    public List<ProjectReferenceEntity> getProjectReferences() {
        return projectReferences;
    }

    /**
     * @param projectReferences
     *            the projectReferences to set
     */
    public void setProjectReferences(List<ProjectReferenceEntity> projectReferences) {
        this.projectReferences = projectReferences;
    }

    /**
     * @return the signatures
     */
    public List<SignatureEntity> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<SignatureEntity> signatures) {
        this.signatures = signatures;
    }

    /**
     * @return the accountingSupplierParty
     */
    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    /**
     * @param accountingSupplierParty
     *            the accountingSupplierParty to set
     */
    public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    /**
     * @return the sellerSupplierParty
     */
    public SupplierPartyEntity getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierPartyEntity sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

    /**
     * @return the withholdingTaxTotal
     */
    public List<TaxTotalEntity> getWithholdingTaxTotal() {
        return withholdingTaxTotal;
    }

    /**
     * @param withholdingTaxTotal
     *            the withholdingTaxTotal to set
     */
    public void setWithholdingTaxTotal(List<TaxTotalEntity> withholdingTaxTotal) {
        this.withholdingTaxTotal = withholdingTaxTotal;
    }

    /**
     * @return the taxTotalsMappings
     */
    public List<InvoiceTaxTotalMappingEntity> getTaxTotalsMappings() {
        return taxTotalsMappings;
    }

    /**
     * @param taxTotalsMappings
     *            the taxTotalsMappings to set
     */
    public void setTaxTotalsMappings(List<InvoiceTaxTotalMappingEntity> taxTotalsMappings) {
        this.taxTotalsMappings = taxTotalsMappings;
    }

}
