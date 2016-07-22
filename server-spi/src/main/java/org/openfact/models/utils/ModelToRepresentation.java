package org.openfact.models.utils;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PostalAddressModel;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization,
            boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setName(organization.getName());
        rep.setEnabled(organization.isEnabled());
        rep.setAdditionalAccountId(organization.getAdditionalAccountId().toString());
        rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
        rep.setRegistrationName(organization.getRegistrationName());
        rep.setSupplierName(organization.getSupplierName());
        rep.setPostalAddress(toRepresentacion(organization.getPostalAddress()));
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

    public static InvoiceRepresentation toRepresentacion(InvoiceModel f) {
        // TODO Auto-generated method stub
        return null;
    }

}
