package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

/**
 * A class to define the price of an item as a percentage of the price of a
 * different item.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:26 a. m.
 */
public class DependentPriceReference {

	/**
	 * The percentage by which the price of the different item is multiplied to
	 * calculate the price of the item.
	 */
	private BigDecimal percent;
	private Address locationAddress;
	private LineReference dependentLineReference;

	public DependentPriceReference(){

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public Address getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(Address locationAddress) {
		this.locationAddress = locationAddress;
	}

	public LineReference getDependentLineReference() {
		return dependentLineReference;
	}

	public void setDependentLineReference(LineReference dependentLineReference) {
		this.dependentLineReference = dependentLineReference;
	}
}//end Dependent Price Reference