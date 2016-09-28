package org.openfact.ubl.pe;

import org.jboss.logging.Logger;
import org.openfact.common.Utils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.UblIDGeneratorProvider;

public class UblIDGeneratorProvider_PE implements UblIDGeneratorProvider {

	private static final Logger log = Logger.getLogger(UblIDGeneratorProvider_PE.class);

	protected OpenfactSession session;

	public UblIDGeneratorProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public String getID(OrganizationModel organization, UblDocumentType type) {
		try {
			if (type.equals(UblDocumentType.INVOICE)) {
				InvoiceModel invoiceModel = session.invoices().getLastInvoice(organization, 13, "%-%");
				String Serie, Number;
				if (invoiceModel == null) {
					Serie = "F" + getSerie(String.valueOf(1), String.valueOf(0));
					Number = getNumber(String.valueOf(1), String.valueOf(0));
				} else {
					String ID = invoiceModel.getID();
					String[] Ids = ID.split("-");
					Serie = Ids[0].substring(0, 1) + getSerie(Ids[0].substring(1), Ids[1]);
					Number = getNumber(Ids[0].substring(1), Ids[1]);
				}
				return Serie + "-" + Number;

			}
			if (type.equals(UblDocumentType.CREDIT_NOTE)) {
				return "";
			}
			if (type.equals(UblDocumentType.DEBIT_NOTE)) {
				return "";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getSerie(String serie, String number) {
		if (Integer.valueOf(number) < 99999999) {
			return Utils.padLeft(serie, 3, "0");
		} else {
			Integer Serie = Integer.valueOf(serie);
			Serie = Serie + 1;
			return Utils.padLeft(String.valueOf(Serie), 3, "0");
		}
	}

	private String getNumber(String serie, String number) {
		if (Integer.valueOf(number) < 99999999) {
			Integer Number = Integer.valueOf(number) + 1;
			return Utils.leftPad(String.valueOf(Number), 8, '0');
		} else {
			return Utils.leftPad(String.valueOf(1), 8, '0');
		}
	}

}
