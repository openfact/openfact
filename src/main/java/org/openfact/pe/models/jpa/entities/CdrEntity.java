package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "archivos_asociados_sunat")
public class CdrEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "ticket")
    private String ticket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
