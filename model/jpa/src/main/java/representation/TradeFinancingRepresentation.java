package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a trade financing instrument.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingRepresentation{

	/**
	 * A code signifying the type of this financing instrument.
	 */
	private CodeType FinancingInstrumentCode;
	/**
	 * An identifier for this trade financing instrument.
	 */
	private IdentifierType ID;
	private List<ClauseRepresentation> Clauses = new ArrayList<>();
	private List<DocumentReferenceRepresentation> ContractDocumentReference = new ArrayList<>();
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private FinancialAccountRepresentation FinancingFinancialAccount;
	private PartyRepresentation FinancingParty;

}
