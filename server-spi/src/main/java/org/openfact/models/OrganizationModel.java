package org.openfact.models;

import java.util.List;
import java.util.Set;

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
    
    /*Currencies*/
    CurrencyModel addCurrency(String code, int priority);
    boolean removeCurrency(CurrencyModel currency);
    Set<CurrencyModel> getCurrencies();
    
    /*Documents*/
    DocumentModel getDocumentById(String documentId);
    DocumentModel addDocument(DocumentType type, String name, String documentId);
    boolean removeDocument(DocumentModel document);
    Set<DocumentModel> getDocuments(); 
    Set<DocumentModel> getDocuments(DocumentType valueOf);
    
    /*Invoices*/
    List<InvoiceModel> getInvoices();
    List<CertifiedModel> getCetifieds();

        

}
