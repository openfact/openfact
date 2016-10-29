package org.openfact.models.ubl.pe;

import java.time.LocalDateTime;
import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.ShipmentModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.pe.DespatchAdviceLineModel;


public interface DespatchAdviceModel {
	
	 String getId() ;	 

	 OrganizationModel getOrganization() ;

	 void setOrganization(OrganizationModel organization) ;

	 UBLExtensionsModel getUblExtensions() ;

	 void setUblExtensions(UBLExtensionsModel ublExtensions);

	 String getUblVersionID();

	 void setUblVersionID(String ublVersionID) ;

	 String getCustomizationID() ;

	 void setCustomizationID(String customizationID) ;

	 List<SignatureModel> getSignature();

	 void setSignature(List<SignatureModel> signature) ;

	 String getID();

	 void setID(String iD);

	 LocalDateTime getIssueDateTime() ;

	 void setIssueDateTime(LocalDateTime issueDateTime) ;

	 String getDespatchAdviceTypeCode();
	 void setDespatchAdviceTypeCode(String despatchAdviceTypeCode) ;

	 List<String> getNote() ;

	 void setNote(List<String> note);

	 OrderReferenceModel getOrderReference();

	 void setOrderReference(OrderReferenceModel orderReference) ;

	 List<DocumentReferenceModel> getAdditionalDocumentReference() ;

	 void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) ;

	 SupplierPartyModel getDespatchSupplierParty() ;

	 void setDespatchSupplierParty(SupplierPartyModel despatchSupplierParty) ;

	 CustomerPartyModel getDeliveryCustomerParty() ;

	 void setDeliveryCustomerParty(CustomerPartyModel deliveryCustomerParty);

	 SupplierPartyModel getSellerSupplierParty();

	 void setSellerSupplierParty(SupplierPartyModel sellerSupplierParty) ;

	 List<ShipmentModel> getShipment();

	 void setShipment(List<ShipmentModel> shipment) ;

	 List<DespatchAdviceLineModel> getDespatchAdviceLine() ;

	 void setInvoiceLine(List<DespatchAdviceLineModel> despatchAdviceLine) ;

	 Byte[] getXmlDocument() ;

	 void setXmlDocument(Byte[] xmlDocument) ;

	 List<RequeridActionDocument> getRequeridAction() ;

	 void setRequeridAction(List<RequeridActionDocument> requeridAction) ;
}
