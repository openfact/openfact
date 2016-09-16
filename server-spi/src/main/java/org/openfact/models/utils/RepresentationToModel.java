package org.openfact.models.utils;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.*;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.PartyLegalEntityModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.representations.idm.*;
import org.openfact.representations.idm.ubl.*;
import org.openfact.representations.idm.ubl.common.*;

public class RepresentationToModel {

    public static InvoiceModel updateModel(OpenfactSession session, OrganizationModel organization,
            InvoiceRepresentation rep) {
        InvoiceModel model = session.invoices().addInvoice(organization);
        model.setIssueDate(rep.getIssueDate());
        if (rep.getAccountingSupplierParty() != null) {
            updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty())
        }
        model.setInvoiceModelCode(model.getInvoiceRepresentationCode());
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            model.setAccountingCustomerParty(updateModel(model.getAccountingCustomerParty()));
        }
        if (model.getInvoiceLine() != null) {
            for (InvoiceLineRepresentation item : model.getInvoiceLine()) {
                model.addInvoiceLine(updateModel(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                model.addTaxTotal(updateModel(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            model.setLegalMonetaryTotal(updateModel(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        return model;
    }

    public static CreditNoteModel updateModel(CreditNoteRepresentation model) {
        CreditNoteModel type = new CreditNoteModel();
        type.setIssueDate(updateModel(model.getIssueDate()));
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(updateModel(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(updateModel(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(updateModel(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(updateModel(model.getAccountingCustomerParty()));
        }

        if (model.getCreditNoteLine() != null) {
            for (CreditNoteLineRepresentation item : model.getCreditNoteLine()) {
                type.addCreditNoteLine(updateModel(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                type.addTaxTotal(updateModel(item));
            }
        }
        if (model.getLegalMonetaryTotal() != null) {
            type.setLegalMonetaryTotal(updateModel(model.getLegalMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceRepresentation item : model.getBillingReference()) {
                type.addBillingReference(updateModel(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(updateModel(item));
            }
        }
        return type;
    }

    public static DebitNoteModel updateModel(DebitNoteRepresentation model) {
        DebitNoteModel type = new DebitNoteModel();
        type.setIssueDate(updateModel(model.getIssueDate()));
        if (model.getUBLExtensions() != null) {
            type.setUBLExtensions(updateModel(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            type.setAccountingSupplierParty(updateModel(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseRepresentation item : model.getDiscrepancyResponse()) {
                type.addDiscrepancyResponse(updateModel(item));
            }
        }
        model.setID(model.getID());
        if (model.getAccountingCustomerParty() != null) {
            type.setAccountingCustomerParty(updateModel(model.getAccountingCustomerParty()));
        }

        if (model.getDebitNoteLine() != null) {
            for (DebitNoteLineRepresentation item : model.getDebitNoteLine()) {
                type.addDebitNoteLine(updateModel(item));
            }
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                type.addTaxTotal(updateModel(item));
            }
        }
        if (model.getRequestedMonetaryTotal() != null) {
            type.setRequestedMonetaryTotal(updateModel(model.getRequestedMonetaryTotal()));
        }
        model.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        if (model.getBillingReference() != null) {
            for (BillingReferenceRepresentation item : model.getBillingReference()) {
                type.addBillingReference(updateModel(item));
            }
        }
        if (model.getDespatchDocumentReference() != null) {
            for (DocumentReferenceRepresentation item : model.getDespatchDocumentReference()) {
                type.addDespatchDocumentReference(updateModel(item));
            }
        }
        return type;
    }

    public static InvoiceLineModel updateModel(InvoiceLineRepresentation model) {
        InvoiceLineModel type = new InvoiceLineModel();
        if (model.getInvoicedQuantity() != null) {
            type.setInvoicedQuantity(updateModel(model.getInvoicedQuantity(), InvoicedQuantityModel.class));
        }
        if (model.getItem() != null) {
            type.setItem(updateModel(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(updateModel(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(updateModel(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                type.addTaxTotal(updateModel(item));
            }
        }
        type.setLineExtensionAmount(model.getLineExtensionAmount());
        type.setID(model.getID());
        if (model.getAllowanceCharge() != null) {
            for (AllowanceChargeRepresentation item : model.getAllowanceCharge()) {
                type.addAllowanceCharge(updateModel(item));
            }
        }
        return type;
    }

    public static CreditNoteLineModel updateModel(CreditNoteLineRepresentation model) {
        CreditNoteLineModel type = new CreditNoteLineModel();
        type.setID(model.getID());
        if (model.getCreditedQuantity() != null) {
            type.setCreditedQuantity(updateModel(model.getCreditedQuantity(), CreditedQuantityModel.class));
        }
        if (model.getItem() != null) {
            type.setItem(updateModel(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(updateModel(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(updateModel(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                type.addTaxTotal(updateModel(item));
            }
        }
        return type;
    }

    public static DebitNoteLineModel updateModel(DebitNoteLineRepresentation model) {
        DebitNoteLineModel type = new DebitNoteLineModel();
        type.setID(model.getID());
        if (model.getDebitedQuantity() != null) {
            type.setDebitedQuantity(updateModel(model.getDebitedQuantity(), DebitedQuantityModel.class));
        }
        if (model.getItem() != null) {
            type.setItem(updateModel(model.getItem()));
        }
        if (model.getPrice() != null) {
            type.setPrice(updateModel(model.getPrice()));
        }
        if (model.getPricingReference() != null) {
            type.setPricingReference(updateModel(model.getPricingReference()));
        }
        if (model.getTaxTotal() != null) {
            for (TaxTotalRepresentation item : model.getTaxTotal()) {
                type.addTaxTotal(updateModel(item));
            }
        }
        return type;
    }

    public static BillingReferenceModel updateModel(BillingReferenceRepresentation model) {
        BillingReferenceModel type = new BillingReferenceModel();
        if (model.getInvoiceDocumentReference() != null) {
            type.setInvoiceDocumentReference(updateModel(model.getInvoiceDocumentReference()));
        }
        return type;
    }

    public static DocumentReferenceModel updateModel(DocumentReferenceRepresentation model) {
        DocumentReferenceModel type = new DocumentReferenceModel();
        type.setDocumentModelCode(model.getDocumentCodeRepresentation());
        return type;
    }

    public static ResponseModel updateModel(ResponseRepresentation model) {
        ResponseModel type = new ResponseModel();
        type.setReferenceID(model.getReferenceID());
        type.setResponseCode(model.getResponseCode());
        if (model.getDescription() != null) {
            for (String item : model.getDescription()) {
                type.addDescription(new DescriptionModel(item));
            }
        }
        return type;
    }

    public static MonetaryTotalModel updateModel(MonetaryTotalRepresentation model) {
        MonetaryTotalModel type = new MonetaryTotalModel();
        type.setChargeTotalAmount(model.getChargeTotalAmount());
        type.setPayableAmount(model.getPayableAmount());
        type.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
        return type;
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
        if (model.getAlternativeConditionPrice() != null) {
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
        if (rep.getID() != null) {
            model.setID(rep.getID());
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
        if (rep.getID() != null) {
            model.setID(rep.getID());
        }
        if (rep.getName() != null) {
            model.setName(rep.getName());
        }
        if (rep.getTaxCodeRepresentation() != null) {
            model.setTaxCodeModel(rep.getTaxCodeRepresentation());
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
        if (model.getPostalAddress() != null) {
            updateModel(model.getPostalAddress(), rep.getPostalAddress());
        }
    }

    public static void updateModel(PartyLegalEntityModel model, PartyLegalEntityRepresentation rep) {
        if (rep.getRegistrationName() != null) {
            model.setRegistrationName(model.getRegistrationName());
        }
    }

    public static void updateModel(AddressModel model, AddressRepresentation rep) {
        if (rep.getID() != null) {
            model.setID(rep.getID());
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

}