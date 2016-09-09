package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a trade financing instrument.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingEntity{

	/**
	 * A code signifying the type of this financing instrument.
	 */
	private CodeType financingInstrumentCode; 
	/**
	 * An identifier for this trade financing instrument.
	 */
	private IdentifierType ID; 
	private List<ClauseEntity> clauses = new ArrayList<>(); 
	private List<DocumentReferenceEntity> contractDocumentReference = new ArrayList<>(); 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private FinancialAccountEntity financingFinancialAccount; 
	private PartyEntity financingParty; 

}
