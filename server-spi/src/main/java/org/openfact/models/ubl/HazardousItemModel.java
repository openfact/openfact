package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a hazardous item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItemModel {

    /**
     * Text providing further information about the hazardous substance.
     */
    private TextModel additionalInformation;
    /**
     * The name of the category of hazard that applies to the Item.
     */
    private NameModel categoryName;
    /**
     * A code signifying the emergency procedures for this hazardous item.
     */
    private CodeModel emergencyProceduresCode;
    /**
     * An identifier for the hazard class applicable to this hazardous item as
     * defined by the relevant regulation authority (e.g., the IMDG Class Number
     * of the SOLAS Convention of IMO and the ADR/RID Class Number for the
     * road/rail environment).
     */
    private IdentifierModel hazardClassID;
    /**
     * A code signifying a kind of hazard for a material.
     */
    private CodeModel hazardousCategoryCode;
    /**
     * An identifier for this hazardous item.
     */
    private IdentifierModel ID;
    /**
     * The number for the lower part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierModel lowerOrangeHazardPlacardID;
    /**
     * An identifier to the marking of the HazardousItem
     */
    private IdentifierModel markingID;
    /**
     * A code signifying a medical first aid guide appropriate to this hazardous
     * item.
     */
    private CodeModel medicalFirstAidGuideCode;
    /**
     * The volume of this hazardous item, excluding packaging and transport
     * equipment.
     */
    private MeasureModel netVolumeMeasure;
    /**
     * The net weight of this hazardous item, excluding packaging.
     */
    private MeasureModel netWeightMeasure;
    /**
     * Text of the placard endorsement that is to be shown on the shipping
     * papers for this hazardous item. Can also be used for the number of the
     * orange placard (lower part) required on the means of transport.
     */
    private TextModel placardEndorsement;
    /**
     * Text of the placard notation corresponding to the hazard class of this
     * hazardous item. Can also be the hazard identification number of the
     * orange placard (upper part) required on the means of transport.
     */
    private TextModel placardNotation;
    /**
     * The quantity of goods items in this hazardous item that are hazardous.
     */
    private QuantityModel quantity;
    /**
     * The full technical name of a specific hazardous substance contained in
     * this goods item.
     */
    private NameModel technicalName;
    /**
     * The UN code for this kind of hazardous item.
     */
    private CodeModel UNDGCode;
    /**
     * The number for the upper part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierModel upperOrangeHazardPlacardID;
    private List<HazardousGoodsTransitModel> hazardousGoodsTransits = new ArrayList<>();
    private PartyModel contactParty;
    private List<SecondaryHazardModel> secondaryHazards = new ArrayList<>();
    private TemperatureModel emergencyTemperature;
    private TemperatureModel additionalTemperature;
    private TemperatureModel flashpointTemperature;

}
