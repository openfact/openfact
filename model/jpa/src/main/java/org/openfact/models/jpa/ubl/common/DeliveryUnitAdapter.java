package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DeliveryUnitEntity;
import org.openfact.models.ubl.common.DeliveryUnitModel;
import org.openfact.models.ubl.common.QuantityModel;

public class DeliveryUnitAdapter implements DeliveryUnitModel, JpaModel<DeliveryUnitEntity> {

    protected static final Logger logger = Logger.getLogger(DeliveryUnitAdapter.class);
    protected DeliveryUnitEntity deliveryUnit;
    protected EntityManager em;
    protected OpenfactSession session;

    public DeliveryUnitAdapter(OpenfactSession session, EntityManager em, DeliveryUnitEntity deliveryUnit) {
        this.session = session;
        this.em = em;
        this.deliveryUnit = deliveryUnit;
    }

    @Override
    public QuantityModel getBatchQuantity() {
        return new QuantityAdapter(session, em, this.deliveryUnit.getBatchQuantity());
    }

    @Override
    public void setBatchQuantity(QuantityModel value) {
        this.deliveryUnit.setBatchQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getConsumerUnitQuantity() {
        return new QuantityAdapter(session, em, this.deliveryUnit.getConsumerUnitQuantity());
    }

    @Override
    public void setConsumerUnitQuantity(QuantityModel value) {
        this.deliveryUnit.setConsumerUnitQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return this.deliveryUnit.isHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        this.deliveryUnit.setHazardousRiskIndicator(value);
    }

    @Override
    public String getId() {
        return this.deliveryUnit.getId();
    }

    public static DeliveryUnitEntity toEntity(DeliveryUnitModel model, EntityManager em) {
        if (model instanceof DeliveryUnitAdapter) {
            return ((DeliveryUnitAdapter) model).getEntity();
        }
        return em.getReference(DeliveryUnitEntity.class, model.getId());
    }

    @Override
    public DeliveryUnitEntity getEntity() {
        return this.deliveryUnit;
    }

}
