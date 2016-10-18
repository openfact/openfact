package org.openfact.ubl.send.pe;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.commons.io.FileUtils;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.UblTemplateProvider;

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

	private UblSenderProvider getUblSenderProvider(OrganizationModel organization) {
		return session.getProvider(UblSenderProvider.class, "soa");
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
		byte[] document = invoice.getXmlDoument();
		try {
			byte[] zip = generateZip(document, fileName);

			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip"),
					zip);

			// Send
			byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName,
					invoice.getInvoiceTypeCode(), InternetMediaType.ZIP,
					"https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService");
			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/R" + fileName + ".zip"),
					result);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException {
		String fileName = generateXmlFileName(creditNote);
		byte[] document = null;//
		// creditNote);
		try {
			byte[] zip = generateZip(document, fileName);

			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip"),
					zip);
			byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName, "",
					InternetMediaType.ZIP, "https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService");
			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/R" + fileName + ".zip"),
					result);

		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	@Override
	public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException {
		String fileName = generateXmlFileName(debitNote);
		byte[] document = null;
		try {
			byte[] zip = generateZip(document, fileName);
			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip"),
					zip);

			byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName, "",
					InternetMediaType.ZIP, "https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService");

			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/R" + fileName + ".zip"),
					result);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		}
	}

	private byte[] generateZip(byte[] document, String fileName) throws TransformerException, IOException {
		return ZipBuilder.createZipInMemory()/*.addFolder("dummy/")*/.add(document).path(fileName + ".xml").save()
				.toBytes();
	}

	private String generateXmlFileName(InvoiceModel invoice) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}
		String codigo;
		if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.FACTURA.getCodigo())) {
			codigo = CodigoTipoDocumento.FACTURA.getCodigo();
		} else if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.BOLETA.getCodigo())) {
			codigo = CodigoTipoDocumento.BOLETA.getCodigo();
		} else {
			throw new UblSenderException("Invalid invoice code", new Throwable());
		}

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codigo).append("-");
		sb.append(invoice.getID());
		return sb.toString();
	}

	private String generateXmlFileName(CreditNoteModel creditNote) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}

		String codigo = CodigoTipoDocumento.NOTA_CREDITO.getCodigo();

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codigo).append("-");
		sb.append(creditNote.getID());
		return sb.toString();
	}

	private String generateXmlFileName(DebitNoteModel debitNote) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}
		String codigo = CodigoTipoDocumento.NOTA_DEBITO.getCodigo();
		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codigo).append("-");
		sb.append(debitNote.getID());
		return sb.toString();
	}

}
