package org.openfact.models.jpa.entities.ubl;

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

	private String id;
	private String name;
	private List<Address> addresses=new ArrayList<>();
	private List<FinancialInstitution> FinancialInstitutions=new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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