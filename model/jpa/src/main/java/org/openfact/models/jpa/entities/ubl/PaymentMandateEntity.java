package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a payment mandate.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
@Entity
@Table(name = "PAYMENT_MANDATE")
public class PaymentMandateEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for this payment mandate.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "MANDATETYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "MANDATETYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "MANDATETYPECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "MANDATETYPECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "MANDATETYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "MANDATETYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "MANDATETYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "MANDATETYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "MANDATETYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "MANDATETYPECODE_LISTSCHEMEURI")) })
	private CodeType mandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	@Column(name = "MAXIMUM_PAID_AMOUNT")
	private BigDecimal maximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity
	 * period.
	 */	
	@Column(name = "MAXIMUM_PAYMENT_INSTRUCTIONS_NUMERIC")
	private BigDecimal maximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "SIGNATUREID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "SIGNATUREID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "SIGNATUREID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "SIGNATUREID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "SIGNATUREID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "SIGNATUREID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "SIGNATUREID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "SIGNATUREID_SCHEMEURI")) })
	private IdentifierType signatureID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "PAYMENT_MEANS_ID")
	private PaymentMeansEntity paymentMeans;
	
	@OneToMany(mappedBy = "paymentMandate", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<ClauseEntity> clauses = new ArrayList<>();
	
	@OneToOne(mappedBy = "paymentMandate", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private FinancialAccountEntity payerFinancialAccount;
	
	@Transient
	private PartyEntity payerParty;
	
	@Transient
	private PeriodEntity validityPeriod;
	
	@Transient
	private PeriodEntity paymentReversalPeriod;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentifierType getID() {
		return ID;
	}

	public void setID(IdentifierType iD) {
		ID = iD;
	}

	public CodeType getMandateTypeCode() {
		return mandateTypeCode;
	}

	public void setMandateTypeCode(CodeType mandateTypeCode) {
		this.mandateTypeCode = mandateTypeCode;
	}

	public BigDecimal getMaximumPaidAmount() {
		return maximumPaidAmount;
	}

	public void setMaximumPaidAmount(BigDecimal maximumPaidAmount) {
		this.maximumPaidAmount = maximumPaidAmount;
	}

	public BigDecimal getMaximumPaymentInstructionsNumeric() {
		return maximumPaymentInstructionsNumeric;
	}

	public void setMaximumPaymentInstructionsNumeric(BigDecimal maximumPaymentInstructionsNumeric) {
		this.maximumPaymentInstructionsNumeric = maximumPaymentInstructionsNumeric;
	}

	public IdentifierType getSignatureID() {
		return signatureID;
	}

	public void setSignatureID(IdentifierType signatureID) {
		this.signatureID = signatureID;
	}

	public PaymentMeansEntity getPaymentMeans() {
		return paymentMeans;
	}

	public void setPaymentMeans(PaymentMeansEntity paymentMeans) {
		this.paymentMeans = paymentMeans;
	}

	public List<ClauseEntity> getClauses() {
		return clauses;
	}

	public void setClauses(List<ClauseEntity> clauses) {
		this.clauses = clauses;
	}

	public FinancialAccountEntity getPayerFinancialAccount() {
		return payerFinancialAccount;
	}

	public void setPayerFinancialAccount(FinancialAccountEntity payerFinancialAccount) {
		this.payerFinancialAccount = payerFinancialAccount;
	}

	public PartyEntity getPayerParty() {
		return payerParty;
	}

	public void setPayerParty(PartyEntity payerParty) {
		this.payerParty = payerParty;
	}

	public PeriodEntity getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(PeriodEntity validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public PeriodEntity getPaymentReversalPeriod() {
		return paymentReversalPeriod;
	}

	public void setPaymentReversalPeriod(PeriodEntity paymentReversalPeriod) {
		this.paymentReversalPeriod = paymentReversalPeriod;
	}

}
