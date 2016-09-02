package org.openfact.models.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openfact.models.CheckableDocumentModel;
import org.openfact.models.CurrencyModel;
import org.openfact.models.CustomerModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.ComposedDocumentModel;
import org.openfact.models.ValuableDocumentModel;
import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceLineTaxTotalModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.CertificateRepresentation;
import org.openfact.representations.idm.CurrencyRepresentation;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.DocumentRepresentation;
import org.openfact.representations.idm.InvoiceAdditionalInformationRepresentation;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceLineTotalTaxRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.InvoiceTaxTotalRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;

public class ModelToRepresentation {

	public static OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
		OrganizationRepresentation rep = new OrganizationRepresentation();
		rep.setId(organization.getId());
		rep.setName(organization.getName());
		rep.setEnabled(organization.isEnabled());

		rep.setAdditionalAccountId(
				organization.getAdditionalAccountId() != null ? organization.getAdditionalAccountId().getName() : null);
		rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
		rep.setRegistrationName(organization.getRegistrationName());
		rep.setSupplierName(organization.getSupplierName());

		PostalAddressRepresentation postalAddressRep = new PostalAddressRepresentation();
		postalAddressRep.setStreetName(organization.getStreetName());
		postalAddressRep.setCitySubdivisionName(organization.getCitySubdivisionName());
		postalAddressRep.setCityName(organization.getCityName());
		postalAddressRep.setCountrySubentity(organization.getCountrySubentity());
		postalAddressRep.setDistrict(organization.getDistrict());
		postalAddressRep.setCountryIdentificationCode(organization.getCountryIdentificationCode());
		rep.setPostalAddress(postalAddressRep);

		rep.setCurrencies(
				organization.getCurrencies().stream().map(f -> toRepresentation(f)).collect(Collectors.toSet()));
		if (internal) {
			TasksScheduleRepresentation tasksSchedulerRep = new TasksScheduleRepresentation();
			tasksSchedulerRep.setAttempNumber(organization.getAttempNumber());
			tasksSchedulerRep.setLapseTime(organization.getLapseTime());
			tasksSchedulerRep.setOnErrorAttempNumber(organization.getOnErrorAttempNumber());
			tasksSchedulerRep.setOnErrorLapseTime(organization.getOnErrorLapseTime());
			tasksSchedulerRep.setDelayTime(organization.getDelayTime());
			tasksSchedulerRep.setSubmitTime(organization.getSubmitTime());
			tasksSchedulerRep.setSubmitDays(organization.getSubmitDays());
			rep.setTasksSchedule(tasksSchedulerRep);

			CertificateRepresentation certificateRep = new CertificateRepresentation();
			certificateRep.setPublicKey(organization.getPublicKeyPem());
			certificateRep.setPrivateKey(organization.getPrivateKeyPem());
			String privateKeyPem = organization.getPrivateKeyPem();
			if (organization.getCertificatePem() == null && privateKeyPem != null) {
				OpenfactModelUtils.generateOrganizationCertificate(organization);
			}
			certificateRep.setCodeSecret(organization.getCodeSecret());
			certificateRep.setCertificate(organization.getCertificatePem());			
			rep.setCertificate(certificateRep);
		}

