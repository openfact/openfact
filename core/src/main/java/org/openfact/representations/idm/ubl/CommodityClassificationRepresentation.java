package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;

/**
 * A class to describe the classification of a commodity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:37 a. m.
 */
public class CommodityClassificationRepresentation {

    /**
     * A mutually agreed code signifying the type of cargo for purposes of
     * commodity classification.
     */
    private CodeRepresentation cargoTypeCode;
    /**
     * The harmonized international commodity code for cross border and
     * regulatory (customs and trade statistics) purposes.
     */
    private CodeRepresentation commodityCode;
    /**
     * A code signifying the trade classification of the commodity.
     */
    private CodeRepresentation itemClassificationCode;
    /**
     * A code defined by a specific maintenance agency signifying the high-level
     * nature of the commodity.
     */
    private CodeRepresentation natureCode;

}
