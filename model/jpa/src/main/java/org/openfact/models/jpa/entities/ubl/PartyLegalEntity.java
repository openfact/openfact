package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a party as a legal entity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntity {

	/**
	 * An identifier for the party as registered within a company registration
	 * scheme.
	 */
	private String companyID;
	/**
	 * The company legal status, expressed as a text.
	 */
	private String companyLegalForm;
	/**
	 * A code signifying the party's legal status.
	 */
	private String companyLegalFormCode;
	/**
	 * A code signifying the party's liquidation status.
	 */
	private String companyLiquidationStatusCode;
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	private BigDecimal corporateStockAmount;
	/**
	 * An indicator that all shares of corporate stock have been paid by
	 * shareholders (true) or not (false).
	 */
	private boolean fullyPaidSharesIndicator;
	/**
	 * The registration date of the CompanyID.
	 */
	private LocalDate registrationDate;
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	private LocalDate registrationExpirationDate;
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	private String registrationName;
	/**
	 * An indicator that the company is owned and controlled by one person
	 * (true) or not (false).
	 */
	private boolean soleProprietorshipIndicator;
	private Address registrationAddress;
	private List<CorporateRegistrationScheme> corporateRegistrationSchemes=new ArrayList<>();
	private Party HeadOfficeParty;
	private List<ShareholderParty> shareholderParties=new ArrayList<>();

	public PartyLegalEntity() {

	}

	public void finalize() throws Throwable {

	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyLegalForm() {
		return companyLegalForm;
	}

	public void setCompanyLegalForm(String companyLegalForm) {
		this.companyLegalForm = companyLegalForm;
	}

	public String getCompanyLegalFormCode() {
		return companyLegalFormCode;
	}

	public void setCompanyLegalFormCode(String companyLegalFormCode) {
		this.companyLegalFormCode = companyLegalFormCode;
	}

	public String getCompanyLiquidationStatusCode() {
		return companyLiquidationStatusCode;
	}

	public void setCompanyLiquidationStatusCode(String companyLiquidationStatusCode) {
		this.companyLiquidationStatusCode = companyLiquidationStatusCode;
	}

	public BigDecimal getCorporateStockAmount() {
		return corporateStockAmount;
	}

	public void setCorporateStockAmount(BigDecimal corporateStockAmount) {
		this.corporateStockAmount = corporateStockAmount;
	}

	public boolean isFullyPaidSharesIndicator() {
		return fullyPaidSharesIndicator;
	}

	public void setFullyPaidSharesIndicator(boolean fullyPaidSharesIndicator) {
		this.fullyPaidSharesIndicator = fullyPaidSharesIndicator;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDate getRegistrationExpirationDate() {
		return registrationExpirationDate;
	}

	public void setRegistrationExpirationDate(LocalDate registrationExpirationDate) {
		this.registrationExpirationDate = registrationExpirationDate;
	}

	public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}

	public boolean isSoleProprietorshipIndicator() {
		return soleProprietorshipIndicator;
	}

	public void setSoleProprietorshipIndicator(boolean soleProprietorshipIndicator) {
		this.soleProprietorshipIndicator = soleProprietorshipIndicator;
	}

	public Address getRegistrationAddress() {
		return registrationAddress;
	}

	public void setRegistrationAddress(Address registrationAddress) {
		this.registrationAddress = registrationAddress;
	}

	public List<CorporateRegistrationScheme> getCorporateRegistrationSchemes() {
		return corporateRegistrationSchemes;
	}

	public void setCorporateRegistrationSchemes(List<CorporateRegistrationScheme> corporateRegistrationSchemes) {
		this.corporateRegistrationSchemes = corporateRegistrationSchemes;
	}

	public Party getHeadOfficeParty() {
		return HeadOfficeParty;
	}

	public void setHeadOfficeParty(Party headOfficeParty) {
		HeadOfficeParty = headOfficeParty;
	}

	public List<ShareholderParty> getShareholderParties() {
		return shareholderParties;
	}

	public void setShareholderParties(List<ShareholderParty> shareholderParties) {
		this.shareholderParties = shareholderParties;
	}
}// end Party Legal Entity