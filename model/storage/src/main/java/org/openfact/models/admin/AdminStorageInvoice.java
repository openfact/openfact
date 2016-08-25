package org.openfact.models.admin;

import org.openfact.common.DateUtils;
import org.openfact.common.NumberToLetter;
import org.openfact.common.Utils;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.enums.*;
import org.openfact.models.pack.LocalStorage;
import org.openfact.models.sign.SignatureXml;
import org.openfact.models.sign.SignatureXmlVerifier;
import org.openfact.models.xml.ubl.entities.XmlInvoice;
import org.openfact.models.xml.ubl.entities.XmlInvoiceDetails;
import org.openfact.models.common.CurrencyCodeContentType;
import org.openfact.models.common.InvoiceType;
import org.openfact.models.common.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class AdminStorageInvoice implements AdminStorageInvoiceProvider {

    @Override
    public boolean createInvoice(InvoiceModel invoice, String xmlPath, String validatorPath, String ublVersion, String customizationId, String signatureId, String referenceURI) {
        try {
            XmlInvoice xmlInvoice = new XmlInvoice();
//            if (invoice.getAdditionalInformation().get(AdditionalInformationType.GRATUITO) != null)
//                xmlInvoice.addInvoiceExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario(AdditionalInformationType.GRATUITO, invoice.getTotalLegalMonetary().get(AdditionalInformationType.GRATUITO));
//            if (invoice.getAdditionalInformation().get(AdditionalInformationType.EXONERADO) != null)
//                xmlInvoice.addInvoiceExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario(AdditionalInformationType.EXONERADO, invoice.getTotalLegalMonetary().get(AdditionalInformationType.EXONERADO));
//            if (invoice.getAdditionalInformation().get(AdditionalInformationType.GRAVADO) != null)
//                xmlInvoice.addInvoiceExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario(AdditionalInformationType.GRAVADO, invoice.getTotalLegalMonetary().get(AdditionalInformationType.GRAVADO));
//            if (invoice.getAdditionalInformation().get(AdditionalInformationType.INACFECTO) != null)
//                xmlInvoice.addInvoiceExtensionesExtensionContenidoDeExtensionInformacionAdicionalTotalMonetario(AdditionalInformationType.INACFECTO, invoice.getTotalLegalMonetary().get(AdditionalInformationType.INACFECTO));

//            xmlInvoice.addInvoiceExtensionesExtensionContenidoDeExtensionInformacionAdicionalPropiedadAdicional(MonetaryTotalType.IMPORTE_TOTAL, NumberToLetter.convertNumberToLetter(invoice.getTotalLegalMonetary().get(MonetaryTotalType.IMPORTE_TOTAL)));
//            xmlInvoice.setUBLIdVersion(ublVersion);
//            xmlInvoice.setCustomizationId(customizationId);

//            String Id = Utils.joinFormat(invoice.getInvoiceType().getCode(), invoice.getInvoiceId().getSeries(), invoice.getInvoiceId().getNumber());
//            xmlInvoice.setId(Id);
//            xmlInvoice.setIssueDate(DateUtils.asDate(invoice.getIssueDate()));
//            xmlInvoice.setInvoiceTypeCode(invoice.getInvoiceType());
//            xmlInvoice.setDocumentCurrencyCode(invoice.getCurrencyCode());
//
//            xmlInvoice.setSignatureId(signatureId);
//            xmlInvoice.setSignatureSignatoryPartyPartyIdentificationId(invoice.getOrganization().getAssignedIdentificationId());
//            xmlInvoice.setSignatureSignatoryPartyPartyNameName(invoice.getOrganization().getSupplierName());
//            xmlInvoice.setSignatureDigitalSignatureAttachmentExternalReferenceURI(referenceURI);

//            xmlInvoice.setAccountingSupplierPartyCustomerAssignedAccountID(invoice.getOrganization().getAssignedIdentificationId());
            //xmlInvoice.setAccountingSupplierPartyAdditionalAccountID(invoice.getOrganization().getAdditionalAccountId());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressId("050105");//AYACUCHO HUAMANGA AYACUCHO
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressStreetName(invoice.getOrganization().getPostalAddress().getStreetName());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressCitySubdivisionName(invoice.getOrganization().getPostalAddress().getCitySubdivisionName());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressCityName(invoice.getOrganization().getPostalAddress().getCityName());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressCountrySubentity(invoice.getOrganization().getPostalAddress().getCitySubdivisionName());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressDistrict(invoice.getOrganization().getPostalAddress().getDistrict());
//            xmlInvoice.setAccountingSupplierPartyPartyPostalAddressCountryIdentificationCode(invoice.getOrganization().getPostalAddress().getCountryIdentificationCode());
//            xmlInvoice.setAccountingSupplierPartyPartyPartyLegalEntityRegistrationName(invoice.getOrganization().getRegistrationName());
//
//            xmlInvoice.setAccountingCustomerPartyCustomerAssignedAccountID(invoice.getCustomer().getAssignedIdentificationId());
            //xmlInvoice.setAccountingCustomerPartyAdditionalAccountID(invoice.getOrganization().getAdditionalAccountId());
//            xmlInvoice.setAccountingCustomerPartyPartyPartyLegalEntityRegistrationName(invoice.getCustomer().getRegistrationName());
//            if (invoice.getTotalTaxs().get(TaxType.IGV) != null) {
//                xmlInvoice.setTaxTotalTaxAmount(invoice.getTotalTaxs().get(TaxType.IGV), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxAmount(invoice.getTotalTaxs().get(TaxType.IGV), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.IGV);
//            }
//            if (invoice.getTotalTaxs().get(TaxType.ISC) != null) {
//                xmlInvoice.setTaxTotalTaxAmount(invoice.getTotalTaxs().get(TaxType.ISC), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxAmount(invoice.getTotalTaxs().get(TaxType.ISC), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.ISC);
//            }
//            if (invoice.getTotalTaxs().get(TaxType.OTROS) != null) {
//                xmlInvoice.setTaxTotalTaxAmount(invoice.getTotalTaxs().get(TaxType.OTROS), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxAmount(invoice.getTotalTaxs().get(TaxType.OTROS), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.OTROS);
//            }
//            xmlInvoice.setLegalMonetaryTotalPayableAmount(invoice.getTotalLegalMonetary().get(MonetaryTotalType.IMPORTE_TOTAL), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));

//            for (InvoiceLineModel e : invoice.getInvoiceLines()) {
//                XmlInvoiceDetails details = new XmlInvoiceDetails();
//                details.setId(String.valueOf(e.getOrderNumber()));
//                details.setInvoicedQuantity(e.getUnitCode(), e.getQuantity());
//                details.setLineExtensionAmount(CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()), e.getExtensionAmmount());
//                details.setPricingReferenceAlternativeConditionPricePriceAmount(CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()), e.getAmmount());
//                if (invoice.getAdditionalInformation().get(AdditionalInformationType.GRATUITO) != null)
//                    details.setPricingReferenceAlternativeConditionPricePriceTypeCode(AdditionalInformationType.GRATUITO);
//                if (invoice.getAdditionalInformation().get(AdditionalInformationType.EXONERADO) != null)
//                    details.setPricingReferenceAlternativeConditionPricePriceTypeCode(AdditionalInformationType.EXONERADO);
//                if (invoice.getAdditionalInformation().get(AdditionalInformationType.GRAVADO) != null)
//                    details.setPricingReferenceAlternativeConditionPricePriceTypeCode(AdditionalInformationType.GRAVADO);
//                if (invoice.getAdditionalInformation().get(AdditionalInformationType.INACFECTO) != null)
//                    details.setPricingReferenceAlternativeConditionPricePriceTypeCode(AdditionalInformationType.INACFECTO);
//
//                if (e.getTaxs().get(TaxType.IGV) != null) {
//                    details.setTaxTotalTaxAmount(e.getTaxs().get(TaxType.IGV), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxAmount(e.getTaxs().get(TaxType.IGV), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.IGV);
//                }
//                if (e.getTaxs().get(TaxType.ISC) != null) {
//                    details.setTaxTotalTaxAmount(e.getTaxs().get(TaxType.ISC), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxAmount(e.getTaxs().get(TaxType.ISC), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.ISC);
//                }
//                if (e.getTaxs().get(TaxType.OTROS) != null) {
//                    details.setTaxTotalTaxAmount(e.getTaxs().get(TaxType.OTROS), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxAmount(e.getTaxs().get(TaxType.OTROS), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                    details.setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType.OTROS);
//                }
//                details.setTaxTotalTaxSubtotalTaxCategoryTaxExemptionReasonCode(CodigoTipoAfectacionIgv.GRABADO_OPERACION_ONEROSA);
//
//                details.setItemDescription(e.getItemDescription());
//                details.setItemDescriptionSellersItemIdentificationId(e.getItemIdentification());
//                details.setPricePriceAmount(e.getPrice(), CurrencyCodeContentType.valueOf(invoice.getCurrencyCode()));
//                xmlInvoice.addInvoiceLine(details);
//            }

           /* xmlInvoice.generar(FileLocation.XmlInvoice.getLocation() + "20494637074-01-F001-1.xml");
            xmlInvoice.validar(FileLocation.XmlValidator.getLocation() + "UBLPE-Invoice-1.0.xsd");*/
//            xmlInvoice.generate(xmlPath);
//            xmlInvoice.validate(validatorPath);
            return  true;
        } catch (JAXBException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        } catch (Exception e) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, e);
            return  false;
        }
    }

    @Override
    public JAXBElement<InvoiceType> unCreateInvoice(String xmlPath) {
        try {

            File file = new File(xmlPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<InvoiceType> result = (JAXBElement<InvoiceType>) jaxbUnmarshaller.unmarshal(file);
            return result;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean signInvoice(String originalXmlPath, String destnSignedXmlPath, String pathJSK, String passwordJSK, String signatureIdJSK) {
        try {
            /*String xmlFilePath = FileLocation.XmlInvoice.getLocation() + "20494637074-01-F001-1.xml";
            String signedXmlPath = FileLocation.XmlSignature.getLocation() + "20494637074-01-F001-1.xml";
            String privateKeyPath = FileLocation.UrlKey.getLocation() + "private.key";
            String publicKeyPath = FileLocation.UrlKey.getLocation() + "public.key";*/

            SignatureXml xmlSig = new SignatureXml();
            xmlSig.generateXMLSignature(originalXmlPath, destnSignedXmlPath, pathJSK, passwordJSK, signatureIdJSK);
            return  true;
        } catch (KeyStoreException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        } catch (IOException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        } catch (CertificateException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (UnrecoverableEntryException ex) {
            Logger.getLogger(AdminStorageInvoice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean verifySignInvoice(String signedXmlPath,String pathJSK, String passwordJSK, String signatureIdJSK) {
      /*  String signedXmlPath = FileLocation.XmlSignature.getLocation() + "20494637074-01-F001-1.xml";
        String publicKeyPath = FileLocation.UrlKey.getLocation() + "public.key";*/
        try {
            boolean validFlag = SignatureXmlVerifier.isXmlSignatureValid(signedXmlPath, pathJSK,passwordJSK,signatureIdJSK);
            return validFlag;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createZipInvoice(String signedXmlPath, String zipPath, FileExtensionType fileExtensionType) {
        /*  String fileName = "20494637074-01-F001-1";
            String fileExtension = FileExtensionType.XML.getValue();*/
            LocalStorage localStorage = new LocalStorage();
            localStorage.createZip(signedXmlPath, zipPath, fileExtensionType);
            return  true;
    }

    @Override
    public void unZipInvoice() {

    }
}
