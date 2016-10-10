package org.openfact.ubl.pe;

import java.io.ByteArrayOutputStream;

import javax.xml.datatype.DatatypeConfigurationException;

import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.models.utils.ModelToType;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21NamespaceContext;
import com.helger.ubl21.UBL21Writer;
import com.helger.xml.microdom.serialize.MicroWriter;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xml.serialize.write.XMLWriterSettings;

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

			MapBasedNamespaceContext mapBasedNamespace = getBasedNamespaceContext(
					"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MicroWriter.writeToStream(UBL21Writer.invoice().getAsMicroDocument(invoiceType), out,
					new XMLWriterSettings().setNamespaceContext(mapBasedNamespace)
							.setPutNamespaceContextPrefixesInRoot(true));
			return DocumentUtils.getByteToDocument(out.toByteArray());
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

	@Override
	public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
		try {
			CreditNoteType creditNoteType = ModelToType.toType(creditNote);

			MapBasedNamespaceContext mapBasedNamespace = getBasedNamespaceContext(
					"urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MicroWriter.writeToStream(UBL21Writer.creditNote().getAsMicroDocument(creditNoteType), out,
					new XMLWriterSettings().setNamespaceContext(mapBasedNamespace)
							.setPutNamespaceContextPrefixesInRoot(true));
			return DocumentUtils.getByteToDocument(out.toByteArray());
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

	@Override
	public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
		try {
			DebitNoteType debitNoteType = ModelToType.toType(debitNote);

			MapBasedNamespaceContext mapBasedNamespace = getBasedNamespaceContext(
					"urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MicroWriter.writeToStream(UBL21Writer.debitNote().getAsMicroDocument(debitNoteType), out,
					new XMLWriterSettings().setNamespaceContext(mapBasedNamespace)
							.setPutNamespaceContextPrefixesInRoot(true));
			return DocumentUtils.getByteToDocument(out.toByteArray());
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ModelException(e.getMessage());
		}
	}

	private MapBasedNamespaceContext getBasedNamespaceContext(String defaultNamespace) {
		UBL21NamespaceContext namespace = UBL21NamespaceContext.getInstance();
		namespace.setMapping("ccts", "urn:un:unece:uncefact:documentation:2");
		namespace.setMapping("ds", "http://www.w3.org/2000/09/xmldsig#");
		namespace.setMapping("ext", "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
		namespace.setMapping("qdt", "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
		namespace.setMapping("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
		namespace.setMapping("udt", "urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2");
		MapBasedNamespaceContext mapBasedNamespace = new MapBasedNamespaceContext();
		mapBasedNamespace.addMappings(namespace);
		mapBasedNamespace.setDefaultNamespaceURI(defaultNamespace);
		return mapBasedNamespace;
	}
}
