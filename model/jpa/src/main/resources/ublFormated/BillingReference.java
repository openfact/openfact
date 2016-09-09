package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReference{

	private List<BillingReferenceLine> BillingReferenceLines = new ArrayList<>();
	private DocumentReference SelfBilledInvoiceDocumentReference;
	private DocumentReference SelfBilledCreditNoteDocumentReference;
	private DocumentReference ReminderDocumentReference;
	private DocumentReference CreditNoteDocumentReference;
	private DocumentReference DebitNoteDocumentReference;
	private DocumentReference InvoiceDocumentReference;
	private DocumentReference AdditionalDocumentReference;

}
