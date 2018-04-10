package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileInfoModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.AbstractInvoiceModel;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.utils.ModelToJaxb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
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
    private CFXManager cfxManager;

    private <T> byte[] marshal(Class classToBeBound, JAXBElement<T> jaxbElement) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classToBeBound);
        Marshaller marshaller = jaxbContext.createMarshaller();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(jaxbElement, os);

        return os.toByteArray();
    }

    private void processBoletaFactura(InvoiceType invoiceType, AbstractInvoiceModel model) {
        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

        byte[] bytes;
        try {
            bytes = marshal(InvoiceType.class, jaxbElement);
        } catch (JAXBException e) {
            throw new IllegalStateException("No se pudo parsear el documento");
        }


        FileInfoModel fileInfo;
        try {
            String fileId = ModelUtils.generateId() + ".xml";
            fileInfo = fileProvider.addFile(fileId, bytes);
        } catch (FileException e) {
            throw new IllegalStateException("No se pudo guardar el archivo al sistema de almacenamiento");
        }

        model.setFileId(fileInfo.getFileName());
        model.setFileProvider(fileInfo.getProvider());

        // Enviar a la SUNAT
        if (model.getEnviarSUNAT()) {
            cfxManager.test();
        }
        cfxManager.test();
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, BoletaModel boleta) {
        InvoiceType invoiceType;
        try {
            invoiceType = ModelToJaxb.toBoletaType(organization, informacionAdicional, boleta);
        } catch (Throwable e) {
            boleta.setError("No se pudo crear el XML");
            return;
        }
        processBoletaFactura(invoiceType, boleta);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        InvoiceType invoiceType;
        try {
            invoiceType = ModelToJaxb.toFacturaType(organization, informacionAdicional, factura);
        } catch (Throwable e) {
            factura.setError("No se pudo crear el XML");
            return;
        }
        processBoletaFactura(invoiceType, factura);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildNotaCredito(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory objectFactory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
    }
}
