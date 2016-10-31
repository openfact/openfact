package org.openfact.models.ubl.pe;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.VoidedDocumentsLineModel;
import org.openfact.provider.ProviderEvent;

public interface VoidedDocumentsModel {
	/**
	 * attributes
	 */
	void setSingleAttribute(String name, String value);

	void setAttribute(String name, List<String> values);

	void removeAttribute(String name);

	String getFirstAttribute(String name);

	List<String> getAttribute(String name);

	Map<String, List<String>> getAttributes();
	
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
	
	/**
	 * Events interfaces
	 */
	interface VoidedDocumentsCreationEvent extends ProviderEvent {
		VoidedDocumentsModel getCreatedVoidedDocuments();
	}

	interface VoidedDocumentsPostCreateEvent extends ProviderEvent {
		VoidedDocumentsModel getCreatedVoidedDocuments();

		OpenfactSession getOpenfactSession();
	}

	interface VoidedDocumentsRemovedEvent extends ProviderEvent {
		VoidedDocumentsModel getVoidedDocuments();

		OpenfactSession getOpenfactSession();
	}
}
