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
	private BigDecimal InvoicedQuantity;
	/**
	 * The monetary amount, including discount, to be charged for this
	 * consumption line.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * An identifier for the transaction line on a related document (such as an
	 * invoice) that covers this consumption line.
	 */
	private String ParentDocumentLineReferenceID;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private List<Delivery> deliveries = new ArrayList<>();
	private Period m_Period;
	private List<Price> prices = new ArrayList<>();
	private List<TaxTotal> taxTotals = new ArrayList<>();
	private UnstructuredPrice m_UnstructuredPrice;
	private UtilityItem m_UtilityItem;

	public ConsumptionLine() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the invoicedQuantity
	 */
	public BigDecimal getInvoicedQuantity() {
		return InvoicedQuantity;
	}

	/**
	 * @param invoicedQuantity
	 *            the invoicedQuantity to set
	 */
	public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
		InvoicedQuantity = invoicedQuantity;
	}

	/**
	 * @return the lineExtensionAmount
	 */
	public BigDecimal getLineExtensionAmount() {
		return LineExtensionAmount;
	}

	/**
	 * @param lineExtensionAmount
	 *            the lineExtensionAmount to set
	 */
	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		LineExtensionAmount = lineExtensionAmount;
	}

	/**
	 * @return the parentDocumentLineReferenceID
	 */
	public String getParentDocumentLineReferenceID() {
		return ParentDocumentLineReferenceID;
	}

	/**
	 * @param parentDocumentLineReferenceID
	 *            the parentDocumentLineReferenceID to set
	 */
	public void setParentDocumentLineReferenceID(String parentDocumentLineReferenceID) {
		ParentDocumentLineReferenceID = parentDocumentLineReferenceID;
	}

	/**
	 * @return the m_AllowanceCharge
	 */
	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	/**
	 * @param m_AllowanceCharge
	 *            the m_AllowanceCharge to set
	 */
	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	/**
	 * @return the m_Delivery
	 */
	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	/**
	 * @param m_Delivery
	 *            the m_Delivery to set
	 */
	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
	}

	/**
	 * @return the m_Period
	 */
	public Period getM_Period() {
		return m_Period;
	}

	/**
	 * @param m_Period
	 *            the m_Period to set
	 */
	public void setM_Period(Period m_Period) {
		this.m_Period = m_Period;
	}

	/**
	 * @return the m_Price
	 */
	public Price getM_Price() {
		return m_Price;
	}

	/**
	 * @param m_Price
	 *            the m_Price to set
	 */
	public void setM_Price(Price m_Price) {
		this.m_Price = m_Price;
	}

	/**
	 * @return the m_TaxTotal
	 */
	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	/**
	 * @param m_TaxTotal
	 *            the m_TaxTotal to set
	 */
	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

	/**
	 * @return the m_UnstructuredPrice
	 */
	public UnstructuredPrice getM_UnstructuredPrice() {
		return m_UnstructuredPrice;
	}

	/**
	 * @param m_UnstructuredPrice
	 *            the m_UnstructuredPrice to set
	 */
	public void setM_UnstructuredPrice(UnstructuredPrice m_UnstructuredPrice) {
		this.m_UnstructuredPrice = m_UnstructuredPrice;
	}

	/**
	 * @return the m_UtilityItem
	 */
	public UtilityItem getM_UtilityItem() {
		return m_UtilityItem;
	}

	/**
	 * @param m_UtilityItem
	 *            the m_UtilityItem to set
	 */
	public void setM_UtilityItem(UtilityItem m_UtilityItem) {
		this.m_UtilityItem = m_UtilityItem;
	}

}// end Consumption Line