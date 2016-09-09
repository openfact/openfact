package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.MeasureType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a hazardous item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItemEntity {

    /**
     * Text providing further information about the hazardous substance.
     */
    private TextType AdditionalInformation;
    /**
     * The name of the category of hazard that applies to the Item.
     */
    private NameType CategoryName;
    /**
     * A code signifying the emergency procedures for this hazardous item.
     */
    private CodeType EmergencyProceduresCode;
    /**
     * An identifier for the hazard class applicable to this hazardous item as
     * defined by the relevant regulation authority (e.g., the IMDG Class Number
     * of the SOLAS Convention of IMO and the ADR/RID Class Number for the
     * road/rail environment).
     */
    private IdentifierType HazardClassID;
    /**
     * A code signifying a kind of hazard for a material.
     */
    private CodeType HazardousCategoryCode;
    /**
     * An identifier for this hazardous item.
     */
    private IdentifierType ID;
    /**
     * The number for the lower part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierType LowerOrangeHazardPlacardID;
    /**
     * An identifier to the marking of the HazardousItem
     */
    private IdentifierType MarkingID;
    /**
     * A code signifying a medical first aid guide appropriate to this hazardous
     * item.
     */
    private CodeType MedicalFirstAidGuideCode;
    /**
     * The volume of this hazardous item, excluding packaging and transport
     * equipment.
     */
    private MeasureType NetVolumeMeasure;
    /**
     * The net weight of this hazardous item, excluding packaging.
     */
    private MeasureType NetWeightMeasure;
    /**
     * Text of the placard endorsement that is to be shown on the shipping
     * papers for this hazardous item. Can also be used for the number of the
     * orange placard (lower part) required on the means of transport.
     */
    private TextType PlacardEndorsement;
    /**
     * Text of the placard notation corresponding to the hazard class of this
     * hazardous item. Can also be the hazard identification number of the
     * orange placard (upper part) required on the means of transport.
     */
    private TextType PlacardNotation;
    /**
     * The quantity of goods items in this hazardous item that are hazardous.
     */
    private QuantityType Quantity;
    /**
     * The full technical name of a specific hazardous substance contained in
     * this goods item.
     */
    private NameType TechnicalName;
    /**
     * The UN code for this kind of hazardous item.
     */
    private CodeType UNDGCode;
    /**
     * The number for the upper part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierType UpperOrangeHazardPlacardID;
    private List<HazardousGoodsTransitEntity> HazardousGoodsTransits = new ArrayList<>();
    private PartyEntity ContactParty;
    private List<SecondaryHazardEntity> SecondaryHazards = new ArrayList<>();
    private TemperatureEntity EmergencyTemperature;
    private TemperatureEntity AdditionalTemperature;
    private TemperatureEntity FlashpointTemperature;

}
