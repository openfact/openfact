package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a hazardous item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItemRepresentation {

    /**
     * Text providing further information about the hazardous substance.
     */
    private TextRepresentation additionalInformation;
    /**
     * The name of the category of hazard that applies to the Item.
     */
    private NameRepresentation categoryName;
    /**
     * A code signifying the emergency procedures for this hazardous item.
     */
    private CodeRepresentation emergencyProceduresCode;
    /**
     * An identifier for the hazard class applicable to this hazardous item as
     * defined by the relevant regulation authority (e.g., the IMDG Class Number
     * of the SOLAS Convention of IMO and the ADR/RID Class Number for the
     * road/rail environment).
     */
    private IdentifierRepresentation hazardClassID;
    /**
     * A code signifying a kind of hazard for a material.
     */
    private CodeRepresentation hazardousCategoryCode;
    /**
     * An identifier for this hazardous item.
     */
    private IdentifierRepresentation ID;
    /**
     * The number for the lower part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierRepresentation lowerOrangeHazardPlacardID;
    /**
     * An identifier to the marking of the HazardousItem
     */
    private IdentifierRepresentation markingID;
    /**
     * A code signifying a medical first aid guide appropriate to this hazardous
     * item.
     */
    private CodeRepresentation medicalFirstAidGuideCode;
    /**
     * The volume of this hazardous item, excluding packaging and transport
     * equipment.
     */
    private MeasureRepresentation netVolumeMeasure;
    /**
     * The net weight of this hazardous item, excluding packaging.
     */
    private MeasureRepresentation netWeightMeasure;
    /**
     * Text of the placard endorsement that is to be shown on the shipping
     * papers for this hazardous item. Can also be used for the number of the
     * orange placard (lower part) required on the means of transport.
     */
    private TextRepresentation placardEndorsement;
    /**
     * Text of the placard notation corresponding to the hazard class of this
     * hazardous item. Can also be the hazard identification number of the
     * orange placard (upper part) required on the means of transport.
     */
    private TextRepresentation placardNotation;
    /**
     * The quantity of goods items in this hazardous item that are hazardous.
     */
    private QuantityRepresentation quantity;
    /**
     * The full technical name of a specific hazardous substance contained in
     * this goods item.
     */
    private NameRepresentation technicalName;
    /**
     * The UN code for this kind of hazardous item.
     */
    private CodeRepresentation UNDGCode;
    /**
     * The number for the upper part of the orange hazard placard required on
     * the means of transport.
     */
    private IdentifierRepresentation upperOrangeHazardPlacardID;
    private List<HazardousGoodsTransitRepresentation> hazardousGoodsTransits = new ArrayList<>();
    private PartyRepresentation contactParty;
    private List<SecondaryHazardRepresentation> secondaryHazards = new ArrayList<>();
    private TemperatureRepresentation emergencyTemperature;
    private TemperatureRepresentation additionalTemperature;
    private TemperatureRepresentation flashpointTemperature;

}
