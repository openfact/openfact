package org.openfact.models.utils;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.AdditionalAccountType;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;

public class RepresentationToModel {

    private static Logger logger = Logger.getLogger(RepresentationToModel.class);

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getName() != null) {
            organization.setName(rep.getName());
        }
        if (rep.getAssignedIdentificationId() != null) {
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            organization.setAdditionalAccountId(AdditionalAccountType.valueOf(rep.getAdditionalAccountId()));
        }
        if (rep.getSupplierName() != null) {
            organization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            organization.setRegistrationName(rep.getRegistrationName());
        }
        if (rep.isEnabled() != null) {
            organization.setEnabled(rep.isEnabled());
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
    }

    public static void updateInvoice(InvoiceRepresentation rep, InvoiceModel invoice) {
        logger.info("Trying to delte invoice " + invoice.getId() + " from organization " + invoice.getOrganization().getId());
        throw new ModelReadOnlyException("An invoice can not be updated, try to delete it");
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
