package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.ComposedDocumentModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.jpa.entities.OrganizationEntity;

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
		
		final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
		session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationCreationEvent() {
            @Override
            public OrganizationModel getCreatedOrganization() {
                return adapter;
            }
        });
		
		createDefaultDocuments(adapter);
		
        return adapter;        
	}

    @Deprecated
    private void createDefaultDocuments(OrganizationModel organization) {
        //
        organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "DNI", "1");
        organization.addSimpleDocument(DocumentType.ADDITIONAL_IDENTIFICATION_ID, "RUC", "6");   
        
        organization.addSimpleDocument(DocumentType.INVOICE_TYPE, "BOLETA", "01");
        organization.addSimpleDocument(DocumentType.INVOICE_TYPE, "FACTURA", "03");
        
        //
        ComposedDocumentModel gravado = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "GRAVADO", "01");
        ComposedDocumentModel exonerado = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "EXONERADO", "02");
        ComposedDocumentModel inafecto = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "INAFECTO", "03");
        ComposedDocumentModel document4 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "EXPORTACION", "04");
        ComposedDocumentModel document5 = organization.addComposedDocument(DocumentType.ADDITIONAL_INFORMATION, "GRATUITO", "05");
        
        DocumentModel children1 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Operacion Onerosa", "10", true);
        DocumentModel children2 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Retiro por premio", "11", true);
        DocumentModel children3 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Retiro por donacion", "12", true);
        DocumentModel children4 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Retiro", "13", true);
        DocumentModel children5 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Retiro por publicidad", "14", true);
        DocumentModel children6 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Bonificaciones", "15", true);
        DocumentModel children7 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gravado - Retiro por entrega a trabajadores", "16", true);
        DocumentModel children8 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Exonerado - Operacion Onerosa", "20", false);
        DocumentModel children9 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Operacion Onerosa", "30", false);
        DocumentModel children10 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro por Bonification", "31", false);
        DocumentModel children11 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro", "32", false);
        DocumentModel children12 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro por muestras medicas", "33", false);
        DocumentModel children13 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro por convenio colectivo", "34", false);
        DocumentModel children14 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro por premio", "35", false);
        DocumentModel children15 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Inafecto - Retiro por publicidad", "36", false);
        DocumentModel children16 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Exportacion", "40", true);
        DocumentModel children17 = organization.addCheckableDocument(DocumentType.ADDITIONAL_INFORMATION_CHILDREN, "Gratuito", "50", true);
        
        gravado.addChildren(children1);
        gravado.addChildren(children2);
        gravado.addChildren(children3);
        gravado.addChildren(children4);
        gravado.addChildren(children5);
        gravado.addChildren(children6);
        gravado.addChildren(children7);
        
        exonerado.addChildren(children8);
        
        inafecto.addChildren(children9);
        inafecto.addChildren(children10);
        inafecto.addChildren(children11);
        inafecto.addChildren(children12);
        inafecto.addChildren(children13);
        inafecto.addChildren(children14);
        inafecto.addChildren(children15);
        
        document4.addChildren(children16);
        
        document5.addChildren(children17);
        
        //
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "IGV", "01", new BigDecimal(0.18));
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "ISC", "02", new BigDecimal(0.10));
        organization.addValuableDocument(DocumentType.TOTAL_TAX, "OTROS", "otros", new BigDecimal(0.0));       
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
        em.remove(organizationEntity);
        
        em.flush();
        em.clear();
        
        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationRemovedEvent() {
            @Override
            public OrganizationModel getOrganization() {
                return adapter;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });

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
