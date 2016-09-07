package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class Declaration {

	/**
	 * A code signifying the type of this declaration.
	 */
	private String declarationTypeCode;
	/**
	 * Text describing this declaration.
	 */
	private String description;
	/**
	 * The name of this declaration.
	 */
	private String name;
	private List<EvidenceSupplied> evidenceSupplieds=new ArrayList<>();

	public Declaration() {

	}

	public void finalize() throws Throwable {

	}

	public String getDeclarationTypeCode() {
		return declarationTypeCode;
	}

	public void setDeclarationTypeCode(String declarationTypeCode) {
		this.declarationTypeCode = declarationTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EvidenceSupplied> getEvidenceSupplieds() {
		return evidenceSupplieds;
	}

	public void setEvidenceSupplieds(List<EvidenceSupplied> evidenceSupplieds) {
		this.evidenceSupplieds = evidenceSupplieds;
	}
}// end Declaration