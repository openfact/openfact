package org.openfact.ubl.send.pe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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
	
	
	private byte[] getBytesFromFile() throws IOException {
        List byteList = new ArrayList();

        FileInputStream is = new FileInputStream(new File("/home/admin/10467793549-01-F001-00000001.zip"));
        int readLen = -1;
        byte[] buff = new byte[4096];

        while ((readLen = is.read(buff)) != -1) {
            copyBytesToList(buff, readLen, byteList);
        }

        is.close();
        return getByteArrayFromList(byteList);
    }

    private void copyBytesToList(byte[] buff, int len, List byteList) {
        for (int i = 0; i < len; i++) {
            byteList.add(Byte.toString(buff[i]));
        }
    }

    private byte[] getByteArrayFromList(List byteList) {
        byte[] buff = new byte[byteList.size()];

        for (int i = 0; i < byteList.size(); i++) {
            buff[i] = Byte.parseByte((String) byteList.get(i));
        }
        return buff;
    }

	@Override
	public void sendInvoice(InvoiceModel invoice) throws UblSenderException {
		String fileName = generateXmlFileName(invoice);
	    Document document = getUblProvider(organization).getDocument(organization, invoice);
		try {
            byte[] zip = generateZip(document, fileName);
            
            // Call Web Service Operation
            BillService_Service service = new BillService_Service();
            service.setHandlerResolver(new UblHeaderHandlerResolver(organization));
            BillService port = service.getBillServicePort();

            // Config data
            DataSource dataSource = new ByteArrayDataSource(zip, "application/zip");
            DataHandler contentFile = new DataHandler(dataSource);

            // Send
            byte[] result = port.sendBill(fileName + ".zip", contentFile);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@Override
	public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException {		
	}

	@Override
	public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException {
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
		sb.append(".xml");
		return sb.toString();
	}

	private String generateXmlFileName(DebitNoteModel debitNote) throws UblSenderException {
		if (organization.getAssignedIdentificationId() == null) {
			throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
		}

		String codido = CodigoTipoDocumento.NOTA_CREDITO.getCodigo();

		StringBuilder sb = new StringBuilder();
		sb.append(organization.getAssignedIdentificationId()).append("-");
		sb.append(codido).append("-");
		sb.append(debitNote.getID());
		sb.append(".xml");
		return sb.toString();
	}

}
