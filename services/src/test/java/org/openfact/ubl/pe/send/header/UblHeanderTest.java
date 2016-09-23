package org.openfact.ubl.pe.send.header;

import java.io.FileOutputStream;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.ws.soap.SOAPFaultException;

import org.junit.Test;
import org.openfact.ubl.pe.send.BillService;
import org.openfact.ubl.pe.send.BillService_Service;

public class UblHeanderTest {

	@Test
	public void sendBill() {

		try { // Call Web Service Operation
			BillService_Service service = new BillService_Service();

			service.setHandlerResolver(new UblHeaderHandlerResolver());

			BillService port = service.getBillServicePort();

			// TODO initialize WS operation arguments here
			java.lang.String fileName = "10428482072-01-F001-1";
			DataSource fds = new FileDataSource("/home/lxpary/Documents/10428482072-01-F001-1.zip");
			javax.activation.DataHandler contentFile = new javax.activation.DataHandler(fds);

			// TODO process result here
			byte[] result = port.sendBill(fileName, contentFile);

			FileOutputStream fileOuputStream = new FileOutputStream("/home/lxpary/Documents/respuesta.zip");
			fileOuputStream.write(result);
			fileOuputStream.close();
			System.out.println("Result = " + result);
		} catch (SOAPFaultException ex) {
			System.out.println(ex.getFault().getFaultCode());
			System.out.println(ex.getFault().getFaultString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UblHeanderTest ublHeanderTest = new UblHeanderTest();
		ublHeanderTest.sendBill();
	}
}
