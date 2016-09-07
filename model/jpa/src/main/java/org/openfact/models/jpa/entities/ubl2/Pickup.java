

/**
 * A class to describe a pickup for delivery.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:49 a. m.
 */
public class Pickup {

	/**
	 * The actual pickup date.
	 */
	private Date. Type ActualPickupDate;
	/**
	 * The actual pickup time.
	 */
	private Time. Type ActualPickupTime;
	/**
	 * The earliest pickup date.
	 */
	private Date. Type EarliestPickupDate;
	/**
	 * The earliest pickup time.
	 */
	private Time. Type EarliestPickupTime;
	/**
	 * An identifier for this pickup.
	 */
	private Identifier. Type ID;
	/**
	 * The latest pickup date.
	 */
	private Date. Type LatestPickupDate;
	/**
	 * The latest pickup time.
	 */
	private Time. Type LatestPickupTime;
	private Location Pickup Location;
	private Party Pickup Party;

	public Pickup(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getActualPickupDate(){
		return ActualPickupDate;
	}

	public Time. Type getActualPickupTime(){
		return ActualPickupTime;
	}

	public Date. Type getEarliestPickupDate(){
		return EarliestPickupDate;
	}

	public Time. Type getEarliestPickupTime(){
		return EarliestPickupTime;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getLatestPickupDate(){
		return LatestPickupDate;
	}

	public Time. Type getLatestPickupTime(){
		return LatestPickupTime;
	}

	public Location getPickup Location(){
		return Pickup Location;
	}

	public Party getPickup Party(){
		return Pickup Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualPickupDate(Date. Type newVal){
		ActualPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualPickupTime(Time. Type newVal){
		ActualPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEarliestPickupDate(Date. Type newVal){
		EarliestPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEarliestPickupTime(Time. Type newVal){
		EarliestPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestPickupDate(Date. Type newVal){
		LatestPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestPickupTime(Time. Type newVal){
		LatestPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPickup Location(Location newVal){
		Pickup Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPickup Party(Party newVal){
		Pickup Party = newVal;
	}
}//end Pickup