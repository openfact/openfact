package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a specific, trackable instance of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstance {

	/**
	 * The date before which it is best to use this item instance.
	 */
	private LocalDate bestBeforeDate;
	/**
	 * The date on which this item instance was manufactured.
	 */
	private LocalDate manufactureDate;
	/**
	 * The time at which this item instance was manufactured.
	 */
	private LocalTime manufactureTime;
	/**
	 * An identifier used for tracing this item instance, such as the EPC number
	 * used in RFID.
	 */
	private String productTraceID;
	/**
	 * The registration identifier of this item instance.
	 */
	private String registrationID;
	/**
	 * The serial number of this item instance.
	 */
	private String serialID;
	private ItemProperty additionalItemProperty;
	private List<LotIdentification> lotIdentifications=new ArrayList<>();

	public LocalDate getBestBeforeDate() {
		return bestBeforeDate;
	}

	public void setBestBeforeDate(LocalDate bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalTime getManufactureTime() {
		return manufactureTime;
	}

	public void setManufactureTime(LocalTime manufactureTime) {
		this.manufactureTime = manufactureTime;
	}

	public String getProductTraceID() {
		return productTraceID;
	}

	public void setProductTraceID(String productTraceID) {
		this.productTraceID = productTraceID;
	}

	public String getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}

	public String getSerialID() {
		return serialID;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public ItemProperty getAdditionalItemProperty() {
		return additionalItemProperty;
	}

	public void setAdditionalItemProperty(ItemProperty additionalItemProperty) {
		this.additionalItemProperty = additionalItemProperty;
	}

	public List<LotIdentification> getLotIdentifications() {
		return lotIdentifications;
	}

	public void setLotIdentifications(List<LotIdentification> lotIdentifications) {
		this.lotIdentifications = lotIdentifications;
	}
}// end Item Instance