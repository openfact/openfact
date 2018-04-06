package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.utils.ModelToJaxb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

@Stateless
public class JAXBManager {

//    @Inject
//    private FileProvider fileProvider;

//    @Inject
//    private JMSContext context;

//    @Resource(lookup = "/jms/topic/sunat-topic")
//    private Topic topic;

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, InformacionAdicionalModel informacionAdicional, BoletaModel boleta) {
        InvoiceType invoiceType = ModelToJaxb.toInvoiceType(organization, informacionAdicional, boleta);

        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(InvoiceType.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(jaxbElement, new File(""));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Guardar archivo xml
//        try {
//            fileProvider.addFile(null, null, null);
//        } catch (FileException e) {
//            e.printStackTrace();
//        }

        // Enviar a la sunat
//        JMSProducer send = context.createProducer().send(topic, "");
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildFactura(OrganizationModel organization, InformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        InvoiceType invoiceType = ModelToJaxb.toInvoiceType(organization, informacionAdicional, factura);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildNotaCredito(OrganizationModel organization, InformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory objectFactory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
    }
}