		return rep;
	}

	public static CurrencyRepresentation toRepresentation(CurrencyModel currency) {
		CurrencyRepresentation rep = new CurrencyRepresentation();
		rep.setId(currency.getId());
		rep.setCode(currency.getCode());
		rep.setPriority(currency.getPriority());
		return rep;
	}

	public static InvoiceRepresentation toRepresentation(InvoiceModel invoice) {
		InvoiceRepresentation rep = new InvoiceRepresentation();
		rep.setId(invoice.getId());
		rep.setIssueDate(invoice.getIssueDate());
		rep.setCurrencyCode(invoice.getCurrencyCode());
		rep.setCustomer(toRepresentation(invoice.getCustomer()));
		rep.setInvoiceSeries(invoice.getSeries());
		rep.setInvoiceNumber(invoice.getNumber());

		rep.setType(invoice.getType().getName());
		rep.setPayableAmount(invoice.getPayableAmount());
		rep.setAllowanceTotalAmount(invoice.getAllowanceTotalAmount());
		rep.setChargeTotalAmount(invoice.getChargeTotalAmount());

		Set<InvoiceAdditionalInformationRepresentation> additionalInformationReps = new HashSet<>();
		for (InvoiceAdditionalInformationModel elem : invoice.getAdditionalInformation()) {
			InvoiceAdditionalInformationRepresentation additionalInformationRep = new InvoiceAdditionalInformationRepresentation();
			additionalInformationRep.setName(elem.getDocument().getName());
			additionalInformationRep.setAmount(elem.getAmmount());

			additionalInformationReps.add(additionalInformationRep);
		}
		rep.setAdditionalInformation(additionalInformationReps);

		Set<InvoiceTaxTotalRepresentation> totalTaxsReps = new HashSet<>();
		for (InvoiceTaxTotalModel elem : invoice.getInvoiceTaxTotal()) {
			InvoiceTaxTotalRepresentation taxsTotalRep = new InvoiceTaxTotalRepresentation();
			taxsTotalRep.setName(elem.getDocument().getName());
			taxsTotalRep.setAmount(elem.getAmount());
			taxsTotalRep.setValue(elem.getValue());

			totalTaxsReps.add(taxsTotalRep);
		}
		rep.setTotalTaxs(totalTaxsReps);

		return rep;
	}

	public static InvoiceLineRepresentation toRepresentation(InvoiceLineModel invoiceLine) {
		InvoiceLineRepresentation rep = new InvoiceLineRepresentation();
		rep.setId(invoiceLine.getId());
		rep.setOrderNumber(invoiceLine.getOrderNumber());
		rep.setQuantity(invoiceLine.getQuantity());
		rep.setUnitCode(invoiceLine.getUnitCode());
		rep.setPrice(invoiceLine.getPrice());
		rep.setAmount(invoiceLine.getAmount());
		rep.setItemDescription(invoiceLine.getItemDescription());
		rep.setItemIdentification(invoiceLine.getItemIdentification());
		rep.setAllowanceCharge(invoiceLine.getAllowanceCharge());

		Set<InvoiceLineTotalTaxRepresentation> totalTaxs = new HashSet<>();
		for (InvoiceLineTaxTotalModel elem : invoiceLine.getTotalTaxs()) {
			InvoiceLineTotalTaxRepresentation totalTax = new InvoiceLineTotalTaxRepresentation();
			totalTax.setAmount(elem.getAmmount());
			totalTax.setDocument(elem.getDocument().getName());
			totalTax.setReason(elem.getReason().getName());

			totalTaxs.add(totalTax);
		}
		rep.setTotalTaxs(totalTaxs);

		return rep;
	}

	private static CustomerRepresentation toRepresentation(CustomerModel customer) {
		CustomerRepresentation rep = new CustomerRepresentation();
		rep.setAdditionalIdentificationId(
				customer.getAdditionalAccountId() != null ? customer.getAdditionalAccountId().getName() : null);
		rep.setAssignedIdentificationId(customer.getAssignedIdentificationId());
		rep.setRegistrationName(customer.getRegistrationName());
		rep.setEmail(customer.getEmail());
		return rep;
	}
	public static DocumentRepresentation toRepresentation(DocumentModel document) {
		DocumentRepresentation rep = new DocumentRepresentation();
		rep.setId(document.getId());
		rep.setType(document.getType().toString());
		rep.setName(document.getName());
		rep.setDescription(document.getDescription());
		rep.setDocumentId(document.getDocumentId());
		rep.setCode(document.getCode());

		if (document instanceof ValuableDocumentModel) {
			ValuableDocumentModel valuable = (ValuableDocumentModel) document;
			rep.setValue(valuable.getValue());
		}
		if (document instanceof CheckableDocumentModel) {
			CheckableDocumentModel checkable = (CheckableDocumentModel) document;
			rep.setChecked(checkable.getChecked());
		}
		if (document instanceof ComposedDocumentModel) {
			ComposedDocumentModel composed = (ComposedDocumentModel) document;
			List<DocumentRepresentation> childrens = composed.getChildrens().stream().map(f -> toRepresentation(f))
					.collect(Collectors.toList());
			rep.setChildrens(childrens);
		}

		return rep;
	}

}
