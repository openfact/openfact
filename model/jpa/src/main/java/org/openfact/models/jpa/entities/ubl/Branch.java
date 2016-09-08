package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a branch or a division of an organization.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class Branch {

	private IdentifierType id;
	private NameType name;
	private List<Address> addresses=new ArrayList<>();
	private List<FinancialInstitution> FinancialInstitutions=new ArrayList<>();

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public NameType getName() {
		return name;
	}

	public void setName(NameType name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<FinancialInstitution> getFinancialInstitutions() {
		return FinancialInstitutions;
	}

	public void setFinancialInstitutions(List<FinancialInstitution> financialInstitutions) {
		FinancialInstitutions = financialInstitutions;
	}
}// end Branch