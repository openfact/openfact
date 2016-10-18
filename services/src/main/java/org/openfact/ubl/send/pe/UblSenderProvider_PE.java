package org.openfact.ubl.send.pe;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.ServiceWrapper;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.pe.sunat.BillService;
import org.openfact.ubl.send.pe.sunat.StatusResponse;

import com.sun.xml.ws.util.ByteArrayDataSource;

public class UblSenderProvider_PE implements UblSenderProvider {

	private OpenfactSession session;

	public UblSenderProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	@Override
	public byte[] send(OrganizationModel organization, byte[] document, String fileName, String invoiceType,
			InternetMediaType mediaType, String wsUrl) throws UblSenderException {
		ServiceWrapper<BillService> serviceWrapper = new ServiceWrapper<BillService>(organization.getUblSenderConfig(),
				wsUrl);
		BillService client = (BillService) serviceWrapper.initWebService(BillService.class);
		DataSource dataSource = new ByteArrayDataSource(document, mediaType.getMimiType());
		DataHandler contentFile = new DataHandler(dataSource);
		// Send
		byte[] result = null;
		if (CodigoTipoDocumento.BOLETA.getCodigo().equals(invoiceType)) {
			client.sendSummary(fileName + mediaType.getExtension(), contentFile);
		} else {
			result = client.sendBill(fileName + mediaType.getExtension(), contentFile);
		}
		return result;
	}

	@Override
	public byte[] getStatus(OrganizationModel organization, String ticket, String wsUrl) throws UblSenderException {
		ServiceWrapper<BillService> serviceWrapper = new ServiceWrapper<BillService>(organization.getUblSenderConfig(),
				wsUrl);
		BillService client = (BillService) serviceWrapper.initWebService(BillService.class);
		StatusResponse statusResponse = client.getStatus(ticket);
		Integer inCode = new Integer(statusResponse.getStatusCode());
		if (inCode.equals(Integer.valueOf(98))) {
			throw new ModelException(
					"La transaccion " + ticket + ", aun se esta procesando con codigo " + inCode.intValue());
		} else {
			byte[] result = statusResponse.getContent();
			return result;
		}
	}

}
