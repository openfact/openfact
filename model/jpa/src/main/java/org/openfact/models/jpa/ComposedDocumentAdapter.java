package org.openfact.models.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentModel;
import org.openfact.models.ComposedDocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.ComposedDocumentEntity;
import org.openfact.models.jpa.entities.DocumentEntity;

public class ComposedDocumentAdapter extends DocumentAdapter implements ComposedDocumentModel {

    protected static final Logger logger = Logger.getLogger(ComposedDocumentAdapter.class);

    protected OrganizationModel organization;
    protected ComposedDocumentEntity document;
    protected EntityManager em;
    protected OpenfactSession session;

    public ComposedDocumentAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            ComposedDocumentEntity document) {
        super(organization, session, em, document);
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.document = document;
    }

    @Override
    public ComposedDocumentEntity getEntity() {
        return document;
    }

    public static ComposedDocumentEntity toEntity(ComposedDocumentAdapter model, EntityManager em) {
        if (model instanceof ComposedDocumentAdapter) {
            return ((ComposedDocumentAdapter) model).getEntity();
        }
        return em.getReference(ComposedDocumentEntity.class, model.getId());
    }

    @Override
    public void addChildren(DocumentModel documentComponent) {
        DocumentEntity entity = DocumentAdapter.toEntity(documentComponent, em);
        this.document.add(entity);
    }

    @Override
    public List<DocumentModel> getChildrens() {
        return document.getChildrens().stream()
                .map(f -> DocumentAdapter.toModel(f, organization, session, em)).collect(Collectors.toList());
    }

}
