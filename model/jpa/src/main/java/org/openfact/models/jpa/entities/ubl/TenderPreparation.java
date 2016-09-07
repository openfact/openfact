package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe directions for preparing a tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:16 a. m.
 */
public class TenderPreparation {

	/**
	 * Text describing the tender envelope.
	 */
	private Text. Type Description;
	/**
	 * An identifier for the open tender associated with this tender preparation.
	 */
	private Identifier. Type OpenTenderID;
	/**
	 * An identifier for the tender envelope to be used with the tender.
	 */
	private Identifier. Type TenderEnvelopeID;
	/**
	 * A code signifying the type of tender envelope (economical or objective criteria
	 * versus technical or subjective criteria).
	 */
	private Code. Type TenderEnvelopeTypeCode;
	private Procurement Project Lot m_Procurement Project Lot;
	private Tender Requirement Document Tender Requirement;

	public Tender Preparation(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Tender Requirement getDocument Tender Requirement(){
		return Document Tender Requirement;
	}

	public Identifier. Type getOpenTenderID(){
		return OpenTenderID;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public Identifier. Type getTenderEnvelopeID(){
		return TenderEnvelopeID;
	}

	public Code. Type getTenderEnvelopeTypeCode(){
		return TenderEnvelopeTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Tender Requirement(Tender Requirement newVal){
		Document Tender Requirement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOpenTenderID(Identifier. Type newVal){
		OpenTenderID = newVal;
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
	public void setTenderEnvelopeID(Identifier. Type newVal){
		TenderEnvelopeID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderEnvelopeTypeCode(Code. Type newVal){
		TenderEnvelopeTypeCode = newVal;
	}
}//end Tender Preparation