package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a party as a legal entity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
@Entity
@Table(name = "PARTY_LEGAL")
public class PartyLegalEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for the party as registered within a company registration
	 * scheme.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "COMPANYID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "COMPANYID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "COMPANYID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "COMPANYID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "COMPANYID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "COMPANYID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "COMPANYID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "COMPANYID_SCHEMEURI")) })
	private IdentifierType companyID;
	/**
	 * The company legal status, expressed as a text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "COMPANYLEGALFORM_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "COMPANYLEGALFORM_LANGUAGE")) })
	private TextType companyLegalForm;
	/**
	 * A code signifying the party's legal status.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "COMPANYLEGALFORMCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "COMPANYLEGALFORMCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "COMPANYLEGALFORMCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "COMPANYLEGALFORMCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "COMPANYLEGALFORMCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "COMPANYLEGALFORMCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "COMPANYLEGALFORMCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "COMPANYLEGALFORMCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "COMPANYLEGALFORMCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "COMPANYLEGALFORMCODE_SCHEMEURI")) })
	private CodeType companyLegalFormCode;
	/**
	 * A code signifying the party's liquidation status.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "COMPANYLIQUIDATIONSTATUSCODE_SCHEMEURI")) })
	private CodeType companyLiquidationStatusCode;
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	@Column(name = "CORPORATE_STOCK_AMOUNT")
	private BigDecimal corporateStockAmount;
	/**
	 * An indicator that all shares of corporate stock have been paid by
	 * shareholders (true) or not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "MARK_ATTENTION_INDICATOR")
	private boolean fullyPaidSharesIndicator;
	/**
	 * The registration date of the CompanyID.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "REGISTRATION_DATE")
	private LocalDate registrationDate;
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "REGISTRATION_EXPIRATION_DATE")
	private LocalDate registrationExpirationDate;
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "REGISTRATIONNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "REGISTRATIONNAME_LANGUAGE")) })
	private NameType registrationName;
	/**
	 * An indicator that the company is owned and controlled by one person
	 * (true) or not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "SOLE_PROPRIETOR_SHIP_INDICATOR")
	private boolean soleProprietorshipIndicator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "PARTY_ID")
	private PartyEntity party;

	@Transient
	private AddressEntity registrationAddress;

	@Transient
	private List<CorporateRegistrationSchemeEntity> corporateRegistrationSchemes = new ArrayList<>();

	@Transient
	private PartyEntity headOfficeParty;

	@Transient
	private List<ShareholderPartyEntity> shareholderParties = new ArrayList<>();

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
	 * @return the companyID
	 */
	public IdentifierType getCompanyID() {
		return companyID;
	}

	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(IdentifierType companyID) {
		this.companyID = companyID;
	}

	/**
	 * @return the companyLegalForm
	 */
	public TextType getCompanyLegalForm() {
		return companyLegalForm;
	}

	/**
	 * @param companyLegalForm the companyLegalForm to set
	 */
	public void setCompanyLegalForm(TextType companyLegalForm) {
		this.companyLegalForm = companyLegalForm;
	}

	/**
	 * @return the companyLegalFormCode
	 */
	public CodeType getCompanyLegalFormCode() {
		return companyLegalFormCode;
	}

	/**
	 * @param companyLegalFormCode the companyLegalFormCode to set
	 */
	public void setCompanyLegalFormCode(CodeType companyLegalFormCode) {
		this.companyLegalFormCode = companyLegalFormCode;
	}

	/**
	 * @return the companyLiquidationStatusCode
	 */
	public CodeType getCompanyLiquidationStatusCode() {
		return companyLiquidationStatusCode;
	}

	/**
	 * @param companyLiquidationStatusCode the companyLiquidationStatusCode to set
	 */
	public void setCompanyLiquidationStatusCode(CodeType companyLiquidationStatusCode) {
		this.companyLiquidationStatusCode = companyLiquidationStatusCode;
	}

	/**
	 * @return the corporateStockAmount
	 */
	public BigDecimal getCorporateStockAmount() {
		return corporateStockAmount;
	}

	/**
	 * @param corporateStockAmount the corporateStockAmount to set
	 */
	public void setCorporateStockAmount(BigDecimal corporateStockAmount) {
		this.corporateStockAmount = corporateStockAmount;
	}

	/**
	 * @return the fullyPaidSharesIndicator
	 */
	public boolean isFullyPaidSharesIndicator() {
		return fullyPaidSharesIndicator;
	}

	/**
	 * @param fullyPaidSharesIndicator the fullyPaidSharesIndicator to set
	 */
	public void setFullyPaidSharesIndicator(boolean fullyPaidSharesIndicator) {
		this.fullyPaidSharesIndicator = fullyPaidSharesIndicator;
	}

	/**
	 * @return the registrationDate
	 */
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the registrationExpirationDate
	 */
	public LocalDate getRegistrationExpirationDate() {
		return registrationExpirationDate;
	}

	/**
	 * @param registrationExpirationDate the registrationExpirationDate to set
	 */
	public void setRegistrationExpirationDate(LocalDate registrationExpirationDate) {
		this.registrationExpirationDate = registrationExpirationDate;
	}

	/**
	 * @return the registrationName
	 */
	public NameType getRegistrationName() {
		return registrationName;
	}

	/**
	 * @param registrationName the registrationName to set
	 */
	public void setRegistrationName(NameType registrationName) {
		this.registrationName = registrationName;
	}

	/**
	 * @return the soleProprietorshipIndicator
	 */
	public boolean isSoleProprietorshipIndicator() {
		return soleProprietorshipIndicator;
	}

	/**
	 * @param soleProprietorshipIndicator the soleProprietorshipIndicator to set
	 */
	public void setSoleProprietorshipIndicator(boolean soleProprietorshipIndicator) {
		this.soleProprietorshipIndicator = soleProprietorshipIndicator;
	}

	/**
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

	/**
	 * @return the registrationAddress
	 */
	public AddressEntity getRegistrationAddress() {
		return registrationAddress;
	}

	/**
	 * @param registrationAddress the registrationAddress to set
	 */
	public void setRegistrationAddress(AddressEntity registrationAddress) {
		this.registrationAddress = registrationAddress;
	}

	/**
	 * @return the corporateRegistrationSchemes
	 */
	public List<CorporateRegistrationSchemeEntity> getCorporateRegistrationSchemes() {
		return corporateRegistrationSchemes;
	}

	/**
	 * @param corporateRegistrationSchemes the corporateRegistrationSchemes to set
	 */
	public void setCorporateRegistrationSchemes(List<CorporateRegistrationSchemeEntity> corporateRegistrationSchemes) {
		this.corporateRegistrationSchemes = corporateRegistrationSchemes;
	}

	/**
	 * @return the headOfficeParty
	 */
	public PartyEntity getHeadOfficeParty() {
		return headOfficeParty;
	}

	/**
	 * @param headOfficeParty the headOfficeParty to set
	 */
	public void setHeadOfficeParty(PartyEntity headOfficeParty) {
		this.headOfficeParty = headOfficeParty;
	}

	/**
	 * @return the shareholderParties
	 */
	public List<ShareholderPartyEntity> getShareholderParties() {
		return shareholderParties;
	}

	/**
	 * @param shareholderParties the shareholderParties to set
	 */
	public void setShareholderParties(List<ShareholderPartyEntity> shareholderParties) {
		this.shareholderParties = shareholderParties;
	}
	
	

}
