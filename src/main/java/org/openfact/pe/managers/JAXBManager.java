package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileInfoModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.InformacionAdicionalModel;
import org.openfact.pe.models.utils.ModelToJaxb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

@Stateless
public class JAXBManager {

    private static final Logger logger = Logger.getLogger(JAXBManager.class);

    @Inject
    private FileProvider fileProvider;

    @Inject
    private JMSContext jmsContext;

//    @Resource(lookup = "/jms/topic/sunat-topic")
//    private Topic topic;

    private <T> byte[] marshal(Class classToBeBound, JAXBElement<T> jaxbElement) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classToBeBound);
        Marshaller marshaller = jaxbContext.createMarshaller();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(jaxbElement, os);

        return os.toByteArray();
    }

    private FileInfoModel processBoletaFactura(InvoiceType invoiceType) throws JAXBException, FileException {
        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

        byte[] bytes = marshal(InvoiceType.class, jaxbElement);

        String fileId = ModelUtils.generateId() + ".xml";
        return fileProvider.addFile(fileId, bytes);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, InformacionAdicionalModel informacionAdicional, BoletaModel boleta) {
        InvoiceType invoiceType = ModelToJaxb.toInvoiceType(organization, informacionAdicional, boleta);

        try {
            FileInfoModel fileInfo = processBoletaFactura(invoiceType);

            boleta.setFileId(fileInfo.getFileName());
            boleta.setFileProvider(fileInfo.getProvider());
        } catch (JAXBException | FileException e) {
            // Nada que hacer
            return;
        }

        // Enviar a la SUNAT
        if (boleta.getEnviarSUNAT()) {
//            JMSProducer send = jmsContext.createProducer().send(topic, "");
        }
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
