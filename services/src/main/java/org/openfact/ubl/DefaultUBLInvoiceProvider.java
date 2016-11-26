package org.openfact.ubl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.FileModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.UserSenderModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class DefaultUBLInvoiceProvider implements UBLInvoiceProvider {

    protected OpenfactSession session;

    public DefaultUBLInvoiceProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public UBLIDGenerator<InvoiceType> idGenerator() {
        return new UBLIDGenerator<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public String generateID(OrganizationModel organization, InvoiceType t) {
                return OpenfactModelUtils.generateId();
            }
        };
    }

    @Override
    public UBLReader<InvoiceType> reader() {
        return new UBLReader<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public InvoiceType read(Document document) {
                return UBL21Reader.invoice().read(document);
            }

            @Override
            public InvoiceType read(byte[] bytes) {
                return UBL21Reader.invoice().read(bytes);
            }
        };
    }

    @Override
    public UBLWriter<InvoiceType> writer() {
        return new UBLWriter<InvoiceType>() {
            @Override
            public void close() {
            }

            @Override
            public Document write(OrganizationModel organization, InvoiceType t) {
                return UBL21Writer.invoice().getAsDocument(t);
            }

            @Override
            public Document write(OrganizationModel organization, InvoiceType t,
                    Map<String, String> attributes) {
                return UBL21Writer.invoice().getAsDocument(t);
            }
        };
    }

    @Override
    public UBLSender<InvoiceModel> sender() {
        return new UBLSender<InvoiceModel>() {           
            
            @Override
            public void close() {
            }

            @Override
            public SendEventModel sendToCustomer(OrganizationModel organization, InvoiceModel invoice) throws SendException {                               
                CustomerPartyModel customerParty = invoice.getAccountingCustomerParty();                
                if(customerParty == null || customerParty.getParty() == null || customerParty.getParty().getContact() == null || customerParty.getParty().getContact().getElectronicMail() == null) {
                    return null;
                }
                
                // User where the email will be send
                UserSenderModel user = new UserSenderModel() {                                                         
                    @Override
                    public String getFullName() {
                        List<PartyLegalEntityModel> partyLegalEntities = customerParty.getParty().getPartyLegalEntity();
                        return partyLegalEntities.stream().map(f -> f.getRegistrationName()).reduce((t,u) -> t + "," +u).get();
                    }                                                           
                    @Override
                    public String getEmail() {
                        return customerParty.getParty().getContact().getElectronicMail();
                    }
                }; 
                
                // Attatchments
                FileModel file = new FileModel();
                file.setFileName(invoice.getDocumentId());
                file.setFile(invoice.getXmlDocument());
                file.setMimeType("application/xml");
                
                try {
                    session.getProvider(EmailTemplateProvider.class)
                            .setOrganization(organization)
                            .setUser(user).setAttachments(new ArrayList<>(Arrays.asList(file)))
                            .sendInvoice(invoice);
                    
                    // Write event to the database
                    SendEventModel sendEvent = session.getProvider(SendEventProvider.class)
                            .addSendEvent(organization, SendResultType.SUCCESS, invoice);
                    sendEvent.setDescription("Invoice Sended by Email");
                    
                    return sendEvent;
                } catch (EmailException e) {
                    throw new SendException(e);
                }
            }

            @Override
            public SendEventModel sendToThridParty(OrganizationModel organization, InvoiceModel t) throws SendException {
                return null;
            }
            
        };
    }

}
