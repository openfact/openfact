package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.FileModel;
import org.openfact.models.FileProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.FileEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaFileProvider implements FileProvider {

    protected static final Logger logger = Logger.getLogger(JpaFileProvider.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public FileModel createFile(OrganizationModel organization, String fileName, byte[] file) throws ModelException {
        FileEntity entity = new FileEntity();
        entity.setFileName(fileName);
        entity.setFile(file);
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(entity);
        return new FileAdapter(em, entity);
    }

    @Override
    public FileModel getFileById(OrganizationModel organization, String id) {
        FileEntity entity = em.find(FileEntity.class, id);
        if (entity != null) {
            return new FileAdapter(em, entity);
        }
        return null;
    }

    @Override
    public boolean removeFile(OrganizationModel organization, FileModel file) {
        FileEntity entity = em.find(FileEntity.class, file.getId());
        if (entity != null && entity.getOrganization().getId().equals(organization.getId())) {
            em.remove(entity);
            em.flush();
            return true;
        }
        return false;
    }

    @Override
    public void preRemove(OrganizationModel organization) {
        em.createNamedQuery("deleteFilesByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }
}
