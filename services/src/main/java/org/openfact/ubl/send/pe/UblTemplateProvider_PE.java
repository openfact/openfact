package org.openfact.ubl.send.pe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.transform.TransformerException;

import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.UblTemplateProvider;
import org.openfact.ubl.send.pe.header.UblHeaderHandlerResolver;
import org.openfact.ubl.send.pe.sunat.BillService;
import org.openfact.ubl.send.pe.sunat.BillService_Service;
import org.w3c.dom.Document;

import com.sun.xml.ws.util.ByteArrayDataSource;

import jodd.io.ZipBuilder;

public class UblTemplateProvider_PE implements UblTemplateProvider {

	private OpenfactSession session;
	private OrganizationModel organization;

	public UblTemplateProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public UblTemplateProvider setOrganization(OrganizationModel organization) {
		this.organization = organization;
		return this;
	}

	@Override
	public void send(String type) throws UblSenderException {
		throw new ModelException("method not implemented");
	}

	@Override
	public void sendInvoice(InvoiceModel invoice) throws UblSenderException {
		String fileName = generateXmlFileName(invoice);
		Document document = getUblProvider(organization).getDocument(organization, invoice);
		try {
			byte[] zip = generateZip(document, fileName);

			File file = new File(System.getProperty("user.home") + "/ubl/" +fileName+ ".zip");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(zip);
			fos.close();

			// Call Web Service Operation
			BillService_Service service = new BillService_Service();
			service.setHandlerResolver(new UblHeaderHandlerResolver(organization.getUblSenderConfig()));
			BillService port = service.getBillServicePort();

			// Config data
			DataSource dataSource = new ByteArrayDataSource(zip, "application/zip");
			DataHandler contentFile = new DataHandler(dataSource);

			// Send
			byte[] result = port.sendBill(fileName + ".zip", contentFile);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException {
		String fileName = generateXmlFileName(creditNote);
		Document document = getUblProvider(organization).getDocument(organization, creditNote);
		try {
			byte[] zip = generateZip(document, fileName);

			File file = new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(zip);
			fos.close();

			// Call Web Service Operation
			BillService_Service service = new BillService_Service();
			service.setHandlerResolver(new UblHeaderHandlerResolver(organization.getUblSenderConfig()));
			BillService port = service.getBillServicePort();

			// Config data
			DataSource dataSource = new ByteArrayDataSource(zip, "application/zip");
			DataHandler contentFile = new DataHandler(dataSource);

			// Send
			byte[] result = port.sendBill(fileName + ".zip", contentFile);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException {
		String fileName = generateXmlFileName(debitNote);
		Document document = getUblProvider(organization).getDocument(organization, debitNote);
		try {
			byte[] zip = generateZip(document, fileName);
			File file = new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(zip);
			fos.close();

			// Call Web Service Operation
			BillService_Service service = new BillService_Service();
			service.setHandlerResolver(new UblHeaderHandlerResolver(organization.getUblSenderConfig()));
			BillService port = service.getBillServicePort();

			// Config data
			DataSource dataSource = new ByteArrayDataSource(zip, "application/zip");
			DataHandler contentFile = new DataHandler(dataSource);

			// Send
			byte[] result = port.sendBill(fileName + ".zip", contentFile);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	private byte[] generateZip(Document document, String fileName) throws TransformerException, IOException {
		byte[] bytes = DocumentUtils.getBytesFromDocument(document);
		return ZipBuilder.createZipInMemory().addFolder("dummy/").add(bytes).path(fileName + ".xml").save().toBytes();
	}

	private UblProvider getUblProvider(OrganizationModel organization) {
		return session.getProvider(UblProvider.class, organization.getDefaultUblLocale());
	}

	private void send(String fileName, byte[] file, String contentType) throws UblSenderException {
		UblSenderProvider ublSender = session.getProvider(UblSenderProvider.class, "soap");
		ublSender.send(organization, fileName, file, contentType);
	}

	private String generateXmlFileName(InvoiceModel invoice) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}

		String codido;
		if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.FACTURA.getCodigo())) {
			codido = CodigoTipoDocumento.FACTURA.getCodigo();
		} else if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.BOLETA.getCodigo())) {
			codido = CodigoTipoDocumento.BOLETA.getCodigo();
		} else {
			throw new UblSenderException("Invalid invoice code", new Throwable());
		}

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codido).append("-");
		sb.append(invoice.getID());
		return sb.toString();
	}

	private String generateXmlFileName(CreditNoteModel creditNote) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}

		String codido = CodigoTipoDocumento.NOTA_CREDITO.getCodigo();

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codido).append("-");
		sb.append(creditNote.getID());
		return sb.toString();
	}

	private String generateXmlFileName(DebitNoteModel debitNote) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}

		String codido = CodigoTipoDocumento.NOTA_DEBITO.getCodigo();

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codido).append("-");
		sb.append(debitNote.getID());
		return sb.toString();
	}

}
