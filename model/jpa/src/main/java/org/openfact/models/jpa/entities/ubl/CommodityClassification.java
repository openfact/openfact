package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the classification of a commodity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:37 a. m.
 */
public class CommodityClassification {

	/**
	 * A mutually agreed code signifying the type of cargo for purposes of
	 * commodity classification.
	 */
	private String cargoTypeCode;
	/**
	 * The harmonized international commodity code for cross border and
	 * regulatory (customs and trade statistics) purposes.
	 */
	private String commodityCode;
	/**
	 * A code signifying the trade classification of the commodity.
	 */
	private String itemClassificationCode;
	/**
	 * A code defined by a specific maintenance agency signifying the high-level
	 * nature of the commodity.
	 */
	private String natureCode;

	public CommodityClassification() {

	}

	public void finalize() throws Throwable {

	}

	public String getCargoTypeCode() {
		return cargoTypeCode;
	}

	public void setCargoTypeCode(String cargoTypeCode) {
		this.cargoTypeCode = cargoTypeCode;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getItemClassificationCode() {
		return itemClassificationCode;
	}

	public void setItemClassificationCode(String itemClassificationCode) {
		this.itemClassificationCode = itemClassificationCode;
	}

	public String getNatureCode() {
		return natureCode;
	}

	public void setNatureCode(String natureCode) {
		this.natureCode = natureCode;
	}
}// end CommodityClassification