package org.openfact.ubl.pe;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;

import org.jboss.logging.Logger;
import org.openfact.common.finance.MoneyConverters;
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
import org.openfact.models.utils.UblSignature;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.pe.extensions.AdditionalInformationTypeSunatAgg;
import org.openfact.ubl.pe.extensions.AdditionalMonetaryTotalType;
import org.openfact.ubl.pe.extensions.AdditionalPropertyType;
import org.openfact.ubl.pe.extensions.InvoiceFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.ValueType;

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
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, InvoiceModel invoice) {               
        try {
            UBLExtensionModel additiontalInformation = generateAdditionalInformation(organization, invoice);
            UBLExtensionModel signature = generateSignature(organization, invoice);
            List<UBLExtensionModel> addedUblExtensions = new ArrayList<>();
            addedUblExtensions.addAll(Arrays.asList(additiontalInformation, signature));
            return addedUblExtensions;
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | KeyStoreException | CertificateException | UnrecoverableEntryException | ParserConfigurationException | IOException | MarshalException | XMLSignatureException e) {
            log.error(e.getMessage(), e);
            throw new ModelException("No se pudo generar Ubl extensions PE");
        }        
    }

    @Override
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, CreditNoteModel creditNote) {
        return null;
    }

    @Override
    public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, DebitNoteModel debitNote) {
        return null;
    }

    private UBLExtensionModel generateAdditionalInformation(OrganizationModel organization, InvoiceModel invoice) {        
        try {            
            AdditionalMonetaryTotalType gravado = generateAdditionalInformationSunatTotal(invoice, "1001", "10", "11", "12", "13", "14", "15", "16", "17");
            AdditionalMonetaryTotalType inafecto = generateAdditionalInformationSunatTotal(invoice, "1002", "30", "31", "32", "33", "34", "35", "36");
            AdditionalMonetaryTotalType exonerado = generateAdditionalInformationSunatTotal(invoice, "1003", "20", "21");
            AdditionalMonetaryTotalType gratuito = generateAdditionalInformationSunatTotal(invoice, "1004", "40");
            AdditionalPropertyType additionalProperty = generateAdditionalInformationSunatTotal(organization, invoice);
                 
            AdditionalInformationTypeSunatAgg additionalInformation =  new AdditionalInformationTypeSunatAgg();
            additionalInformation.getAdditionalMonetaryTotal().addAll(Arrays.asList(gravado, inafecto, exonerado, gratuito));
            additionalInformation.getAdditionalProperty().add(additionalProperty);
            
            UBLExtensionsModel ublExtensions = invoice.getUBLExtensions();
            UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
            ExtensionContentModel extensionContent = ublExtension.getExtensionContent();            
            extensionContent.setAny(generateElement(additionalInformation));
            return ublExtension;
        } catch (JAXBException e) {
            log.error(e.getMessage(), e);
            throw new ModelException("Invalid marshall");
        }        
    }

    private UBLExtensionModel generateSignature(OrganizationModel organization, InvoiceModel invoice) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, IOException, MarshalException, XMLSignatureException {
        UBLExtensionsModel ublExtensions = invoice.getUBLExtensions();
        UBLExtensionModel ublExtension = ublExtensions.addUblExtension();
        ExtensionContentModel extensionContent = ublExtension.getExtensionContent();
        
        Document document = UblSignature.ublSignatureGenerate(organization);
        Element element = document.getDocumentElement();
        extensionContent.setAny(element);        
        return ublExtension;
    }

    private Element generateElement(AdditionalInformationTypeSunatAgg object) throws JAXBException {
        InvoiceFactory factory = new InvoiceFactory();
        JAXBContext context = JAXBContext.newInstance(InvoiceFactory.class);
        Marshaller marshallerElement = context.createMarshaller();

        JAXBElement<AdditionalInformationTypeSunatAgg> jaxbElement = factory.createAdditionalInformation(object);
        DOMResult res = new DOMResult();
        marshallerElement.marshal(jaxbElement, res);
        Element element = ((Document) res.getNode()).getDocumentElement();
        return element;
    }
    
    private AdditionalMonetaryTotalType generateAdditionalInformationSunatTotal(InvoiceModel invoice, String additionalMonetaryTotalCode, String... taxExemptionReasonCode) {
        String currencyID = invoice.getDocumentCurrencyCode();                            

        // Get discount percent = allowanceTotalAmmount/total sum(lineExtensionAmount)       
        MonetaryTotalModel monetaryTotal = invoice.getLegalMonetaryTotal();
        BigDecimal allowanceTotalAmount = monetaryTotal.getAllowanceTotalAmount();
        BigDecimal discountPercent = allowanceTotalAmount.divide(getTotalLineExtensionAmmount(invoice));
        
        // Apply discount = sum(lineExtensionAmount) * (1 - discountPercent)
        BigDecimal payableAmountDiscount = getTotalGroupByExemptionReasonCode(invoice, taxExemptionReasonCode);
        payableAmountDiscount = payableAmountDiscount.multiply(BigDecimal.ONE.subtract(discountPercent));
        
        // Payable amount
        PayableAmountType payableAmount = new PayableAmountType();
        payableAmount.setCurrencyID(currencyID);
        payableAmount.setValue(payableAmountDiscount);

        AdditionalMonetaryTotalType additionalMonetaryTotal = new AdditionalMonetaryTotalType();
        additionalMonetaryTotal.setID(new IDType(additionalMonetaryTotalCode));
        additionalMonetaryTotal.setPayableAmount(payableAmount);        
        return additionalMonetaryTotal;
    }
    
    private AdditionalPropertyType generateAdditionalInformationSunatTotal(OrganizationModel organization, InvoiceModel invoice) {                          
        MoneyConverters converter;
        switch (organization.getDefaultLocale()) {
        case "en":
            converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
            break;
        case "es":
            converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
            break;
        default:
            converter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
            break;
        }
        String valueAsWords = converter.asWords(invoice.getLegalMonetaryTotal().getPayableAmount());
        
        AdditionalPropertyType additionalProperty = new AdditionalPropertyType();
        additionalProperty.setID(new IDType("1000"));
        additionalProperty.setValue(new ValueType(valueAsWords));                              
        return additionalProperty;
    }
    
    private BigDecimal getTotalLineExtensionAmmount(InvoiceModel invoice) {
        return invoice.getInvoiceLine().stream().map(f -> f.getLineExtensionAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
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
