package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReferenceRepresentation{

	private List<BillingReferenceLineRepresentation> BillingReferenceLines = new ArrayList<>();
	private DocumentReferenceRepresentation SelfBilledInvoiceDocumentReference;
	private DocumentReferenceRepresentation SelfBilledCreditNoteDocumentReference;
	private DocumentReferenceRepresentation ReminderDocumentReference;
	private DocumentReferenceRepresentation CreditNoteDocumentReference;
	private DocumentReferenceRepresentation DebitNoteDocumentReference;
	private DocumentReferenceRepresentation InvoiceDocumentReference;
	private DocumentReferenceRepresentation AdditionalDocumentReference;

}
