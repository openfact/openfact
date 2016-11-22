package org.openfact.models.ubl;

import java.util.List;

public interface InvoiceSendEventModel extends SendEventModel {
	List<InvoiceModel> getInvoices();

	void setInvoices(List<InvoiceModel> invoices);

}
