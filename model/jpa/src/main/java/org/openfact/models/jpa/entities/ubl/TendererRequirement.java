package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirement {

	/**
	 * Text describing this requirement.
	 */
	private String description;
	/**
	 * The legal reference of the exclusion criterion.
	 */
	private String legalReference;
	/**
	 * A name of this tenderer requirement.
	 */
	private String name;
	/**
	 * A code signifying this requirement.
	 */
	private String tendererRequirementTypeCode;
	private Evidence suggestedEvidence;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLegalReference() {
		return legalReference;
	}

	public void setLegalReference(String legalReference) {
		this.legalReference = legalReference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTendererRequirementTypeCode() {
		return tendererRequirementTypeCode;
	}

	public void setTendererRequirementTypeCode(String tendererRequirementTypeCode) {
		this.tendererRequirementTypeCode = tendererRequirementTypeCode;
	}

	public Evidence getSuggestedEvidence() {
		return suggestedEvidence;
	}

	public void setSuggestedEvidence(Evidence suggestedEvidence) {
		this.suggestedEvidence = suggestedEvidence;
	}
}// end TendererRequirement