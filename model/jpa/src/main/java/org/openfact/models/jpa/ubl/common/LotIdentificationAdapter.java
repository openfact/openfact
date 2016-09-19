package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

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

    String getLotNumberID() {
        return this.lotIdentification.getLotNumberID();
    }

    void setLotNumberID(String value) {
        this.lotIdentification.setLotNumberID(value);
    }

    LocalDate getExpiryDate() {
        return this.lotIdentification.getExpiryDate();
    }

    void setExpiryDate(LocalDate value) {
        this.lotIdentification.setExpiryDate(value);
    }

    List<ItemPropertyAdapter> getAdditionalItemProperty() {
        return this.lotIdentification.getAdditionalItemProperty();
    }

    void setAdditionalItemProperty(List<ItemPropertyAdapter> additionalItemProperty) {
        this.lotIdentification.setAdditionalItemProperty(additionalItemProperty);
    }

    String getId() {
        return this.lotIdentification.getId();
    }

    void setId(String value) {
        this.lotIdentification.setId(value);
    }

}
