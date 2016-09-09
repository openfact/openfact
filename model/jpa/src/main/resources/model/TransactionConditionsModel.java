package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe purchasing, sales, or payment conditions.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditionsModel{

	/**
	 * A code signifying a type of action relating to sales or payment conditions.
	 */
	private CodeType actionCode;
	/**
	 * Text describing the transaction conditions.
	 */
	private TextType description;
	/**
	 * An identifier for conditions of the transaction, typically purchase/sales
	 * conditions.
	 */
	private IdentifierType ID;
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>();

}
