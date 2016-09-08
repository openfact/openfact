package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe one of the parts of a procurement project that is being
 * subdivided to allow the contracting party to award different lots to
 * different economic operators under different contracts.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:05 a. m.
 */
public class ProcurementProjectLot {

	/**
	 * An identifier for this procurement project lot.
	 */
	private String id;
	private List<ProcurementProject> procurementProjects=new ArrayList<>();
	private List<TenderingTerms> tenderingTerms=new ArrayList<>();

	public ProcurementProjectLot() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProcurementProject> getProcurementProjects() {
		return procurementProjects;
	}

	public void setProcurementProjects(List<ProcurementProject> procurementProjects) {
		this.procurementProjects = procurementProjects;
	}

	public List<TenderingTerms> getTenderingTerms() {
		return tenderingTerms;
	}

	public void setTenderingTerms(List<TenderingTerms> tenderingTerms) {
		this.tenderingTerms = tenderingTerms;
	}
}// end ProcurementProjectLot