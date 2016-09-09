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
public class BillingReferenceEntity{

	private List<BillingReferenceLineEntity> billingReferenceLines = new ArrayList<>(); 
	private DocumentReferenceEntity selfBilledInvoiceDocumentReference; 
	private DocumentReferenceEntity selfBilledCreditNoteDocumentReference; 
	private DocumentReferenceEntity reminderDocumentReference; 
	private DocumentReferenceEntity creditNoteDocumentReference; 
	private DocumentReferenceEntity debitNoteDocumentReference; 
	private DocumentReferenceEntity invoiceDocumentReference; 
	private DocumentReferenceEntity additionalDocumentReference; 

}
