package org.openfact.representations.idm.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.report.common.CreditNoteLineReport;
import org.openfact.representations.idm.report.common.InvoiceLineReport;

public class CreditNoteReport {

	private String ID;
	private LocalDateTime issueDate;
	private String currencyCode;
	private String supplierAssignedAccountID;
	private String supplierRegistrationName;
	private String supplierAddress;
	private String customerAssignedAccountID;
	private String customerRegistrationName;
	private BigDecimal subTotal;
	private BigDecimal taxTotal;
	private BigDecimal Total;
	private List<CreditNoteLineReport> creditNoteLine;

	public void addLine(CreditNoteLineReport report) {
		if (creditNoteLine == null) {
			creditNoteLine = new ArrayList<>();
		}
		creditNoteLine.add(report);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSupplierAssignedAccountID() {
		return supplierAssignedAccountID;
	}

	public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
		this.supplierAssignedAccountID = supplierAssignedAccountID;
	}

	public String getSupplierRegistrationName() {
		return supplierRegistrationName;
	}

	public void setSupplierRegistrationName(String supplierRegistrationName) {
		this.supplierRegistrationName = supplierRegistrationName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getCustomerAssignedAccountID() {
		return customerAssignedAccountID;
	}

	public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
		this.customerAssignedAccountID = customerAssignedAccountID;
	}

	public String getCustomerRegistrationName() {
		return customerRegistrationName;
	}

	public void setCustomerRegistrationName(String customerRegistrationName) {
		this.customerRegistrationName = customerRegistrationName;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(BigDecimal taxTotal) {
		this.taxTotal = taxTotal;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
		Total = total;
	}

	public List<CreditNoteLineReport> getCreditNoteLine() {
		return creditNoteLine;
	}

	public void setCreditNoteLine(List<CreditNoteLineReport> creditNoteLine) {
		this.creditNoteLine = creditNoteLine;
	}

}
