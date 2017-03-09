package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.FileModel;
import org.openfact.models.jpa.entities.FileEntity;

import javax.persistence.EntityManager;

public class FileAdapter implements FileModel, JpaModel<FileEntity> {

    protected static final Logger logger = Logger.getLogger(FileAdapter.class);

    protected FileEntity file;
    protected EntityManager em;

    public FileAdapter(EntityManager em, FileEntity file) {
        this.em = em;
        this.file = file;
    }

    public static FileEntity toEntity(FileModel model, EntityManager em) {
        if (model instanceof FileAdapter) {
            return ((FileAdapter) model).getEntity();
        }
        return em.getReference(FileEntity.class, model.getId());
    }

    @Override
    public FileEntity getEntity() {
        return file;
    }

    @Override
    public String getId() {
        return file.getId();
    }

    @Override
    public String getFileName() {
        return file.getFileName();
    }

    @Override
    public void setFileName(String fileName) {
        file.setFileName(fileName);
    }

    @Override
    public byte[] getFile() {
        return file.getFile();
    }

    @Override
    public String getExtension() {
        String fileName = file.getFileName();
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        } else {
            return "";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof FileModel)) return false;

        FileModel that = (FileModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
