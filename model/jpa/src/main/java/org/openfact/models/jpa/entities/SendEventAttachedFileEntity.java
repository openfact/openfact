package org.openfact.models.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SEND_EVENT_ATTACH_FILE")
@IdClass(SendEventAttachedFileEntity.Key.class)
@NamedQueries(value = {
        @NamedQuery(name = "deleteSendEventAttachedFilesByOrganization", query = "delete from SendEventAttachedFileEntity att where att.sendEvent IN (select send from SendEventEntity send join send.document doc where doc.organizationId=:organizationId)")
})
public class SendEventAttachedFileEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "SEND_EVENT_ID")
    protected SendEventEntity sendEvent;

    @Id
    @Column(name = "FILE_ID")
    protected String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public SendEventEntity getSendEvent() {
        return sendEvent;
    }

    public void setSendEvent(SendEventEntity ublDocumentSendEvent) {
        this.sendEvent = ublDocumentSendEvent;
    }

    public static class Key implements Serializable {

        private static final long serialVersionUID = 1L;

        protected SendEventEntity sendEvent;

        protected String fileId;

        public Key() {
        }

        public Key(SendEventEntity ublDocumentSendEvent, String fileId) {
            this.sendEvent = ublDocumentSendEvent;
            this.fileId = fileId;
        }

        public SendEventEntity getSendEvent() {
            return sendEvent;
        }

        public String getFileId() {
            return fileId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SendEventAttachedFileEntity.Key key = (SendEventAttachedFileEntity.Key) o;

            if (fileId != null ? !fileId.equals(key.fileId) : key.fileId != null) return false;
            if (sendEvent != null ? !sendEvent.getId().equals(key.sendEvent != null ? key.sendEvent.getId() : null) : key.sendEvent != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = sendEvent != null ? sendEvent.getId().hashCode() : 0;
            result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
            return result;
        }
    }
}
