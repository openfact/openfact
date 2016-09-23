package org.openfact.models.utils;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.CurrencyModel;
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
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.representations.idm.CertificateRepresentation;
import org.openfact.representations.idm.CurrencyRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;
import org.openfact.representations.idm.ubl.*;
import org.openfact.representations.idm.ubl.common.*;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setOrganization(organization.getName());
        rep.setEnabled(organization.isEnabled());

        rep.setAdditionalAccountId(organization.getAdditionalAccountId());
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

        rep.setCurrencies(organization.getCurrencies().stream().map(f -> toRepresentation(f)).collect(Collectors.toSet()));
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
    
    public static InvoiceRepresentation toRepresentation(InvoiceModel model) {
        InvoiceRepresentation rep = new InvoiceRepresentation();
        rep.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            rep.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        rep.setInvoiceRepresentationCode(model.getInvoiceModelCode());
        rep.setIdUbl(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }
        if (model.getInvoiceLine() != null) {
            for (InvoiceLineModel item : model.getInvoiceLine()) {
                rep.addInvoiceLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            rep.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        return rep;
    }

    public static CreditNoteRepresentation toRepresentation(CreditNoteModel model) {
        CreditNoteRepresentation rep = new CreditNoteRepresentation();
        rep.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            rep.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                rep.addDiscrepancyResponse(toRepresentation(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }

        if (model.getCreditNoteLine() != null) {
            for (CreditNoteLineModel item : model.getCreditNoteLine()) {
                rep.addCreditNoteLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            rep.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                rep.addBillingReference(toRepresentation(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                rep.addDespatchDocumentReference(toRepresentation(item));
            }
        }
        return rep;
    }

    public static DebitNoteRepresentation toRepresentation(DebitNoteModel model) {
        DebitNoteRepresentation rep = new DebitNoteRepresentation();
        rep.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            rep.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                rep.addDiscrepancyResponse(toRepresentation(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }

        if (model.getDebitNoteLine() != null) {
            for (DebitNoteLineModel item : model.getDebitNoteLine()) {
                rep.addDebitNoteLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getRequestedMonetaryTotal() != null) {
            rep.setRequestedMonetaryTotal(toRepresentation(model.getRequestedMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                rep.addBillingReference(toRepresentation(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                rep.addDespatchDocumentReference(toRepresentation(item));
            }
        }
        return rep;
    }

    public static InvoiceLineRepresentation toRepresentation(InvoiceLineModel model) {
        InvoiceLineRepresentation rep = new InvoiceLineRepresentation();
        if (model.getInvoicedQuantity() != null) {
            rep.setInvoicedQuantity(toRepresentation(model.getInvoicedQuantity()));
        }
        if (model.getItem() != null) {
            rep.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            rep.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            rep.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        rep.setLineExtensionAmount(model.getLineExtensionAmount());
        rep.setIdUbl(model.getID());
        if (model.getAllowanceCharge() != null) {
            for (AllowanceChargeModel item : model.getAllowanceCharge()) {
                rep.addAllowanceCharge(toRepresentation(item));
            }
        }
        return rep;
    }

    public static CreditNoteLineRepresentation toRepresentation(CreditNoteLineModel model) {
        CreditNoteLineRepresentation rep = new CreditNoteLineRepresentation();
        rep.setIdUbl(model.getID());
        if (model.getCreditedQuantity() != null) {
            rep.setCreditedQuantity(toRepresentation(model.getCreditedQuantity()));
        }
        if (model.getItem() != null) {
            rep.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            rep.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            rep.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        return rep;
    }

    public static DebitNoteLineRepresentation toRepresentation(DebitNoteLineModel model) {
        DebitNoteLineRepresentation rep = new DebitNoteLineRepresentation();
        rep.setIdUbl(model.getID());
        if (model.getDebitedQuantity() != null) {
            rep.setDebitedQuantity(toRepresentation(model.getDebitedQuantity()));
        }
        if (model.getItem() != null) {
            rep.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            rep.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            rep.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                rep.addTaxTotal(toRepresentation(item));
            }
        }
        return rep;
    }

    public static BillingReferenceRepresentation toRepresentation(BillingReferenceModel model) {
        BillingReferenceRepresentation rep = new BillingReferenceRepresentation();
        if (model.getInvoiceDocumentReference() != null) {
            rep.setInvoiceDocumentReference(toRepresentation(model.getInvoiceDocumentReference()));
        }
        return rep;
    }

    public static DocumentReferenceRepresentation toRepresentation(DocumentReferenceModel model) {
        DocumentReferenceRepresentation rep = new DocumentReferenceRepresentation();
        rep.setDocumentCodeRepresentation(model.getDocumentCode());
        return rep;
    }

    public static ResponseRepresentation toRepresentation(ResponseModel model) {
        ResponseRepresentation rep = new ResponseRepresentation();
        rep.setReferenceID(model.getReferenceID());
        rep.setResponseCode(model.getResponseCode());
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                rep.addDescription(item);
            }
        }
        return rep;
    }

    public static MonetaryTotalRepresentation toRepresentation(MonetaryTotalModel model) {
        MonetaryTotalRepresentation rep = new MonetaryTotalRepresentation();
        rep.setChargeTotalAmount(model.getChargeTotalAmount());
        rep.setPayableAmount(model.getPayableAmount());
        rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return rep;
    }

    public static AllowanceChargeRepresentation toRepresentation(AllowanceChargeModel model) {
        AllowanceChargeRepresentation rep = new AllowanceChargeRepresentation();
        rep.setAmount(model.getAmount());
        rep.setChargeIndicator(model.getChargeIndicator());
        return rep;
    }

    public static PricingReferenceRepresentation toRepresentation(PricingReferenceModel model) {
        PricingReferenceRepresentation rep = new PricingReferenceRepresentation();
        if (model.getAlternativeConditionPrice() != null) {
            for (PriceModel item : model.getAlternativeConditionPrice()) {
                rep.addAlternativeConditionPrice(toRepresentation(item));
            }
        }
        return rep;
    }

    public static PriceRepresentation toRepresentation(PriceModel model) {
        PriceRepresentation rep = new PriceRepresentation();
        // if (model.getPriceAmount() != null) {
        // rep.setPriceAmount(toRepresentation(model.getPriceAmount()));
        // }
        rep.setPriceAmount(model.getPriceAmount());

        return rep;
    }

    // public static PriceAmountRepresentation toRepresentation(PriceAmountModel model) {
    // PriceAmountRepresentation rep = new PriceAmountRepresentation();
    // rep.setCurrencyID(model.getCurrencyID());
    // rep.setValue(model.getValue());
    // return rep;
    // }

    public static ItemRepresentation toRepresentation(ItemModel model) {
        ItemRepresentation rep = new ItemRepresentation();
        for (String item : model.getDescription()) {
            rep.addDescription(item);
        }
        if (model.getSellersItemIdentification() != null) {
            rep.setSellersItemIdentification(toRepresentation(model.getSellersItemIdentification()));
        }
        return rep;
    }

    public static ItemIdentificationRepresentation toRepresentation(ItemIdentificationModel model) {
        ItemIdentificationRepresentation rep = new ItemIdentificationRepresentation();
        rep.setIdUbl(model.getID());
        return rep;
    }

    public static TaxTotalRepresentation toRepresentation(TaxTotalModel model) {
        TaxTotalRepresentation rep = new TaxTotalRepresentation();
        rep.setTaxAmount(model.getTaxAmount());
        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                rep.addTaxSubtotal(toRepresentation(item));
            }
        }
        return rep;
    }

    public static TaxSubtotalRepresentation toRepresentation(TaxSubtotalModel model) {
        TaxSubtotalRepresentation rep = new TaxSubtotalRepresentation();
        rep.setTaxAmount(model.getTaxAmount());
        rep.setTaxCategory(toRepresentation(model.getTaxCategory()));
        return rep;
    }

    public static TaxCategoryRepresentation toRepresentation(TaxCategoryModel model) {
        TaxCategoryRepresentation rep = new TaxCategoryRepresentation();
        rep.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
        if (model.getTaxScheme() != null) {
            rep.setTaxScheme(toRepresentation(model.getTaxScheme()));
        }
        rep.setTierRange(model.getTierRange());
        return rep;
    }

    public static TaxSchemeRepresentation toRepresentation(TaxSchemeModel model) {
        TaxSchemeRepresentation rep = new TaxSchemeRepresentation();
        rep.setIdUbl(model.getID());
        rep.setName(model.getName());
        rep.setTaxRepresentationCode(model.getTaxCode());
        return rep;
    }

    public static CustomerPartyRepresentation toRepresentation(CustomerPartyModel model) {
        CustomerPartyRepresentation rep = new CustomerPartyRepresentation();
        rep.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            rep.addAdditionalAccountID(item);
        }
        if (model.getParty() != null) {
            rep.setParty(toRepresentation(model.getParty()));
        }
        return rep;
    }

    public static SupplierPartyRepresentation toRepresentation(SupplierPartyModel model) {
        SupplierPartyRepresentation rep = new SupplierPartyRepresentation();
        if (model.getParty() != null) {
            rep.setParty(toRepresentation(model.getParty()));
        }
        rep.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            rep.addAdditionalAccountID(item);
        }
        return rep;
    }

    public static PartyRepresentation toRepresentation(PartyModel model) {
        PartyRepresentation rep = new PartyRepresentation();
        for (PartyLegalModel item : model.getPartyLegalEntity()) {
            rep.addPartyLegalEntity(toRepresentation(item));
        }
        for (String item : model.getPartyName()) {
            rep.addPartyName(item);
        }
        if (model.getPostalAddress() != null) {
            rep.setPostalAddress(toRepresentation(model.getPostalAddress()));
        }
        return rep;
    }

    public static PartyLegalEntityRepresentation toRepresentation(PartyLegalModel model) {
        PartyLegalEntityRepresentation rep = new PartyLegalEntityRepresentation();
        rep.setRegistrationName(model.getRegistrationName());
        return rep;
    }

    public static AddressRepresentation toRepresentation(AddressModel model) {
        AddressRepresentation rep = new AddressRepresentation();
        rep.setIdUbl(model.getID());
        rep.setStreetName(model.getStreetName());
        rep.setCitySubdivisionName(model.getCitySubdivisionName());
        rep.setCityName(model.getCityName());
        rep.setCountrySubentity(model.getCountrySubentity());
        rep.setDistrict(model.getDistrict());
        rep.setDepartment(model.getDepartment());
        if (model.getCountry() != null) {
            rep.setCountry(toRepresentation(model.getCountry()));
        }
        return rep;
    }

    public static CountryRepresentation toRepresentation(CountryModel model) {
        CountryRepresentation rep = new CountryRepresentation();
        rep.setIdentificationCode(model.getIdentificationCode());
        return rep;
    }

    public static QuantityRepresentation toRepresentation(QuantityModel model) {
        QuantityRepresentation rep = new QuantityRepresentation();
        rep.setUnitCode(model.getUnitCode());
        rep.setValue(model.getValue());
        return rep;
    }

    public static UBLExtensionsRepresentation toRepresentation(UBLExtensionsModel model) {
        UBLExtensionsRepresentation rep = new UBLExtensionsRepresentation();
        for (UBLExtensionModel item : model.getUBLExtension()) {
            rep.addUBLExtension(toRepresentation(item));
        }
        return null;
    }

    public static UBLExtensionRepresentation toRepresentation(UBLExtensionModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    public static XMLGregorianCalendar toRepresentation(LocalDate date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }

}
