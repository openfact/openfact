package org.openfact.ubl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

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

public class DefaultUblSenderProvider implements UblSenderProvider {

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void send(OrganizationModel organization, InvoiceModel invoice, Document document)
            throws UblException {
        // TODO Auto-generated method stub
        
    }

   

}