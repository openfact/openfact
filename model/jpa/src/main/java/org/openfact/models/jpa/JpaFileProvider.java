package org.openfact.models.jpa;

import org.openfact.models.FileModel;
import org.openfact.models.FileProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.FileEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class JpaFileProvider implements FileProvider {

    @Inject
    protected EntityManager em;

    @Override
    public FileModel addFile(OrganizationModel organization, String fileName, byte[] file) throws ModelException {
        FileEntity entity = new FileEntity();
        entity.setFileName(fileName);
        entity.setFile(file);
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(entity);
        em.flush();
        return new FileAdapter(organization, em, entity);
    }

    @Override
    public FileModel getFile(OrganizationModel organization, String id) {
        TypedQuery<FileEntity> query = em.createNamedQuery("getOrganizationFileById", FileEntity.class);
        query.setParameter("organizationId", organization.getId());
        List<FileEntity> entities = query.getResultList();
        if (entities.size() == 0) return null;
        return new FileAdapter(organization, em, entities.get(0));
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

}