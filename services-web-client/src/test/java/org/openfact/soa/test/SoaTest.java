package org.openfact.soa.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openfact.soa.builder.SoapBuilder;
import org.openfact.soa.builder.SoapOperation;
import org.openfact.soa.builder.core.Wsdl;
import org.openfact.soa.client.core.SoapClient;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import groovy.util.XmlSlurper;

public class SoaTest {

	public static void main(String[] args) {
    	try {
    		FileOutputStream f = new FileOutputStream("/home/lxpary/test.zip");
    		ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(f));
    		zip.putNextEntry(new ZipEntry("dummy/"));
    		zip.putNextEntry(new ZipEntry("invoice.xml"));
    		zip.close();
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
	
	public static void maiasn(String[] args) {
		System.out.println(send("F001-1", ""));

		try {
			Wsdl wsdl = Wsdl.parse("https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?wsdl"); // (1)

			List<QName> bindings = wsdl.getBindings(); // (2)

			SoapBuilder builder = wsdl.binding().localPart("BillServicePortBinding").find(); // (3)
			// wsdl.printBindings(); // (4)

			List<SoapOperation> operations = builder.getOperations(); // (5)
			for (int i = 0; i < operations.size(); i++) {
				System.out.println(operations.get(i));
			}

			SoapOperation operation = builder.operation().name("sendBill").find(); // (6)

			String request = builder.buildInputMessage(operation);

			SoapClient client = SoapClient.builder()
					.endpointUri("https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService").build();
			System.out.println(request);
			String response = client.post(request);

			System.out.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String send(String a, String b) {
		try {
			// generate the message (the quickest way)
			String input = Wsdl.parse("https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?wsdl").binding()
					.name("{http://service.gem.factura.comppago.registro.servicio.sunat.gob.pe/}BillServicePortBinding")
					.find().operation().soapAction("urn:sendBill").find().buildInputMessage();

			SoapClient client = SoapClient.builder()
					.endpointUri("https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService").build();

			String response = client.post(input);

			XmlSlurper slurper = new XmlSlurper(XMLReaderFactory.createXMLReader());
			return slurper.parseText(response).toString();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Document loadXML(String xml) throws Exception {
		DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
		DocumentBuilder bldr = fctr.newDocumentBuilder();
		InputSource insrc = new InputSource(new StringReader(xml));
		return bldr.parse(insrc);
	}

}
