package org.openfact.models.jpa.entities.ubl;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe the acceptance or rejection of an economic operator in a
 * tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:13 a. m.
 */
public class QualificationResolution {

	/**
	 * An indicator that the economic operator has been accepted into the tendering
	 * process (true) or rejected from the tendering process (false).
	 */
	private String admissionCode;
	/**
	 * Text describing a reason for an exclusion from the tendering process.
	 */
	private String exclusionReason;
	/**
	 * Text describing this qualification resolution.
	 */
	private String resolution;
	/**
	 * The date on which this qualification resolution was formalized.
	 */
	private LocalDate resolutionDate;
	/**
	 * The time at which this qualification resolution was formalized.
	 */
	private LocalTime resolutionTime;
	private ProcurementProjectLot m_ProcurementProjectLot;

	public String getAdmissionCode() {
		return admissionCode;
	}

	public void setAdmissionCode(String admissionCode) {
		this.admissionCode = admissionCode;
	}

	public String getExclusionReason() {
		return exclusionReason;
	}

	public void setExclusionReason(String exclusionReason) {
		this.exclusionReason = exclusionReason;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public LocalDate getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(LocalDate resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public LocalTime getResolutionTime() {
		return resolutionTime;
	}

	public void setResolutionTime(LocalTime resolutionTime) {
		this.resolutionTime = resolutionTime;
	}

	public ProcurementProjectLot getM_ProcurementProjectLot() {
		return m_ProcurementProjectLot;
	}

	public void setM_ProcurementProjectLot(ProcurementProjectLot m_ProcurementProjectLot) {
		this.m_ProcurementProjectLot = m_ProcurementProjectLot;
	}
}//end QualificationResolution