package org.openfact.models.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CertifiedModel;
import org.openfact.models.CurrencyModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.CurrencyEntity;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.PostalAddressEntity;
import org.openfact.models.jpa.entities.TasksScheduleEntity;

public class OrganizationAdapter implements OrganizationModel, JpaModel<OrganizationEntity> {

    protected static final Logger logger = Logger.getLogger(OrganizationAdapter.class);
    protected OrganizationEntity organization;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrganizationAdapter(OpenfactSession session, EntityManager em, OrganizationEntity organization) {
        this.session = session;
        this.em = em;
        this.organization = organization;
    }

    @Override
    public OrganizationEntity getEntity() {
        return organization;
    }

    public static OrganizationEntity toEntity(OrganizationModel model, EntityManager em) {
        if (model instanceof OrganizationAdapter) {
            return ((OrganizationAdapter) model).getEntity();
        }
        return em.getReference(OrganizationEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return organization.getId();
    }

    @Override
    public String getName() {
        return organization.getName();
    }

    @Override
    public void setName(String name) {
        organization.setName(name);
        em.flush();
    }
    
    @Override
    public String getDescription() {
        return organization.getDescription();
    }

    @Override
    public void setDescription(String description) {
        organization.setDescription(description);
    } 

    @Override
    public boolean isEnabled() {
        return organization.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        organization.setEnabled(enabled);
    }

    @Override
    public String getAssignedIdentificationId() {
        return organization.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        organization.setAssignedIdentificationId(assignedIdentificationId);
    }

    @Override
    public DocumentModel getAdditionalAccountId() {
        DocumentEntity enumType = organization.getAdditionalAccountId();
        if(enumType == null) {
            return null;
        }
        return new DocumentAdapter(this, session, em, enumType);
    }

    @Override
    public void setAdditionalAccountId(DocumentModel additionalAccount) {
        DocumentEntity enumTypeEntity = DocumentAdapter.toEntity(additionalAccount, em);
        organization.setAdditionalAccountId(enumTypeEntity);
    }

    @Override
    public String getSupplierName() {
        return organization.getSupplierName();
    }

    @Override
    public void setSupplierName(String supplierName) {
        organization.setSupplierName(supplierName);
    }

    @Override
    public String getRegistrationName() {
        return organization.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String registrationName) {
        organization.setRegistrationName(registrationName);
    }

    @Override
    public PostalAddressModel getPostalAddress() {
        if (organization.getPostalAddress() != null) {
            return new PostalAddressAdapter(this, session, em, organization.getPostalAddress());
        }
        return null;
    }

    @Override
    public void setPostalAddress(PostalAddressModel postalAddress) {
        PostalAddressEntity postalAddressEntity = PostalAddressAdapter.toEntity(postalAddress, em);
        organization.setPostalAddress(postalAddressEntity);
    }

    @Override
    public TasksScheduleModel getTasksSchedule() {
        if (organization.getTasksSchedule() != null) {
            return new TasksScheduleAdapter(this, session, em, organization.getTasksSchedule());
        }
        return null;
    }

    @Override
    public void setTasksSchedule(TasksScheduleModel tasksSchedule) {
        TasksScheduleEntity tasksScheduleEntity = TasksScheduleAdapter.toEntity(tasksSchedule, em);
        organization.setTasksSchedule(tasksScheduleEntity);
    }

    @Override
    public DocumentModel getDocumentById(String documentId) {
        DocumentEntity document = em.find(DocumentEntity.class, documentId);
        // Check if document belongs to this organization
        if (document == null || !organization.equals(document.getOrganization())) {
            return null;
        }            
        DocumentAdapter adapter = new DocumentAdapter(this, session, em, document);
        return adapter;
    }

    @Override
    public boolean removeDocument(DocumentModel document) {
        if (document == null) {
            return false;
        }

        DocumentEntity documentEntity = null;
        Iterator<DocumentEntity> it = organization.getDocuments().iterator();
        while (it.hasNext()) {
            DocumentEntity ae = it.next();
            if (ae.equals(document)) {
                documentEntity = ae;
                it.remove();
                break;
            }
        }
        if (documentEntity == null) {
            return false;
        }

        em.remove(documentEntity);
        em.flush();
        return true;
    }   
    
    @Override
    public Set<DocumentModel> getDocuments() {
        return organization.getDocuments().stream()
                .map(f -> new DocumentAdapter(this, session, em, f))
                .collect(Collectors.toSet());
    }
    
    @Override
    public Set<DocumentModel> getDocuments(DocumentType type) {
        return organization.getDocuments().stream()
                .filter(f -> f.getType().equals(type))
                .map(f -> new DocumentAdapter(this, session, em, f))
                .collect(Collectors.toSet());
    }

    @Override
    public DocumentModel addDocument(DocumentType type, String name, String code) {
        DocumentEntity entity = new DocumentEntity();
        entity.setName(name);
        entity.setCode(code);;
        entity.setType(type);
        entity.setOrganization(organization);
        em.persist(entity);
        em.flush();
        final DocumentModel adapter = new DocumentAdapter(this, session, em, entity);
        return adapter; 
    }      
    

    @Override
    public CurrencyModel addCurrency(String code, int priority) {
        CurrencyEntity entity = new CurrencyEntity();
        entity.setCode(code);
        entity.setPriority(priority);;        
        entity.setOrganization(organization);
        em.persist(entity);
        em.flush();
        final CurrencyModel adapter = new CurrencyAdapter(this, session, em, entity);
        return adapter; 
    }

    @Override
    public boolean removeCurrency(CurrencyModel currency) {
        if (currency == null) {
            return false;
        }

        CurrencyEntity currencyEntity = null;
        Iterator<CurrencyEntity> it = organization.getCurrencies().iterator();
        while (it.hasNext()) {
            CurrencyEntity ae = it.next();
            if (ae.equals(currency)) {
                currencyEntity = ae;
                it.remove();
                break;
            }
        }
        if (currencyEntity == null) {
            return false;
        }

        em.remove(currencyEntity);
        em.flush();
        return true;
    }

    @Override
    public Set<CurrencyModel> getCurrencies() {
        return organization.getCurrencies().stream()
                .map(f -> new CurrencyAdapter(this, session, em, f))
                .collect(Collectors.toSet());
    } 
    
    @Override
    public List<InvoiceModel> getInvoices() {
        List<InvoiceModel> models = new ArrayList<>();
        organization.getInvoices().forEach(f -> models.add(new InvoiceAdapter(session, this, em, f)));
        return models;
    }

    @Override
    public List<CertifiedModel> getCetifieds() {
        List<CertifiedModel> models = new ArrayList<>();
        organization.getCertifieds().forEach(f -> models.add(new CertifiedAdapter(this, f, em, session)));
        return models;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((organization == null) ? 0 : organization.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrganizationAdapter other = (OrganizationAdapter) obj;
        if (organization == null) {
            if (other.organization != null)
                return false;
        } else if (!organization.equals(other.organization))
            return false;
        return true;
    }   

}
