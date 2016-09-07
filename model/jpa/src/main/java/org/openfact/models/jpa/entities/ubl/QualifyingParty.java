package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe the distinctive features or characteristics qualifying an
 * economic operator to be a party in a tendering process (e.g., number of
 * employees, number of operating units, type of business, technical and
 * financial capabilities, completed p
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:14 a. m.
 */
public class QualifyingParty {

    /**
     * An identifier for an item of evidence to support the classification of
     * this qualifying party.
     */
    private String businessClassificationEvidenceID;
    /**
     * An identifier for an item of evidence to support the business identity of
     * this qualifying party.
     */
    private String businessIdentityEvidenceID;
    /**
     * The number of people employed by this qualifying party.
     */
    private BigDecimal employeeQuantity;
    /**
     * The number of years that this qualifying party has been in operation.
     */
    private BigDecimal operatingYearsQuantity;
    /**
     * The extent to which this party is expected to participate in the
     * tendering process, expressed as a percentage.
     */
    private BigDecimal participationPercent;
    /**
     * Text describing the personal situation of the qualifying party.
     */
    private String personalSituation;
    /**
     * A code stating the Tenderer Role.
     */
    private String tendererRoleCode;
    private Capability technicalCapability;
    private Capability financialCapability;
    private ClassificationScheme businessClassificationScheme;
    private CompletedTask m_CompletedTask;
    private Declaration m_Declaration;
    private EconomicOperatorRole m_EconomicOperatorRole;
    private Party m_Party;

    public String getBusinessClassificationEvidenceID() {
        return businessClassificationEvidenceID;
    }

    public void setBusinessClassificationEvidenceID(String businessClassificationEvidenceID) {
        this.businessClassificationEvidenceID = businessClassificationEvidenceID;
    }

    public String getBusinessIdentityEvidenceID() {
        return businessIdentityEvidenceID;
    }

    public void setBusinessIdentityEvidenceID(String businessIdentityEvidenceID) {
        this.businessIdentityEvidenceID = businessIdentityEvidenceID;
    }

    public BigDecimal getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(BigDecimal employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public BigDecimal getOperatingYearsQuantity() {
        return operatingYearsQuantity;
    }

    public void setOperatingYearsQuantity(BigDecimal operatingYearsQuantity) {
        this.operatingYearsQuantity = operatingYearsQuantity;
    }

    public BigDecimal getParticipationPercent() {
        return participationPercent;
    }

    public void setParticipationPercent(BigDecimal participationPercent) {
        this.participationPercent = participationPercent;
    }

    public String getPersonalSituation() {
        return personalSituation;
    }

    public void setPersonalSituation(String personalSituation) {
        this.personalSituation = personalSituation;
    }

    public String getTendererRoleCode() {
        return tendererRoleCode;
    }

    public void setTendererRoleCode(String tendererRoleCode) {
        this.tendererRoleCode = tendererRoleCode;
    }

    public Capability getTechnicalCapability() {
        return technicalCapability;
    }

    public void setTechnicalCapability(Capability technicalCapability) {
        this.technicalCapability = technicalCapability;
    }

    public Capability getFinancialCapability() {
        return financialCapability;
    }

    public void setFinancialCapability(Capability financialCapability) {
        this.financialCapability = financialCapability;
    }

    public ClassificationScheme getBusinessClassificationScheme() {
        return businessClassificationScheme;
    }

    public void setBusinessClassificationScheme(ClassificationScheme businessClassificationScheme) {
        this.businessClassificationScheme = businessClassificationScheme;
    }

    public CompletedTask getM_CompletedTask() {
        return m_CompletedTask;
    }

    public void setM_CompletedTask(CompletedTask m_CompletedTask) {
        this.m_CompletedTask = m_CompletedTask;
    }

    public Declaration getM_Declaration() {
        return m_Declaration;
    }

    public void setM_Declaration(Declaration m_Declaration) {
        this.m_Declaration = m_Declaration;
    }

    public EconomicOperatorRole getM_EconomicOperatorRole() {
        return m_EconomicOperatorRole;
    }

    public void setM_EconomicOperatorRole(EconomicOperatorRole m_EconomicOperatorRole) {
        this.m_EconomicOperatorRole = m_EconomicOperatorRole;
    }

    public Party getM_Party() {
        return m_Party;
    }

    public void setM_Party(Party m_Party) {
        this.m_Party = m_Party;
    }
}// end QualifyingParty