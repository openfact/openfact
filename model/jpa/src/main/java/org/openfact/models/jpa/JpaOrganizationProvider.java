package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.CertifiedModel;
import org.openfact.models.DocumentComponentModel;
import org.openfact.models.DocumentComposedModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.PostalAddressEntity;
import org.openfact.models.jpa.entities.TasksScheduleEntity;

public class JpaOrganizationProvider implements OrganizationProvider {

	protected static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaOrganizationProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public MigrationModel getMigrationModel() {
		return new MigrationModelAdapter(em);
	}

	@Override
	public OrganizationModel createOrganization(String name) {
		return createOrganization(OpenfactModelUtils.generateId(), name);
	}

	@Override
	public OrganizationModel createOrganization(String id, String name) {
	    if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
		OrganizationEntity organization = new OrganizationEntity();
		organization.setName(name);
		organization.setId(id);
		organization.setEnabled(true);
		em.persist(organization);
		em.flush();
		
		createPostalAddress(organization);
		createDefaultTasksSchedule(organization);		
		
		final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
		createDefaultDocuments(adapter);
		createDefaultCurrencies(adapter);
		
		return adapter;
	}
	
	private void createPostalAddress(OrganizationEntity organization) {
	    PostalAddressEntity postalAddress = new PostalAddressEntity();
	    postalAddress.setOrganization(organization);
	    em.persist(postalAddress);
	    em.flush();
	}
	
	@Deprecated
    private void createDefaultTasksSchedule(OrganizationEntity organization) {
        Set<DayOfWeek> submitDays = new HashSet<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            submitDays.add(day);
        }

        TasksScheduleEntity tasksSchedule = new TasksScheduleEntity();
        tasksSchedule.setAttempNumber(5);
        tasksSchedule.setLapseTime(10);
        tasksSchedule.setOnErrorAttempNumber(5);
        tasksSchedule.setOnErrorLapseTime(600);
        tasksSchedule.setDelayTime(0);
        tasksSchedule.setSubmitTime(LocalTime.MIDNIGHT);
        tasksSchedule.setSubmitDays(submitDays);

        tasksSchedule.setOrganization(organization);
        em.persist(tasksSchedule);
        em.flush();
    }
    
    @Deprecated
    private void createDefaultDocuments(OrganizationModel organization) {
        //
        organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "DNI", "1");
        organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "6");   
        
        organization.addSimpleDocument(DocumentType.INVOICE_TYPE, "BOLETA", "01");
        organization.addSimpleDocument(DocumentType.INVOICE_TYPE, "FACTURA", "03");
        
        //
        DocumentComposedModel document1 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "GRAVADO", "01");
        DocumentComposedModel document2 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "EXONERADO", "02");
        DocumentComposedModel document3 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "INAFECTO", "03");
        DocumentComposedModel document4 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "GRATUITO", "04");
        
        DocumentComponentModel children1 = organization.addSimpleDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Retiro por premio", "01");
        DocumentComponentModel children2 = organization.addSimpleDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Retiro por donacion", "01");
        DocumentComponentModel children3 = organization.addSimpleDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Operacion por onerosa", "01");
        DocumentComponentModel children4 = organization.addSimpleDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Retiro por premio", "01");
        DocumentComponentModel children5 = organization.addSimpleDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Retiro por premio", "01");
        
        document1.addChildren(children1);
        document1.addChildren(children2);
        document2.addChildren(children3);
        document3.addChildren(children4);
        document4.addChildren(children5);
        
        //
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "IGV", "01", new BigDecimal(0.18));
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "ISC", "01", new BigDecimal(0.10));
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "OTROS", "otros", new BigDecimal(0.0));                
    }
    
    @Deprecated
    private void createDefaultCurrencies(OrganizationModel organization) {
        organization.addCurrency("PEN", 1);
        organization.addCurrency("USD", 2);
        organization.addCurrency("EUR", 3);
    }

	@Override
	public OrganizationModel getOrganization(String id) {
		OrganizationEntity organization = em.find(OrganizationEntity.class, id);
		if (organization == null)
			return null;
		OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
		return adapter;
	}

	@Override
	public OrganizationModel getOrganizationByName(String name) {
		TypedQuery<String> query = em.createNamedQuery("getOrganizationIdByName", String.class);
		query.setParameter("name", name);
		List<String> entities = query.getResultList();
		if (entities.size() == 0)
			return null;
		if (entities.size() > 1)
			throw new IllegalStateException("Should not be more than one organization with same name");
		String id = query.getResultList().get(0);

		return session.organizations().getOrganization(id);
	}

	@Override
	public boolean removeOrganization(OrganizationModel organization) {
	    OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, organization.getId());
        if (organizationEntity == null) {
            return false;
        }       
        em.refresh(organizationEntity);
        
        final OrganizationAdapter adapter = new OrganizationAdapter(session, em, organizationEntity);        
        for (InvoiceModel invoice : adapter.getInvoices()) {
            session.invoices().removeInvoice(organization, invoice);
        }
		for (CertifiedModel certified : adapter.getCetifieds()) {
			session.certifieds().removeCertified(organization, certified);
		}
        em.remove(organizationEntity);
        em.flush();
        em.clear();            
        return true;
	}
		
	@Override
	public List<OrganizationModel> getOrganizations() {
		TypedQuery<String> query = em.createNamedQuery("getAllOrganizationIds", String.class);
		List<String> entities = query.getResultList();
		List<OrganizationModel> organizations = new ArrayList<>();
		for (String id : entities) {
			OrganizationModel organization = session.organizations().getOrganization(id);
			if (organization != null)
				organizations.add(organization);
		}
		return organizations;
	}

}
