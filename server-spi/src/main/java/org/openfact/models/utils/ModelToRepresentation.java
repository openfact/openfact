package org.openfact.models.utils;

import org.openfact.models.*;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.enums.TaxType;
import org.openfact.representations.idm.CustomerRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;

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
        rep.setPostalAddress(organization.getPostalAddress() != null ? toRepresentacion(organization.getPostalAddress()) : null);
        
        if (internal) {
            // TODO Add private information like security cert or another one
        }
        return rep;
    }

    public static PostalAddressRepresentation toRepresentacion(PostalAddressModel postalAddress) {
        PostalAddressRepresentation rep = new PostalAddressRepresentation();
        rep.setId(postalAddress.getId());
        rep.setStreetName(postalAddress.getStreetName());
        rep.setCitySubdivisionName(postalAddress.getCitySubdivisionName());
        rep.setCityName(postalAddress.getCityName());
        rep.setCountrySubentity(postalAddress.getCountrySubentity());
        rep.setDistrict(postalAddress.getDistrict());
        rep.setCountryIdentificationCode(postalAddress.getCountryIdentificationCode());
        return rep;
    }

    public static InvoiceRepresentation toRepresentacion(InvoiceModel invoice) {
        InvoiceRepresentation rep= new InvoiceRepresentation();
        rep.setId(invoice.getId());
        rep.setIssueDate(invoice.getIssueDate());
        rep.setCurrencyCode(invoice.getCurrencyCode());
        rep.setCustomer(toRepresentacion(invoice.getCustomer()));
        rep.setInvoiceSeries(invoice.getInvoiceId().getSeries());
        rep.setInvoiceNumber(invoice.getInvoiceId().getNumber());
        rep.setType(invoice.getInvoiceType() != null ? invoice.getInvoiceType().toString() : null);
        rep.setTotalTaxed(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.GRAVADO) : null);
        rep.setTotalUnaffected(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.INACFECTO) : null);
        rep.setTotalExonerated(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.EXONERADO) : null);
        rep.setTotalByFree(invoice.getAdditionalInformation() != null ? invoice.getAdditionalInformation().get(AdditionalInformationType.GRATUITO) : null);
        rep.setTotalDiscounted(invoice.getTotalLegalMonetary() != null ? invoice.getTotalLegalMonetary().get(MonetaryTotalType.DESCUENTO_TOTAL) : null);
        rep.setTotalAmmount(invoice.getTotalLegalMonetary() !=null? invoice.getTotalLegalMonetary().get(MonetaryTotalType.IMPORTE_TOTAL): null);
        rep.setTotalIgvTax(invoice.getTotalTaxs() !=null? invoice.getTotalTaxs().get(TaxType.IGV):null);
        rep.setTotalIscTax(invoice.getTotalTaxs() !=null? invoice.getTotalTaxs().get(TaxType.ISC):null);
        rep.setTotalOtherTax(invoice.getTotalTaxs()!=null? invoice.getTotalTaxs().get(TaxType.OTROS):null);
        return rep;
    }

    private static CustomerRepresentation toRepresentacion(CustomerModel customer) {
        CustomerRepresentation rep = new CustomerRepresentation();
        rep.setId(customer.getId());
        rep.setAdditionalAccountId(customer.getAdditionalAccountId() != null ? customer.getAdditionalAccountId().toString() : null);
        rep.setAssignedIdentificationId(customer.getAssignedIdentificationId());
        rep.setRegistrationName(customer.getRegistrationName());
        return rep;
    }


}
