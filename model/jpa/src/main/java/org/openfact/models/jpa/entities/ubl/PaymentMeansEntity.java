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
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ublType.*;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PaymentMeansCodeType;

/**
 * A class to describe a means of payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:39 a. m.
 */
@Entity
@Table(name = "PAYMENT_MEAN")
public class PaymentMeansEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for this means of payment.
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
	 * An identifier for the payment instruction.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "INSTRUCTIONID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "INSTRUCTIONID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "INSTRUCTIONID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "INSTRUCTIONID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "INSTRUCTIONID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "INSTRUCTIONID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "INSTRUCTIONID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "INSTRUCTIONID_SCHEMEURI")) })
	private IdentifierType instructionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "INSTRUCTIONNOTE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "INSTRUCTIONNOTE_LANGUAGEID")) })
	private TextType instructionNote;
	/**
	 * A code signifying the payment channel for this means of payment.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTCHANNELCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PAYMENTCHANNELCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PAYMENTCHANNELCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PAYMENTCHANNELCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PAYMENTCHANNELCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PAYMENTCHANNELCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PAYMENTCHANNELCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTCHANNELCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PAYMENTCHANNELCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PAYMENTCHANNELCODE_LISTSCHEMEURI")) })
	private CodeType paymentChannelCode;
	/**
	 * The date on which payment is due for this means of payment.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "PAYMENT_DUE_DATE")
	private LocalDate paymentDueDate;
	/**
	 * An identifier for a payment made using this means of payment.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "PAYMENTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "PAYMENTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "PAYMENTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "PAYMENTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "PAYMENTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "PAYMENTID_SCHEMEDATAURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "PAYMENTID_SCHEMEURI")) })
	private IdentifierType paymentID;
	/**
	 * A code signifying the type of this means of payment.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTMEANSCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PAYMENTMEANSCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PAYMENTMEANSCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PAYMENTMEANSCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PAYMENTMEANSCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PAYMENTMEANSCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PAYMENTMEANSCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTMEANSCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PAYMENTMEANSCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PAYMENTMEANSCODE_LISTSCHEMEURI")) })
	private PaymentMeansCodeType paymentMeansCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ALLOWANCE_CHARGE_ID")
	private AllowanceChargeEntity allowanceCharge;
	
	@OneToMany(mappedBy = "paymentMeans", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CardAccountEntity> cardAccounts = new ArrayList<>();
	
	@OneToMany(mappedBy = "paymentMeans", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CreditAccountEntity> creditAccounts = new ArrayList<>();
	
	@OneToMany(mappedBy = "paymentMeans", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<PaymentMandateEntity> paymentMandates = new ArrayList<>();
	
	@Transient
	private List<TradeFinancingEntity> tradeFinancings = new ArrayList<>();
	@Transient
	private FinancialAccountEntity payeeFinancialAccount;
	@Transient
	private FinancialAccountEntity payerFinancialAccount;
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
	public IdentifierType getInstructionID() {
		return instructionID;
	}
	public void setInstructionID(IdentifierType instructionID) {
		this.instructionID = instructionID;
	}
	public TextType getInstructionNote() {
		return instructionNote;
	}
	public void setInstructionNote(TextType instructionNote) {
		this.instructionNote = instructionNote;
	}
	public CodeType getPaymentChannelCode() {
		return paymentChannelCode;
	}
	public void setPaymentChannelCode(CodeType paymentChannelCode) {
		this.paymentChannelCode = paymentChannelCode;
	}
	public LocalDate getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(LocalDate paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public IdentifierType getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(IdentifierType paymentID) {
		this.paymentID = paymentID;
	}
	public PaymentMeansCodeType getPaymentMeansCode() {
		return paymentMeansCode;
	}
	public void setPaymentMeansCode(PaymentMeansCodeType paymentMeansCode) {
		this.paymentMeansCode = paymentMeansCode;
	}
	public AllowanceChargeEntity getAllowanceCharge() {
		return allowanceCharge;
	}
	public void setAllowanceCharge(AllowanceChargeEntity allowanceCharge) {
		this.allowanceCharge = allowanceCharge;
	}
	public List<CardAccountEntity> getCardAccounts() {
		return cardAccounts;
	}
	public void setCardAccounts(List<CardAccountEntity> cardAccounts) {
		this.cardAccounts = cardAccounts;
	}
	public List<CreditAccountEntity> getCreditAccounts() {
		return creditAccounts;
	}
	public void setCreditAccounts(List<CreditAccountEntity> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}
	public List<PaymentMandateEntity> getPaymentMandates() {
		return paymentMandates;
	}
	public void setPaymentMandates(List<PaymentMandateEntity> paymentMandates) {
		this.paymentMandates = paymentMandates;
	}
	public List<TradeFinancingEntity> getTradeFinancings() {
		return tradeFinancings;
	}
	public void setTradeFinancings(List<TradeFinancingEntity> tradeFinancings) {
		this.tradeFinancings = tradeFinancings;
	}
	public FinancialAccountEntity getPayeeFinancialAccount() {
		return payeeFinancialAccount;
	}
	public void setPayeeFinancialAccount(FinancialAccountEntity payeeFinancialAccount) {
		this.payeeFinancialAccount = payeeFinancialAccount;
	}
	public FinancialAccountEntity getPayerFinancialAccount() {
		return payerFinancialAccount;
	}
	public void setPayerFinancialAccount(FinancialAccountEntity payerFinancialAccount) {
		this.payerFinancialAccount = payerFinancialAccount;
	}
	
	
	

}
