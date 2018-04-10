package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.files.FileException;
import org.openfact.pe.models.*;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.IOException;

@Stateless
public class SUNATManager {

    private static final Logger logger = Logger.getLogger(SUNATManager.class);

    @Inject
    private FileProvider fileProvider;

    @Inject
    private SUNATProvider sunatProvider;

    @Inject
    private FinishDocumentManager finishDocumentManager;

    private DocumentoResponse to(byte[] bytes) {
        return null;
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void enviarBoleta(BoletaModel boleta, FileModel file) {
        if (!boleta.getEstado().equals(EstadoComprobantePago.NO_REGISTRADO)) {
            logger.warnf("Documento Serie %s y Numero %s ya fue registrado previamente en la SUNAT", boleta.getSerie(), boleta.getNumero());
            return;
        }

        byte[] zipFile;
        String zipFilename = boleta.getSerie() + "-" + boleta.getNumero() + ".zip";
        try {
            String xmlFileName = boleta.getSerie() + "-" + boleta.getNumero() + ".xml";
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(xmlFileName)
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el zip");
        }


        byte[] responseBytes = sunatProvider.sendBill(zipFilename, zipFile);
        DocumentoResponse documentoResponse = to(responseBytes);

        if (documentoResponse.getResponseCode().equals("0")) {
            try {
                FileModel cdrFile = fileProvider.addFile("cdr.xml", responseBytes);
                boleta.setCdrFileId(cdrFile.getFileName());
            } catch (FileException e) {
                e.printStackTrace();
            }
        } else {

        }

        finishDocumentManager.processBoleta(boleta);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void enviarFactura(FacturaModel factura, FileModel file) {

    }

}
