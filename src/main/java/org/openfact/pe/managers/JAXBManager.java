package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.KeyManager;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.utils.JaxbUtils;
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
import java.security.cert.X509Certificate;

@Stateless
public class JAXBManager {

    private static final Logger logger = Logger.getLogger(JAXBManager.class);

    @Inject
    private KeyManager keystore;

    @Inject
    private SUNATManager sunatManager;

    @Inject
    private FileProvider fileProvider;



    private FileModel processBoletaFactura(InvoiceType invoiceType) {
        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

        byte[] bytes;
        try {
            bytes = JaxbUtils.marshalToBytes(InvoiceType.class, jaxbElement);
        } catch (JAXBException e) {
            throw new IllegalStateException("No se pudo parsear el documento");
        }


        FileModel file;
        try {
            String fileId = "Invoice_" + ModelUtils.generateId() + ".xml";
            file = fileProvider.addFile(fileId, bytes);
        } catch (FileException e) {
            throw new IllegalStateException("No se pudo guardar el archivo al sistema de almacenamiento");
        }

        return file;
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, BoletaModel boleta) {
        KeyManager.ActiveRsaKey activeRsaKey = keystore.getActiveRsaKey(organization);
        X509Certificate certificate = activeRsaKey.getCertificate();

        InvoiceType invoiceType;
        try {
            invoiceType = ModelToJaxb.toBoletaType(organization, informacionAdicional, boleta, certificate);
        } catch (Throwable e) {
            boleta.setError("No se pudo crear el XML");
            return;
        }

        FileModel file = processBoletaFactura(invoiceType);
        boleta.setFileId(file.getFileName());

        // Enviar a la SUNAT
        if (boleta.getEnviarSUNAT()) {
            sunatManager.enviarBoleta(boleta, file);
        }
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        KeyManager.ActiveRsaKey activeRsaKey = keystore.getActiveRsaKey(organization);
        X509Certificate certificate = activeRsaKey.getCertificate();

        InvoiceType invoiceType;
        try {
            invoiceType = ModelToJaxb.toFacturaType(organization, informacionAdicional, factura, certificate);
        } catch (Throwable e) {
            factura.setError("No se pudo crear el XML");
            return;
        }

        FileModel file = processBoletaFactura(invoiceType);
        factura.setFileId(file.getFileName());

        // Enviar a la SUNAT
        if (factura.getEnviarSUNAT()) {
            sunatManager.enviarFactura(informacionAdicional, factura, file);
        }
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildNotaCredito(OrganizationModel organization, OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura) {
        oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory objectFactory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
    }
}
