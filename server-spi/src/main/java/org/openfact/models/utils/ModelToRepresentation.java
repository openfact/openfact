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
        InvoiceRepresentation type = new InvoiceRepresentation();
        type.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        type.setInvoiceRepresentationCode(model.getInvoiceModelCode());
        type.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }
        if (model.getInvoiceLine() != null) {
            for (InvoiceLineModel item : model.getInvoiceLine()) {
                type.addInvoiceLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        return type;
    }

    public static CreditNoteRepresentation toRepresentation(CreditNoteModel model) {
        CreditNoteRepresentation type = new CreditNoteRepresentation();
        type.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(toRepresentation(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }

        if (model.getCreditNoteLine() != null) {
            for (CreditNoteLineModel item : model.getCreditNoteLine()) {
                type.addCreditNoteLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                type.addBillingReference(toRepresentation(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(toRepresentation(item));
            }
        }
        return type;
    }

    public static DebitNoteRepresentation toRepresentation(DebitNoteModel model) {
        DebitNoteRepresentation type = new DebitNoteRepresentation();
        type.setIssueDate(model.getIssueDate());
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(toRepresentation(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
        }

        if (model.getDebitNoteLine() != null) {
            for (DebitNoteLineModel item : model.getDebitNoteLine()) {
                type.addDebitNoteLine(toRepresentation(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        if (model.getRequestedMonetaryTotal() != null) {
            type.setRequestedMonetaryTotal(toRepresentation(model.getRequestedMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceModel item : model.getBillingReference()) {
                type.addBillingReference(toRepresentation(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(toRepresentation(item));
            }
        }
        return type;
    }

    public static InvoiceLineRepresentation toRepresentation(InvoiceLineModel model) {
        InvoiceLineRepresentation type = new InvoiceLineRepresentation();
        if (model.getInvoicedQuantity() != null) {
            type.setInvoicedQuantity(toRepresentation(model.getInvoicedQuantity()));
        }
        if (model.getItem() != null) {
            type.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        type.setLineExtensionAmount(model.getLineExtensionAmount());
        type.setID(model.getID());
        if (model.getAllowanceCharge() != null) {
            for (AllowanceChargeModel item : model.getAllowanceCharge()) {
                type.addAllowanceCharge(toRepresentation(item));
            }
        }
        return type;
    }

    public static CreditNoteLineRepresentation toRepresentation(CreditNoteLineModel model) {
        CreditNoteLineRepresentation type = new CreditNoteLineRepresentation();
        type.setID(model.getID());
        if (model.getCreditedQuantity() != null) {
            type.setCreditedQuantity(toRepresentation(model.getCreditedQuantity()));
        }
        if (model.getItem() != null) {
            type.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        return type;
    }

    public static DebitNoteLineRepresentation toRepresentation(DebitNoteLineModel model) {
        DebitNoteLineRepresentation type = new DebitNoteLineRepresentation();
        type.setID(model.getID());
        if (model.getDebitedQuantity() != null) {
            type.setDebitedQuantity(toRepresentation(model.getDebitedQuantity()));
        }
        if (model.getItem() != null) {
            type.setItem(toRepresentation(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(toRepresentation(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(toRepresentation(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalModel item : model.getTaxTotal()) {
                type.addTaxTotal(toRepresentation(item));
            }
        }
        return type;
    }

    public static BillingReferenceRepresentation toRepresentation(BillingReferenceModel model) {
        BillingReferenceRepresentation type = new BillingReferenceRepresentation();
        if (model.getInvoiceDocumentReference() != null) {
            type.setInvoiceDocumentReference(toRepresentation(model.getInvoiceDocumentReference()));
        }
        return type;
    }

    public static DocumentReferenceRepresentation toRepresentation(DocumentReferenceModel model) {
        DocumentReferenceRepresentation type = new DocumentReferenceRepresentation();
        type.setDocumentCodeRepresentation(model.getDocumentCode());
        return type;
    }

    public static ResponseRepresentation toRepresentation(ResponseModel model) {
        ResponseRepresentation type = new ResponseRepresentation();
        type.setReferenceID(model.getReferenceID());
        type.setResponseCode(model.getResponseCode());
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                type.addDescription(item);
            }
        }
        return type;
    }

    public static MonetaryTotalRepresentation toRepresentation(MonetaryTotalModel model) {
        MonetaryTotalRepresentation type = new MonetaryTotalRepresentation();
        type.setChargeTotalAmount(model.getChargeTotalAmount());
        type.setPayableAmount(model.getPayableAmount());
        type.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return type;
    }

    public static AllowanceChargeRepresentation toRepresentation(AllowanceChargeModel model) {
        AllowanceChargeRepresentation type = new AllowanceChargeRepresentation();
        type.setAmount(model.getAmount());
        type.setChargeIndicator(model.getChargeIndicator());
        return type;
    }

    public static PricingReferenceRepresentation toRepresentation(PricingReferenceModel model) {
        PricingReferenceRepresentation type = new PricingReferenceRepresentation();
        if (model.getAlternativeConditionPrice() != null) {
            for (PriceModel item : model.getAlternativeConditionPrice()) {
                type.addAlternativeConditionPrice(toRepresentation(item));
            }
        }
        return type;
    }

    public static PriceRepresentation toRepresentation(PriceModel model) {
        PriceRepresentation type = new PriceRepresentation();
        // if (model.getPriceAmount() != null) {
        // type.setPriceAmount(toRepresentation(model.getPriceAmount()));
        // }
        type.setPriceAmount(model.getPriceAmount());

        return type;
    }

    // public static PriceAmountRepresentation toRepresentation(PriceAmountModel model) {
    // PriceAmountRepresentation type = new PriceAmountRepresentation();
    // type.setCurrencyID(model.getCurrencyID());
    // type.setValue(model.getValue());
    // return type;
    // }

    public static ItemRepresentation toRepresentation(ItemModel model) {
        ItemRepresentation type = new ItemRepresentation();
        for (String item : model.getDescription()) {
            type.addDescription(item);
        }
        if (model.getSellersItemIdentification() != null) {
            type.setSellersItemIdentification(toRepresentation(model.getSellersItemIdentification()));
        }
        return type;
    }

    public static ItemIdentificationRepresentation toRepresentation(ItemIdentificationModel model) {
        ItemIdentificationRepresentation type = new ItemIdentificationRepresentation();
        type.setID(model.getID());
        return type;
    }

    public static TaxTotalRepresentation toRepresentation(TaxTotalModel model) {
        TaxTotalRepresentation type = new TaxTotalRepresentation();
        type.setTaxAmount(model.getTaxAmount());
        if (model.getTaxSubtotal() != null) {
            for (TaxSubtotalModel item : model.getTaxSubtotal()) {
                type.addTaxSubtotal(toRepresentation(item));
            }
        }
        return type;
    }

    public static TaxSubtotalRepresentation toRepresentation(TaxSubtotalModel model) {
        TaxSubtotalRepresentation type = new TaxSubtotalRepresentation();
        type.setTaxAmount(model.getTaxAmount());
        type.setTaxCategory(toRepresentation(model.getTaxCategory()));
        return type;
    }

    public static TaxCategoryRepresentation toRepresentation(TaxCategoryModel model) {
        TaxCategoryRepresentation type = new TaxCategoryRepresentation();
        type.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
        if (model.getTaxScheme() != null) {
            type.setTaxScheme(toRepresentation(model.getTaxScheme()));
        }
        type.setTierRange(model.getTierRange());
        return type;
    }

    public static TaxSchemeRepresentation toRepresentation(TaxSchemeModel model) {
        TaxSchemeRepresentation type = new TaxSchemeRepresentation();
        type.setID(model.getID());
        type.setName(model.getName());
        type.setTaxRepresentationCode(model.getTaxCode());
        return type;
    }

    public static CustomerPartyRepresentation toRepresentation(CustomerPartyModel model) {
        CustomerPartyRepresentation type = new CustomerPartyRepresentation();
        type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            type.addAdditionalAccountID(item);
        }
        if (model.getParty() != null) {
            type.setParty(toRepresentation(model.getParty()));
        }
        return type;
    }

    public static SupplierPartyRepresentation toRepresentation(SupplierPartyModel model) {
        SupplierPartyRepresentation type = new SupplierPartyRepresentation();
        if (model.getParty() != null) {
            type.setParty(toRepresentation(model.getParty()));
        }
        type.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
        for (String item : model.getAdditionalAccountID()) {
            type.addAdditionalAccountID(item);
        }
        return type;
    }

    public static PartyRepresentation toRepresentation(PartyModel model) {
        PartyRepresentation type = new PartyRepresentation();
        for (PartyLegalModel item : model.getPartyLegalEntity()) {
            type.addPartyLegalEntity(toRepresentation(item));
        }
        for (String item : model.getPartyName()) {
            type.addPartyName(item);
        }
        if (model.getPostalAddress() != null) {
            type.setPostalAddress(toRepresentation(model.getPostalAddress()));
        }
        return type;
    }

    public static PartyLegalEntityRepresentation toRepresentation(PartyLegalModel model) {
        PartyLegalEntityRepresentation type = new PartyLegalEntityRepresentation();
        type.setRegistrationName(model.getRegistrationName());
        return type;
    }

    public static AddressRepresentation toRepresentation(AddressModel model) {
        AddressRepresentation type = new AddressRepresentation();
        type.setID(model.getID());
        type.setStreetName(model.getStreetName());
        type.setCitySubdivisionName(model.getCitySubdivisionName());
        type.setCityName(model.getCityName());
        type.setCountrySubentity(model.getCountrySubentity());
        type.setDistrict(model.getDistrict());
        type.setDepartment(model.getDepartment());
        if (model.getCountry() != null) {
            type.setCountry(toRepresentation(model.getCountry()));
        }
        return type;
    }

    public static CountryRepresentation toRepresentation(CountryModel model) {
        CountryRepresentation type = new CountryRepresentation();
        type.setIdentificationCode(model.getIdentificationCode());
        return type;
    }

    public static QuantityRepresentation toRepresentation(QuantityModel model) {
        QuantityRepresentation type = new QuantityRepresentation();
        type.setUnitCode(model.getUnitCode());
        type.setValue(model.getValue());
        return type;
    }

    public static UBLExtensionsRepresentation toRepresentation(UBLExtensionsModel model) {
        UBLExtensionsRepresentation type = new UBLExtensionsRepresentation();
        for (UBLExtensionModel item : model.getUBLExtension()) {
            type.addUBLExtension(toRepresentation(item));
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
