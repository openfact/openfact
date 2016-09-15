package org.openfact.models.utils;

import java.util.List;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.representations.idm.ubl.AddressRepresentation;
import org.openfact.representations.idm.ubl.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.ItemRepresentation;
import org.openfact.representations.idm.ubl.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.PartyLegalEntityRepresentation;
import org.openfact.representations.idm.ubl.PartyRepresentation;
import org.openfact.representations.idm.ubl.PriceRepresentation;
import org.openfact.representations.idm.ubl.PricingReferenceRepresentation;
import org.openfact.representations.idm.ubl.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.TaxCategoryRepresentation;
import org.openfact.representations.idm.ubl.TaxSchemeRepresentation;
import org.openfact.representations.idm.ubl.TaxSubtotalRepresentation;
import org.openfact.representations.idm.ubl.TaxTotalRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

public class RepresentationToModelUbl {

    private static Logger logger = Logger.getLogger(RepresentationToModelUbl.class);

    public static InvoiceModel createInvoice(OpenfactSession session, OrganizationModel organization, InvoiceRepresentation rep) {
        InvoiceModel invoice = session.invoicesUBL().addInvoice(organization);
        
        /*if (rep.getID() != null) {
            updateIdentifier(invoice.getID(), rep.getID());
        } else {

        }
        
        if (rep.getIssueDate() != null) {
            invoice.setIssueDate(rep.getIssueDate());
        }
        if (rep.getIssueTime() != null) {
            invoice.setIssueTime(rep.getIssueTime());
        }

        if (rep.getCodeTypeDocumentCurrencyCode() != null) {
            updateCodeTypeDocumentCurrencyCode(invoice.getCodeTypeDocumentCurrencyCode(), rep.getCodeTypeDocumentCurrencyCode());
        }
        
        if (rep.getInvoiceTypeCode() != null) {
            updateCode(invoice.getInvoiceTypeCode(), rep.getInvoiceTypeCode());
        }

        if (rep.getLegalMonetaryTotal() != null) {
            updateLegalMonetaryTotal(invoice.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }

        if (rep.getAccountingSupplierParty() != null) {
            updateSupplierParty(invoice.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
        }
        if (rep.getAccountingCustomerParty() != null) {
            updateCustomerParty(invoice.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
        }

        if (rep.getTaxTotals() != null) {
            for (TaxTotalRepresentation taxTotalRep : rep.getTaxTotals()) {
                TaxTotalModel taxTotal = invoice.addTaxTotal();
                updateTaxTotal(taxTotal, taxTotalRep);
            }
        }*/

        return invoice;
    }    

