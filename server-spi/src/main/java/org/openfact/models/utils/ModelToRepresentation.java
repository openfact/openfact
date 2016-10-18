package org.openfact.models.utils;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.ArrayUtils;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.BinaryObjectModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;
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
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.TasksScheduleRepresentation;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.AddressRepresentation;
import org.openfact.representations.idm.ubl.common.AllowanceChargeRepresentation;
import org.openfact.representations.idm.ubl.common.AttachmentRepresentation;
import org.openfact.representations.idm.ubl.common.BillingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.BinaryObjectRepresentation;
import org.openfact.representations.idm.ubl.common.CountryRepresentation;
import org.openfact.representations.idm.ubl.common.CreditNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.DocumentReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.ExternalReferenceRepresentation;
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
import org.openfact.representations.idm.ubl.common.SignatureRepresentation;
import org.openfact.representations.idm.ubl.common.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.common.TaxCategoryRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSchemeRepresentation;
import org.openfact.representations.idm.ubl.common.TaxSubtotalRepresentation;
import org.openfact.representations.idm.ubl.common.TaxTotalRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionsRepresentation;

public class ModelToRepresentation {

    public static OrganizationRepresentation toRepresentation(OrganizationModel organization,
            boolean internal) {
        OrganizationRepresentation rep = new OrganizationRepresentation();
        rep.setId(organization.getId());
        rep.setOrganization(organization.getName());
        rep.setDescription(organization.getDescription());
        rep.setEnabled(organization.isEnabled());
        rep.setCreatedTimestamp(organization.getCreatedTimestamp());

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
        
        rep.setDefaultCurrency(organization.getDefaultCurrency());
        rep.setDefaultLocale(organization.getDefaultLocale());
        rep.setDefaultUblLocale(organization.getDefaultLocale());
        
        rep.setAdminEventsEnabled(organization.isAdminEventsEnabled());
        rep.setAdminEventsDetailsEnabled(organization.isAdminEventsDetailsEnabled());        

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

    public static CodeCatalogRepresentation toRepresentation(CodeCatalogModel model, boolean internal) {
        CodeCatalogRepresentation rep = new CodeCatalogRepresentation();
        rep.setCode(model.getCode());
        rep.setDescription(model.getDescription());
        rep.setLocale(model.getLocale());
        rep.setType(model.getLocale());
        if (internal) {
            rep.setId(model.getId());
        }
        return rep;
    }

    public static InvoiceRepresentation toRepresentation(InvoiceModel model) {
        InvoiceRepresentation rep = new InvoiceRepresentation();

        rep.setId(model.getId());
        rep.setUblVersionID(model.getUBLVersionID());
        rep.setCustomizationID(model.getCustomizationID());
        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                rep.addSignature(toRepresentation(item));
            }
        }

        rep.setIssueDateTime(model.getIssueDateTime());
        if (model.getUBLExtensions() != null) {
            rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }

        rep.setIdUbl(model.getID());
        rep.setInvoiceTypeCode(model.getInvoiceTypeCode());

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
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
        
