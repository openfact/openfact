

/**
 * A class to define a line describing the transaction that updates the
 * specification of an item in a catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:18 a. m.
 */
public class Catalogue Item Specification Update Line {

	/**
	 * An identifier for the line to be updated in a catalogue.
	 */
	private Identifier. Type ID;
	private Customer Party Contractor Customer Party;
	private Item m_Item;
	private Supplier Party Seller Supplier Party;

	public Catalogue Item Specification Update Line(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractor Customer Party(Customer Party newVal){
		Contractor Customer Party = newVal;
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
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}
}//end Catalogue Item Specification Update Line