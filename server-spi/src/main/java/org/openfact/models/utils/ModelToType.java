package org.openfact.models.utils;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openfact.models.ubl.AttachmentModel;
import org.openfact.models.ubl.CustomerPartyModel;
import org.openfact.models.ubl.ExternalReferenceModel;
import org.openfact.models.ubl.InvoiceLineModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.MonetaryTotalModel;
import org.openfact.models.ubl.PartyIdentificationModel;
import org.openfact.models.ubl.PartyModel;
import org.openfact.models.ubl.PartyNameModel;
import org.openfact.models.ubl.SignatureModel;
import org.openfact.models.ubl.SupplierPartyModel;
import org.openfact.models.ubl.TaxTotalModel;
import org.openfact.models.ubl.type.CodeModel;
import org.openfact.models.ubl.type.CurrencyCodeModel;
import org.openfact.models.ubl.type.IdentifierModel;
import org.openfact.models.ubl.type.NameModel;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SignatureType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.NameType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class ModelToType {

    public static InvoiceType toType(InvoiceModel model) throws DatatypeConfigurationException {
        InvoiceType type = new InvoiceType();

        type.setIssueDate(toGregorianCalendar(model.getIssueDate()));
        type.setID(toType(model.getID()));
        type.setInvoiceTypeCode(toType(model.getInvoiceTypeCode()));
        type.setDocumentCurrencyCode(toType(model.getCodeTypeDocumentCurrencyCode()));
        
        for (SignatureModel sinature : model.getSignatures()) {
            type.addSignature(toType(sinature));
        }
        
        type.setAccountingSupplierParty(toType(model.getAccountingSupplierParty()));
        type.setAccountingCustomerParty(toType(model.getAccountingCustomerParty()));
        
        type.setLegalMonetaryTotal(toType(model.getLegalMonetaryTotal()));
        
        for (TaxTotalModel taxTotal : model.getTaxTotals()) {
            type.addTaxTotal(toType(taxTotal));
        }
                
        for (InvoiceLineModel invoiceLine : model.getInvoiceLines()) {
            type.addInvoiceLine(toType(invoiceLine));
        }
                       
        return type;
    }

    public static SignatureType toType(SignatureModel model) {
        SignatureType type = new SignatureType();
        type.setID(toType(model.getID()));
        type.setSignatoryParty(toType(model.getSignatoryParty()));
        type.setDigitalSignatureAttachment(toType(model.getDigitalSignatureAttachment()));
        return type;
    }
    
    private static AttachmentType toType(AttachmentModel model) {
        AttachmentType type = new AttachmentType();
        type.setExternalReference(toType(model.getExternalReference()));
        return type;
    }

    private static ExternalReferenceType toType(ExternalReferenceModel model) {
        ExternalReferenceType type = new ExternalReferenceType();
        return type;
    }

    private static PartyType toType(PartyModel model) {
        PartyType type = new PartyType();
        for (PartyIdentificationModel partyIdentification : model.getPartyIdentifications()) {
            type.addPartyIdentification(toType(partyIdentification));
        }
        for (PartyNameModel partyName : model.getPartyNames()) {
            type.addPartyName(toType(partyName));
        }
        return type;
    }

    private static PartyNameType toType(PartyNameModel model) {
        PartyNameType type = new PartyNameType();
        type.setName(toType(model.getName()));
        return type;
    }

    private static NameType toType(NameModel model) {
        NameType type = new NameType();
        type.setLanguageID(model.getLanguageID());
        type.setValue(model.getValue());
        return type;
    }

    private static PartyIdentificationType toType(PartyIdentificationModel model) {
        PartyIdentificationType type = new PartyIdentificationType();
        type.setID(toType(model.getID()));
        return type;
    }

    private static DocumentCurrencyCodeType toType(CurrencyCodeModel model) {
        DocumentCurrencyCodeType type = new DocumentCurrencyCodeType();
        type.setLanguageID(model.getLanguageID());
        type.setListAgencyID(model.getListAgencyID());
        type.setListAgencyName(model.getListAgencyName());
        type.setListID(model.getListID());
        type.setListName(model.getListName());
        type.setListSchemeURI(model.getListSchemeURI());
        type.setListURI(model.getListURI());
        type.setListVersionID(model.getListVersionID());
        type.setName(model.getName());
        type.setValue(model.getValue());
        return type;
    }

    private static MonetaryTotalType toType(MonetaryTotalModel legalMonetaryTotal) {
        MonetaryTotalType type = new MonetaryTotalType();
        type.setPayableAmount(legalMonetaryTotal.getPayableAmount());
        return type;
    }

    private static TaxTotalType toType(TaxTotalModel model) {
        TaxTotalType type = new TaxTotalType();
        type.setTaxAmount(model.getTaxAmount());
        return type;
    }

    private static InvoiceLineType toType(InvoiceLineModel model) {
        InvoiceLineType type = new InvoiceLineType();
        return type;
    }

    private static CustomerPartyType toType(CustomerPartyModel model) {
        CustomerPartyType type = new CustomerPartyType();
        return type;
    }

    private static SupplierPartyType toType(SupplierPartyModel model) {
        SupplierPartyType type = new SupplierPartyType();
        return type;
    }
    
    private static IDType toType(IdentifierModel model) {
        IDType type = new IDType();        
        type.setSchemeAgencyID(model.getSchemeAgencyID());
        type.setSchemeAgencyName(model.getSchemeAgencyName());
        type.setSchemeDataURI(model.getSchemeDataURI());
        type.setSchemeID(model.getSchemeID());
        type.setSchemeName(model.getSchemeName());
        type.setSchemeURI(model.getSchemeURI());
        type.setSchemeVersionID(model.getSchemeVersionID());
        type.setValue(model.getValue());        
        return type;
    }

    private static InvoiceTypeCodeType toType(CodeModel model) {
        InvoiceTypeCodeType type = new InvoiceTypeCodeType();
        type.setLanguageID(model.getLanguageID());
        type.setListAgencyID(model.getListAgencyID());
        type.setListAgencyName(model.getListAgencyName());
        type.setListID(model.getListID());
        type.setListName(model.getListName());
        type.setListSchemeURI(model.getListSchemeURI());
        type.setListURI(model.getListURI());
        type.setListVersionID(model.getListVersionID());
        type.setName(model.getName());
        type.setValue(model.getValue());
        return type;
    }
      
    public static XMLGregorianCalendar toGregorianCalendar(LocalDate date)
            throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }

}
