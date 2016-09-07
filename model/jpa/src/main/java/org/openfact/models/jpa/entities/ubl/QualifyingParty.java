package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private List<CompletedTask> completedTasks = new ArrayList<>();
	private List<Declaration> declarations = new ArrayList<>();
	private List<EconomicOperatorRole> economicOperatorRoles = new ArrayList<>();
	private List<Party> parties = new ArrayList<>();

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

	public List<CompletedTask> getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(List<CompletedTask> completedTasks) {
		this.completedTasks = completedTasks;
	}

	public List<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

	public List<EconomicOperatorRole> getEconomicOperatorRoles() {
		return economicOperatorRoles;
	}

	public void setEconomicOperatorRoles(List<EconomicOperatorRole> economicOperatorRoles) {
		this.economicOperatorRoles = economicOperatorRoles;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
}// end QualifyingParty