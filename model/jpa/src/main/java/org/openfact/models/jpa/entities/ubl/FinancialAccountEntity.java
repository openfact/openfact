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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.InvoiceEntityDEPRECATED;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a financial account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
@Entity
@Table(name = "FINANCIAL_ACCOUNT")
public class FinancialAccountEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * A code signifying the format of this financial account.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTFORMATCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ACCOUNTFORMATCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ACCOUNTFORMATCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ACCOUNTFORMATCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ACCOUNTFORMATCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ACCOUNTFORMATCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ACCOUNTFORMATCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTFORMATCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ACCOUNTFORMATCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ACCOUNTFORMATCODE_LISTSCHEMEURI")) })
	private CodeType accountFormatCode;
	/**
	 * A code signifying the type of this financial account.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ACCOUNTTYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ACCOUNTTYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ACCOUNTTYPECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ACCOUNTTYPECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ACCOUNTTYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ACCOUNTTYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ACCOUNTTYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ACCOUNTTYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ACCOUNTTYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ACCOUNTTYPECODE_LISTSCHEMEURI")) })
	private CodeType accountTypeCode;
	/**
	 * An alias for the name of this financial account, to be used in place of
	 * the actual account name for security reasons.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ALIASNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ALIASNAME_LANGUAGEID")) })
	private NameType aliasName;
	/**
	 * A code signifying the currency in which this financial account is held.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CURRENCYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "CURRENCYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "CURRENCYCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "CURRENCYCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "CURRENCYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "CURRENCYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "CURRENCYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CURRENCYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "CURRENCYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "CURRENCYCODE_LISTSCHEMEURI")) })
	private CurrencyCodeType currencyCode;
	/**
	 * The identifier for this financial account; the bank account number.
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
	 * The name of this financial account.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGEID")) })
	private NameType name;
	/**
	 * Free-form text applying to the PaymentEntity for the owner of this
	 * account.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PAYMENTNOTE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PAYMENTNOTE_LANGUAGEID")) })
	private TextType paymentNote;

	@OneToOne(mappedBy = "financialAccount", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private BranchEntity financialInstitutionBranch;
	
	@Transient
	private List<CountryEntity> countries = new ArrayList<>();
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_MANDATE_ID")
	private PaymentMandateEntity paymentMandate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CodeType getAccountFormatCode() {
		return accountFormatCode;
	}

	public void setAccountFormatCode(CodeType accountFormatCode) {
		this.accountFormatCode = accountFormatCode;
	}

	public CodeType getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(CodeType accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public NameType getAliasName() {
		return aliasName;
	}

	public void setAliasName(NameType aliasName) {
		this.aliasName = aliasName;
	}

	public CurrencyCodeType getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCodeType currencyCode) {
		this.currencyCode = currencyCode;
	}

	public IdentifierType getID() {
		return ID;
	}

	public void setID(IdentifierType iD) {
		ID = iD;
	}

	public NameType getName() {
		return name;
	}

	public void setName(NameType name) {
		this.name = name;
	}

	public TextType getPaymentNote() {
		return paymentNote;
	}

	public void setPaymentNote(TextType paymentNote) {
		this.paymentNote = paymentNote;
	}

	public BranchEntity getFinancialInstitutionBranch() {
		return financialInstitutionBranch;
	}

	public void setFinancialInstitutionBranch(BranchEntity financialInstitutionBranch) {
		this.financialInstitutionBranch = financialInstitutionBranch;
	}

	public List<CountryEntity> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryEntity> countries) {
		this.countries = countries;
	}

	public PaymentMandateEntity getPaymentMandate() {
		return paymentMandate;
	}

	public void setPaymentMandate(PaymentMandateEntity paymentMandate) {
		this.paymentMandate = paymentMandate;
	}
	
	

}
