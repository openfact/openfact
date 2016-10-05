package org.openfact.ubl.pe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.pe.extensions.AdditionalInformationTypeSunatAgg;
import org.openfact.ubl.pe.extensions.AdditionalMonetaryTotalType;
import org.openfact.ubl.pe.extensions.AdditionalPropertyType;
import org.openfact.ubl.pe.extensions.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.ValueType;
import pl.allegro.finance.tradukisto.MoneyConverters;
import pl.allegro.finance.tradukisto.ValueConverters;

public class UblExtensionContentGeneratorProvider_PE implements UblExtensionContentGeneratorProvider {

    private static final Logger log = Logger.getLogger(UblExtensionContentGeneratorProvider_PE.class);

    protected OpenfactSession session;

    public UblExtensionContentGeneratorProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization,
            InvoiceModel invoice) {
        List<UBLExtensionModel> addedUblExtensions = new ArrayList<>();

        UBLExtensionModel additiontalInformation = generateAdditionalInformation(organization, invoice);
        UBLExtensionModel signature = generateSignature(organization, invoice);

        addedUblExtensions.add(additiontalInformation);
        addedUblExtensions.add(signature);
        return addedUblExtensions;
    }

    @Override
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization,
            CreditNoteModel creditNote) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization,
            DebitNoteModel debitNote) {
        // TODO Auto-generated method stub
        return null;
    }

    private UBLExtensionModel generateAdditionalInformation(OrganizationModel organization,
            InvoiceModel invoice) {

        UBLExtensionsModel ublExtensions = invoice.getUBLExtensions();
        UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
        ExtensionContentModel extensionContent = ublExtension.getExtensionContent();
        try {
            
            // No contiene descuentos
            AdditionalInformationTypeSunatAgg gravado = generateAdditionalInformationSunatTotal(invoice, "1001", "10", "11", "12", "13", "14", "15", "16", "17");
            AdditionalInformationTypeSunatAgg inafecto = generateAdditionalInformationSunatTotal(invoice, "1002", "30", "31", "32", "33", "34", "35", "36");
            AdditionalInformationTypeSunatAgg exonerado = generateAdditionalInformationSunatTotal(invoice, "1003", "20", "21");
            AdditionalInformationTypeSunatAgg gratuito = generateAdditionalInformationSunatTotal(invoice, "1004", "40");
            AdditionalInformationTypeSunatAgg additionalProperty = generateAdditionalInformationSunatTotal(organization, invoice);
            
            extensionContent.setAny(generateElement(gravado));
            extensionContent.setAny(generateElement(inafecto));
            extensionContent.setAny(generateElement(exonerado));
            extensionContent.setAny(generateElement(gratuito));
        } catch (JAXBException e) {
            throw new ModelException("Invalid marshall");
        }

        return ublExtension;
    }

    private UBLExtensionModel generateSignature(OrganizationModel organization, InvoiceModel invoice) {
        UBLExtensionsModel ublExtensions = invoice.getUBLExtensions();
        UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
        ExtensionContentModel extensionContent = ublExtension.getExtensionContent();

        return ublExtension;
    }

    private Element generateElement(AdditionalInformationTypeSunatAgg object) throws JAXBException {
        ObjectFactory factory = new ObjectFactory();
        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
        Marshaller marshallerElement = context.createMarshaller();

        JAXBElement<AdditionalInformationTypeSunatAgg> jaxbElement = factory.createAdditionalInformation(object);
        DOMResult res = new DOMResult();
        marshallerElement.marshal(jaxbElement, res);
        Element element = ((Document) res.getNode()).getDocumentElement();
        return element;
    }
    
    private AdditionalInformationTypeSunatAgg generateAdditionalInformationSunatTotal(InvoiceModel invoice, String additionalMonetaryTotalCode, String... taxExemptionReasonCode) {
        String currencyID = invoice.getDocumentCurrencyCode();
        
        AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
        AdditionalMonetaryTotalType additionalMonetaryTotal = new AdditionalMonetaryTotalType();             

        // Get discount percent = allowanceTotalAmmount/total sum(lineExtensionAmount)       
        MonetaryTotalModel monetaryTotal = invoice.getLegalMonetaryTotal();
        BigDecimal allowanceTotalAmount = monetaryTotal.getAllowanceTotalAmount();
        BigDecimal discountPercent = allowanceTotalAmount.divide(getTotalLineExtensionAmmount(invoice));
        
        // Apply discount = sum(lineExtensionAmount) * (1 - discountPercent)
        BigDecimal payableAmountDiscount = getTotalGroupByExemptionReasonCode(invoice, taxExemptionReasonCode);
        payableAmountDiscount = payableAmountDiscount.multiply(BigDecimal.ONE.subtract(discountPercent));
        
        PayableAmountType payableAmount = new PayableAmountType();
        payableAmount.setCurrencyID(currencyID);
        payableAmount.setValue(payableAmountDiscount);

        additionalMonetaryTotal.setID(new IDType(additionalMonetaryTotalCode));
        additionalMonetaryTotal.setPayableAmount(payableAmount);
        additionalInformation.getAdditionalMonetaryTotal().add(additionalMonetaryTotal);
        
        return additionalInformation;
    }
    
    private AdditionalInformationTypeSunatAgg generateAdditionalInformationSunatTotal(OrganizationModel organization, InvoiceModel invoice) {
        AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
        AdditionalPropertyType additionalProperty = new AdditionalPropertyType();                   

        MoneyConverters converter;
        switch (organization.getDefaultLocale()) {
        case "en":
            converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
            break;
        case "es":
            converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
            break;
        default:
            converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
            break;
        }
        String valueAsWords = converter.asWords(invoice.getLegalMonetaryTotal().getPayableAmount());
        
        additionalProperty.setID(new IDType("1000"));
        additionalProperty.setValue(new ValueType(valueAsWords));               
        
        additionalInformation.getAdditionalProperty().add(additionalProperty);        
        return additionalInformation;
    }
    
    private BigDecimal getTotalLineExtensionAmmount(InvoiceModel invoice) {
        return invoice.getInvoiceLine().stream().map(f -> f.getLineExtensionAmount()).reduce(BigDecimal.ZERO,
                BigDecimal::add);
    }
    
    private BigDecimal getTotalGroupByExemptionReasonCode(InvoiceModel invoice, String... taxExemptionReasonCode) {       
        BigDecimal result = BigDecimal.ZERO;
        List<String> taxExemptionReasonCodes = Arrays.asList(taxExemptionReasonCode);
        
        for (InvoiceLineModel invoiceLine : invoice.getInvoiceLine()) {
            for (TaxTotalModel taxTotal : invoiceLine.getTaxTotal()) {
                for (TaxSubtotalModel taxSubtotal : taxTotal.getTaxSubtotal()) {
                    TaxCategoryModel taxCategory = taxSubtotal.getTaxCategory();
                    if(taxExemptionReasonCodes.contains(taxCategory.getTaxExemptionReason())) {
                        result = result.add(invoiceLine.getLineExtensionAmount());
                    }
                }
            }
        }
        return result;
    }

}
