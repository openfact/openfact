package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirement {

	/**
	 * Text describing this requirement.
	 */
	private String Description;
	/**
	 * The legal reference of the exclusion criterion.
	 */
	private String LegalReference;
	/**
	 * A name of this tenderer requirement.
	 */
	private String Name;
	/**
	 * A code signifying this requirement.
	 */
	private String TendererRequirementTypeCode;
	private Evidence Suggested Evidence;

	public Tenderer Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public String getDescription(){
		return Description;
	}

	public String getLegalReference(){
		return LegalReference;
	}

	public String getName(){
		return Name;
	}

	public Evidence getSuggested Evidence(){
		return Suggested Evidence;
	}

	public String getTendererRequirementTypeCode(){
		return TendererRequirementTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegalReference(String newVal){
		LegalReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSuggested Evidence(Evidence newVal){
		Suggested Evidence = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTendererRequirementTypeCode(String newVal){
		TendererRequirementTypeCode = newVal;
	}
}//end Tenderer Requirement