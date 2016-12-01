/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.representations.idm.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.report.common.InvoiceLineReport;

public class InvoiceReport {
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
	private List<InvoiceLineReport> invoiceLine;

	public void addLine(InvoiceLineReport report) {
		if (invoiceLine == null) {
			invoiceLine = new ArrayList<>();
		}
		invoiceLine.add(report);
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

	public List<InvoiceLineReport> getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(List<InvoiceLineReport> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

}
