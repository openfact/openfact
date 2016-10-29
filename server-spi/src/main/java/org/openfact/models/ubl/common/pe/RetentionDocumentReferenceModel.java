package org.openfact.models.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.openfact.models.ubl.common.PaymentModel;

public interface RetentionDocumentReferenceModel {
	String getId();

	String getID();

	void setID(String iD);

	LocalDateTime getIssueDateTime();

	void setIssueDateTime(LocalDateTime issueDateTime);

	BigDecimal getTotalInvoiceAmount();

	void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount);

	PaymentModel getPayment();

	void setPayment(PaymentModel payment);

	RetentionInformationModel getSunatRetentionInformation();

	void setSunatRetentionInformation(RetentionInformationModel sunatRetentionInformation);
}
