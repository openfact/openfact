package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
public interface PartyLegalEntityModel {

    String getId();

    /**
     * @return the companyID
     */
    IdentifierType getCompanyID();

    /**
     * @param companyID
     *            the companyID to set
     */
    void setCompanyID(IdentifierType companyID);

    /**
     * @return the companyLegalForm
     */
    TextType getCompanyLegalForm();

    /**
     * @param companyLegalForm
     *            the companyLegalForm to set
     */
    void setCompanyLegalForm(TextType companyLegalForm);

    /**
     * @return the companyLegalFormCode
     */
    CodeType getCompanyLegalFormCode();

    /**
     * @param companyLegalFormCode
     *            the companyLegalFormCode to set
     */
    void setCompanyLegalFormCode(CodeType companyLegalFormCode);

    /**
     * @return the companyLiquidationStatusCode
     */
    CodeType getCompanyLiquidationStatusCode();

    /**
     * @param companyLiquidationStatusCode
     *            the companyLiquidationStatusCode to set
     */
    void setCompanyLiquidationStatusCode(CodeType companyLiquidationStatusCode);

    /**
     * @return the corporateStockAmount
     */
    BigDecimal getCorporateStockAmount();

    /**
     * @param corporateStockAmount
     *            the corporateStockAmount to set
     */
    void setCorporateStockAmount(BigDecimal corporateStockAmount);

    /**
     * @return the fullyPaidSharesIndicator
     */
    boolean isFullyPaidSharesIndicator();

    /**
     * @param fullyPaidSharesIndicator
     *            the fullyPaidSharesIndicator to set
     */
    void setFullyPaidSharesIndicator(boolean fullyPaidSharesIndicator);

    /**
     * @return the registrationDate
     */
    LocalDate getRegistrationDate();

    /**
     * @param registrationDate
     *            the registrationDate to set
     */
    void setRegistrationDate(LocalDate registrationDate);

    /**
     * @return the registrationExpirationDate
     */
    LocalDate getRegistrationExpirationDate();

    /**
     * @param registrationExpirationDate
     *            the registrationExpirationDate to set
     */
    void setRegistrationExpirationDate(LocalDate registrationExpirationDate);

    /**
     * @return the registrationName
     */
    NameType getRegistrationName();

    /**
     * @param registrationName
     *            the registrationName to set
     */
    void setRegistrationName(NameType registrationName);

    /**
     * @return the soleProprietorshipIndicator
     */
    boolean isSoleProprietorshipIndicator();

    /**
     * @param soleProprietorshipIndicator
     *            the soleProprietorshipIndicator to set
     */
    void setSoleProprietorshipIndicator(boolean soleProprietorshipIndicator);

    /**
     * @return the registrationAddress
     */
    AddressModel getRegistrationAddress();

    /**
     * @param registrationAddress
     *            the registrationAddress to set
     */
    void setRegistrationAddress(AddressModel registrationAddress);

    /**
     * @return the corporateRegistrationSchemes
     */
    List<CorporateRegistrationSchemeModel> getCorporateRegistrationSchemes();

    /**
     * @param corporateRegistrationSchemes
     *            the corporateRegistrationSchemes to set
     */
    void setCorporateRegistrationSchemes(List<CorporateRegistrationSchemeModel> corporateRegistrationSchemes);

    /**
     * @return the headOfficeParty
     */
    PartyModel getHeadOfficeParty();

    /**
     * @param headOfficeParty
     *            the headOfficeParty to set
     */
    void setHeadOfficeParty(PartyModel headOfficeParty);

    /**
     * @return the shareholderParties
     */
    List<ShareholderPartyModel> getShareholderParties();

    /**
     * @param shareholderParties
     *            the shareholderParties to set
     */
    void setShareholderParties(List<ShareholderPartyModel> shareholderParties);

    /**
     * Custom methods
     */
    void setRegistrationName(String valueParam);
}
