package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class ItemIdentificationAdapter
        implements ItemIdentificationModel, JpaModel<ItemIdentificationEntity> {

    protected static final Logger logger = Logger.getLogger(ItemIdentificationAdapter.class);
    protected ItemIdentificationEntity itemIdentification;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemIdentificationAdapter(OpenfactSession session, EntityManager em,
            ItemIdentificationEntity itemIdentification) {
        this.session = session;
        this.em = em;
        this.itemIdentification = itemIdentification;
    }

    String getID() {
        return this.itemIdentification.getID();
    }

    void setID(String value) {
        this.itemIdentification.setID(value);
    }

    String getExtendedID() {
        return this.itemIdentification.getExtendedID();
    }

    void setExtendedID(String value) {
        this.itemIdentification.setExtendedID(value);
    }

    List<PhysicalAttributeAdapter> getPhysicalAttribute() {
        return this.itemIdentification.getPhysicalAttribute();
    }

    void setPhysicalAttribute(List<PhysicalAttributeAdapter> physicalAttribute) {
        this.itemIdentification.setPhysicalAttribute(physicalAttribute);
    }

    List<DimensionAdapter> getMeasurementDimension() {
        return this.itemIdentification.getMeasurementDimension();
    }

    void setMeasurementDimension(List<DimensionAdapter> measurementDimension) {
        this.itemIdentification.setMeasurementDimension(measurementDimension);
    }

    PartyAdapter getIssuerParty() {
        return this.itemIdentification.getIssuerParty();
    }

    void setIssuerParty(PartyAdapter value) {
        this.itemIdentification.setIssuerParty(value);
    }

    String getId() {
        return this.itemIdentification.getId();
    }

    void setId(String value) {
        this.itemIdentification.setId(value);
    }

}
