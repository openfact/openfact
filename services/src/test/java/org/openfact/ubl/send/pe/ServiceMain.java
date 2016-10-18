package org.openfact.ubl.send.pe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.openfact.models.ModelException;
import org.openfact.ubl.send.ServiceWrapper;
import org.openfact.ubl.send.pe.UblResponse_PE;
import org.openfact.ubl.send.pe.sunat.BillService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ServiceMain {
	static ServiceWrapper<BillService> client;

	public static void main(String[] args) {
		Map<String, String> config = new HashMap<>();
		config.put("username", "10467793549MODDATOS");
		config.put("password", "moddatos");
		client = new ServiceWrapper<BillService>(config,
				"https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService");
		UblResponse_PE respon = sendBill("10467793549-01-F001-00000007.zip", "/home/lxpary/ubl/");

		Map<String, String> resultado = new HashMap();
		if (!respon.isError()) {
			Integer errorCode = Integer.valueOf(respon.getCode());
			String msgError = respon.getMsj();
			System.out.println("isError es Falso, Mensaje Error Obtenido: " + respon.getMsj());
			List<String> listaWarnings = respon.getWarnings() != null ? respon.getWarnings() : new ArrayList();
			System.out.println("isError es Falso, Cantidad de Warnings: " + listaWarnings.size());
			resultado.put("situacion", "08");
			resultado.put("mensaje", "Nro. Ticket: " + msgError);

		} else {
			Integer errorCode = Integer.valueOf(respon.getCode());
			System.out.println("isError es True, Codigo de Error : " + errorCode);
			String msgError = respon.getMsj();
			System.out.println("isError es True, Mensaje Error Obtenido: " + msgError);

			resultado.put("situacion", "05");
			resultado.put("mensaje", "codigo de error personalizado");
		}
	}

	public static UblResponse_PE sendBill(String nombreArchivo, String rutaArchivo) {
		BillService sender = (BillService) client.initWebService(BillService.class);
		FileDataSource source = new FileDataSource(new File(rutaArchivo + nombreArchivo ));

		try {
			byte[] e = sender.sendBill(nombreArchivo , new DataHandler(source));

			try {
				FileUtils.writeByteArrayToFile(new File(rutaArchivo + "R" + nombreArchivo), e);
			} catch (IOException var9) {
				var9.printStackTrace();
			}

			return byteToResponse(e);
		} catch (SOAPFaultException var10) {
			UblResponse_PE response = SOAPFaultToResponse(var10.getFault());
			return response;
		}
	}

	private static UblResponse_PE SOAPFaultToResponse(SOAPFault soapFault) {
		String faultCode = soapFault.getFaultCode();
		String mensaje = "";
		String retCode = obtenerNumeroEnCadena(faultCode);
		String faultString = soapFault.getFaultString();
		int intCode = -1;

		try {
			if ("".equals(retCode)) {
				intCode = (new Integer(faultString)).intValue();
			} else {
				intCode = (new Integer(retCode)).intValue();
			}

			Integer e = Integer.valueOf(soapFault.getFaultString().indexOf("Detalle"));
			if (e.intValue() > 0) {
				mensaje = soapFault.getFaultString().substring(0, e.intValue() - 1);
			} else {
				mensaje = soapFault.getFaultString();
			}
		} catch (Throwable var8) {
			var8.printStackTrace();
			mensaje = "Error al invocar Servicio: " + var8.getMessage();
		}

		return new UblResponse_PE(intCode, mensaje, (List) null);
	}

	private static String obtenerNumeroEnCadena(String mensaje) {
		Integer largo = Integer.valueOf(mensaje.length());
		String numero = "";

		for (int i = 0; i < largo.intValue(); ++i) {
			if (Character.isDigit(mensaje.charAt(i))) {
				numero = numero + mensaje.charAt(i);
			}
		}

		return numero;
	}

	public static UblResponse_PE byteToResponse(byte[] data) {
		byte intCode = -1;

		try {
			data = unzip(data);
			Document e = byteToDocument(data);
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

			int var13 = (new Integer(codigo)).intValue();
			return new UblResponse_PE(var13, mensaje, lstWarnings);
		} catch (XPathExpressionException var12) {
			var12.printStackTrace();
			return new UblResponse_PE(intCode, var12.getMessage(), (List) null);
		}
	}

	private static byte[] unzip(byte[] data) {
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
		} catch (Exception ex) {
			throw new ModelException(".................");
		}		
	}

	private static Document byteToDocument(byte[] data) {
		ByteArrayInputStream ipEntrada = new ByteArrayInputStream(data);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		try {
			Document e = dbf.newDocumentBuilder().parse(ipEntrada);
			return e;
		} catch (SAXException ex) {
			System.out.println("Error al leer la constancia" + ex.getCause());
		} catch (IOException ex) {
			System.out.println("Error al leer la constancia" + ex.getCause());
		} catch (ParserConfigurationException ex) {
			System.out.println("Error al leer la constancia" + ex.getCause());
		}
		return null;
	}
}
