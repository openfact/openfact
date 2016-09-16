package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class HazardousItemModel {
    protected String ID;
    protected String PlacardNotation;
    protected String PlacardEndorsement;
    protected String AdditionalInformation;
    protected String UNDGCode;
    protected String EmergencyProceduresCode;
    protected String MedicalFirstAidGuideCode;
    protected String TechnicalName;
    protected String CategoryName;
    protected String HazardousCategoryCode;
    protected String UpperOrangeHazardPlacardID;
    protected String LowerOrangeHazardPlacardID;
    protected String MarkingID;
    protected String HazardClassID;
    protected MeasureModel NetWeightMeasure;
    protected MeasureModel NetVolumeMeasure;
    protected QuantityModel Quantity;
    protected PartyModel ContactParty;
    protected List<SecondaryHazardModel> SecondaryHazard;
    protected List<HazardousGoodsTransitModel> HazardousGoodsTransit;
    protected TemperatureModel EmergencyTemperature;
    protected TemperatureModel FlashpointTemperature;
    protected List<TemperatureModel> AdditionalTemperature;
    protected String Id;
}