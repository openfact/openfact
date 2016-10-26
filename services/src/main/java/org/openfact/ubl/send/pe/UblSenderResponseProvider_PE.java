package org.openfact.ubl.send.pe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderResponseProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UblSenderResponseProvider_PE implements UblSenderResponseProvider {
	private static final Logger log = Logger.getLogger(UblSenderResponseProvider_PE.class);
	private OpenfactSession session;
	private OrganizationModel organization;

	public UblSenderResponseProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public UblSenderResponseProvider setOrganization(OrganizationModel organization) {
		this.organization = organization;
		return this;
	}

	@Override
	public void senderInvoiceResponse(List<InvoiceModel> invoices, byte[] xmlDocument, byte[] eventDocument,
			String... fault) throws UblSenderException {
		try {
			UblResponse_PE response = null;
			if (eventDocument != null) {
				response = byteToResponse(eventDocument);
			} else {
				response = faultToResponse(fault);
			}
			if (!response.isError()) {
				for (InvoiceModel invoice : invoices) {
					invoice.removeRequeridAction(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
				}
			}
			Map<String, String> result = getResponseToMap(response, invoices.get(0).getInvoiceTypeCode());
			session.sendEvent().addEvent(organization, invoices, xmlDocument, eventDocument, response.isError(),
					result);
		} catch (Exception e) {
			throw new UblSenderException(e);
		}

	}

	@Override
	public void senderCreditNoteResponse(CreditNoteModel creditNote, byte[] eventDocument, String... fault)
			throws UblSenderException {
		try {
			UblResponse_PE response = null;

			if (eventDocument != null) {
				response = byteToResponse(eventDocument);
			} else {
				response = faultToResponse(fault);
			}
			if (!response.isError()) {
				creditNote.removeRequeridAction(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
			}
			Map<String, String> result = getResponseToMap(response, CodigoTipoDocumento.NOTA_CREDITO.getCodigo());
			session.sendEvent().addEvent(organization, creditNote, ArrayUtils.toPrimitive(creditNote.getXmlDoument()),
					eventDocument, response.isError(), result);
		} catch (Exception e) {
			throw new UblSenderException(e);
		}

	}

	@Override
	public void senderDebitNoteResponse(DebitNoteModel debitNote, byte[] eventDocument, String... fault)
			throws UblSenderException {
		try {
			UblResponse_PE response = null;

			if (eventDocument != null) {
				response = byteToResponse(eventDocument);
			} else {
				response = faultToResponse(fault);
			}
			if (!response.isError()) {
				debitNote.removeRequeridAction(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
			}
			Map<String, String> result = getResponseToMap(response, CodigoTipoDocumento.NOTA_DEBITO.getCodigo());
			session.sendEvent().addEvent(organization, debitNote, ArrayUtils.toPrimitive(debitNote.getXmlDoument()),
					eventDocument, response.isError(), result);
		} catch (Exception e) {
			throw new UblSenderException(e);
		}

	}

	@Override
	public void senderDocumentResponse(byte[] xmlDocument, byte[] eventDocument, String typeDocument, String... fault)
			throws UblSenderException {
		throw new ModelException("method not implemented");

	}

	private Map<String, String> getResponseToMap(UblResponse_PE response, String invoiceTypeCode) {
		String message = "";
		Map<String, String> result = new HashMap<>();
		if (!response.isError()) {
			Integer errorCode = Integer.valueOf(response.getErrorCode());

			String msgError = response.getMessage();
			List<String> listaWarnings = response.getWarnings() != null ? response.getWarnings()
					: new ArrayList<String>();

			if (!invoiceTypeCode.equals(CodigoTipoDocumento.BOLETA.getCodigo())) {
				if ((errorCode.intValue() == 0) && (listaWarnings.size() == 0)) {
					result.put("situacion", "03");
				}
				if ((errorCode.intValue() == 0) && (listaWarnings.size() > 0)) {
					result.put("situacion", "04");
				}
				if (errorCode.intValue() > 0) {
					// get code error and message error from data base
					result.put("situacion", "10");
					result.put("message", message);
				}
			} else {
				result.put("situacion", "08");
				result.put("message", "Nro. Ticket: " + msgError);
				result.put("ticket", msgError);
			}
		} else {
			Integer errorCode = Integer.valueOf(response.getErrorCode());
			String msgError = response.getMessage();
			// get code error and message error from data base
			message = errorCode + "-" + msgError;
			result.put("situacion", "05");
			result.put("message", message);
		}
		return result;
	}

	private UblResponse_PE byteToResponse(byte[] data) throws Exception {
		byte intCode = -1;
		try {
			data = unzip(data);
			Document e = DocumentUtils.getByteToDocument(data);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String codigo = (String) xPath.evaluate(
					"/*[local-name()=\'ApplicationResponse\']/*[local-name()=\'DocumentResponse\']/*[local-name()=\'Response\']/*[local-name()=\'ResponseCode\']/text()",
					e.getDocumentElement(), XPathConstants.STRING);
			String mensaje = (String) xPath.evaluate(
					"/*[local-name()=\'ApplicationResponse\']/*[local-name()=\'DocumentResponse\']/*[local-name()=\'Response\']/*[local-name()=\'Description\']/text()",
					e.getDocumentElement(), XPathConstants.STRING);
			NodeList warningsNode = (NodeList) xPath.evaluate(
					"/*[local-name()=\'ApplicationResponse\']/*[local-name()=\'Note\']", e.getDocumentElement(),
					XPathConstants.NODESET);
			ArrayList lstWarnings = new ArrayList();
			for (int i = 0; i < warningsNode.getLength(); ++i) {
				Node show = warningsNode.item(i);
				lstWarnings.add(show.getTextContent());
			}
			int ErrorCode = (new Integer(codigo)).intValue();
			return new UblResponse_PE(ErrorCode, mensaje, lstWarnings);
		} catch (UblSenderException e) {
			return new UblResponse_PE(intCode, e.getMessage(), (List) null);
		} catch (XPathExpressionException e) {
			return new UblResponse_PE(intCode, e.getMessage(), (List) null);
		}
	}

	private UblResponse_PE faultToResponse(String... soapFault) {
		String faultCode = soapFault[0];
		String message = "";
		String retCode = getErrorCode(faultCode);
		String faultString = soapFault[1];
		int intCode = -1;
		try {
			if ("".equals(retCode)) {
				intCode = (new Integer(faultString)).intValue();
			} else {
				intCode = (new Integer(retCode)).intValue();
			}
			Integer errorCode = Integer.valueOf(soapFault[1].indexOf("Detalle"));
			if (errorCode.intValue() > 0) {
				message = soapFault[1].substring(0, errorCode.intValue() - 1);
			} else {
				message = soapFault[1];
			}
		} catch (Throwable e) {
			message = "Error al invocar Servicio: " + e.getMessage();
		}
		return new UblResponse_PE(intCode, message, (List<String>) null);
	}

	private String getErrorCode(String faultCode) {
		Integer length = Integer.valueOf(faultCode.length());
		String errorCode = "";

		for (int i = 0; i < length.intValue(); ++i) {
			if (Character.isDigit(faultCode.charAt(i))) {
				errorCode = errorCode + faultCode.charAt(i);
			}
		}
		return errorCode;
	}

	private byte[] unzip(byte[] data) {
		try {
			ByteArrayInputStream e = new ByteArrayInputStream(data);
			ZipInputStream srcIs = new ZipInputStream(e);
			ByteArrayOutputStream destOs = new ByteArrayOutputStream();
			ZipEntry entry = null;

			while (true) {
				do {
					if ((entry = srcIs.getNextEntry()) == null) {
						destOs.flush();
						byte[] b2 = destOs.toByteArray();
						destOs.close();
						destOs.close();
						srcIs.close();
						e.close();
						return b2;
					}
				} while (!entry.getName().endsWith(".xml"));

				boolean b = false;
				byte[] buffer = new byte[2048];

				int b1;
				while ((b1 = srcIs.read(buffer)) > 0) {
					destOs.write(buffer, 0, b1);
				}
			}
		} catch (Exception e) {
			throw new ModelException("Error al descomprimir la constancia", e.getCause());
		}
	}
}
