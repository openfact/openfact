package org.openfact.models;

import java.math.BigDecimal;
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

    SimpleDocumentModel getAdditionalAccountId();
    void setAdditionalAccountId(SimpleDocumentModel additionalAccount);

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
    DocumentModel getDocumentById(String id);
    DocumentModel getDocumentByTymeAndName(DocumentType type, String documentName);
    SimpleDocumentModel addSimpleDocument(DocumentType type, String name, String documentId);
    ValuableDocumentModel addValuableDocument(DocumentType type, String name, String documentId, BigDecimal value);
    CheckableDocumentModel addCheckableDocument(DocumentType type, String name, String documentId, boolean check);
    ComposedDocumentModel addComposedDocument(DocumentType type, String name, String documentId);
    boolean removeDocument(DocumentModel document);
    Set<DocumentModel> getDocuments(); 
    Set<DocumentModel> getDocuments(DocumentType valueOf);
    
    /*Invoices*/
    List<InvoiceModel> getInvoices();
    List<CertifiedModel> getCetifieds();

    /*s*/
    boolean isEventsEnabled();

    void setEventsEnabled(boolean enabled);
    
    Set<String> getEventsListeners();

    void setEventsListeners(Set<String> listeners);
    
    Set<String> getEnabledEventTypes();

    void setEnabledEventTypes(Set<String> enabledEventTypes);

    boolean isAdminEventsEnabled();

    void setAdminEventsEnabled(boolean enabled);

    boolean isAdminEventsDetailsEnabled();

    void setAdminEventsDetailsEnabled(boolean enabled);

}
