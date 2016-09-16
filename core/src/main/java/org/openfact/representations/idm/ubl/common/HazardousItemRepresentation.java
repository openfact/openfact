package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class HazardousItemRepresentation {
    private String ID;
    private String PlacardNotation;
    private String PlacardEndorsement;
    private String AdditionalInformation;
    private String UNDGCode;
    private String EmergencyProceduresCode;
    private String MedicalFirstAidGuideCode;
    private String TechnicalName;
    private String CategoryName;
    private String HazardousCategoryCode;
    private String UpperOrangeHazardPlacardID;
    private String LowerOrangeHazardPlacardID;
    private String MarkingID;
    private String HazardClassID;
    private MeasureRepresentation NetWeightMeasure;
    private MeasureRepresentation NetVolumeMeasure;
    private QuantityRepresentation Quantity;
    private PartyRepresentation ContactParty;
    private List<SecondaryHazardRepresentation> SecondaryHazard;
    private List<HazardousGoodsTransitRepresentation> HazardousGoodsTransit;
    private TemperatureRepresentation EmergencyTemperature;
    private TemperatureRepresentation FlashpointTemperature;
    private List<TemperatureRepresentation> AdditionalTemperature;
    private String Id;
}