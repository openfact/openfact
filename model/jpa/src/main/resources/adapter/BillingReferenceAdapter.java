package org.openfact.models.jpa.entities.ubl;
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

	private List<BillingReferenceLineAdapter> billingReferenceLines = new ArrayList<>(); 
	private DocumentReferenceAdapter selfBilledInvoiceDocumentReference; 
	private DocumentReferenceAdapter selfBilledCreditNoteDocumentReference; 
	private DocumentReferenceAdapter reminderDocumentReference; 
	private DocumentReferenceAdapter creditNoteDocumentReference; 
	private DocumentReferenceAdapter debitNoteDocumentReference; 
	private DocumentReferenceAdapter invoiceDocumentReference; 
	private DocumentReferenceAdapter additionalDocumentReference; 

}
