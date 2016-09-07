package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupply {

	private Consumption Average m_Consumption Average;
	private Consumption Correction Energy Water Consumption Correction;
	private Consumption Report m_Consumption Report;
	private Energy Tax Report m_Energy Tax Report;

	public Energy Water Supply(){

	}

	public void finalize() throws Throwable {

	}
	public Consumption Average getConsumption Average(){
		return m_Consumption Average;
	}

	public Consumption Report getConsumption Report(){
		return m_Consumption Report;
	}

	public Energy Tax Report getEnergy Tax Report(){
		return m_Energy Tax Report;
	}

	public Consumption Correction getEnergy Water Consumption Correction(){
		return Energy Water Consumption Correction;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption Average(Consumption Average newVal){
		m_Consumption Average = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption Report(Consumption Report newVal){
		m_Consumption Report = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnergy Tax Report(Energy Tax Report newVal){
		m_Energy Tax Report = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnergy Water Consumption Correction(Consumption Correction newVal){
		Energy Water Consumption Correction = newVal;
	}
}//end Energy Water Supply