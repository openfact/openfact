package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ubl2.Auction;

/**
 * A class to describe the terms to be fulfilled by tenderers if an auction is to
 * be executed before the awarding of a tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:49 a. m.
 */
public class AuctionTerms {

	/**
	 * Indicates whether an electronic auction will be used before the awarding of a
	 * contract (true) or not (false).
	 */
	private boolean AuctionConstraintIndicator;
	/**
	 * The Uniform Resource Identifier (URI) of the electronic device used for the
	 * auction.
	 */
	private String AuctionURIID;
	/**
	 * Text describing the conditions under which the tenderers will be able to bid as
	 * part of the auction.
	 */
	private String ConditionsDescription;
	/**
	 * Text for tenderers describing terms governing the auction.
	 */
	private String Description;
	/**
	 * Text describing an electronic device used for the auction, including associated
	 * connectivity specifications.
	 */
	private String ElectronicDeviceDescription;
	/**
	 * Text describing a justification for the use of an auction in awarding the
	 * tender.
	 */
	private String JustificationDescription;
	/**
	 * Text describing the auction process.
	 */
	private String ProcessDescription;

	public Auction Terms(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getAuctionConstraintIndicator(){
		return AuctionConstraintIndicator;
	}

	public String getAuctionURIID(){
		return AuctionURIID;
	}

	public String getConditionsDescription(){
		return ConditionsDescription;
	}

	public String getDescription(){
		return Description;
	}

	public String getElectronicDeviceDescription(){
		return ElectronicDeviceDescription;
	}

	public String getJustificationDescription(){
		return JustificationDescription;
	}

	public String getProcessDescription(){
		return ProcessDescription;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAuctionConstraintIndicator(boolean newVal){
		AuctionConstraintIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAuctionURIID(String newVal){
		AuctionURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConditionsDescription(String newVal){
		ConditionsDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setElectronicDeviceDescription(String newVal){
		ElectronicDeviceDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJustificationDescription(String newVal){
		JustificationDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessDescription(String newVal){
		ProcessDescription = newVal;
	}
}//end Auction Terms