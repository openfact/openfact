package org.openfact.soa.test;

import org.openfact.soa.builder.SoapBuilder;
import org.openfact.soa.builder.SoapOperation;
import org.openfact.soa.builder.core.Wsdl;
import org.openfact.soa.client.core.SoapClient;
import org.openfact.soa.common.SoapContext;

public class SoaTest {

	public static void main(String[] args) {

		// construct the client
		String url = "https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService";
		SoapClient client = SoapClient.builder().endpointUri(url).build();

		//https://e-beta.sunat.gob.pe:443/ol-ti-itcpfegem-beta/billService
		
		Wsdl parser = Wsdl.parse("https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?wsdl");
		SoapBuilder builder = parser.binding().localPart("sendBillResponse").find();

		// get the operation to invoked -> assumption our operation is the first
		// operation in the WSDL's
		SoapOperation operation = builder.operation().name("sendBill").find();

		// construct the request
		String request = builder.buildInputMessage(operation);
		// post the request to the server
		String response = client.post(request);
		// get the response
		String expectedResponse = builder.buildOutputMessage(operation, SoapContext.NO_CONTENT);

	}

}
