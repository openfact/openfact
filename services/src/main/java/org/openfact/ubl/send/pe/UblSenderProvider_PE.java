package org.openfact.ubl.send.pe;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.ws.soap.SOAPFaultException;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.services.ServicesLogger;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.pe.header.UblHeaderHandlerResolver;
import org.openfact.ubl.send.pe.sunat.BillService;
import org.openfact.ubl.send.pe.sunat.BillService_Service;

import com.sun.xml.ws.util.ByteArrayDataSource;

public class UblSenderProvider_PE implements UblSenderProvider {

    private static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    private final OpenfactSession session;

    public UblSenderProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public void send(OrganizationModel organization, InvoiceModel invoice, byte[] document,
            String contentType, String name) throws UblSenderException {
        try {
            // Call Web Service Operation
            BillService_Service service = new BillService_Service();
            service.setHandlerResolver(new UblHeaderHandlerResolver());
            BillService port = service.getBillServicePort();

            // TODO initialize WS operation arguments here
            DataSource dataSource = new ByteArrayDataSource(document, contentType);
            DataHandler contentFile = new DataHandler(dataSource);

            // DataSource fds = new
            // FileDataSource("/home/lxpary/Documents/10428482072-01-F001-1.zip");
            // DataHandler contentFile = new DataHandler(fds);

            // TODO process result here
            byte[] result = port.sendBill(name, contentFile);

            System.out.println("Result = " + result);
        } catch (SOAPFaultException ex) {
            System.out.println(ex.getFault().getFaultCode());
            System.out.println(ex.getFault().getFaultString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void send(OrganizationModel organization, DebitNoteModel debitNote, byte[] document,
            String contentType, String name) throws UblSenderException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void send(OrganizationModel organization, CreditNoteModel creditNote, byte[] document,
            String contentType, String name) throws UblSenderException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void send(OrganizationModel organization, String fileName, byte[] document, String contentType)
            throws UblSenderException {
        // TODO Auto-generated method stub
        
    }

}
