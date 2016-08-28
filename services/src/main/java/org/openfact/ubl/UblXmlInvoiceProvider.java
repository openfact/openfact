package org.openfact.ubl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openfact.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblXmlInvoiceProvider implements UblTemplateProvider {

    private OpenfactSession session;
    
    private OrganizationModel organization;
    private InvoiceModel invoice;
    private final Map<String, Object> attributes = new HashMap<>();
    
    private InvoiceType ubl;
    
    public UblXmlInvoiceProvider(OpenfactSession session) {
        this.ubl = new InvoiceType();
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

        //send(toCamelCase(event.getType()) + "Subject", "event-" + event.getType().toStaDoc2ring().toLowerCase() + ".ftl", attributes);
    }

    @Override
    public void sendPasswordReset(String link, long expirationInMinutes) throws EmailException {
        // TODO Auto-generated method stub
        final Document aDoc2 = UBL21Writer.invoice ().getAsDocument (ubl);
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
    

}