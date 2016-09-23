package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyEntity;
import org.openfact.models.jpa.entities.ubl.common.LotIdentificationEntity;
import org.openfact.models.ubl.common.ItemPropertyModel;
import org.openfact.models.ubl.common.LotIdentificationModel;

public class LotIdentificationAdapter implements LotIdentificationModel, JpaModel<LotIdentificationEntity> {

    protected static final Logger logger = Logger.getLogger(LotIdentificationAdapter.class);
    protected LotIdentificationEntity lotIdentification;
    protected EntityManager em;
    protected OpenfactSession session;

    public LotIdentificationAdapter(OpenfactSession session, EntityManager em,
            LotIdentificationEntity lotIdentification) {
        this.session = session;
        this.em = em;
        this.lotIdentification = lotIdentification;
    }

    @Override
    public String getLotNumberID() {
        return this.lotIdentification.getLotNumberID();
    }

    @Override
    public void setLotNumberID(String value) {
        this.lotIdentification.setLotNumberID(value);
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.lotIdentification.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDate value) {
        this.lotIdentification.setExpiryDate(value);
    }

    @Override
    public List<ItemPropertyModel> getAdditionalItemProperty() {
        return lotIdentification.getAdditionalItemProperty().stream()
                .map(f -> new ItemPropertyAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty) {
        List<ItemPropertyEntity> entities = additionalItemProperty.stream()
                .map(f -> ItemPropertyAdapter.toEntity(f, em)).collect(Collectors.toList());
        lotIdentification.setAdditionalItemProperty(entities);
    }

    @Override
    public String getId() {
        return this.lotIdentification.getId();
    }

    @Override
    public void setId(String value) {
        this.lotIdentification.setId(value);
    }

    @Override
    public LotIdentificationEntity getEntity() {
        return lotIdentification;
    }

    public static LotIdentificationEntity toEntity(LotIdentificationModel model, EntityManager em) {
        if (model instanceof LotIdentificationModel) {
            return ((LotIdentificationAdapter) model).getEntity();
        }
        return em.getReference(LotIdentificationEntity.class, model.getId());
    }

}
