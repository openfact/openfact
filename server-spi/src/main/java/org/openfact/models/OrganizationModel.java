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

    DocumentSimpleModel getAdditionalAccountId();
    void setAdditionalAccountId(DocumentSimpleModel additionalAccount);

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
    DocumentComponentModel getDocumentById(String documentId);
    DocumentSimpleModel addSimpleDocument(DocumentType type, String name, String documentId);
    DocumentValuableModel addValuableDocument(DocumentType type, String name, String documentId, BigDecimal value);    
    DocumentComposedModel addComposedDocument(DocumentType type, String name, String documentId);
    boolean removeDocument(DocumentComponentModel document);
    Set<DocumentComponentModel> getDocuments(); 
    Set<DocumentComponentModel> getDocuments(DocumentType valueOf);
    
    /*Invoices*/
    List<InvoiceModel> getInvoices();
    List<CertifiedModel> getCetifieds();

        

}
