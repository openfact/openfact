package org.openfact.models.utils;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

public class RepresentationToModel {

    private static Logger logger = Logger.getLogger(RepresentationToModel.class);

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getName() != null) organization.setName(rep.getName());
    }

    public static void updateInvoice(InvoiceRepresentation rep, InvoiceModel invoice){
//        if (rep.getCustomer() !=null) invoice.setCustomer(rep.getCustomer().);
    }

//    public static Void addInvoice(InvoiceRepresentation rep, OrganizationModel organization,
//                                     InvoiceProvider provider) {
//        CustomerModel customer= null;
//        // provider.createAdquiriente(numeroDocumento);
//        InvoiceIdModel InvoiceId= null;
//
//        InvoiceModel model = provider.addInvoice(organization, customer, InvoiceId,rep.getType(),rep.getCurrencyCode(),rep.getIssueDate());
//        // model.setTipoDocumentoRelacionadoType(type);
//        // model.setInformacionAdicional(informacionAdicional);
//        model.commit();
//        return model;



}
