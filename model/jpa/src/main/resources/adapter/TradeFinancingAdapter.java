package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a trade financing instrument.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingAdapter{

	/**
	 * A code signifying the type of this financing instrument.
	 */
	private CodeType financingInstrumentCode;
	/**
	 * An identifier for this trade financing instrument.
	 */
	private IdentifierType ID;
	private List<ClauseAdapter> clauses = new ArrayList<>();
	private List<DocumentReferenceAdapter> contractDocumentReference = new ArrayList<>();
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();
	private FinancialAccountAdapter financingFinancialAccount;
	private PartyAdapter financingParty;

}
