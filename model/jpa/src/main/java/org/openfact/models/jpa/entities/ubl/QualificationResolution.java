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
	private Code. Type AdmissionCode;
	/**
	 * Text describing a reason for an exclusion from the tendering process.
	 */
	private Text. Type ExclusionReason;
	/**
	 * Text describing this qualification resolution.
	 */
	private Text. Type Resolution;
	/**
	 * The date on which this qualification resolution was formalized.
	 */
	private Date. Type ResolutionDate;
	/**
	 * The time at which this qualification resolution was formalized.
	 */
	private Time. Type ResolutionTime;
	private Procurement Project Lot m_Procurement Project Lot;

	public Qualification Resolution(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getAdmissionCode(){
		return AdmissionCode;
	}

	public Text. Type getExclusionReason(){
		return ExclusionReason;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public Text. Type getResolution(){
		return Resolution;
	}

	public Date. Type getResolutionDate(){
		return ResolutionDate;
	}

	public Time. Type getResolutionTime(){
		return ResolutionTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdmissionCode(Code. Type newVal){
		AdmissionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExclusionReason(Text. Type newVal){
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
	public void setResolution(Text. Type newVal){
		Resolution = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResolutionDate(Date. Type newVal){
		ResolutionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResolutionTime(Time. Type newVal){
		ResolutionTime = newVal;
	}
}//end Qualification Resolution