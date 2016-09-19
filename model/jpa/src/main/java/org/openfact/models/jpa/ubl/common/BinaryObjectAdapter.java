package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.BinaryObjectEntity;
import org.openfact.models.jpa.entities.ubl.common.BinaryObjectMimeCodeContentType;
import org.openfact.models.ubl.common.BinaryObjectModel;

public class BinaryObjectAdapter implements BinaryObjectModel, JpaModel<BinaryObjectEntity> {

    protected static final Logger logger = Logger.getLogger(BinaryObjectAdapter.class);
    protected BinaryObjectEntity binaryObject;
    protected EntityManager em;
    protected OpenfactSession session;

    public BinaryObjectAdapter(OpenfactSession session, EntityManager em, BinaryObjectEntity binaryObject) {
        this.session = session;
        this.em = em;
        this.binaryObject = binaryObject;
    }

    @Override
    public Byte[] getValue() {
        return this.binaryObject.getValue();
    }

    @Override
    public void setValue(Byte[] value) {
        this.binaryObject.setValue(value);
    }

    @Override
    public String getFormat() {
        return this.binaryObject.getFormat();
    }

    @Override
    public void setFormat(String value) {
        this.binaryObject.setFormat(value);
    }

    @Override
    public String getMimeCode() {
        return this.binaryObject.getMimeCode().toString();
    }

    @Override
    public void setMimeCode(String value) {
        this.binaryObject.setMimeCode(BinaryObjectMimeCodeContentType.valueOf(value));
    }

    @Override
    public String getEncodingCode() {
        return this.binaryObject.getEncodingCode();
    }

    @Override
    public void setEncodingCode(String value) {
        this.binaryObject.setEncodingCode(value);
    }

    @Override
    public String getCharacterSetCode() {
        return this.binaryObject.getCharacterSetCode();
    }

    @Override
    public void setCharacterSetCode(String value) {
        this.binaryObject.setCharacterSetCode(value);
    }

    @Override
    public String getUri() {
        return this.binaryObject.getUri();
    }

    @Override
    public void setUri(String value) {
        this.binaryObject.setUri(value);
    }

    @Override
    public String getFilename() {
        return this.binaryObject.getFilename();
    }

    @Override
    public void setFilename(String value) {
        this.binaryObject.setFilename(value);
    }

    @Override
    public String getId() {
        return this.binaryObject.getId();
    }

    @Override
    public void setId(String value) {
        this.binaryObject.setId(value);
    }

    public static BinaryObjectEntity toEntity(BinaryObjectModel model, EntityManager em) {
        if (model instanceof BinaryObjectAdapter) {
            return ((BinaryObjectAdapter) model).getEntity();
        }
        return em.getReference(BinaryObjectEntity.class, model.getId());
    }

    @Override
    public BinaryObjectEntity getEntity() {
        return binaryObject;
    }

}
