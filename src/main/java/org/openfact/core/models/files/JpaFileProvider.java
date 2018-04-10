package org.openfact.core.models.files;

import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.FileProviderVendor;
import org.openfact.core.models.jpa.entities.FileEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.JPA)
public class JpaFileProvider implements FileProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public FileModel addFile(String filename, byte[] bytes) throws FileException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFilename(filename);
        fileEntity.setBytes(bytes);
        em.persist(fileEntity);
        return new FileModel() {
            @Override
            public String getFileName() {
                return filename;
            }

            @Override
            public byte[] getBytes() {
                return bytes;
            }
        };
    }

}
