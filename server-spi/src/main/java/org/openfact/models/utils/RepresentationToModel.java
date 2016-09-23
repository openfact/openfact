package org.openfact.models.utils;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.AddressRepresentation;
import org.openfact.representations.idm.ubl.common.AllowanceChargeRepresentation;
import org.openfact.representations.idm.ubl.common.BillingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.CountryRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.DocumentReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.common.ItemIdentificationRepresentation;
import org.openfact.representations.idm.ubl.common.ItemRepresentation;
import org.openfact.representations.idm.ubl.common.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.common.PartyLegalEntityRepresentation;
import org.openfact.representations.idm.ubl.common.PartyRepresentation;
import org.openfact.representations.idm.ubl.common.PriceRepresentation;
import org.openfact.representations.idm.ubl.common.PricingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.QuantityRepresentation;
import org.openfact.representations.idm.ubl.common.ResponseRepresentation;
import org.openfact.representations.idm.ubl.common.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.common.TaxCategoryRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSchemeRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSubtotalRepresentation;
import org.openfact.representations.idm.ubl.common.TaxTotalRepresentation;

public class RepresentationToModel {

    public static void importOrganization(OpenfactSession session, OrganizationRepresentation rep, OrganizationModel newOrganization) {
        newOrganization.setName(rep.getOrganization());

        /**
         * General information
         */
        if (rep.getDescription() != null) {
            newOrganization.setDescription(rep.getDescription());
        }
        if (rep.getAdditionalAccountId() != null) {           
            newOrganization.setAdditionalAccountId(rep.getAdditionalAccountId());
        }
        if (rep.getAssignedIdentificationId() != null) {
            newOrganization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getSupplierName() != null) {
            newOrganization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            newOrganization.setRegistrationName(rep.getRegistrationName());
        }
        if (rep.getEnabled() != null) {
            newOrganization.setEnabled(rep.getEnabled());
        }

        /**
         * Certificate
         */
        if (rep.getPrivateKey() == null || rep.getPublicKey() == null) {
            OpenfactModelUtils.generateOrganizationKeys(newOrganization);
        } else {
            newOrganization.setPrivateKeyPem(rep.getPrivateKey());
            newOrganization.setPublicKeyPem(rep.getPublicKey());
        }
        if (rep.getCertificate() == null) {
            OpenfactModelUtils.generateOrganizationCertificate(newOrganization);
        } else {
            newOrganization.setCertificatePem(rep.getCertificate());
        }

        if (rep.getCodeSecret() == null) {
            newOrganization.setCodeSecret(OpenfactModelUtils.generateCodeSecret());
        } else {
            newOrganization.setCodeSecret(rep.getCodeSecret());
        }

        /**
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                newOrganization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                newOrganization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                newOrganization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                newOrganization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                newOrganization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                newOrganization.setStreetName(postalAddressRep.getStreetName());
            }
        }

        /**
         * Tasks schedule
         */
        if (rep.getTasksSchedule() != null) {
            TasksScheduleRepresentation tasksScheduleRep = rep.getTasksSchedule();
            if (tasksScheduleRep.getAttempNumber() != null) {
                newOrganization.setAttempNumber(tasksScheduleRep.getAttempNumber());
            } else {
                newOrganization.setAttempNumber(5);
            }
            if (tasksScheduleRep.getLapseTime() != null) {
                newOrganization.setLapseTime(tasksScheduleRep.getLapseTime());
            } else {
                newOrganization.setAttempNumber(5);
            }
            if (tasksScheduleRep.getOnErrorAttempNumber() != null) {
                newOrganization.setOnErrorAttempNumber(tasksScheduleRep.getOnErrorAttempNumber());
            } else {
                newOrganization.setOnErrorAttempNumber(2);
            }
            if (tasksScheduleRep.getOnErrorLapseTime() != null) {
                newOrganization.setOnErrorLapseTime(tasksScheduleRep.getOnErrorLapseTime());
            } else {
                newOrganization.setOnErrorLapseTime(5);
            }
            if (tasksScheduleRep.getDelayTime() != null) {
                newOrganization.setDelayTime(tasksScheduleRep.getDelayTime());
            } else {
                newOrganization.setDelayTime(0);
            }
            if (tasksScheduleRep.getSubmitTime() != null) {
                newOrganization.setSubmitTime(tasksScheduleRep.getSubmitTime());
            } else {
                newOrganization.setSubmitTime(LocalTime.MIDNIGHT);
            }
            if (tasksScheduleRep.getSubmitDays() != null) {
                newOrganization.setSubmitDays(tasksScheduleRep.getSubmitDays());
            } else {
                newOrganization.setSubmitDays(new HashSet<DayOfWeek>(Arrays.asList(DayOfWeek.values())));
            }
        }

        /**
         * Currencies
         */
        if (rep.getCurrencies() != null && !rep.getCurrencies().isEmpty()) {
            rep.getCurrencies().stream().forEach(f -> newOrganization.addCurrency(f.getCode(), f.getPriority()));
        } else {
            Currency currency = Currency.getInstance(Locale.getDefault());
            newOrganization.addCurrency(currency.getCurrencyCode());
        }

        /**
         * Smtp server
         */
        if (rep.getSmtpServer() != null) {
            newOrganization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
        }        
        
        // create invoices and their lines
        if (rep.getInvoices() != null) {
            for (InvoiceRepresentation invoiceRep : rep.getInvoices()) {
                createInvoice(session, newOrganization, invoiceRep);
            }
        }
        
        // create debit notes and their lines
        if (rep.getDebitNotes() != null) {
            for (DebitNoteRepresentation debitNoteRep : rep.getDebitNotes()) {
                createDebitNote(session, newOrganization, debitNoteRep);
            }
        }
        
        // create debit notes and their lines
        if (rep.getCreditNotes() != null) {
            for (CreditNoteRepresentation creditNoteRep : rep.getCreditNotes()) {
                createCreditNote(session, newOrganization, creditNoteRep);
            }
        }
    }
    
    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization) {
        if (rep.getOrganization() != null) {
            organization.setName(rep.getOrganization());
        }
        if (rep.getDescription() != null) {
            organization.setDescription(rep.getDescription());
        }
        if (rep.getAssignedIdentificationId() != null) {
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            organization.setAdditionalAccountId(rep.getAdditionalAccountId());
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
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                organization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                organization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                organization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                organization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                organization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                organization.setStreetName(postalAddressRep.getStreetName());
            }
        }
        if (rep.getTasksSchedule() != null) {
            TasksScheduleRepresentation tasksScheduleRep = rep.getTasksSchedule();
            if (tasksScheduleRep.getAttempNumber() != null) {
                organization.setAttempNumber(tasksScheduleRep.getAttempNumber());
            }
            if (tasksScheduleRep.getLapseTime() != null) {
                organization.setLapseTime(tasksScheduleRep.getLapseTime());
            }
            if (tasksScheduleRep.getOnErrorAttempNumber() != null) {
                organization.setOnErrorAttempNumber(tasksScheduleRep.getOnErrorAttempNumber());
            }
            if (tasksScheduleRep.getOnErrorLapseTime() != null) {
                organization.setOnErrorLapseTime(tasksScheduleRep.getOnErrorLapseTime());
            }
            if (tasksScheduleRep.getDelayTime() != null) {
                organization.setDelayTime(tasksScheduleRep.getDelayTime());
            }
            if (tasksScheduleRep.getSubmitTime() != null) {
                organization.setSubmitTime(tasksScheduleRep.getSubmitTime());
            }
            if (tasksScheduleRep.getSubmitDays() != null) {
                organization.setSubmitDays(tasksScheduleRep.getSubmitDays());
            }
        }
        if (rep.getCurrencies() != null && !rep.getCurrencies().isEmpty()) {
            Set<CurrencyModel> actualCurrencties = organization.getCurrencies();
            rep.getCurrencies().stream().forEach(f -> organization.addCurrency(f.getCode(), f.getPriority()));
            actualCurrencties.stream().forEach(f -> organization.removeCurrency(f.getCode()));
        }

        if (rep.getSmtpServer() != null) {
            organization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
        }
    }
    
    public static InvoiceModel createInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceRepresentation rep) {

        InvoiceModel model = session.invoices().addInvoice(organization);

        if (rep.getIssueDate() != null) {
            model.setIssueDate(rep.getIssueDate());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getInvoiceCodeRepresentation() != null) {
            model.setInvoiceCodeModel(rep.getInvoiceCodeRepresentation());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
        }
        if (rep.getInvoiceLine() != null) {
            for (InvoiceLineRepresentation item : rep.getInvoiceLine()) {
                updateModel(model.addInvoiceLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());

        return model;
    }

    public static void createCreditNote(OpenfactSession session, OrganizationModel organization, CreditNoteRepresentation rep) {
        
        CreditNoteModel model = session.creditNotes().addCreditNote(organization);
        
        if (rep.getIssueDate() != null) {
            model.setIssueDate(rep.getIssueDate());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getCreditNoteLine() != null) {
            for (CreditNoteLineRepresentation item : rep.getCreditNoteLine()) {
                updateModel(model.addCreditNoteLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }

        if (rep.getLegalMonetaryTotal() != null) {
            updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }

        if (rep.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
        }
        if (rep.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
    }

    public static void createDebitNote(OpenfactSession session, OrganizationModel organization, DebitNoteRepresentation rep) {
        
        DebitNoteModel model = session.debitNotes().addDebitNote(organization);
        
        if (rep.getIssueDate() != null) {
            model.setIssueDate(rep.getIssueDate());
        }
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
                updateModel(model.addDiscrepancyResponse(), item);
            }
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAccountingCustomerParty() != null) {
            updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
        }
        if (rep.getDebitNoteLine() != null) {
            for (DebitNoteLineRepresentation item : rep.getDebitNoteLine()) {
                updateModel(model.addDebitNoteLine(), item);
            }
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getRequestedMonetaryTotal() != null) {
            updateModel(model.getRequestedMonetaryTotal(), rep.getRequestedMonetaryTotal());
        }
        if (rep.getDocumentCurrencyCode() != null) {
            model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
        }
        if (rep.getBillingReference() != null) {
            for (BillingReferenceRepresentation item : rep.getBillingReference()) {
                updateModel(model.addBillingReference(), item);
            }
        }
        if (rep.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
                updateModel(model.addDespatchDocumentReference(), item);
            }
        }
    }

    public static void updateModel(InvoiceLineModel model, InvoiceLineRepresentation rep) {
        if (rep.getInvoicedQuantity() != null) {
            updateModel(model.getInvoicedQuantity(), rep.getInvoicedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
        if (rep.getLineExtensionAmount() != null) {
            model.setLineExtensionAmount(rep.getLineExtensionAmount());
        }
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getAllowanceCharge() != null) {
            for (AllowanceChargeRepresentation item : rep.getAllowanceCharge()) {
                updateModel(model.addAllowanceCharge(), item);
            }
        }
    }

    public static void updateModel(CreditNoteLineModel model, CreditNoteLineRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getCreditedQuantity() != null) {
            updateModel(model.getCreditedQuantity(), rep.getCreditedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
    }

    public static void updateModel(DebitNoteLineModel model, DebitNoteLineRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getDebitedQuantity() != null) {
            updateModel(model.getDebitedQuantity(), rep.getDebitedQuantity());
        }
        if (rep.getItem() != null) {
            updateModel(model.getItem(), rep.getItem());
        }
        if (rep.getPrice() != null) {
            updateModel(model.getPrice(), rep.getPrice());
        }
        if (rep.getPricingReference() != null) {
            updateModel(model.getPricingReference(), rep.getPricingReference());
        }
        if (rep.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : rep.getTaxTotal()) {
                updateModel(model.addTaxTotal(), item);
            }
        }
    }

    public static void updateModel(BillingReferenceModel model, BillingReferenceRepresentation rep) {
        if (rep.getInvoiceDocumentReference() != null) {
            updateModel(model.getInvoiceDocumentReference(), rep.getInvoiceDocumentReference());
        }
    }

    public static void updateModel(DocumentReferenceModel model, DocumentReferenceRepresentation rep) {
        if (rep.getDocumentCodeRepresentation() != null) {
            model.setDocumentCode(rep.getDocumentCodeRepresentation());
        }
    }

    public static void updateModel(ResponseModel model, ResponseRepresentation rep) {
        if (rep.getReferenceID() != null) {
            model.setReferenceID(rep.getReferenceID());
        }
        if (rep.getReferenceID() != null) {
            model.setReferenceID(rep.getReferenceID());
        }
        if (rep.getDescription() != null) {
            for (String item : rep.getDescription()) {
                model.getDescription().add(item);
            }
        }
    }

    public static void updateModel(MonetaryTotalModel model, MonetaryTotalRepresentation rep) {
        if (rep.getChargeTotalAmount() != null) {
            model.setChargeTotalAmount(rep.getChargeTotalAmount());
        }
        if (rep.getPayableAmount() != null) {
            model.setPayableAmount(rep.getPayableAmount());
        }
        if (rep.getAllowanceTotalAmount() != null) {
            model.setAllowanceTotalAmount(rep.getAllowanceTotalAmount());
        }
    }

    public static void updateModel(AllowanceChargeModel model, AllowanceChargeRepresentation rep) {
        if (rep.getAmount() != null) {
            model.setAmount(rep.getAmount());
        }
        if (rep.getChargeIndicator() != null) {
            model.setChargeIndicator(rep.getChargeIndicator());
        }
    }

    public static void updateModel(PricingReferenceModel model, PricingReferenceRepresentation rep) {
        if (rep.getAlternativeConditionPrice() != null) {
            for (PriceRepresentation item : rep.getAlternativeConditionPrice()) {
                updateModel(model.addAlternativeConditionPrice(), item);
            }
        }
    }

    public static void updateModel(PriceModel model, PriceRepresentation rep) {
        if (rep.getPriceAmount() != null) {
            model.setPriceAmount(rep.getPriceAmount());
        }
    }

    public static void updateModel(ItemModel model, ItemRepresentation rep) {
        if (rep.getDescription() != null) {
            for (String item : model.getDescription()) {
                model.getDescription().add(item);
            }
        }
        if (rep.getSellersItemIdentification() != null) {
            updateModel(model.getSellersItemIdentification(), rep.getSellersItemIdentification());
        }
    }

    public static void updateModel(ItemIdentificationModel model, ItemIdentificationRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
    }

    public static void updateModel(TaxTotalModel model, TaxTotalRepresentation rep) {
        if (rep.getTaxAmount() != null) {
            model.setTaxAmount(rep.getTaxAmount());
        }
        if (rep.getTaxSubtotal() != null) {
            for (TaxSubtotalRepresentation item : rep.getTaxSubtotal()) {
                updateModel(model.addTaxSubtotal(), item);
            }
        }
    }

    public static void updateModel(TaxSubtotalModel model, TaxSubtotalRepresentation rep) {
        if (rep.getTaxAmount() != null) {
            model.setTaxAmount(rep.getTaxAmount());
        }
        if (rep.getTaxCategory() != null) {
            updateModel(model.getTaxCategory(), rep.getTaxCategory());
        }
    }

    public static void updateModel(TaxCategoryModel model, TaxCategoryRepresentation rep) {
        if (rep.getTaxExemptionReasonCode() != null) {
            model.setTaxExemptionReasonCode(rep.getTaxExemptionReasonCode());
        }
        if (rep.getTaxScheme() != null) {
            updateModel(model.getTaxScheme(), rep.getTaxScheme());
        }
        if (rep.getTierRange() != null) {
            model.setTierRange(rep.getTierRange());
        }
    }

    public static void updateModel(TaxSchemeModel model, TaxSchemeRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getName() != null) {
            model.setName(rep.getName());
        }
        if (rep.getTaxCodeRepresentation() != null) {
            model.setTaxCode(rep.getTaxCodeRepresentation());
        }
    }

    public static void updateModel(CustomerPartyModel model, CustomerPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            for (String item : model.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item);
            }
        }
        if (rep.getParty() != null) {
            updateModel(model.getParty(), rep.getParty());
        }
    }

    public static void updateModel(SupplierPartyModel model, SupplierPartyRepresentation rep) {
        if (rep.getParty() != null) {
            updateModel(model.getParty(), rep.getParty());
        }
        if (rep.getCustomerAssignedAccountID() != null) {
            model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            for (String item : model.getAdditionalAccountID()) {
                model.getAdditionalAccountID().add(item);
            }
        }
    }

    public static void updateModel(PartyModel model, PartyRepresentation rep) {
        if (rep.getPartyLegalEntity() != null) {
            for (PartyLegalEntityRepresentation item : rep.getPartyLegalEntity()) {
                updateModel(model.addPartyLegalEntity(), item);
            }
        }
        if (rep.getPartyName() != null) {
            for (String item : model.getPartyName()) {
                model.getPartyName().add(item);
            }
        }
        if (rep.getPostalAddress() != null) {
            updateModel(model.getPostalAddress(), rep.getPostalAddress());
        }
    }

    public static void updateModel(PartyLegalModel model, PartyLegalEntityRepresentation rep) {
        if (rep.getRegistrationName() != null) {
            model.setRegistrationName(model.getRegistrationName());
        }
    }

    public static void updateModel(AddressModel model, AddressRepresentation rep) {
        if (rep.getIdUbl() != null) {
            model.setID(rep.getIdUbl());
        }
        if (rep.getStreetName() != null) {
            model.setStreetName(rep.getStreetName());
        }
        if (rep.getCitySubdivisionName() != null) {
            model.setCitySubdivisionName(rep.getCitySubdivisionName());
        }
        if (rep.getCityName() != null) {
            model.setCityName(rep.getCityName());
        }
        if (rep.getCountrySubentity() != null) {
            model.setCountrySubentity(rep.getCountrySubentity());
        }
        if (rep.getDistrict() != null) {
            model.setDistrict(rep.getDistrict());
        }
        if (rep.getDepartment() != null) {
            model.setDepartment(rep.getDepartment());
        }
        if (rep.getCountry() != null) {
            updateModel(model.getCountry(), rep.getCountry());
        }
    }

    public static void updateModel(CountryModel model, CountryRepresentation rep) {
        if (rep.getIdentificationCode() != null) {
            model.setIdentificationCode(rep.getIdentificationCode());
        }
    }

    private static void updateModel(QuantityModel model, QuantityRepresentation rep) {
        if (rep.getUnitCode() != null) {
            model.setUnitCode(rep.getUnitCode());
        }
        if (rep.getValue() != null) {
            model.setValue(rep.getValue());
        }
    }    
    
}