        if(model.getXmlDocument() != null) {            
            try {
                DocumentUtils.getByteToDocument(ArrayUtils.toPrimitive(model.getXmlDocument()));
            } catch (Exception e) {
                throw new ModelException(e.getMessage());
            }
        }
        return rep;
    }

    public static CreditNoteRepresentation toRepresentation(CreditNoteModel model) {
        CreditNoteRepresentation rep = new CreditNoteRepresentation();

        rep.setId(model.getId());
        rep.setUblVersionID(model.getUBLVersionID());
        rep.setCustomizationID(model.getCustomizationID());
        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                rep.addSignature(toRepresentation(item));
            }
        }

        rep.setIssueDateTime(model.getIssueDateTime());
        if (model.getUBLExtensions() != null) {
            rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                rep.addDiscrepancyResponse(toRepresentation(item));
            }
        }

        rep.setIdUbl(model.getID());

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
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
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

        rep.setId(model.getId());
        rep.setUblVersionID(model.getUBLVersionID());
        rep.setCustomizationID(model.getCustomizationID());
        if (model.getSignature() != null) {
            for (SignatureModel item : model.getSignature()) {
                rep.addSignature(toRepresentation(item));
            }
        }

        rep.setIssueDateTime(model.getIssueDateTime());
        if (model.getUBLExtensions() != null) {
            rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
        }
        if (model.getAccountingSupplierParty() != null) {
            rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
        }
        if (model.getDiscrepancyResponse() != null) {
            for (ResponseModel item : model.getDiscrepancyResponse()) {
                rep.addDiscrepancyResponse(toRepresentation(item));
            }
        }

        rep.setIdUbl(model.getID());

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
        rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
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
        rep.setLineExtensionAmount(model.getLineExtensionAmount());
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
        rep.setLineExtensionAmount(model.getLineExtensionAmount());
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
        rep.setPriceAmount(model.getPriceAmount());
        rep.setPriceTypeCode(model.getPriceTypeCode());

        return rep;
    }

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
        rep.setTaxCodeType(model.getTaxCode());
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
        if (model.getPostalAddress() != null) {
            rep.setPostalAddress(toRepresentation(model.getPostalAddress()));
        }
        for (PartyLegalModel item : model.getPartyLegalEntity()) {
            rep.addPartyLegalEntity(toRepresentation(item));
        }
        for (String item : model.getPartyName()) {
            rep.addPartyName(item);
        }
        for (String item : model.getPartyIdentification()) {
            rep.addPartyIdentification(item);
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

    public static SignatureRepresentation toRepresentation(SignatureModel model) {
        SignatureRepresentation rep = new SignatureRepresentation();
        if (model.getCanonicalizationMethod() != null) {
            rep.setCanonicalizationMethod(model.getCanonicalizationMethod());
        }
        if (model.getID() != null) {
            rep.setIdUbl(model.getID());
        }
        if (model.getNote() != null) {
            rep.setNote(model.getNote());
        }
        if (model.getSignatureMethod() != null) {
            rep.setSignatureMethod(model.getSignatureMethod());
        }
        if (model.getValidationDate() != null) {
            rep.setValidationDate(model.getValidationDate());
        }
        if (model.getValidationTime() != null) {
            rep.setValidationTime(model.getValidationTime());
        }
        if (model.getValidatorID() != null) {
            rep.setValidatorID(model.getValidatorID());
        }
        if (model.getSignatoryParty() != null) {
            rep.setSignatoryParty(toRepresentation(model.getSignatoryParty()));
        }
        if (model.getDigitalSignatureAttachment() != null) {
            rep.setDigitalSignatureAttachment(toRepresentation(model.getDigitalSignatureAttachment()));
        }
        return rep;
    }

    public static AttachmentRepresentation toRepresentation(AttachmentModel model) {
        AttachmentRepresentation rep = new AttachmentRepresentation();
        if (model.getExternalReference() != null) {
            rep.setExternalReference(toRepresentation(model.getExternalReference()));
        }
        if (model.getEmbeddedDocumentBinaryObject() != null) {
            rep.setEmbeddedDocumentBinaryObject(toRepresentation(model.getEmbeddedDocumentBinaryObject()));
        }
        return rep;
    }

    public static ExternalReferenceRepresentation toRepresentation(ExternalReferenceModel model) {
        ExternalReferenceRepresentation rep = new ExternalReferenceRepresentation();
        if (model.getDocumentHash() != null) {
            rep.setDocumentHash(model.getDocumentHash());
        }
        if (model.getExpiryDate() != null) {
            rep.setExpiryDate(model.getExpiryDate());
        }
        if (model.getExpiryTime() != null) {
            rep.setExpiryTime(model.getExpiryTime());
        }
        if (model.getURI() != null) {
            rep.setUri(model.getURI());
        }
        return rep;
    }

    public static BinaryObjectRepresentation toRepresentation(BinaryObjectModel model) {
        BinaryObjectRepresentation rep = new BinaryObjectRepresentation();
        if (model.getCharacterSetCode() != null) {
            rep.setCharacterSetCode(model.getCharacterSetCode());
        }
        if (model.getEncodingCode() != null) {
            rep.setEncodingCode(model.getEncodingCode());
        }
        if (model.getFilename() != null) {
            rep.setFilename(model.getFilename());
        }
        if (model.getFormat() != null) {
            rep.setFormat(model.getFormat());
        }
        if (model.getMimeCode() != null) {
            rep.setMimeCode(model.getMimeCode());
        }
        if (model.getUri() != null) {
            rep.setUri(model.getUri());
        }
        if (model.getValue() != null) {
            rep.setValue(model.getValue());
        }
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

    public static XMLGregorianCalendar toRepresentation(LocalDate date)
            throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }

}
