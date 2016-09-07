package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a line item for utility consumption. To specify more than
 * one utility item, use separate consumption lines.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:52 a. m.
 */
public class ConsumptionLine {

	/**
	 * An identifier for this consumption line.
	 */
	private String ID;
	/**
	 * The quantity invoiced.
	 */
	private BigDecimal invoicedQuantity;
	/**
	 * The monetary amount, including discount, to be charged for this
	 * consumption line.
	 */
	private BigDecimal lineExtensionAmount;
	/**
	 * An identifier for the transaction line on a related document (such as an
	 * invoice) that covers this consumption line.
	 */
	private String parentDocumentLineReferenceID;
	private List<AllowanceCharge> allowanceCharges= new ArrayList<>();
	private List<Delivery> deliverys= new ArrayList<>();
	private List<Period> periods= new ArrayList<>();
	private List<Price> prices= new ArrayList<>();
	private List<TaxTotal> taxTotals= new ArrayList<>();
	private List<UnstructuredPrice> unstructuredPrices= new ArrayList<>();
	private List<UtilityItem> utilityItems= new ArrayList<>();

	public ConsumptionLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getInvoicedQuantity() {
		return invoicedQuantity;
	}

	public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
		this.invoicedQuantity = invoicedQuantity;
	}

	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}

	public String getParentDocumentLineReferenceID() {
		return parentDocumentLineReferenceID;
	}

	public void setParentDocumentLineReferenceID(String parentDocumentLineReferenceID) {
		this.parentDocumentLineReferenceID = parentDocumentLineReferenceID;
	}

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}

	public List<UnstructuredPrice> getUnstructuredPrices() {
		return unstructuredPrices;
	}

	public void setUnstructuredPrices(List<UnstructuredPrice> unstructuredPrices) {
		this.unstructuredPrices = unstructuredPrices;
	}

	public List<UtilityItem> getUtilityItems() {
		return utilityItems;
	}

	public void setUtilityItems(List<UtilityItem> utilityItems) {
		this.utilityItems = utilityItems;
	}
}// end Consumption Line