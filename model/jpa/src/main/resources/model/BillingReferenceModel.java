package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReferenceModel{

	private List<BillingReferenceLineModel> billingReferenceLines = new ArrayList<>();
	private DocumentReferenceModel selfBilledinvoiceDocumentReference;
	private DocumentReferenceModel selfBilledcreditNoteDocumentReference;
	private DocumentReferenceModel reminderDocumentReference;
	private DocumentReferenceModel creditNoteDocumentReference;
	private DocumentReferenceModel debitNoteDocumentReference;
	private DocumentReferenceModel invoiceDocumentReference;
	private DocumentReferenceModel additionalDocumentReference;

}
