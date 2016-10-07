package org.openfact.soa.test;

import java.util.List;

import javax.xml.namespace.QName;

import org.openfact.soa.builder.SoapBuilder;
import org.openfact.soa.builder.SoapOperation;
import org.openfact.soa.builder.core.Wsdl;
import org.openfact.soa.client.core.SoapClient;
import org.openfact.soa.common.SoapContext;

public class SoaTest {

	public static void main(String[] args) {

		Wsdl wsdl = Wsdl.parse("https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?wsdl"); // (1)

		List<QName> bindings = wsdl.getBindings(); // (2)
		
		SoapBuilder builder = wsdl.binding().localPart("BillServicePortBinding").find(); // (3)
		//wsdl.printBindings(); // (4)

		List<SoapOperation> operations = builder.getOperations(); // (5)
		SoapOperation operation = builder.operation().name("sendBill").find(); // (6)

		String request = builder.buildInputMessage(operation);

		SoapClient client = SoapClient.builder()
				.endpointUri("https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService").build();
		System.out.println(request);
		String response = client.post(request);

		System.out.println(response);

		// // construct the client
		// String url =
		// "https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService";
		// SoapClient client = SoapClient.builder().endpointUri(url).build();
		//
		// Wsdl parser =
		// Wsdl.parse("https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?wsdl");
		// QName bindingName = new QName("billService?ns1.wsdl", "sendBill");
		// SoapBuilder builder = parser.binding().name(bindingName).find();
		//
		// // get the operation to invoked -> assumption our operation is the
		// first
		// // operation in the WSDL's
		// SoapOperation operation =
		// builder.operation().name("sendBill").find();
		//
		// // construct the request
		// String request = builder.buildInputMessage(operation);
		// // post the request to the server
		// String response = client.post(request);
		// // get the response
		// String expectedResponse = builder.buildOutputMessage(operation,
		// SoapContext.NO_CONTENT);

	}

}
