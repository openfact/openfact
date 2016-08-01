package org.openfact.models.utils;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.AdditionalAccountType;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

public class RepresentationToModel {

    private static Logger logger = Logger.getLogger(RepresentationToModel.class);

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getName() != null)
            organization.setName(rep.getName());
        if (rep.getAssignedIdentificationId() != null)
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        if (rep.getAdditionalAccountId() != null)
            organization.setAdditionalAccountId(AdditionalAccountType.valueOf(rep.getAdditionalAccountId()));
        if (rep.getSupplierName() != null)
            organization.setSupplierName(rep.getSupplierName());
        if (rep.getRegistrationName() != null)
            organization.setRegistrationName(rep.getRegistrationName());
    }

    public static void updateInvoice(InvoiceRepresentation rep, InvoiceModel invoice) {               
        logger.info("Trying to delte invoice " + invoice.getId() + " from organization " + invoice.getOrganization().getId());
        throw new ModelReadOnlyException("An invoice can not be updated, try to delete it");
    }

}
