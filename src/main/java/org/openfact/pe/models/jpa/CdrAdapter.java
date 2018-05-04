package org.openfact.pe.models.jpa;

import org.openfact.core.models.jpa.JpaModel;
import org.openfact.pe.models.CdrModel;
import org.openfact.pe.models.jpa.entities.CdrEntity;

public class CdrAdapter implements CdrModel, JpaModel<CdrEntity> {

    private final CdrEntity cdr;

    public CdrAdapter(CdrEntity cdr) {
        this.cdr = cdr;
    }

    @Override
    public CdrEntity getEntity() {
        return cdr;
    }

    @Override
    public String getId() {
        return cdr.getId();
    }

    @Override
    public String getFileId() {
        return cdr.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        cdr.setFileId(fileId);
    }

    @Override
    public String getTicket() {
        return cdr.getTicket();
    }

    @Override
    public void setTicket(String ticket) {
        cdr.setTicket(ticket);
    }

}
