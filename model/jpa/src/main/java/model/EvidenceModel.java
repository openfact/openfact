package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an item of evidentiary support for representations of
 * capabilities or the ability to meet tendering requirements, which an economic
 * operator must provide for acceptance into a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:01 a. m.
 */
public class EvidenceModel{

	/**
	 * Information about a candidate statement that the contracting authority accepts
	 * as a sufficient response.
	 */
	private TextType CandidateStatement;
	/**
	 * The textual description for this Evidence.
	 */
	private TextType Description;
	/**
	 * A code signifying the type of evidence.
	 */
	private CodeType EvidenceTypeCode;
	/**
	 * An identifier for this item of evidentiary support.
	 */
	private IdentifierType ID;
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<LanguageModel> Languages = new ArrayList<>();
	private PartyModel EvidenceIssuingParty;

}
