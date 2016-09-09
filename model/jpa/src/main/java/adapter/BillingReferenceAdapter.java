package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReferenceAdapter{

	private List<BillingReferenceLineAdapter> BillingReferenceLines = new ArrayList<>();
	private DocumentReferenceAdapter SelfBilledInvoiceDocumentReference;
	private DocumentReferenceAdapter SelfBilledCreditNoteDocumentReference;
	private DocumentReferenceAdapter ReminderDocumentReference;
	private DocumentReferenceAdapter CreditNoteDocumentReference;
	private DocumentReferenceAdapter DebitNoteDocumentReference;
	private DocumentReferenceAdapter InvoiceDocumentReference;
	private DocumentReferenceAdapter AdditionalDocumentReference;

}
