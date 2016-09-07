package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the qualifications of a tenderer party.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:22 a. m.
 */
public class TendererPartyQualification {

	private ProcurementProjectLot Interested ProcurementProjectLot;
	private Qualifying Party Main Qualifying Party;
	private Qualifying Party Additional Qualifying Party;

	public Tenderer Party Qualification(){

	}

	public void finalize() throws Throwable {

	}
	public Qualifying Party getAdditional Qualifying Party(){
		return Additional Qualifying Party;
	}

	public ProcurementProjectLot getInterested ProcurementProjectLot(){
		return Interested ProcurementProjectLot;
	}

	public Qualifying Party getMain Qualifying Party(){
		return Main Qualifying Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Qualifying Party(Qualifying Party newVal){
		Additional Qualifying Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInterested ProcurementProjectLot(ProcurementProjectLot newVal){
		Interested ProcurementProjectLot = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMain Qualifying Party(Qualifying Party newVal){
		Main Qualifying Party = newVal;
	}
}//end Tenderer Party Qualification