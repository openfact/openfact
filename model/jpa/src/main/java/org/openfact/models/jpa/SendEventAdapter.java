package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.FileModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.jpa.entities.SendEventAttachedFileEntity;
import org.openfact.models.jpa.entities.SendEventAttributeEntity;
import org.openfact.models.jpa.entities.SendEventEntity;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.SendEventStatus;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SendEventAdapter implements SendEventModel, JpaModel<SendEventEntity> {

    protected static final Logger logger = Logger.getLogger(SendEventAdapter.class);
    protected OrganizationModel organization;
    protected SendEventEntity sendEvent;
    protected EntityManager em;

    public SendEventAdapter(EntityManager em, OrganizationModel organization, SendEventEntity ublDocumentDendEvent) {
        this.em = em;
        this.organization = organization;
        this.sendEvent = ublDocumentDendEvent;
    }

    public static SendEventEntity toEntity(SendEventModel model, EntityManager em) {
        if (model instanceof SendEventAdapter) {
            return ((SendEventAdapter) model).getEntity();
        }
        return em.getReference(SendEventEntity.class, model.getId());
    }

    @Override
    public SendEventEntity getEntity() {
        return sendEvent;
    }

    @Override
    public String getId() {
        return sendEvent.getId();
    }

    @Override
    public SendEventStatus getResult() {
        return sendEvent.getStatus();
    }

    @Override
    public void setResult(SendEventStatus result) {
        sendEvent.setStatus(result);
    }

    @Override
    public String getDescription() {
        return sendEvent.getDescription();
    }

    @Override
    public void setDescription(String description) {
        sendEvent.setDescription(description);
    }

    /**
     * Attribute
     */
    @Override
    public void setAttribute(String name, String value) {
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            if (attr.getName().equals(name)) {
                attr.setValue(value);
                return;
            }
        }
        SendEventAttributeEntity attr = new SendEventAttributeEntity();
        attr.setName(name);
        attr.setValue(value);
        attr.setSendEvent(sendEvent);
        em.persist(attr);
        sendEvent.getAttributes().add(attr);
    }

    @Override
    public void setAttribute(String name, Boolean value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Integer value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Long value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void removeAttribute(String name) {
        Iterator<SendEventAttributeEntity> it = sendEvent.getAttributes().iterator();
        while (it.hasNext()) {
            SendEventAttributeEntity attr = it.next();
            if (attr.getName().equals(name)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public String getAttribute(String name) {
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public Integer getAttribute(String name, Integer defaultValue) {
        String v = getAttribute(name);
        return v != null ? Integer.parseInt(v) : defaultValue;

    }

    @Override
    public Long getAttribute(String name, Long defaultValue) {
        String v = getAttribute(name);
        return v != null ? Long.parseLong(v) : defaultValue;

    }

    @Override
    public Boolean getAttribute(String name, Boolean defaultValue) {
        String v = getAttribute(name);
        return v != null ? Boolean.parseBoolean(v) : defaultValue;

    }

    @Override
    public Map<String, String> getAttributes() {
        // should always return a copy
        Map<String, String> result = new HashMap<String, String>();
        for (SendEventAttributeEntity attr : sendEvent.getAttributes()) {
            result.put(attr.getName(), attr.getValue());
        }
        return result;
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return sendEvent.getCreatedTimestamp();
    }

    @Override
    public DestinyType getDestityType() {
        return sendEvent.getDestiny();
    }

    @Override
    public List<String> getAttachedFileIds() {
        return sendEvent.getAttachedFiles().stream()
                .map(f -> f.getFileId())
                .collect(Collectors.toList());
    }

    @Override
    public void attachFile(FileModel file) {
        SendEventAttachedFileEntity entity = new SendEventAttachedFileEntity();
        entity.setFileId(file.getId());
        entity.setSendEvent(sendEvent);
        em.persist(entity);
        sendEvent.getAttachedFiles().add(entity);
    }

    @Override
    public void unattachResponseFile(FileModel file) {
        Iterator<SendEventAttachedFileEntity> it = sendEvent.getAttachedFiles().iterator();
        while (it.hasNext()) {
            SendEventAttachedFileEntity attachFile = it.next();
            if (attachFile.getFileId().equals(file.getId())) {
                it.remove();
                em.remove(attachFile);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof SendEventModel)) return false;

        SendEventModel that = (SendEventModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
