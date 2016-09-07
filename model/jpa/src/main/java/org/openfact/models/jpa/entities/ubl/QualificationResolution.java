package org.openfact.models.jpa.entities.ubl;


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
	private String AdmissionCode;
	/**
	 * Text describing a reason for an exclusion from the tendering process.
	 */
	private String ExclusionReason;
	/**
	 * Text describing this qualification resolution.
	 */
	private String Resolution;
	/**
	 * The date on which this qualification resolution was formalized.
	 */
	private LocalDate ResolutionDate;
	/**
	 * The time at which this qualification resolution was formalized.
	 */
	private LocalTime ResolutionTime;
	private Procurement Project Lot m_Procurement Project Lot;

	public Qualification Resolution(){

	}

	public void finalize() throws Throwable {

	}
	public String getAdmissionCode(){
		return AdmissionCode;
	}

	public String getExclusionReason(){
		return ExclusionReason;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public String getResolution(){
		return Resolution;
	}

	public LocalDate getResolutionDate(){
		return ResolutionDate;
	}

	public LocalTime getResolutionTime(){
		return ResolutionTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdmissionCode(String newVal){
		AdmissionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExclusionReason(String newVal){
		ExclusionReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Project Lot(Procurement Project Lot newVal){
		m_Procurement Project Lot = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResolution(String newVal){
		Resolution = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResolutionDate(LocalDate newVal){
		ResolutionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResolutionTime(LocalTime newVal){
		ResolutionTime = newVal;
	}
}//end Qualification Resolution