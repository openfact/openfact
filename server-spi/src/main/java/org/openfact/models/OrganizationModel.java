package org.openfact.models;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.enums.AdditionalAccountType;

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

    AdditionalAccountType getAdditionalAccountId();
    void setAdditionalAccountId(AdditionalAccountType additionalAccountId);

    String getSupplierName();
    void setSupplierName(String supplierName);

    String getRegistrationName();
    void setRegistrationName(String registrationName);

    PostalAddressModel getPostalAddress();
    void setPostalAddress(PostalAddressModel postalAddress);
    
    TasksScheduleModel getTasksSchedule();
    void setTasksSchedule(TasksScheduleModel tasksScheduleModel);
    
    TaxTypeModel getTaxTypeById(String taxTypeId);
    boolean removeTaxType(TaxTypeModel taxType);
    List<TaxTypeModel> getTaxTypes();
    TaxTypeModel addTaxType(String name, String code, BigDecimal value);
    
    List<InvoiceModel> getInvoices();
    List<CertifiedModel> getCetifieds();    

}
