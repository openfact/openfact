package org.openfact.models.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.openfact.models.CertifiedModel;
import org.openfact.models.CurrencyModel;
import org.openfact.models.CustomerModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.enums.DocumentType;
import org.openfact.representations.idm.CertifiedRepresentation;
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

public class RepresentationToModel {

    private static Logger logger = Logger.getLogger(RepresentationToModel.class);

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getName() != null) {
            organization.setName(rep.getName());
        }
        if (rep.getDescription() != null) {
            organization.setDescription(rep.getDescription());
        }
        if (rep.getAssignedIdentificationId() != null) {
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null && !rep.getAdditionalAccountId().isEmpty()) {
            DocumentModel additionalAccount = organization
                    .getDocuments(DocumentType.ADDITIONAL_IDENTIFICATION_ID).stream()
                    .filter(f -> f.getName().equals(rep.getAdditionalAccountId())).findAny()
                    .get();
            
            organization.setAdditionalAccountId(additionalAccount);
        }
        if (rep.getSupplierName() != null) {
            organization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            organization.setRegistrationName(rep.getRegistrationName());
        }
        if (rep.getEnabled() != null) {
            organization.setEnabled(rep.getEnabled());
        }
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            PostalAddressModel postalAddress = organization.getPostalAddress();
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                postalAddress.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                postalAddress.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                postalAddress.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                postalAddress.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                postalAddress.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                postalAddress.setStreetName(postalAddressRep.getStreetName());
            }
        }
        if (rep.getTasksSchedule() != null) {
            TasksScheduleRepresentation tasksScheduleRep = rep.getTasksSchedule();
            TasksScheduleModel tasksSchedule = organization.getTasksSchedule();
            if (tasksScheduleRep.getAttempNumber() != null) {
                tasksSchedule.setAttempNumber(tasksScheduleRep.getAttempNumber());
            }
            if (tasksScheduleRep.getLapseTime() != null) {
                tasksSchedule.setLapseTime(tasksScheduleRep.getLapseTime());
            }
            if (tasksScheduleRep.getOnErrorAttempNumber() != null) {
                tasksSchedule.setOnErrorAttempNumber(tasksScheduleRep.getOnErrorAttempNumber());
            }
            if (tasksScheduleRep.getOnErrorLapseTime() != null) {
                tasksSchedule.setOnErrorLapseTime(tasksScheduleRep.getOnErrorLapseTime());
            }
            if (tasksScheduleRep.getDelayTime() != null) {
                tasksSchedule.setDelayTime(tasksScheduleRep.getDelayTime());
            }
            if (tasksScheduleRep.getSubmitTime() != null) {
                tasksSchedule.setSubmitTime(tasksScheduleRep.getSubmitTime());
            }
            if (tasksScheduleRep.getSubmitDays() != null) {
                tasksSchedule.setSubmitDays(tasksScheduleRep.getSubmitDays());
            }
        }
        if(rep.getCurrencies() != null && !rep.getCurrencies().isEmpty()) {
            Set<CurrencyModel> actualCurrencties = organization.getCurrencies();
            rep.getCurrencies().stream().forEach(f -> organization.addCurrency(f.getCode(), f.getPriority()));
            actualCurrencties.stream().forEach(f -> organization.removeCurrency(f));
        }
    }
    
    public static DocumentModel createDocument(OpenfactSession session, OrganizationModel organization, DocumentRepresentation rep) { 
        DocumentModel document = organization.addDocument(DocumentType.valueOf(rep.getType()), rep.getName(), rep.getDocumentId());        
        document.setDescription(rep.getDescription());
        return document;
    }
    
    public static void updateDocument(DocumentRepresentation rep, DocumentModel taxType) {
        if (rep.getName() != null){
            taxType.setName(rep.getName());
        }
        if (rep.getDocumentId() != null){
            taxType.setDocumentId(rep.getDocumentId());
        }
    }

    public static void updateInvoice(InvoiceRepresentation rep, InvoiceModel invoice) {
        logger.info("Updating invoice data from representation. " + invoice.getId() + " from organization " + invoice.getOrganization().getId());
        
        if (rep.getType() != null) {
            DocumentModel type = invoice.getOrganization()
                    .getDocuments(DocumentType.INVOICE_TYPE).stream()
                    .filter(f -> f.getName().equals(rep.getType())).findAny()
                    .get();             
            invoice.setType(type.getName(), type.getDocumentId());
        }
        
        if (rep.getCurrencyCode() != null) {
            invoice.setCurrencyCode(rep.getCurrencyCode());
        }
        
        if (rep.getIssueDate() != null) {
            invoice.setIssueDate(rep.getIssueDate());
        } else {
            invoice.setIssueDate(LocalDate.now());
        }
        
        if (rep.getAllowanceTotalAmount() != null) {
            invoice.setAllowanceTotalAmount(rep.getAllowanceTotalAmount());
        }
        if (rep.getChargeTotalAmount() != null) {
            invoice.setChargeTotalAmount(rep.getChargeTotalAmount());
        }
        if (rep.getPayableAmount() != null) {
            invoice.setPayableAmount(rep.getPayableAmount());
        }
        
        if(rep.getCustomer() != null) {            
            CustomerRepresentation customerRep = rep.getCustomer();
            CustomerModel customer = invoice.setCustomer(customerRep.getRegistrationName());
            
            DocumentModel additionalIdentificationId = invoice.getOrganization()
                    .getDocuments(DocumentType.ADDITIONAL_IDENTIFICATION_ID).stream()
                    .filter(f -> f.getName().equals(customerRep.getAdditionalIdentificationId())).findAny()
                    .get();
            
            customer.setAdditionalAccountId(additionalIdentificationId.getName(), additionalIdentificationId.getDocumentId());
            customer.setAssignedIdentificationId(customerRep.getAssignedIdentificationId());
            customer.setEmail(customerRep.getEmail());
        }       
        
        if(rep.getAdditionalInformation() != null && !rep.getAdditionalInformation().isEmpty()) {
            for (InvoiceAdditionalInformationRepresentation additionalInformationRep : rep.getAdditionalInformation()) {
                DocumentModel document = invoice.getOrganization()
                        .getDocuments(DocumentType.ADDITIONAL_INFORMATION).stream()
                        .filter(f -> f.getName().equals(additionalInformationRep.getName())).findAny()
                        .get();
                invoice.addAdditionalInformation(document.getName(), document.getDocumentId(), additionalInformationRep.getAmount());                
            }
        }
        if(rep.getTotalTaxs() != null && !rep.getTotalTaxs().isEmpty()) {
            for (InvoiceTaxTotalRepresentation totalTaxRep : rep.getTotalTaxs()) {
                DocumentModel document = invoice.getOrganization()
                        .getDocuments(DocumentType.TOTAL_TAX).stream()
                        .filter(f -> f.getName().equals(totalTaxRep.getName())).findAny()
                        .get();
                
                InvoiceTaxTotalModel totalTaxModel = invoice.addTaxTotal(document.getName(), document.getDocumentId(), totalTaxRep.getAmount());
                if(totalTaxRep.getValue() != null) {
                    totalTaxModel.setValue(totalTaxRep.getValue());    
                }                
            }
        }
        
        updateInvoiceLine(rep.getLines(), invoice);
    }

    public static void updateInvoiceLine(List<InvoiceLineRepresentation> invoiceLines, InvoiceModel invoice) {
        // Remove previous lines
        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLines()) {
            invoice.removeInvoiceLine(invoiceLine);
        }
        
        // Add new lines
        for (int i = 0; i < invoiceLines.size(); i++) {
            InvoiceLineRepresentation invoiceLineRep = invoiceLines.get(i);
            
            InvoiceLineModel invoiceLine = invoice.addInvoiceLine();
            invoiceLine.setAllowanceCharge(invoiceLineRep.getAllowanceCharge());
            invoiceLine.setAmmount(invoiceLineRep.getAmount());
            invoiceLine.setItemDescription(invoiceLineRep.getItemDescription());
            invoiceLine.setItemIdentification(invoiceLineRep.getItemIdentification());    
            invoiceLine.setOrderNumber(invoiceLineRep.getOrderNumber() != null ? invoiceLineRep.getOrderNumber() : i + 1);
            invoiceLine.setPrice(invoiceLineRep.getPrice());
            invoiceLine.setQuantity(invoiceLineRep.getQuantity());
            invoiceLine.setUnitCode(invoiceLineRep.getUnitCode());
            
            for (InvoiceLineTotalTaxRepresentation invoiceLineTotalTaxRep : invoiceLineRep.getTotalTaxs()) {
                DocumentModel document = invoice.getOrganization()
                        .getDocuments(DocumentType.TOTAL_TAX).stream()
                        .filter(f -> f.getName().equals(invoiceLineTotalTaxRep.getDocument())).findAny()
                        .get();
                DocumentModel reason = invoice.getOrganization()
                        .getDocuments(DocumentType.TAX_REASON).stream()
                        .filter(f -> f.getName().equals(invoiceLineTotalTaxRep.getReason())).findAny()
                        .get();
                
                invoiceLine.addTotalTax(document.getName(), document.getDocumentId(), reason.getName(), reason.getDocumentId(), invoiceLineTotalTaxRep.getAmount());
            }
            
            logger.debug("Invoice line created with id " + invoiceLine.getId());
        }
    }

    public static void updateCertified(CertifiedRepresentation rep, CertifiedModel certified) {
        if (rep.getAlias()!=null){
            certified.setAlias(rep.getAlias());
        }
        if(rep.getPassword()!=null){
            certified.setPassword(rep.getPassword());
        }
    }    
          
}
