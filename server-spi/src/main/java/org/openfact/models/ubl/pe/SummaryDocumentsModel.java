package org.openfact.models.ubl.pe;

import java.time.LocalDateTime;
import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SummaryDocumentsLineModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public interface SummaryDocumentsModel {
	String getId();

	OrganizationModel getOrganization();

	void setOrganization(OrganizationModel organization);

	UBLExtensionsModel getUblExtensions();

	void setUblExtensions(UBLExtensionsModel ublExtensions);

	String getUblVersionID();

	void setUblVersionID(String ublVersionID);

	String getCustomizationID();

	void setCustomizationID(String customizationID);

	String getID();

	void setID(String iD);

	LocalDateTime getReferenceDateTime();

	void setReferenceDateTime(LocalDateTime referenceDateTime);

	LocalDateTime getIssueDateTime();

	void setIssueDateTime(LocalDateTime issueDateTime);

	List<SignatureModel> getSignature();

	void setSignature(List<SignatureModel> signature);

	SupplierPartyModel getAccountingSupplierParty();

	void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty);

	List<SummaryDocumentsLineModel> getSummaryDocumentsLines();

	void setSummaryDocumentsLines(List<SummaryDocumentsLineModel> summaryDocumentsLines);

	Byte[] getXmlDocument();

	void setXmlDocument(Byte[] xmlDocument);

	List<RequeridActionDocument> getRequeridAction();

	void setRequeridAction(List<RequeridActionDocument> requeridAction);
}
