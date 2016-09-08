package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * A class to define a reference to a procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class ProjectReference {

	/**
	 * An identifier for the referenced project.
	 */
	private String id;
	/**
	 * The date on which the referenced project was issued.
	 */
	private LocalDate issueDate;
	/**
	 * A universally unique identifier for the referenced project.
	 */
	private String UUID;
	private List<WorkPhaseReference> workPhaseReferences=new ArrayList<>();

	public ProjectReference() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public List<WorkPhaseReference> getWorkPhaseReferences() {
		return workPhaseReferences;
	}

	public void setWorkPhaseReferences(List<WorkPhaseReference> workPhaseReferences) {
		this.workPhaseReferences = workPhaseReferences;
	}
}// end Project Reference