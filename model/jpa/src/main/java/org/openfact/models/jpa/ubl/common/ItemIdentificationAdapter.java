package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PhysicalAttributeModel;

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

    @Override
    public String getID() {
        return this.itemIdentification.getID();
    }

    @Override
    public void setID(String value) {
        this.itemIdentification.setID(value);
    }

    @Override
    public String getExtendedID() {
        return this.itemIdentification.getExtendedID();
    }

    @Override
    public void setExtendedID(String value) {
        this.itemIdentification.setExtendedID(value);
    }

    @Override
    public List<PhysicalAttributeModel> getPhysicalAttribute() {
        return this.itemIdentification.getPhysicalAttribute();
    }

    @Override
    public void setPhysicalAttribute(List<PhysicalAttributeAdapter> physicalAttribute) {
        this.itemIdentification.setPhysicalAttribute(physicalAttribute);
    }

    @Override
    public List<DimensionModel> getMeasurementDimension() {
        return this.itemIdentification.getMeasurementDimension();
    }

    @Override
    public void setMeasurementDimension(List<DimensionAdapter> measurementDimension) {
        this.itemIdentification.setMeasurementDimension(measurementDimension);
    }

    @Override
    public PartyModel getIssuerParty() {
        return this.itemIdentification.getIssuerParty();
    }

    @Override
    public void setIssuerParty(PartyAdapter value) {
        this.itemIdentification.setIssuerParty(value);
    }

    @Override
    public String getId() {
        return this.itemIdentification.getId();
    }

    @Override
    public void setId(String value) {
        this.itemIdentification.setId(value);
    }

}
