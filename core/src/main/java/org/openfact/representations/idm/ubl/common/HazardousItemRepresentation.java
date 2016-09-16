package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class HazardousItemRepresentation {
    private String ID;
    private String placardNotation;
    private String placardEndorsement;
    private String additionalInformation;
    private String UNDGCode;
    private String emergencyProceduresCode;
    private String medicalFirstAidGuideCode;
    private String technicalName;
    private String categoryName;
    private String hazardousCategoryCode;
    private String upperOrangeHazardPlacardID;
    private String lowerOrangeHazardPlacardID;
    private String markingID;
    private String hazardClassID;
    private MeasureRepresentation netWeightMeasure;
    private MeasureRepresentation netVolumeMeasure;
    private QuantityRepresentation quantity;
    private PartyRepresentation contactParty;
    private List<SecondaryHazardRepresentation> secondaryHazard;
    private List<HazardousGoodsTransitRepresentation> hazardousGoodsTransit;
    private TemperatureRepresentation emergencyTemperature;
    private TemperatureRepresentation flashpointTemperature;
    private List<TemperatureRepresentation> additionalTemperature;
    private String id;
}
