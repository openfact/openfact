package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CertifiedModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.TaxTypeModel;
import org.openfact.models.enums.AdditionalAccountType;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.PostalAddressEntity;
import org.openfact.models.jpa.entities.TasksScheduleEntity;
import org.openfact.models.jpa.entities.TaxTypeEntity;

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
    public AdditionalAccountType getAdditionalAccountId() {
        return organization.getAdditionalAccountId();
    }

    @Override
    public void setAdditionalAccountId(AdditionalAccountType additionalAccountId) {
        organization.setAdditionalAccountId(additionalAccountId);
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
    public TaxTypeModel getTaxTypeById(String taxTypeId) {
        TaxTypeEntity taxType = em.find(TaxTypeEntity.class, taxTypeId);

        // Check if taxType belongs to this organization
        if (taxType == null || !organization.equals(taxType.getOrganization())) {
            return null;
        }            
        TaxTypeAdapter adapter = new TaxTypeAdapter(this, session, em, taxType);
        return adapter;
    }

    @Override
    public boolean removeTaxType(TaxTypeModel taxType) {
        if (taxType == null) {
            return false;
        }

        TaxTypeEntity taxTypeEntity = null;
        Iterator<TaxTypeEntity> it = organization.getTaxTypes().iterator();
        while (it.hasNext()) {
            TaxTypeEntity ae = it.next();
            if (ae.equals(taxType)) {
                taxTypeEntity = ae;
                it.remove();
                break;
            }
        }
        if (taxTypeEntity == null) {
            return false;
        }

        em.remove(taxTypeEntity);
        em.flush();
        return true;
    }
    
    @Override
    public List<TaxTypeModel> getTaxTypes() {
        return organization.getTaxTypes().stream().map(f -> new TaxTypeAdapter(this, session, em, f)).collect(Collectors.toList());
    }         

    @Override
    public TaxTypeModel addTaxType(String name, String code, BigDecimal value) {
        TaxTypeEntity entity = new TaxTypeEntity();
        entity.setName(name);
        entity.setCode(code);
        entity.setValue(value);
        entity.setOrganization(organization);
        em.persist(entity);
        em.flush();
        final TaxTypeModel adapter = new TaxTypeAdapter(this, session, em, entity);
        return adapter; 
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
