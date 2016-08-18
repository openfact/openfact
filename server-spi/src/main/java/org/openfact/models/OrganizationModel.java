package org.openfact.models;

import java.util.List;

import org.openfact.models.enums.DocumentType;

public interface OrganizationModel {

    String NAME = "name";
    
    String getId();

    String getName();
    void setName(String name);
    
    String getDescription();
    void setDescription(String description);

    boolean isEnabled();
    void setEnabled(boolean enabled);

    String getAssignedIdentificationId();
    void setAssignedIdentificationId(String assignedIdentificationId);

    DocumentModel getAdditionalAccountId();
    void setAdditionalAccountId(DocumentModel additionalAccount);

    String getSupplierName();
    void setSupplierName(String supplierName);

    String getRegistrationName();
    void setRegistrationName(String registrationName);

    PostalAddressModel getPostalAddress();
    void setPostalAddress(PostalAddressModel postalAddress);
    
    TasksScheduleModel getTasksSchedule();
    void setTasksSchedule(TasksScheduleModel tasksScheduleModel);
    
    /*Documents*/
    DocumentModel getDocumentById(String documentId);
    DocumentModel addDocument(DocumentType type, String name, String code);
    boolean removeDocument(DocumentModel document);
    List<DocumentModel> getDocuments();      
    List<DocumentModel> getDocuments(DocumentType valueOf);
    
    /*Invoices*/
    List<InvoiceModel> getInvoices();
    List<CertifiedModel> getCetifieds();

        

}
