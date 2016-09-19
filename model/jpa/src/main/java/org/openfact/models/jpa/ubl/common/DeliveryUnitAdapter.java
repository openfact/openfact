package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
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
        return this.deliveryUnit.getBatchQuantity();
    }

    @Override
    public void setBatchQuantity(QuantityAdapter value) {
        this.deliveryUnit.setBatchQuantity(value);
    }

    @Override
    public QuantityModel getConsumerUnitQuantity() {
        return this.deliveryUnit.getConsumerUnitQuantity();
    }

    @Override
    public void setConsumerUnitQuantity(QuantityAdapter value) {
        this.deliveryUnit.setConsumerUnitQuantity(value);
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return this.deliveryUnit.getHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        this.deliveryUnit.setHazardousRiskIndicator(value);
    }

    @Override
    public String getId() {
        return this.deliveryUnit.getId();
    }

    @Override
    public void setId(String value) {
        this.deliveryUnit.setId(value);
    }

}
