package org.openfact.models.xml.ubl;

import org.openfact.models.InvoiceModel;
import org.openfact.models.xml.XmlInvoiceModel;
import org.openfact.models.xml.XmlInvoiceProvider;

public class UblXmlInvoiceProvider implements XmlInvoiceProvider {

    @Override
    public XmlInvoiceModel toXml(InvoiceModel invoice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    //
    // @Override
    // public InvoiceModel addInvoice(OrganizationModel organization,
    // InvoiceType type, String currencyCode, LocalDate issueDate) {
    // InvoiceModel invoice = this.getDelegate().addInvoice(organization, type,
    // currencyCode, issueDate);
    // String NameXml = invoice.getOrganization().getSupplierName() + "-" +
    // invoice.getInvoiceType().getCode() + invoice.getInvoiceId().getSeries() +
    // "-" + invoice.getInvoiceId().getNumber();
    // String xmlPath = FileLocation.XmlInvoice.getLocation() + NameXml +
    // FileExtensionType.XML.getValue();
    // String validatorPath = FileLocation.XmlValidator.getLocation() +
    // "UBLPE-Invoice-1.0.xsd";
    // String ublVersion = "2.1";
    // String customizationId = "1.0";
    // String signatureId = "IDSignOpenFact";
    // String referenceURI = "#SignatureOpenFact";
    // boolean creator = invoiceProvider.createInvoice(invoice, xmlPath,
    // validatorPath, ublVersion, customizationId, signatureId, referenceURI);
    // if (creator) {
    // String destnSignedXmlPath = FileLocation.XmlSignature.getLocation() +
    // NameXml + FileExtensionType.XML.getValue();
    // String privateKeyPath = FileLocation.UrlKey.getLocation() +
    // KeyLoaderType.PRIVATE_KEY_LOADER.getKeyLoader();
    // String pathJSK = FileLocation.KeyStore.getLocation()+ "openfact.jsk";
    // String passwordJSK = "123456";
    // String signatureIdJSK = "SignatureOpenFact";
    // boolean signature = invoiceProvider.signInvoice(xmlPath,
    // destnSignedXmlPath, pathJSK, passwordJSK, signatureIdJSK);
    // if (signature) {
    //
    // String zipPath = FileLocation.XmlSignature.getLocation() + NameXml;
    // boolean zip = invoiceProvider.createZipInvoice(destnSignedXmlPath,
    // zipPath, FileExtensionType.ZIP);
    // if (zip) {
    // System.out.printf("correct!!!");
    // } else {
    // System.out.println("Error creating ZIP file");
    // }
    // } else {
    // System.out.println("Error Signed XML");
    // }
    // } else {
    // System.out.println("Error creating XML");
    // }
    // return invoice;
    // }
    //
    // @Override
    // public InvoiceModel addInvoice(OrganizationModel organization, String id,
    // InvoiceType type, String currencyCode, LocalDate issueDate) {
    // InvoiceModel invoice = this.getDelegate().addInvoice(organization, id,
    // type, currencyCode, issueDate);
    // String NameXml = invoice.getOrganization().getSupplierName() + "-" +
    // invoice.getInvoiceType().getCode() + invoice.getInvoiceId().getSeries() +
    // "-" + invoice.getInvoiceId().getNumber();
    // String xmlPath = FileLocation.XmlInvoice.getLocation() + NameXml +
    // FileExtensionType.XML.getValue();
    // String validatorPath = FileLocation.XmlValidator.getLocation() +
    // "UBLPE-Invoice-1.0.xsd";
    // String ublVersion = "2.1";
    // String customizationId = "1.0";
    // String signatureId = "IDSignOpenFact";
    // String referenceURI = "#SignatureOpenFact";
    // boolean creator = invoiceProvider.createInvoice(invoice, xmlPath,
    // validatorPath, ublVersion, customizationId, signatureId, referenceURI);
    // if (creator) {
    // String destnSignedXmlPath = FileLocation.XmlSignature.getLocation() +
    // NameXml + FileExtensionType.XML.getValue();
    // String privateKeyPath = FileLocation.UrlKey.getLocation() +
    // KeyLoaderType.PRIVATE_KEY_LOADER.getKeyLoader();
    // String pathJSK = FileLocation.KeyStore.getLocation()+"openfact.jsk";
    //
    // String passwordJSK = "123456";
    // String signatureIdJSK = "SignatureOpenFact";
    // boolean signature = invoiceProvider.signInvoice(xmlPath,
    // destnSignedXmlPath, pathJSK, passwordJSK, signatureIdJSK);
    // if (signature) {
    //
    // String zipPath = FileLocation.XmlSignature.getLocation() + NameXml;
    // boolean zip = invoiceProvider.createZipInvoice(destnSignedXmlPath,
    // zipPath, FileExtensionType.ZIP);
    // if (zip) {
    // System.out.printf("correct!!!");
    // } else {
    // System.out.println("Error creating ZIP file");
    // }
    // } else {
    // System.out.println("Error Signed XML");
    // }
    // } else {
    // System.out.println("Error creating XML");
    // }
    // return invoice;
    // }

}