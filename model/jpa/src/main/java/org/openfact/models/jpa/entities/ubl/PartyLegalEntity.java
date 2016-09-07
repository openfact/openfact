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
	private String CompanyID;
	/**
	 * The company legal status, expressed as a text.
	 */
	private String CompanyLegalForm;
	/**
	 * A code signifying the party's legal status.
	 */
	private String CompanyLegalFormCode;
	/**
	 * A code signifying the party's liquidation status.
	 */
	private String CompanyLiquidationStatusCode;
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	private BigDecimal CorporateStockAmount;
	/**
	 * An indicator that all shares of corporate stock have been paid by
	 * shareholders (true) or not (false).
	 */
	private boolean FullyPaidSharesIndicator;
	/**
	 * The registration date of the CompanyID.
	 */
	private LocalDate RegistrationDate;
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	private LocalDate RegistrationExpirationDate;
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	private String RegistrationName;
	/**
	 * An indicator that the company is owned and controlled by one person
	 * (true) or not (false).
	 */
	private boolean SoleProprietorshipIndicator;
	private Address RegistrationAddress;
	private CorporateRegistrationScheme m_CorporateRegistrationScheme;
	private Party HeadOfficeParty;
	private ShareholderParty m_ShareholderParty;

	public PartyLegalEntity() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the companyID
	 */
	public String getCompanyID() {
		return CompanyID;
	}

	/**
	 * @param companyID
	 *            the companyID to set
	 */
	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}

	/**
	 * @return the companyLegalForm
	 */
	public String getCompanyLegalForm() {
		return CompanyLegalForm;
	}

	/**
	 * @param companyLegalForm
	 *            the companyLegalForm to set
	 */
	public void setCompanyLegalForm(String companyLegalForm) {
		CompanyLegalForm = companyLegalForm;
	}

	/**
	 * @return the companyLegalFormCode
	 */
	public String getCompanyLegalFormCode() {
		return CompanyLegalFormCode;
	}

	/**
	 * @param companyLegalFormCode
	 *            the companyLegalFormCode to set
	 */
	public void setCompanyLegalFormCode(String companyLegalFormCode) {
		CompanyLegalFormCode = companyLegalFormCode;
	}

	/**
	 * @return the companyLiquidationStatusCode
	 */
	public String getCompanyLiquidationStatusCode() {
		return CompanyLiquidationStatusCode;
	}

	/**
	 * @param companyLiquidationStatusCode
	 *            the companyLiquidationStatusCode to set
	 */
	public void setCompanyLiquidationStatusCode(String companyLiquidationStatusCode) {
		CompanyLiquidationStatusCode = companyLiquidationStatusCode;
	}

	/**
	 * @return the corporateStockAmount
	 */
	public BigDecimal getCorporateStockAmount() {
		return CorporateStockAmount;
	}

	/**
	 * @param corporateStockAmount
	 *            the corporateStockAmount to set
	 */
	public void setCorporateStockAmount(BigDecimal corporateStockAmount) {
		CorporateStockAmount = corporateStockAmount;
	}

	/**
	 * @return the fullyPaidSharesIndicator
	 */
	public boolean isFullyPaidSharesIndicator() {
		return FullyPaidSharesIndicator;
	}

	/**
	 * @param fullyPaidSharesIndicator
	 *            the fullyPaidSharesIndicator to set
	 */
	public void setFullyPaidSharesIndicator(boolean fullyPaidSharesIndicator) {
		FullyPaidSharesIndicator = fullyPaidSharesIndicator;
	}

	/**
	 * @return the registrationDate
	 */
	public LocalDate getRegistrationDate() {
		return RegistrationDate;
	}

	/**
	 * @param registrationDate
	 *            the registrationDate to set
	 */
	public void setRegistrationDate(LocalDate registrationDate) {
		RegistrationDate = registrationDate;
	}

	/**
	 * @return the registrationExpirationDate
	 */
	public LocalDate getRegistrationExpirationDate() {
		return RegistrationExpirationDate;
	}

	/**
	 * @param registrationExpirationDate
	 *            the registrationExpirationDate to set
	 */
	public void setRegistrationExpirationDate(LocalDate registrationExpirationDate) {
		RegistrationExpirationDate = registrationExpirationDate;
	}

	/**
	 * @return the registrationName
	 */
	public String getRegistrationName() {
		return RegistrationName;
	}

	/**
	 * @param registrationName
	 *            the registrationName to set
	 */
	public void setRegistrationName(String registrationName) {
		RegistrationName = registrationName;
	}

	/**
	 * @return the soleProprietorshipIndicator
	 */
	public boolean isSoleProprietorshipIndicator() {
		return SoleProprietorshipIndicator;
	}

	/**
	 * @param soleProprietorshipIndicator
	 *            the soleProprietorshipIndicator to set
	 */
	public void setSoleProprietorshipIndicator(boolean soleProprietorshipIndicator) {
		SoleProprietorshipIndicator = soleProprietorshipIndicator;
	}

	/**
	 * @return the registrationAddress
	 */
	public Address getRegistrationAddress() {
		return RegistrationAddress;
	}

	/**
	 * @param registrationAddress
	 *            the registrationAddress to set
	 */
	public void setRegistrationAddress(Address registrationAddress) {
		RegistrationAddress = registrationAddress;
	}

	/**
	 * @return the m_CorporateRegistrationScheme
	 */
	public CorporateRegistrationScheme getM_CorporateRegistrationScheme() {
		return m_CorporateRegistrationScheme;
	}

	/**
	 * @param m_CorporateRegistrationScheme
	 *            the m_CorporateRegistrationScheme to set
	 */
	public void setM_CorporateRegistrationScheme(CorporateRegistrationScheme m_CorporateRegistrationScheme) {
		this.m_CorporateRegistrationScheme = m_CorporateRegistrationScheme;
	}

	/**
	 * @return the headOfficeParty
	 */
	public Party getHeadOfficeParty() {
		return HeadOfficeParty;
	}

	/**
	 * @param headOfficeParty
	 *            the headOfficeParty to set
	 */
	public void setHeadOfficeParty(Party headOfficeParty) {
		HeadOfficeParty = headOfficeParty;
	}

	/**
	 * @return the m_ShareholderParty
	 */
	public ShareholderParty getM_ShareholderParty() {
		return m_ShareholderParty;
	}

	/**
	 * @param m_ShareholderParty
	 *            the m_ShareholderParty to set
	 */
	public void setM_ShareholderParty(ShareholderParty m_ShareholderParty) {
		this.m_ShareholderParty = m_ShareholderParty;
	}

}// end Party Legal Entity