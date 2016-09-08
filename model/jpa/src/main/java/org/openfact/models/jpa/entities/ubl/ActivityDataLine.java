package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLine {

	/**
	 * An identifier for this activity data line.
	 */
	private IdentifierType id;

	/**
	 * A code signifying the type of supply chain activity.
	 */
	private CodeType supplyChainActivityTypeCode;
	private CustomerParty buyerCustomerParty;
	private Location activityOriginLocation;
	private Period activityPeriod;
	private Location activityFinalLocation;
	private List<SalesItem> salesItems = new ArrayList<>();
	private SupplierParty sellerSupplierParty;

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public CodeType getSupplyChainActivityTypeCode() {
		return supplyChainActivityTypeCode;
	}

	public void setSupplyChainActivityTypeCode(CodeType supplyChainActivityTypeCode) {
		this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
	}

	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public Location getActivityOriginLocation() {
		return activityOriginLocation;
	}

	public void setActivityOriginLocation(Location activityOriginLocation) {
		this.activityOriginLocation = activityOriginLocation;
	}

	public Period getActivityPeriod() {
		return activityPeriod;
	}

	public void setActivityPeriod(Period activityPeriod) {
		this.activityPeriod = activityPeriod;
	}

	public Location getActivityFinalLocation() {
		return activityFinalLocation;
	}

	public void setActivityFinalLocation(Location activityFinalLocation) {
		this.activityFinalLocation = activityFinalLocation;
	}

	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}