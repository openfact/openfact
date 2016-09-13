package org.openfact.models.utils;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.AddressModel;
import org.openfact.models.ubl.CustomerPartyModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.MonetaryTotalModel;
import org.openfact.models.ubl.PartyLegalEntityModel;
import org.openfact.models.ubl.PartyModel;
import org.openfact.models.ubl.SupplierPartyModel;
import org.openfact.models.ubl.TaxCategoryModel;
import org.openfact.models.ubl.TaxSchemeModel;
import org.openfact.models.ubl.TaxSubtotalModel;
import org.openfact.models.ubl.TaxTotalModel;
import org.openfact.models.ubl.type.CodeModel;
import org.openfact.models.ubl.type.IdentifierModel;
import org.openfact.representations.idm.ubl.AddressRepresentation;
import org.openfact.representations.idm.ubl.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.PartyLegalEntityRepresentation;
import org.openfact.representations.idm.ubl.PartyRepresentation;
import org.openfact.representations.idm.ubl.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.TaxCategoryRepresentation;
import org.openfact.representations.idm.ubl.TaxSubtotalRepresentation;
import org.openfact.representations.idm.ubl.TaxTotalRepresentation;

public class RepresentationToModelUBL {

    private static Logger logger = Logger.getLogger(RepresentationToModelUBL.class);

    public static InvoiceModel createInvoice(OpenfactSession session, OrganizationModel organization,
            InvoiceRepresentation rep) {

        InvoiceModel invoice = session.invoicesUBL().addInvoice(organization);
        invoice.setIssueDate(rep.getIssueDate());
        invoice.setIssueTime(rep.getIssueTime());

        if (rep.getInvoiceTypeCode() != null) {
            updateCodeType(invoice.getInvoiceTypeCode(), rep.getInvoiceTypeCode());
        }
        if (rep.getInvoiceTypeCode() != null) {
            updateCodeType(invoice.getInvoiceTypeCode(), rep.getInvoiceTypeCode());
        }

        if (rep.getID() != null) {
            updateIdentifierType(invoice.getID(), rep.getID());
        } else {

        }

        if (rep.getLegalMonetaryTotal() != null) {
            updateLegalMonetaryTotal(invoice.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
        }

        // 28 Tipo de moneda en la cual se emite la factura electronica
        // invoice.setCodeTypeDocumentCurrencyCode(null);

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
        }

        return invoice;
    }

    public static void updateLegalMonetaryTotal(MonetaryTotalModel monetaryTotal,
            MonetaryTotalRepresentation rep) {
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
                TaxSubtotalModel taSubtotal = taxTotal.addTaxSubtotal();
                TaxCategoryModel taxCategory = taSubtotal.getTaxCategory();
                TaxSchemeModel taxScheme = taxCategory.getTaxScheme();
                // taxScheme.setName(rep.taxSubtotalRep.get);
                taxScheme.setTaxTypeCode(null);
            }
        }
    }

    public static void updateSupplierParty(SupplierPartyModel supplierParty,
            SupplierPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            updateIdentifierType(supplierParty.getAdditionalAccountID(), rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            updateIdentifierType(supplierParty.getAdditionalAccountID(), rep.getAdditionalAccountID());
        }

        if (rep.getParty() != null) {
            updateParty(supplierParty.getParty(), rep.getParty());
        }
    }

    public static void updateCustomerParty(CustomerPartyModel customerParty,
            CustomerPartyRepresentation rep) {
        if (rep.getCustomerAssignedAccountID() != null) {
            updateIdentifierType(customerParty.getAdditionalAccountID(), rep.getCustomerAssignedAccountID());
        }
        if (rep.getAdditionalAccountID() != null) {
            updateIdentifierType(customerParty.getAdditionalAccountID(), rep.getAdditionalAccountID());
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

    public static void updatePartyLegalEntity(PartyLegalEntityModel partyLegalEntity,
            PartyLegalEntityRepresentation rep) {
        if (rep.getRegistrationName() != null) {
            partyLegalEntity.setRegistrationName(rep.getRegistrationName());
        }
    }

    public static void updateAddress(AddressModel address, AddressRepresentation rep) {
        if (rep.getAdditionalStreetName() != null) {
            address.setAdditionalStreetName(rep.getAdditionalStreetName());
        }
        if (rep.getAddressFormatCode() != null) {
            updateCodeType(address.getAddressFormatCode(), rep.getAddressFormatCode());
        }
        if (rep.getAddressTypeCode() != null) {
            updateCodeType(address.getAddressTypeCode(), rep.getAddressTypeCode());
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
            updateCodeType(address.getCountrySubentityCode(), rep.getCountrySubentityCode());
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
            updateIdentifierType(address.getID(), rep.getID());
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

    public static void updateCodeType(CodeModel codeType,
            org.openfact.representations.idm.ubl.type.CodeType rep) {
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

    public static void updateIdentifierType(IdentifierModel identifierType,
            org.openfact.representations.idm.ubl.type.IdentifierType rep) {
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
    }

    /*
     * public static List<org.openfact.models.ubl.InvoiceLineModel>
     * createInvoiceLine(OpenfactSession session, OrganizationModel
     * organization, org.openfact.models.ubl.InvoiceModel invoice,
     * List<InvoiceLineRepresentation> reps) {
     * List<org.openfact.models.ubl.InvoiceLineModel> result = new
     * ArrayList<>();
     * 
     * for (InvoiceLineRepresentation rep : reps) {
     * org.openfact.models.ubl.InvoiceLineModel invoiceLine =
     * invoice.addInvoiceLine();
     * 
     * InvoiceLineType invoiceLineType = null;
     * invoiceLineType.getTaxTotal().get(0).getTaxSubtotal().get(0).
     * getTaxCategory().settaxsc
     * 
     * // 11 Unidad de medida por item InvoicedQuantityType invoicedQuantity =
     * invoiceLine.getInvoicedQuantity(); invoicedQuantity.setUnitCode("");
     * 
     * // 12 Cantidad de unidades por item
     * invoiceLine.setInvoicedQuantity(BigDecimal.ZERO);
     * 
     * // 13 Descripcion detallada del servicio prestado, bien vendido o cedido
     * en uso, indicando caracteristicas ItemModel item = invoiceLine.getItem();
     * item.addDescription();
     * 
     * // 14 Valor unitario por item PriceModel price = invoiceLine.getPrice();
     * price.setPriceAmount(null);
     * 
     * // 15 Precio de venta unitario por item y codigo PricingReferenceModel
     * pricingReference = invoiceLine.getPricingReference(); PriceModel
     * pricingReference1 = pricingReference.getAlternativeConditionPrice();
     * pricingReference1.setPriceAmount(null);
     * pricingReference1.setPriceTypeCode(null);
     * 
     * //16 afectacion a igv por item TaxTotalModel taxTotal =
     * invoiceLine.addTaxTotal(); taxTotal.setTaxAmount(null); TaxSubtotalModel
     * taxSubtotal = taxTotal.addTaxSubtotal(); taxSubtotal.setTaxAmount(null);
     * TaxCategoryModel taxCategory = taxSubtotal.getTaxCategory();
     * taxCategory.setTaxExemptionReasonCode(null); TaxSchemeModel taxScheme =
     * taxCategory.getTaxScheme(); taxScheme.setID(null); taxScheme.setName("");
     * taxScheme.setTaxTypeCode(null); }
     * 
     * return result; }
     */

}