    /*public static void updateInvoiceLine(InvoiceModel invoice, List<InvoiceLineRepresentation> reps) {
        for (InvoiceLineRepresentation rep : reps) {
            InvoiceLineModel invoiceLine = invoice.addInvoiceLine();
            
            if(rep.getInvoicedQuantity() != null) {
                updateQuantity(invoiceLine.getInvoicedQuantity(), rep.getInvoicedQuantity());
            }
                
            if(rep.getItem() != null) {
                updateItem(invoiceLine.getItem(), rep.getItem());
            }                 
                  
            if(rep.getPrice() != null) {
                updatePrice(invoiceLine.getPrice(), rep.getPrice());
            }            
            if(rep.getPricingReference() != null) {
                updatePrincingReference(invoiceLine.getPricingReference(), rep.getPricingReference());
            }
            
            if(rep.getTaxTotals() != null) {
                for (TaxTotalRepresentation taxTotalRep : rep.getTaxTotals()) {
                    TaxTotalModel taxTotal = invoiceLine.addTaxTotal();
                    updateTaxTotal(taxTotal, taxTotalRep);
                }
            }                   
        }
    }
    
    private static void updatePrincingReference(PricingReferenceModel pricingReference, PricingReferenceRepresentation rep) {
        if(rep.getAlternativeConditionPrice() != null) {
            updatePrice(pricingReference.getAlternativeConditionPrice(), rep.getAlternativeConditionPrice());
        }
    }

    private static void updatePrice(PriceModel price, PriceRepresentation rep) {
        if(rep.getPriceAmount() != null) {
            price.setPriceAmount(rep.getPriceAmount());
        }
    }

    private static void updateItem(ItemModel item, ItemRepresentation rep) {
        if(rep.getDescription() != null) {
            item.setDescription(rep.getDescription());
        }
    }

    private static void updateQuantity(QuantityModel invoicedQuantity, QuantityRepresentation rep) {
        if(rep.getUnitCode() != null) {
            invoicedQuantity.setUnitCode(rep.getUnitCode());    
        }
        if(rep.getValue() != null) {
            invoicedQuantity.setValue(rep.getValue());   
        }              
    }

    public static void updateLegalMonetaryTotal(MonetaryTotalModel monetaryTotal, MonetaryTotalRepresentation rep) {
        if (monetaryTotal.getChargeTotalAmount() != null) {
            monetaryTotal.setChargeTotalAmount(rep.getChargeTotalAmount());
        }
        if (monetaryTotal.getPayableAmount() != null) {
            monetaryTotal.setPayableAmount(rep.getPayableAmount());
        }
    }

    public static void updateTaxTotal(TaxTotalModel taxTotal, TaxTotalRepresentation rep) {
        if (rep.getTaxAmount() != null) {
            taxTotal.setTaxAmount(rep.getTaxAmount());
        }
        if (rep.getTaxSubtotals() != null) {
            for (TaxSubtotalRepresentation taxSubtotalRep : rep.getTaxSubtotals()) {
                TaxSubtotalModel taxSubtotal = taxTotal.addTaxSubtotal();
                updateTaxSubtotal(taxSubtotal, taxSubtotalRep);               
            }
        }
    }
    
    public static void updateTaxSubtotal(TaxSubtotalModel taxSubtotal, TaxSubtotalRepresentation rep) {
        if(rep.getTaxCategory() != null) {
            updateTaxCategory(taxSubtotal.getTaxCategory(), rep.getTaxCategory());
        }       
    }
    
    public static void updateTaxCategory(TaxCategoryModel taxCategory, TaxCategoryRepresentation rep) {
        if(rep.getTaxScheme() != null) {
            
        }        
    }

    public static void updateTaxScheme(TaxSchemeModel taxScheme, TaxSchemeRepresentation rep) {
        if(rep.getName() != null) {
            taxScheme.setName(rep.getName());
        }
        if(rep.getTaxTypeCode() != null) {
            updateCode(taxScheme.getTaxTypeCode(), rep.getTaxTypeCode());
        }
    }
    
    public static void updateSupplierParty(SupplierPartyModel supplierParty, SupplierPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            updateIdentifier(supplierParty.getAdditionalAccountID(), rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            updateIdentifier(supplierParty.getAdditionalAccountID(), rep.getAdditionalAccountID());
        }

        if (rep.getParty() != null) {
            updateParty(supplierParty.getParty(), rep.getParty());
        }
    }

    public static void updateCustomerParty(CustomerPartyModel customerParty, CustomerPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            updateIdentifier(customerParty.getAdditionalAccountID(), rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            updateIdentifier(customerParty.getAdditionalAccountID(), rep.getAdditionalAccountID());
        }
    }

    public static void updateParty(PartyModel party, PartyRepresentation rep) {
        if (rep.getPartyNames() != null) {
            rep.getPartyNames().stream().forEach(c -> party.addPartyName(c.getName()));
        }
        if (rep.getPostalAddress() != null) {
            updateAddress(party.getPostalAddress(), rep.getPostalAddress());
        }
        if (rep.getPartyLegalEntities() != null) {
            for (PartyLegalEntityRepresentation partyLegalEntityRep : rep.getPartyLegalEntities()) {
                PartyLegalEntityModel partyLegalEntity = party.addPartyLegalEntity();
                updatePartyLegalEntity(partyLegalEntity, partyLegalEntityRep);
            }
        }
    }

    public static void updatePartyLegalEntity(PartyLegalEntityModel partyLegalEntity, PartyLegalEntityRepresentation rep) {
        if (rep.getRegistrationName() != null) {
            partyLegalEntity.setRegistrationName(rep.getRegistrationName());
        }
    }

    public static void updateAddress(AddressModel address, AddressRepresentation rep) {
        if (rep.getAdditionalStreetName() != null) {
            address.setAdditionalStreetName(rep.getAdditionalStreetName());
        }
        if (rep.getAddressFormatCode() != null) {
            updateCode(address.getAddressFormatCode(), rep.getAddressFormatCode());
        }
        if (rep.getAddressTypeCode() != null) {
            updateCode(address.getAddressTypeCode(), rep.getAddressTypeCode());
        }
        if (rep.getBlockName() != null) {
            address.setBlockName(rep.getBlockName());
        }
        if (rep.getBuildingName() != null) {
            address.setBuildingName(rep.getBuildingName());
        }
        if (rep.getBuildingNumber() != null) {
            address.setBuildingNumber(rep.getBuildingNumber());
        }
        if (rep.getCityName() != null) {
            address.setCityName(rep.getCityName());
        }
        if (rep.getCitySubdivisionName() != null) {
            address.setCitySubdivisionName(rep.getCitySubdivisionName());
        }
        if (rep.getCountrySubentity() != null) {
            address.setCountrySubentity(rep.getCountrySubentity());
        }
        if (rep.getCountrySubentityCode() != null) {
            updateCode(address.getCountrySubentityCode(), rep.getCountrySubentityCode());
        }
        if (rep.getDepartment() != null) {
            address.setDepartment(rep.getDepartment());
        }
        if (rep.getDistrict() != null) {
            address.setDistrict(rep.getDistrict());
        }
        if (rep.getFloor() != null) {
            address.setFloor(rep.getFloor());
        }
        if (rep.getID() != null) {
            updateIdentifier(address.getID(), rep.getID());
        }
        if (rep.getInhouseMail() != null) {
            address.setInhouseMail(rep.getInhouseMail());
        }
        if (rep.getMarkAttention() != null) {
            address.setMarkAttention(rep.getMarkAttention());
        }
        if (rep.getMarkCare() != null) {
            address.setMarkCare(rep.getMarkCare());
        }
        if (rep.getPlotIdentification() != null) {
            address.setPlotIdentification(rep.getPlotIdentification());
        }
        if (rep.getPostalZone() != null) {
            address.setPostalZone(rep.getPostalZone());
        }
        if (rep.getPostbox() != null) {
            address.setPostbox(rep.getPostbox());
        }
        if (rep.getRegion() != null) {
            address.setRegion(rep.getRegion());
        }
        if (rep.getRoom() != null) {
            address.setRoom(rep.getRoom());
        }
        if (rep.getStreetName() != null) {
            address.setStreetName(rep.getStreetName());
        }
        if (rep.getTimezoneOffset() != null) {
            address.setTimezoneOffset(rep.getTimezoneOffset());
        }
    }

    public static void updateCode(CodeModel codeType, CodeRepresentation rep) {
        if (rep.getValue() != null) {
            codeType.setValue(rep.getValue());
        }
        if (rep.getListID() != null) {
            codeType.setListID(rep.getListID());
        }
        if (rep.getListAgencyID() != null) {
            codeType.setListAgencyID(rep.getListAgencyID());
        }
        if (rep.getListAgencyName() != null) {
            codeType.setListAgencyName(rep.getListAgencyName());
        }
        if (rep.getListName() != null) {
            codeType.setListName(rep.getListName());
        }
        if (rep.getListVersionID() != null) {
            codeType.setListVersionID(rep.getListVersionID());
        }
        if (rep.getName() != null) {
            codeType.setName(rep.getName());
        }
        if (rep.getLanguageID() != null) {
            codeType.setLanguageID(rep.getLanguageID());
        }
        if (rep.getListURI() != null) {
            codeType.setListURI(rep.getListURI());
        }
        if (rep.getListSchemeURI() != null) {
            codeType.setListSchemeURI(rep.getListSchemeURI());
        }
    }
    
    private static void updateCodeTypeDocumentCurrencyCode(CurrencyCodeModel currencyCodeModel, CurrencyCodeRepresentation rep) {
        if (rep.getValue() != null) {
            currencyCodeModel.setValue(rep.getValue());
        }
        if (rep.getListID() != null) {
            currencyCodeModel.setListID(rep.getListID());
        }
        if (rep.getListAgencyID() != null) {
            currencyCodeModel.setListAgencyID(rep.getListAgencyID());
        }
        if (rep.getListAgencyName() != null) {
            currencyCodeModel.setListAgencyName(rep.getListAgencyName());
        }
        if (rep.getListName() != null) {
            currencyCodeModel.setListName(rep.getListName());
        }
        if (rep.getListVersionID() != null) {
            currencyCodeModel.setListVersionID(rep.getListVersionID());
        }
        if (rep.getName() != null) {
            currencyCodeModel.setName(rep.getName());
        }
        if (rep.getLanguageID() != null) {
            currencyCodeModel.setLanguageID(rep.getLanguageID());
        }
        if (rep.getListURI() != null) {
            currencyCodeModel.setListURI(rep.getListURI());
        }
        if (rep.getListSchemeURI() != null) {
            currencyCodeModel.setListSchemeURI(rep.getListSchemeURI());
        }
    }

    public static void updateIdentifier(IdentifierModel identifierType, IdentifierRepresentation rep) {
        if (rep.getValue() != null) {
            identifierType.setValue(rep.getValue());
        }
        if (rep.getSchemeID() != null) {
            identifierType.setSchemeID(rep.getSchemeID());
        }
        if (rep.getSchemeName() != null) {
            identifierType.setSchemeName(rep.getSchemeName());
        }
        if (rep.getSchemeAgencyID() != null) {
            identifierType.setSchemeAgencyID(rep.getSchemeAgencyID());
        }
        if (rep.getSchemeAgencyName() != null) {
            identifierType.setSchemeAgencyName(rep.getSchemeAgencyName());
        }
        if (rep.getSchemeVersionID() != null) {
            identifierType.setSchemeVersionID(rep.getSchemeVersionID());
        }
        if (rep.getSchemeDataURI() != null) {
            identifierType.setSchemeDataURI(rep.getSchemeDataURI());
        }
        if (rep.getSchemeURI() != null) {
            identifierType.setSchemeURI(rep.getSchemeURI());
        }
    }*/    

}