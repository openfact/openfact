package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a regulation.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class Regulation {

	/**
	 * Text describing a legal reference.
	 */
	private String LegalReference;
	/**
	 * A name for this regulation.
	 */
	private String Name;
	/**
	 * The Uniform Resource Identifier (URI) of an ontology related to this
	 * regulation.
	 */
	private String OntologyURIID;

	public Regulation() {

	}

	public void finalize() throws Throwable {

	}

	public String getLegalReference() {
		return LegalReference;
	}

	public String getName() {
		return Name;
	}

	public String getOntologyURIID() {
		return OntologyURIID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLegalReference(String newVal) {
		LegalReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOntologyURIID(String newVal) {
		OntologyURIID = newVal;
	}
}// end Regulation