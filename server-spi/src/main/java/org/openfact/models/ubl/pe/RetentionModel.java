package org.openfact.models.ubl.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.pe.RetentionDocumentReferenceModel;

public interface RetentionModel {
	String getId();

	OrganizationModel getOrganization();

	void setOrganization(OrganizationModel organization);

	UBLExtensionsModel getUblExtensions();

	void setUblExtensions(UBLExtensionsModel ublExtensions);

	String getUblVersionID();

	void setUblVersionID(String ublVersionID);

	String getCustomizationID();

	void setCustomizationID(String customizationID);

	List<SignatureModel> getSignature();

	void setSignature(List<SignatureModel> signature);

	String getID();

	void setID(String iD);

	LocalDateTime getIssueDateTime();

	void setIssueDateTime(LocalDateTime issueDateTime);

	List<String> getNote();

	void setNote(List<String> note);

	String getSUNATRetentionSystemCode();

	void setSUNATRetentionSystemCode(String sUNATRetentionSystemCode);

	BigDecimal getSUNATRetentionPercent();

	void setSUNATRetentionPercent(BigDecimal sUNATRetentionPercent);

	PartyModel getAgentParty();

	void setAgentParty(PartyModel agentParty);

	PartyModel getReceiverParty();

	void setReceiverParty(PartyModel receiverParty);

	BigDecimal getTotalInvoiceAmount();

	void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount);

	BigDecimal getSUNATTotalPaid();

	void setSUNATTotalPaid(BigDecimal sUNATTotalPaid);

	List<RetentionDocumentReferenceModel> getSUNATRetentionDocumentReference();

	void setSUNATRetentionDocumentReference(List<RetentionDocumentReferenceModel> sUNATRetentionDocumentReference);

	Byte[] getXmlDocument();

	void setXmlDocument(Byte[] xmlDocument);

	List<RequeridActionDocument> getRequeridAction();

	void setRequeridAction(List<RequeridActionDocument> requeridAction);
}
