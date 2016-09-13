package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a party as a legal entity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntityRepresentation {

    /**
     * An identifier for the party as registered within a company registration
     * scheme.
     */
    private IdentifierType companyID;
    /**
     * The company legal status, expressed as a text.
     */
    private String companyLegalForm;
    /**
     * A code signifying the party's legal status.
     */
    private CodeType companyLegalFormCode;
    /**
     * A code signifying the party's liquidation status.
     */
    private CodeType companyLiquidationStatusCode;
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
    private AddressRepresentation registrationAddress;
    private List<CorporateRegistrationSchemeRepresentation> corporateRegistrationSchemes = new ArrayList<>();
    private PartyRepresentation headOfficeParty;
    private List<ShareholderPartyRepresentation> shareholderParties = new ArrayList<>();

    /**
     * @return the companyID
     */
    public IdentifierType getCompanyID() {
        return companyID;
    }

    /**
     * @param companyID
     *            the companyID to set
     */
    public void setCompanyID(IdentifierType companyID) {
        this.companyID = companyID;
    }

    /**
     * @return the companyLegalForm
     */
    public String getCompanyLegalForm() {
        return companyLegalForm;
    }

    /**
     * @param companyLegalForm
     *            the companyLegalForm to set
     */
    public void setCompanyLegalForm(String companyLegalForm) {
        this.companyLegalForm = companyLegalForm;
    }

    /**
     * @return the companyLegalFormCode
     */
    public CodeType getCompanyLegalFormCode() {
        return companyLegalFormCode;
    }

    /**
     * @param companyLegalFormCode
     *            the companyLegalFormCode to set
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
     * @param companyLiquidationStatusCode
     *            the companyLiquidationStatusCode to set
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
     * @param corporateStockAmount
     *            the corporateStockAmount to set
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
     * @param fullyPaidSharesIndicator
     *            the fullyPaidSharesIndicator to set
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
     * @param registrationDate
     *            the registrationDate to set
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
     * @param registrationExpirationDate
     *            the registrationExpirationDate to set
     */
    public void setRegistrationExpirationDate(LocalDate registrationExpirationDate) {
        this.registrationExpirationDate = registrationExpirationDate;
    }

    /**
     * @return the registrationName
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * @param registrationName
     *            the registrationName to set
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    /**
     * @return the soleProprietorshipIndicator
     */
    public boolean isSoleProprietorshipIndicator() {
        return soleProprietorshipIndicator;
    }

    /**
     * @param soleProprietorshipIndicator
     *            the soleProprietorshipIndicator to set
     */
    public void setSoleProprietorshipIndicator(boolean soleProprietorshipIndicator) {
        this.soleProprietorshipIndicator = soleProprietorshipIndicator;
    }

    /**
     * @return the registrationAddress
     */
    public AddressRepresentation getRegistrationAddress() {
        return registrationAddress;
    }

    /**
     * @param registrationAddress
     *            the registrationAddress to set
     */
    public void setRegistrationAddress(AddressRepresentation registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    /**
     * @return the corporateRegistrationSchemes
     */
    public List<CorporateRegistrationSchemeRepresentation> getCorporateRegistrationSchemes() {
        return corporateRegistrationSchemes;
    }

    /**
     * @param corporateRegistrationSchemes
     *            the corporateRegistrationSchemes to set
     */
    public void setCorporateRegistrationSchemes(
            List<CorporateRegistrationSchemeRepresentation> corporateRegistrationSchemes) {
        this.corporateRegistrationSchemes = corporateRegistrationSchemes;
    }

    /**
     * @return the headOfficeParty
     */
    public PartyRepresentation getHeadOfficeParty() {
        return headOfficeParty;
    }

    /**
     * @param headOfficeParty
     *            the headOfficeParty to set
     */
    public void setHeadOfficeParty(PartyRepresentation headOfficeParty) {
        this.headOfficeParty = headOfficeParty;
    }

    /**
     * @return the shareholderParties
     */
    public List<ShareholderPartyRepresentation> getShareholderParties() {
        return shareholderParties;
    }

    /**
     * @param shareholderParties
     *            the shareholderParties to set
     */
    public void setShareholderParties(List<ShareholderPartyRepresentation> shareholderParties) {
        this.shareholderParties = shareholderParties;
    }

}
