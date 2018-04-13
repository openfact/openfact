package org.openfact.core.models.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Cacheable
@Table(name = "file")
public class FileEntity implements Serializable {

    @Id
    @Column(name = "filename")
    @Access(AccessType.PROPERTY)
    private String filename;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "bytes")
    private byte[] bytes;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] file) {
        this.bytes = file;
    }
}
