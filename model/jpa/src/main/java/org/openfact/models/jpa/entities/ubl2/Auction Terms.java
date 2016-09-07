

/**
 * A class to describe the terms to be fulfilled by tenderers if an auction is to
 * be executed before the awarding of a tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:49 a. m.
 */
public class Auction Terms {

	/**
	 * Indicates whether an electronic auction will be used before the awarding of a
	 * contract (true) or not (false).
	 */
	private Indicator. Type AuctionConstraintIndicator;
	/**
	 * The Uniform Resource Identifier (URI) of the electronic device used for the
	 * auction.
	 */
	private Identifier. Type AuctionURIID;
	/**
	 * Text describing the conditions under which the tenderers will be able to bid as
	 * part of the auction.
	 */
	private Text. Type ConditionsDescription;
	/**
	 * Text for tenderers describing terms governing the auction.
	 */
	private Text. Type Description;
	/**
	 * Text describing an electronic device used for the auction, including associated
	 * connectivity specifications.
	 */
	private Text. Type ElectronicDeviceDescription;
	/**
	 * Text describing a justification for the use of an auction in awarding the
	 * tender.
	 */
	private Text. Type JustificationDescription;
	/**
	 * Text describing the auction process.
	 */
	private Text. Type ProcessDescription;

	public Auction Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Indicator. Type getAuctionConstraintIndicator(){
		return AuctionConstraintIndicator;
	}

	public Identifier. Type getAuctionURIID(){
		return AuctionURIID;
	}

	public Text. Type getConditionsDescription(){
		return ConditionsDescription;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Text. Type getElectronicDeviceDescription(){
		return ElectronicDeviceDescription;
	}

	public Text. Type getJustificationDescription(){
		return JustificationDescription;
	}

	public Text. Type getProcessDescription(){
		return ProcessDescription;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAuctionConstraintIndicator(Indicator. Type newVal){
		AuctionConstraintIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAuctionURIID(Identifier. Type newVal){
		AuctionURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConditionsDescription(Text. Type newVal){
		ConditionsDescription = newVal;
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
	public void setElectronicDeviceDescription(Text. Type newVal){
		ElectronicDeviceDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJustificationDescription(Text. Type newVal){
		JustificationDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessDescription(Text. Type newVal){
		ProcessDescription = newVal;
	}
}//end Auction Terms