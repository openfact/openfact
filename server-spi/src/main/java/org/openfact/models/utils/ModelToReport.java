package org.openfact.models.utils;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.representations.idm.report.CreditNoteReport;
import org.openfact.representations.idm.report.DebitNoteReport;
import org.openfact.representations.idm.report.InvoiceReport;
import org.openfact.representations.idm.report.common.CreditNoteLineReport;
import org.openfact.representations.idm.report.common.DebitNoteLineReport;
import org.openfact.representations.idm.report.common.InvoiceLineReport;

public class ModelToReport {

	public static InvoiceReport toReport(InvoiceModel model) {
		InvoiceReport report = new InvoiceReport();
		report.setID(model.getID());
		report.setIssueDate(model.getIssueDateTime());
		report.setCurrencyCode(model.getDocumentCurrencyCode());
		if (model.getAccountingSupplierParty() != null) {
			report.setSupplierAssignedAccountID(model.getAccountingSupplierParty().getCustomerAssignedAccountID());
			if (model.getAccountingSupplierParty().getParty() != null) {
				if (!model.getAccountingSupplierParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setSupplierRegistrationName(model.getAccountingSupplierParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		report.setSupplierAddress(toReport(model.getSellerSupplierParty()));
		if (model.getAccountingCustomerParty() != null) {
			report.setCustomerAssignedAccountID(model.getAccountingCustomerParty().getCustomerAssignedAccountID());
			if (model.getAccountingCustomerParty().getParty() != null) {
				if (!model.getAccountingCustomerParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setCustomerRegistrationName(model.getAccountingCustomerParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		for (InvoiceLineModel line : model.getInvoiceLine()) {
			report.addLine(toReport(line));
		}
		BigDecimal taxTotal = toReport(model.getTaxTotal());
		BigDecimal total = model.getLegalMonetaryTotal().getPayableAmount();
		report.setTaxTotal(taxTotal);
		report.setTotal(total);
		report.setSubTotal(total.subtract(taxTotal));
		return report;
	}

	public static CreditNoteReport toReport(CreditNoteModel model) {
		CreditNoteReport report = new CreditNoteReport();
		report.setID(model.getID());
		report.setIssueDate(model.getIssueDateTime());
		report.setCurrencyCode(model.getDocumentCurrencyCode());
		if (model.getAccountingSupplierParty() != null) {
			report.setSupplierAssignedAccountID(model.getAccountingSupplierParty().getCustomerAssignedAccountID());
			if (model.getAccountingSupplierParty().getParty() != null) {
				if (!model.getAccountingSupplierParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setSupplierRegistrationName(model.getAccountingSupplierParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		report.setSupplierAddress(toReport(model.getAccountingSupplierParty()));
		if (model.getAccountingCustomerParty() != null) {
			report.setCustomerAssignedAccountID(model.getAccountingCustomerParty().getCustomerAssignedAccountID());
			if (model.getAccountingCustomerParty().getParty() != null) {
				if (!model.getAccountingCustomerParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setCustomerRegistrationName(model.getAccountingCustomerParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		for (CreditNoteLineModel line : model.getCreditNoteLine()) {
			report.addLine(toReport(line));
		}
		BigDecimal taxTotal = toReport(model.getTaxTotal());
		BigDecimal total = model.getLegalMonetaryTotal().getPayableAmount();
		report.setTaxTotal(taxTotal);
		report.setTotal(total);
		report.setSubTotal(total.subtract(taxTotal));
		return report;
	}

	public static DebitNoteReport toReport(DebitNoteModel model) {
		DebitNoteReport report = new DebitNoteReport();
		report.setID(model.getID());
		report.setIssueDate(model.getIssueDateTime());
		report.setCurrencyCode(model.getDocumentCurrencyCode());
		if (model.getAccountingSupplierParty() != null) {
			report.setSupplierAssignedAccountID(model.getAccountingSupplierParty().getCustomerAssignedAccountID());
			if (model.getAccountingSupplierParty().getParty() != null) {
				if (!model.getAccountingSupplierParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setSupplierRegistrationName(model.getAccountingSupplierParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		report.setSupplierAddress(toReport(model.getAccountingSupplierParty()));
		if (model.getAccountingCustomerParty() != null) {
			report.setCustomerAssignedAccountID(model.getAccountingCustomerParty().getCustomerAssignedAccountID());
			if (model.getAccountingCustomerParty().getParty() != null) {
				if (!model.getAccountingCustomerParty().getParty().getPartyLegalEntity().isEmpty()) {
					report.setCustomerRegistrationName(model.getAccountingCustomerParty().getParty()
							.getPartyLegalEntity().get(0).getRegistrationName());
				}
			}
		}
		for (DebitNoteLineModel line : model.getDebitNoteLine()) {
			report.addLine(toReport(line));
		}
		BigDecimal taxTotal = toReport(model.getTaxTotal());
		BigDecimal total = model.getRequestedMonetaryTotal().getPayableAmount();
		report.setTaxTotal(taxTotal);
		report.setTotal(total);
		report.setSubTotal(total.subtract(taxTotal));
		return report;
	}

	private static DebitNoteLineReport toReport(DebitNoteLineModel model) {
		DebitNoteLineReport report = new DebitNoteLineReport();
		if (model.getID() != null) {
			report.setSecuence(model.getID());
		}
		if (model.getDebitedQuantity() != null) {
			report.setUnitCode(toReport(model.getDebitedQuantity()));
			report.setQuantity(model.getDebitedQuantity().getValue());
		}
		if (model.getItem() != null) {
			if (!model.getItem().getDescription().isEmpty()) {
				report.setDescription(model.getItem().getDescription().get(0));
			}
		}
		if (model.getPrice() != null) {
			report.setPrice(model.getPrice().getPriceAmount());
		}
		report.setLineAmount(model.getLineExtensionAmount());
		return report;
	}

	private static CreditNoteLineReport toReport(CreditNoteLineModel model) {
		CreditNoteLineReport report = new CreditNoteLineReport();
		if (model.getID() != null) {
			report.setSecuence(model.getID());
		}
		if (model.getCreditedQuantity() != null) {
			report.setUnitCode(toReport(model.getCreditedQuantity()));
			report.setQuantity(model.getCreditedQuantity().getValue());
		}
		if (model.getItem() != null) {
			if (!model.getItem().getDescription().isEmpty()) {
				report.setDescription(model.getItem().getDescription().get(0));
			}
		}
		if (model.getPrice() != null) {
			report.setPrice(model.getPrice().getPriceAmount());
		}
		report.setLineAmount(model.getLineExtensionAmount());
		return report;
	}

	private static BigDecimal toReport(List<TaxTotalModel> list) {
		BigDecimal taxTotal = new BigDecimal("0.00");
		for (TaxTotalModel model : list) {
			taxTotal.add(model.getTaxAmount());
		}
		return taxTotal;
	}

	private static InvoiceLineReport toReport(InvoiceLineModel model) {
		InvoiceLineReport report = new InvoiceLineReport();
		if (model.getID() != null) {
			report.setSecuence(model.getID());
		}
		if (model.getInvoicedQuantity() != null) {
			report.setUnitCode(toReport(model.getInvoicedQuantity()));
			report.setQuantity(model.getInvoicedQuantity().getValue());
		}
		if (model.getItem() != null) {
			if (!model.getItem().getDescription().isEmpty()) {
				report.setDescription(model.getItem().getDescription().get(0));
			}
		}
		if (model.getPrice() != null) {
			report.setPrice(model.getPrice().getPriceAmount());
		}
		report.setLineAmount(model.getLineExtensionAmount());
		return report;
	}

	private static String toReport(QuantityModel model) {
		if (model.getUnitCode() != null) {
			return model.getUnitCode();
		}
		return "";
	}

	private static String toReport(SupplierPartyModel model) {
		if (model.getParty() != null) {
			return toReport(model.getParty());
		}
		return "";
	}

	private static String toReport(PartyModel model) {
		String address = "";
		if (model.getPostalAddress() != null) {
			address = toReport(model.getPostalAddress());
		}
		return address;
	}

	private static String toReport(AddressModel model) {
		String address = "";
		if (model.getStreetName() != null) {
			address = address + model.getStreetName();
		}
		if (model.getCitySubdivisionName() != null) {
			address = address + model.getCitySubdivisionName();
		}
		if (model.getCityName() != null) {
			address = address + model.getCityName();
		}
		if (model.getDistrict() != null) {
			address = address + model.getDistrict();
		}
		if (model.getCountrySubentity() != null) {
			address = address + model.getCountrySubentity();
		}
		return address;
	}

}
