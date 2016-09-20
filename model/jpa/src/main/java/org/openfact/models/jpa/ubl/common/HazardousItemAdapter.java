package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.HazardousGoodsTransitEntity;
import org.openfact.models.jpa.entities.ubl.common.HazardousItemEntity;
import org.openfact.models.jpa.entities.ubl.common.SecondaryHazardEntity;
import org.openfact.models.jpa.entities.ubl.common.TemperatureEntity;
import org.openfact.models.jpa.entities.ubl.common.TransactionConditionsEntity;
import org.openfact.models.ubl.common.HazardousGoodsTransitModel;
import org.openfact.models.ubl.common.HazardousItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.SecondaryHazardModel;
import org.openfact.models.ubl.common.TemperatureModel;
import org.openfact.models.ubl.common.TransactionConditionsModel;

public class HazardousItemAdapter implements HazardousItemModel, JpaModel<HazardousItemEntity> {

    protected static final Logger logger = Logger.getLogger(HazardousItemAdapter.class);
    protected HazardousItemEntity hazardousItem;
    protected EntityManager em;
    protected OpenfactSession session;

    public HazardousItemAdapter(OpenfactSession session, EntityManager em,
            HazardousItemEntity hazardousItem) {
        this.session = session;
        this.em = em;
        this.hazardousItem = hazardousItem;
    }

    @Override
    public String getID() {
        return this.hazardousItem.getID();
    }

    @Override
    public void setID(String value) {
        this.hazardousItem.setID(value);
    }

    @Override
    public String getPlacardNotation() {
        return this.hazardousItem.getPlacardNotation();
    }

    @Override
    public void setPlacardNotation(String value) {
        this.hazardousItem.setPlacardNotation(value);
    }

    @Override
    public String getPlacardEndorsement() {
        return this.hazardousItem.getPlacardEndorsement();
    }

    @Override
    public void setPlacardEndorsement(String value) {
        this.hazardousItem.setPlacardEndorsement(value);
    }

    @Override
    public String getAdditionalInformation() {
        return this.hazardousItem.getAdditionalInformation();
    }

    @Override
    public void setAdditionalInformation(String value) {
        this.hazardousItem.setAdditionalInformation(value);
    }

    @Override
    public String getUNDGCode() {
        return this.hazardousItem.getUndgCode();
    }

    @Override
    public void setUNDGCode(String value) {
        this.hazardousItem.setUndgCode(value);
    }

    @Override
    public String getEmergencyProceduresCode() {
        return this.hazardousItem.getEmergencyProceduresCode();
    }

    @Override
    public void setEmergencyProceduresCode(String value) {
        this.hazardousItem.setEmergencyProceduresCode(value);
    }

    @Override
    public String getMedicalFirstAidGuideCode() {
        return this.hazardousItem.getMedicalFirstAidGuideCode();
    }

    @Override
    public void setMedicalFirstAidGuideCode(String value) {
        this.hazardousItem.setMedicalFirstAidGuideCode(value);
    }

    @Override
    public String getTechnicalName() {
        return this.hazardousItem.getTechnicalName();
    }

    @Override
    public void setTechnicalName(String value) {
        this.hazardousItem.setTechnicalName(value);
    }

    @Override
    public String getCategoryName() {
        return this.hazardousItem.getCategoryName();
    }

    @Override
    public void setCategoryName(String value) {
        this.hazardousItem.setCategoryName(value);
    }

    @Override
    public String getHazardousCategoryCode() {
        return this.hazardousItem.getHazardousCategoryCode();
    }

    @Override
    public void setHazardousCategoryCode(String value) {
        this.hazardousItem.setHazardousCategoryCode(value);
    }

    @Override
    public String getUpperOrangeHazardPlacardID() {
        return this.hazardousItem.getUpperOrangeHazardPlacardID();
    }

    @Override
    public void setUpperOrangeHazardPlacardID(String value) {
        this.hazardousItem.setUpperOrangeHazardPlacardID(value);
    }

    @Override
    public String getLowerOrangeHazardPlacardID() {
        return this.hazardousItem.getLowerOrangeHazardPlacardID();
    }

