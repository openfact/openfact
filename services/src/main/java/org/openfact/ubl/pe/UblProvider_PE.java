package org.openfact.ubl.pe;

import javax.xml.datatype.DatatypeConfigurationException;

import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToType;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21NamespaceContext;
import com.helger.ubl21.UBL21Writer;
import com.helger.ubl21.UBL21WriterBuilder;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblProvider_PE implements UblProvider {

	private static final Logger log = Logger.getLogger(UblProvider_PE.class);

	protected OpenfactSession session;

	public UblProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	@Override
	public Document getDocument(OrganizationModel organization, InvoiceModel invoice) {
		try {
			InvoiceType invoiceType = ModelToType.toType(invoice);

			UBL21NamespaceContext namespaceContext = UBL21NamespaceContext.getInstance();
			namespaceContext.setMapping("sac",
					"urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
			namespaceContext.setMapping("udt",
					"urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2");
			namespaceContext.setMapping("ccts", "urn:un:unece:uncefact:documentation:2");
			namespaceContext.setMapping("ext",
					"urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
			namespaceContext.setMapping("qdt", "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
			namespaceContext.setMapping("ds", "http://www.w3.org/2000/09/xmldsig#");
			namespaceContext.setMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
			
			
			System.out.println(namespaceContext.getCustomNamespaceURI("sac"));
			System.out.println(namespaceContext.getMappingCount());
			return UBL21Writer.invoice().setNamespaceContext(namespaceContext).getAsDocument(invoiceType);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

	@Override
	public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
		try {
			CreditNoteType creditNoteType = ModelToType.toType(creditNote);
			return UBL21Writer.creditNote().getAsDocument(creditNoteType);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

	@Override
	public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
		try {
			DebitNoteType debitNoteType = ModelToType.toType(debitNote);
			return UBL21Writer.debitNote().getAsDocument(debitNoteType);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

}
