package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the consumption of a utility.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class Consumption {

    /**
     * A code identifying the type of the Utility Statement required for this
     * consumption. Explains the kind of utility the statement is about, e.g..
     * "gas", "electricity", "telephone"
     */
    private String UtilityStatementTypeCode;
    private AllowanceCharge m_AllowanceCharge;
    private EnergyWaterSupply m_EnergyWaterSupply;
    private MonetaryTotal LegalMonetaryTotal;
    private Period MainPeriod;
    private TaxTotal m_TaxTotal;
    private TelecommunicationsSupply m_TelecommunicationsSupply;

    public Consumption() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the utilityStatementTypeCode
     */
    public String getUtilityStatementTypeCode() {
        return UtilityStatementTypeCode;
    }

    /**
     * @param utilityStatementTypeCode
     *            the utilityStatementTypeCode to set
     */
    public void setUtilityStatementTypeCode(String utilityStatementTypeCode) {
        UtilityStatementTypeCode = utilityStatementTypeCode;
    }

    /**
     * @return the m_AllowanceCharge
     */
    public AllowanceCharge getM_AllowanceCharge() {
        return m_AllowanceCharge;
    }

    /**
     * @param m_AllowanceCharge
     *            the m_AllowanceCharge to set
     */
    public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
        this.m_AllowanceCharge = m_AllowanceCharge;
    }

    /**
     * @return the m_EnergyWaterSupply
     */
    public EnergyWaterSupply getM_EnergyWaterSupply() {
        return m_EnergyWaterSupply;
    }

    /**
     * @param m_EnergyWaterSupply
     *            the m_EnergyWaterSupply to set
     */
    public void setM_EnergyWaterSupply(EnergyWaterSupply m_EnergyWaterSupply) {
        this.m_EnergyWaterSupply = m_EnergyWaterSupply;
    }

    /**
     * @return the legalMonetaryTotal
     */
    public MonetaryTotal getLegalMonetaryTotal() {
        return LegalMonetaryTotal;
    }

    /**
     * @param legalMonetaryTotal
     *            the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
        LegalMonetaryTotal = legalMonetaryTotal;
    }

    /**
     * @return the mainPeriod
     */
    public Period getMainPeriod() {
        return MainPeriod;
    }

    /**
     * @param mainPeriod
     *            the mainPeriod to set
     */
    public void setMainPeriod(Period mainPeriod) {
        MainPeriod = mainPeriod;
    }

    /**
     * @return the m_TaxTotal
     */
    public TaxTotal getM_TaxTotal() {
        return m_TaxTotal;
    }

    /**
     * @param m_TaxTotal
     *            the m_TaxTotal to set
     */
    public void setM_TaxTotal(TaxTotal m_TaxTotal) {
        this.m_TaxTotal = m_TaxTotal;
    }

    /**
     * @return the m_TelecommunicationsSupply
     */
    public TelecommunicationsSupply getM_TelecommunicationsSupply() {
        return m_TelecommunicationsSupply;
    }

    /**
     * @param m_TelecommunicationsSupply
     *            the m_TelecommunicationsSupply to set
     */
    public void setM_TelecommunicationsSupply(TelecommunicationsSupply m_TelecommunicationsSupply) {
        this.m_TelecommunicationsSupply = m_TelecommunicationsSupply;
    }

}// end Consumption