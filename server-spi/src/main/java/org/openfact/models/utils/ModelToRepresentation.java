package org.openfact.models.utils;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.CertifiedModel;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.enums.TaxType;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setName(organization.getName());
        rep.setEnabled(organization.isEnabled());

        rep.setAdditionalAccountId(organization.getAdditionalAccountId() != null ? organization.getAdditionalAccountId().toString() : null);
        rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
        rep.setRegistrationName(organization.getRegistrationName());
        rep.setSupplierName(organization.getSupplierName());
        rep.setPostalAddress(organization.getPostalAddress() != null ? toRepresentation(organization.getPostalAddress()) : null);        

        if (internal) {
            rep.setTasksSchedule(organization.getTasksSchedule() != null ? toRepresentation(organization.getTasksSchedule()) : null);
        }
        return rep;
    }

    public static PostalAddressRepresentation toRepresentation(PostalAddressModel postalAddress) {
        PostalAddressRepresentation rep = new PostalAddressRepresentation();
        rep.setStreetName(postalAddress.getStreetName());
        rep.setCitySubdivisionName(postalAddress.getCitySubdivisionName());
        rep.setCityName(postalAddress.getCityName());
        rep.setCountrySubentity(postalAddress.getCountrySubentity());
        rep.setDistrict(postalAddress.getDistrict());
        rep.setCountryIdentificationCode(postalAddress.getCountryIdentificationCode());
        return rep;
    }
    
    public static TasksScheduleRepresentation toRepresentation(TasksScheduleModel tasksSchedule) {
        TasksScheduleRepresentation rep = new TasksScheduleRepresentation();
        rep.setAttempNumber(tasksSchedule.getAttempNumber());
        rep.setLapseTime(tasksSchedule.getLapseTime());
        rep.setOnErrorAttempNumber(tasksSchedule.getOnErrorAttempNumber());
        rep.setOnErrorLapseTime(tasksSchedule.getOnErrorLapseTime());
        rep.setDelayTime(tasksSchedule.getDelayTime());
        rep.setSubmitTime(tasksSchedule.getSubmitTime());
        rep.setSubmitDays(tasksSchedule.getSubmitDays());
        return rep;
    }

    public static InvoiceRepresentation toRepresentation(InvoiceModel invoice) {
        InvoiceRepresentation rep = new InvoiceRepresentation();
        rep.setId(invoice.getId());
        rep.setIssueDate(invoice.getIssueDate());
        rep.setCurrencyCode(invoice.getCurrencyCode());
        rep.setCustomer(toRepresentation(invoice.getCustomer()));
        rep.setInvoiceSeries(invoice.getInvoiceId().getSeries());
        rep.setInvoiceNumber(invoice.getInvoiceId().getNumber());
        rep.setType(invoice.getInvoiceType() != null ? invoice.getInvoiceType().getDescription() : null);
        rep.setTotalTaxed(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.GRAVADO) : null);
        rep.setTotalUnaffected(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.INACFECTO) : null);
        rep.setTotalExonerated(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.EXONERADO) : null);
        rep.setTotalByFree(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.GRATUITO) : null);
        rep.setTotalDiscounted(invoice.getTotalLegalMonetary() != null ? invoice.getTotalLegalMonetary().get(MonetaryTotalType.DESCUENTO_TOTAL) : null);
        rep.setTotalAmmount(invoice.getTotalLegalMonetary() != null ? invoice.getTotalLegalMonetary().get(MonetaryTotalType.IMPORTE_TOTAL) : null);
        rep.setTotalIgvTax(invoice.getTotalTaxs() != null ? invoice.getTotalTaxs().get(TaxType.IGV) : null);
        rep.setTotalIscTax(invoice.getTotalTaxs() != null ? invoice.getTotalTaxs().get(TaxType.ISC) : null);
        rep.setTotalOtherTax(invoice.getTotalTaxs() != null ? invoice.getTotalTaxs().get(TaxType.OTROS) : null);
        List<InvoiceLineRepresentation> representationList = new ArrayList<>();
        invoice.getInvoiceLines().forEach(invoiceLineModel -> representationList.add(toRepresentation(invoiceLineModel)));
        rep.setLines(representationList);
        return rep;
    }

    private static InvoiceLineRepresentation toRepresentation(InvoiceLineModel invoiceLine) {
        InvoiceLineRepresentation rep = new InvoiceLineRepresentation();
        rep.setId(invoiceLine.getId());
        rep.setOrderNumber(invoiceLine.getOrderNumber());
        rep.setQuantity(invoiceLine.getQuantity());
        rep.setUnitCode(invoiceLine.getUnitCode());
        rep.setPrice(invoiceLine.getPrice());
        rep.setAmmount(invoiceLine.getAmmount());
        rep.setItemDescription(invoiceLine.getItemDescription());
        rep.setItemIdentification(invoiceLine.getItemIdentification());
        rep.setIgv(invoiceLine.getTaxs().get(TaxType.IGV));
        rep.setIsc(invoiceLine.getTaxs().get(TaxType.ISC));
        rep.setOtherTaxs(invoiceLine.getTaxs().get(TaxType.OTROS));
        rep.setAllowanceCharge(invoiceLine.getAllowanceCharge());
        return rep;
    }

    private static CustomerRepresentation toRepresentation(CustomerModel customer) {
        CustomerRepresentation rep = new CustomerRepresentation();
        rep.setId(customer.getId());
        rep.setAdditionalAccountId(customer.getAdditionalAccountId() != null ? customer.getAdditionalAccountId().getDescription() : null);
        rep.setAssignedIdentificationId(customer.getAssignedIdentificationId());
        rep.setRegistrationName(customer.getRegistrationName());
        rep.setEmail(customer.getEmail());
        return rep;
    }


    public static CertifiedRepresentation toRepresentation(CertifiedModel certified) {
        CertifiedRepresentation rep = new CertifiedRepresentation();
        rep.setId(certified.getId());
        rep.setAlias(certified.getAlias());
        rep.setUrlcertificate(certified.getCertificate());
        rep.setPassword(certified.getPassword());
        rep.setPasswordConfirmation(certified.getPasswordConfirmation());
        rep.setValidity(certified.getValidity());
        return rep;
    }

}
