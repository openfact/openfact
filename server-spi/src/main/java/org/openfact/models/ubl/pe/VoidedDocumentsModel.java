package org.openfact.models.ubl.pe;

import java.time.LocalDateTime;
import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.VoidedDocumentsLineModel;

public interface VoidedDocumentsModel {
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

	LocalDateTime getReferenceDate();

	void setReferenceDate(LocalDateTime referenceDate);

	LocalDateTime getIssueDateTime();

	void setIssueDateTime(LocalDateTime issueDateTime);

	List<String> getNote();

	void setNote(List<String> note);

	List<SignatureModel> getSignature();

	void setSignature(List<SignatureModel> signature);

	SupplierPartyModel getAccountingSupplierParty();

	void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty);

	List<VoidedDocumentsLineModel> getVoidedDocumentsLine();

	void setVoidedDocumentsLine(List<VoidedDocumentsLineModel> voidedDocumentsLine);

	Byte[] getXmlDocument();

	void setXmlDocument(Byte[] xmlDocument);

	List<RequeridActionDocument> getRequeridAction();

	void setRequeridAction(List<RequeridActionDocument> requeridAction);
}
