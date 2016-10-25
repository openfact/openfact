package org.openfact.ubl.send.pe;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.soap.SOAPFault;
import javax.xml.transform.TransformerException;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
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
import org.openfact.ubl.send.UblSenderResponseProvider;
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
		return session.getProvider(UblSenderProvider.class, organization.getDefaultUblLocale());
	}

	private UblSenderResponseProvider getUblSenderResponseProvider(OrganizationModel organization) {
		return session.getProvider(UblSenderResponseProvider.class, organization.getDefaultUblLocale())
				.setOrganization(organization);
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
	public void sendInvoice(List<InvoiceModel> invoices) throws UblSenderException {
		try {
			if (invoices.get(0).getInvoiceTypeCode().equals(CodigoTipoDocumento.FACTURA.getCodigo())) {
				String fileName = generateXmlFileName(invoices.get(0));
				byte[] zip = generateZip(ArrayUtils.toPrimitive(invoices.get(0).getXmlDocument()), fileName);
				writeByteToFile(fileName, zip, false);
				byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName,
						invoices.get(0).getInvoiceTypeCode(), InternetMediaType.ZIP,
						organization.getUblSenderConfig().get("urlService"));
				writeByteToFile(fileName, result, true);
				getUblSenderResponseProvider(organization).senderInvoiceResponse(invoices,
						ArrayUtils.toPrimitive(invoices.get(0).getXmlDocument()), result);

			} else if (invoices.get(0).getInvoiceTypeCode().equals(CodigoTipoDocumento.BOLETA.getCodigo())) {
				throw new UblSenderException("method not implemented", new Throwable());
			} else {
				throw new UblSenderException("Invalid invoice template", new Throwable());
			}

		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			if (invoices.get(0).getInvoiceTypeCode().equals(CodigoTipoDocumento.FACTURA.getCodigo())) {
				getUblSenderResponseProvider(organization).senderInvoiceResponse(invoices,
						ArrayUtils.toPrimitive(invoices.get(0).getXmlDocument()), null,
						new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
			} else {
				throw new UblSenderException("method not implemented", new Throwable());
			}
		}
	}

	@Override
	public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException {
		try {
			String fileName = generateXmlFileName(creditNote);
			byte[] zip = generateZip(ArrayUtils.toPrimitive(creditNote.getXmlDoument()), fileName);
			writeByteToFile(fileName, zip, false);
			byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName,
					CodigoTipoDocumento.NOTA_CREDITO.getCodigo(), InternetMediaType.ZIP,
					organization.getUblSenderConfig().get("urlService"));
			writeByteToFile(fileName, result, true);
			getUblSenderResponseProvider(organization).senderCreditNoteResponse(creditNote, result);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			getUblSenderResponseProvider(organization).senderCreditNoteResponse(creditNote, null,
					new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
		}
	}

	@Override
	public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException {
		try {
			String fileName = generateXmlFileName(debitNote);
			byte[] zip = generateZip(ArrayUtils.toPrimitive(debitNote.getXmlDoument()), fileName);
			byte[] result = getUblSenderProvider(organization).send(organization, zip, fileName,
					CodigoTipoDocumento.NOTA_DEBITO.getCodigo(), InternetMediaType.ZIP,
					organization.getUblSenderConfig().get("urlService"));
			writeByteToFile(fileName, result, true);
			getUblSenderResponseProvider(organization).senderDebitNoteResponse(debitNote, result);
		} catch (TransformerException e) {
			throw new UblSenderException(e);
		} catch (IOException e) {
			throw new UblSenderException(e);
		} catch (SOAPFaultException e) {
			SOAPFault soapFault = e.getFault();
			getUblSenderResponseProvider(organization).senderDebitNoteResponse(debitNote, null,
					new String[] { soapFault.getFaultCode(), soapFault.getFaultString() });
		}
	}

	private byte[] generateZip(byte[] document, String fileName) throws TransformerException, IOException {
		return ZipBuilder.createZipInMemory()/* .addFolder("dummy/") */.add(document).path(fileName + ".xml").save()
				.toBytes();
	}

	private void writeByteToFile(String fileName, byte[] document, boolean response) throws IOException {
		if (!response) {
			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/" + fileName + ".zip"),
					document);
		} else {
			FileUtils.writeByteArrayToFile(new File(System.getProperty("user.home") + "/ubl/R" + fileName + ".zip"),
					document);
		}
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
