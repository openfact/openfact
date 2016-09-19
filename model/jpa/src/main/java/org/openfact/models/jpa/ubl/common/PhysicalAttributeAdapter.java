package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class PhysicalAttributeAdapter implements PhysicalAttributeModel, JpaModel<PhysicalAttributeEntity> {

    protected static final Logger logger = Logger.getLogger(PhysicalAttributeAdapter.class);
    protected PhysicalAttributeEntity physicalAttribute;
    protected EntityManager em;
    protected OpenfactSession session;

    public PhysicalAttributeAdapter(OpenfactSession session, EntityManager em,
            PhysicalAttributeEntity physicalAttribute) {
        this.session = session;
        this.em = em;
        this.physicalAttribute = physicalAttribute;
    }

    String getAttributeID() {
        return this.physicalAttribute.getAttributeID();
    }

    void setAttributeID(String value) {
        this.physicalAttribute.setAttributeID(value);
    }

    String getPositionCode() {
        return this.physicalAttribute.getPositionCode();
    }

    void setPositionCode(String value) {
        this.physicalAttribute.setPositionCode(value);
    }

    String getDescriptionCode() {
        return this.physicalAttribute.getDescriptionCode();
    }

    void setDescriptionCode(String value) {
        this.physicalAttribute.setDescriptionCode(value);
    }

    List<String> getDescription() {
        return this.physicalAttribute.getDescription();
    }

    void setDescription(List<String> description) {
        this.physicalAttribute.setDescription(description);
    }

    String getId() {
        return this.physicalAttribute.getId();
    }

    void setId(String value) {
        this.physicalAttribute.setId(value);
    }

}