    @Override
    public void setLowerOrangeHazardPlacardID(String value) {
        this.hazardousItem.setLowerOrangeHazardPlacardID(value);
    }

    @Override
    public String getMarkingID() {
        return this.hazardousItem.getMarkingID();
    }

    @Override
    public void setMarkingID(String value) {
        this.hazardousItem.setMarkingID(value);
    }

    @Override
    public String getHazardClassID() {
        return this.hazardousItem.getHazardClassID();
    }

    @Override
    public void setHazardClassID(String value) {
        this.hazardousItem.setHazardClassID(value);
    }

    @Override
    public MeasureModel getNetWeightMeasure() {
        return new MeasureAdapter(session, em, hazardousItem.getNetWeightMeasure());
    }

    @Override
    public void setNetWeightMeasure(MeasureModel value) {
        this.hazardousItem.setNetWeightMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public MeasureModel getNetVolumeMeasure() {
        return new MeasureAdapter(session, em, hazardousItem.getNetVolumeMeasure());
    }

    @Override
    public void setNetVolumeMeasure(MeasureModel value) {
        this.hazardousItem.setNetVolumeMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getQuantity() {
        return new QuantityAdapter(session, em, hazardousItem.getQuantity());
    }

    @Override
    public void setQuantity(QuantityModel value) {
        this.hazardousItem.setQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public PartyModel getContactParty() {
        return new PartyAdapter(session, em, hazardousItem.getContactParty());
    }

    @Override
    public void setContactParty(PartyModel value) {
        this.hazardousItem.setContactParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public List<SecondaryHazardModel> getSecondaryHazard() {
        return hazardousItem.getSecondaryHazard().stream()
                .map(f -> new SecondaryHazardAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setSecondaryHazard(List<SecondaryHazardModel> secondaryHazard) {
        List<SecondaryHazardEntity> entities = secondaryHazard.stream()
                .map(f -> SecondaryHazardAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.hazardousItem.setSecondaryHazard(entities);
    }

    @Override
    public List<HazardousGoodsTransitModel> getHazardousGoodsTransit() {
        return hazardousItem.getHazardousGoodsTransit().stream()
                .map(f -> new HazardousGoodsTransitAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit) {
        List<HazardousGoodsTransitEntity> entities = hazardousGoodsTransit.stream()
                .map(f -> HazardousGoodsTransitAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.hazardousItem.setHazardousGoodsTransit(entities);
    }

    @Override
    public TemperatureModel getEmergencyTemperature() {
        return new TemperatureAdapter(session, em, hazardousItem.getEmergencyTemperature());
    }

    @Override
    public void setEmergencyTemperature(TemperatureModel value) {
        this.hazardousItem.setEmergencyTemperature(TemperatureAdapter.toEntity(value, em));
    }

    @Override
    public TemperatureModel getFlashpointTemperature() {
        return new TemperatureAdapter(session, em, hazardousItem.getFlashpointTemperature());
    }

    @Override
    public void setFlashpointTemperature(TemperatureModel value) {
        this.hazardousItem.setFlashpointTemperature(TemperatureAdapter.toEntity(value, em));
    }

    @Override
    public List<TemperatureModel> getAdditionalTemperature() {
        return hazardousItem.getAdditionalTemperature().stream()
                .map(f -> new TemperatureAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAdditionalTemperature(List<TemperatureModel> additionalTemperature) {
        List<TemperatureEntity> entities = additionalTemperature.stream()
                .map(f -> TemperatureAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.hazardousItem.setAdditionalTemperature(entities);
    }

    @Override
    public String getId() {
        return this.hazardousItem.getId();
    }

    @Override
    public void setId(String value) {
        this.hazardousItem.setId(value);
    }

    @Override
    public HazardousItemEntity getEntity() {
        return hazardousItem;
    }

    public static HazardousItemEntity toEntity(HazardousItemModel model, EntityManager em) {
        if (model instanceof HazardousItemAdapter) {
            return ((HazardousItemAdapter) model).getEntity();
        }
        return em.getReference(HazardousItemEntity.class, model.getId());
    }

}
