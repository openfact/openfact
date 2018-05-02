package org.openfact.core.files.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "file")
public class FileEntity implements Serializable {

    @Id
    @Column(name = "filename")
    @Access(AccessType.PROPERTY)
    private String filename;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file_bytes")
    private byte[] fileBytes;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] file) {
        this.fileBytes = file;
    }
}
