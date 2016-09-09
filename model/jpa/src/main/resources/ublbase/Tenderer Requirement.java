

/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class Tenderer Requirement {

	/**
	 * Text describing this requirement.
	 */
	private Text. Type Description;
	/**
	 * The legal reference of the exclusion criterion.
	 */
	private Text. Type LegalReference;
	/**
	 * A name of this tenderer requirement.
	 */
	private Name. Type Name;
	/**
	 * A code signifying this requirement.
	 */
	private Code. Type TendererRequirementTypeCode;
	private Evidence Suggested Evidence;

	public Tenderer Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Text. Type getLegalReference(){
		return LegalReference;
	}

	public Name. Type getName(){
		return Name;
	}

	public Evidence getSuggested Evidence(){
		return Suggested Evidence;
	}

	public Code. Type getTendererRequirementTypeCode(){
		return TendererRequirementTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegalReference(Text. Type newVal){
		LegalReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
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
	public void setTendererRequirementTypeCode(Code. Type newVal){
		TendererRequirementTypeCode = newVal;
	}
}//end Tenderer Requirement