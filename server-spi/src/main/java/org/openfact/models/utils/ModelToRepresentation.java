package org.openfact.models.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.CertifiedModel;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceLineTaxTotalModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.DocumentModel;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.representations.idm.CurrencyRepresentation;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceLineTotalTaxRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;
import org.openfact.representations.idm.DocumentRepresentation;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setName(organization.getName());
        rep.setEnabled(organization.isEnabled());

        rep.setAdditionalAccountId(organization.getAdditionalAccountId() != null ? organization.getAdditionalAccountId().getName() : null);
        rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
        rep.setRegistrationName(organization.getRegistrationName());
        rep.setSupplierName(organization.getSupplierName());
        rep.setPostalAddress(organization.getPostalAddress() != null ? toRepresentation(organization.getPostalAddress()) : null);
        rep.setCurrencies(organization.getCurrencies().stream().map(f -> {
            CurrencyRepresentation rep1 = new CurrencyRepresentation();
            rep1.setId(f.getId());
            rep1.setCode(f.getCode());
            rep1.setPriority(f.getPriority());
            return rep1;
        }).collect(Collectors.toSet()));

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
        
        rep.setType(invoice.getType().getName());
        rep.setPayableAmount(invoice.getPayableAmount());
        rep.setAllowanceTotalAmount(invoice.getAllowanceTotalAmount());
        rep.setChargeTotalAmount(invoice.getChargeTotalAmount());
        
        Map<String, BigDecimal> additionalInformationRep = new HashMap<>();
        for (InvoiceAdditionalInformationModel elem : invoice.getAdditionalInformation()) {            
            additionalInformationRep.put(elem.getDocument().getName(), elem.getAmmount());            
        }
        rep.setAdditionalInformation(additionalInformationRep);
        
        Map<String, BigDecimal> totalTaxsRep = new HashMap<>();
        for (InvoiceTaxTotalModel elem : invoice.getInvoiceTaxTotal()) {            
            totalTaxsRep.put(elem.getDocument().getName(), elem.getAmmount());            
        }
        rep.setTotalTaxs(totalTaxsRep);
                          
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
        rep.setAllowanceCharge(invoiceLine.getAllowanceCharge());
        
        Set<InvoiceLineTotalTaxRepresentation> totalTaxs = new HashSet<>();
        for (InvoiceLineTaxTotalModel elem : invoiceLine.getTotalTaxs()) {           
            InvoiceLineTotalTaxRepresentation totalTax = new InvoiceLineTotalTaxRepresentation();
            totalTax.setAmmount(elem.getAmmount());
            totalTax.setDocument(elem.getDocument().getName());
            totalTax.setReason(elem.getReason().getName());
        }
        rep.setTotalTaxs(totalTaxs);
        
        return rep;
    }

    private static CustomerRepresentation toRepresentation(CustomerModel customer) {
        CustomerRepresentation rep = new CustomerRepresentation();
        rep.setId(customer.getId());
        rep.setAdditionalIdentificationId(customer.getAdditionalAccountId() != null ? customer.getAdditionalAccountId().getName(): null);
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

    public static DocumentRepresentation toRepresentation(DocumentModel document) {
        DocumentRepresentation rep = new DocumentRepresentation();
        rep.setId(document.getId());
        rep.setType(document.getType().toString());
        rep.setName(document.getName());
        rep.setDescription(document.getDescription());
        rep.setDocumentId(document.getDocumentId());
        rep.setCode(document.getCode());
        rep.setValue(document.getValue());
        return rep;
    }

}
