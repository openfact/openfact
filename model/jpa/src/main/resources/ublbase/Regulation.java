

/**
 * A class to describe a regulation.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class Regulation {

	/**
	 * Text describing a legal reference.
	 */
	private Text. Type LegalReference;
	/**
	 * A name for this regulation.
	 */
	private Name. Type Name;
	/**
	 * The Uniform Resource Identifier (URI) of an ontology related to this regulation.
	 */
	private Identifier. Type OntologyURIID;

	public Regulation(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getLegalReference(){
		return LegalReference;
	}

	public Name. Type getName(){
		return Name;
	}

	public Identifier. Type getOntologyURIID(){
		return OntologyURIID;
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
	public void setOntologyURIID(Identifier. Type newVal){
		OntologyURIID = newVal;
	}
}//end Regulation