package org.openfact.ubl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.theme.ThemeProvider;
import org.openfact.ubl.UblTemplateProvider;

import org.w3c.dom.Document;

import com.helger.commons.io.resource.ClassPathResource;
import com.helger.ubl21.EUBL21DocumentType;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;
import com.helger.ubl21.UBL21WriterBuilder;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblXmlInvoiceProvider implements UblTemplateProvider {

    private OpenfactSession session;
    
    private OrganizationModel organization;
    private InvoiceModel invoice;
    private final Map<String, Object> attributes = new HashMap<>();
    
    public UblXmlInvoiceProvider(OpenfactSession session) {
       this.session = session;
    }       

    @Override
    public void close() {
        // TODO Auto-generated method stub      
    }

    @Override
    public UblTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public UblTemplateProvider setInvoice(InvoiceModel invoice) {
        this.invoice = invoice;
        return this;
    }

    @Override
    public UblTemplateProvider setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    @Override
    public void sendEvent(Event event) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("invoice", new ProfileBean(invoice));
        attributes.put("event", new EventBean(event));

        send(toCamelCase(event.getType()) + "Subject", "event-" + event.getType().toString().toLowerCase() + ".ftl", attributes);
    }

    @Override
    public void sendPasswordReset(String link, long expirationInMinutes) throws EmailException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendConfirmIdentityBrokerLink(String link, long expirationInMinutes) throws EmailException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendExecuteActions(String link, long expirationInMinutes) throws EmailException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendVerifyEmail(String link, long expirationInMinutes) throws EmailException {
        // TODO Auto-generated method stub
        
    }

    private void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException {
        send(subjectKey, Collections.emptyList(), template, attributes);
    }

    private void send(String subjectKey, List<Object> subjectAttributes, String template, Map<String, Object> attributes) throws EmailException {

    }

    private void send(String subject, String textBody, String htmlBody) throws UblException {
        UblSenderProvider ublSender = session.getProvider(UblSenderProvider.class);
        ublSender.send(organization, invoice, subject, textBody, htmlBody);
    }
    
    private String toCamelCase(EventType event){
        StringBuilder sb = new StringBuilder("event");
        for(String s : event.name().toString().toLowerCase().split("_")){
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }
    
//    @Override
//    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceType type, String currencyCode,
//            LocalDate issueDate) {
//        
//        String NameXml = invoice.getOrganization().getSupplierName() + "-"
//                + invoice.getType().getDocumentId() + invoice.getInvoiceId().getSeries() + "-"
//                + invoice.getInvoiceId().getNumber();
//        String xmlPath = FileLocation.XmlInvoice.getLocation() + NameXml + FileExtensionType.XML.getValue();
//        String validatorPath = FileLocation.XmlValidator.getLocation() + "UBLPE-Invoice-1.0.xsd";
//        String ublVersion = "2.1";
//        String customizationId = "1.0";
//        String signatureId = "IDSignOpenFact";
//        String referenceURI = "#SignatureOpenFact";
//        boolean creator = invoiceProvider.createInvoice(invoice, xmlPath, validatorPath, ublVersion,
//                customizationId, signatureId, referenceURI);
//        if (creator) {
//            String destnSignedXmlPath = FileLocation.XmlSignature.getLocation() + NameXml
//                    + FileExtensionType.XML.getValue();
//            String privateKeyPath = FileLocation.UrlKey.getLocation()
//                    + KeyLoaderType.PRIVATE_KEY_LOADER.getKeyLoader();
//            String pathJSK = FileLocation.KeyStore.getLocation() + "openfact.jsk";
//            String passwordJSK = "123456";
//            String signatureIdJSK = "SignatureOpenFact";
//            boolean signature = invoiceProvider.signInvoice(xmlPath, destnSignedXmlPath, pathJSK, passwordJSK,
//                    signatureIdJSK);
//            if (signature) {
//
//                String zipPath = FileLocation.XmlSignature.getLocation() + NameXml;
//                boolean zip = invoiceProvider.createZipInvoice(destnSignedXmlPath, zipPath,
//                        FileExtensionType.ZIP);
//                if (zip) {
//                    System.out.printf("correct!!!");
//                } else {
//                    System.out.println("Error creating ZIP file");
//                }
//            } else {
//                System.out.println("Error Signed XML");
//            }
//        } else {
//            System.out.println("Error creating XML");
//        }
//        return invoice;
//    }

//    @Override
//    public InvoiceModel addInvoice(OrganizationModel organization, String id, InvoiceType type,
//            String currencyCode, LocalDate issueDate) {
//        InvoiceModel invoice = this.getDelegate().addInvoice(organization, id, type, currencyCode, issueDate);
//        String NameXml = invoice.getOrganization().getSupplierName() + "-"
//                + invoice.getInvoiceType().getCode() + invoice.getInvoiceId().getSeries() + "-"
//                + invoice.getInvoiceId().getNumber();
//        String xmlPath = FileLocation.XmlInvoice.getLocation() + NameXml + FileExtensionType.XML.getValue();
//        String validatorPath = FileLocation.XmlValidator.getLocation() + "UBLPE-Invoice-1.0.xsd";
//        String ublVersion = "2.1";
//        String customizationId = "1.0";
//        String signatureId = "IDSignOpenFact";
//        String referenceURI = "#SignatureOpenFact";
//        boolean creator = invoiceProvider.createInvoice(invoice, xmlPath, validatorPath, ublVersion,
//                customizationId, signatureId, referenceURI);
//        if (creator) {
//            String destnSignedXmlPath = FileLocation.XmlSignature.getLocation() + NameXml
//                    + FileExtensionType.XML.getValue();
//            String privateKeyPath = FileLocation.UrlKey.getLocation()
//                    + KeyLoaderType.PRIVATE_KEY_LOADER.getKeyLoader();
//            String pathJSK = FileLocation.KeyStore.getLocation() + "openfact.jsk";
//
//            String passwordJSK = "123456";
//            String signatureIdJSK = "SignatureOpenFact";
//            boolean signature = invoiceProvider.signInvoice(xmlPath, destnSignedXmlPath, pathJSK, passwordJSK,
//                    signatureIdJSK);
//            if (signature) {
//
//                String zipPath = FileLocation.XmlSignature.getLocation() + NameXml;
//                boolean zip = invoiceProvider.createZipInvoice(destnSignedXmlPath, zipPath,
//                        FileExtensionType.ZIP);
//                if (zip) {
//                    System.out.printf("correct!!!");
//                } else {
//                    System.out.println("Error creating ZIP file");
//                }
//            } else {
//                System.out.println("Error Signed XML");
//            }
//        } else {
//            System.out.println("Error creating XML");
//        }
//        return invoice;
//    }

}