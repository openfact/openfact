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
	private String ID;
	private ProcurementProject m_ProcurementProject;
	private TenderingTerms m_TenderingTerms;

	public ProcurementProjectLot() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public ProcurementProject getProcurementProject() {
		return m_ProcurementProject;
	}

	public TenderingTerms getTenderingTerms() {
		return m_TenderingTerms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementProject(ProcurementProject newVal) {
		m_ProcurementProject = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderingTerms(TenderingTerms newVal) {
		m_TenderingTerms = newVal;
	}
}// end ProcurementProjectLot