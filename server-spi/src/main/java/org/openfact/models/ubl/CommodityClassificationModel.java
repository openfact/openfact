package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the classification of a commodity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:37 a. m.
 */
public class CommodityClassificationModel {

    /**
     * A mutually agreed code signifying the type of cargo for purposes of
     * commodity classification.
     */
    private CodeModel cargoTypeCode;
    /**
     * The harmonized international commodity code for cross border and
     * regulatory (customs and trade statistics) purposes.
     */
    private CodeModel commodityCode;
    /**
     * A code signifying the trade classification of the commodity.
     */
    private CodeModel itemClassificationCode;
    /**
     * A code defined by a specific maintenance agency signifying the high-level
     * nature of the commodity.
     */
    private CodeModel natureCode;

}
