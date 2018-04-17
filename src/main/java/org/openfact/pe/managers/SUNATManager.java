package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.files.FileException;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.SUNATUtils;

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
    private SunatProvider sunatProvider;

    @Inject
    private FinishDocumentManager finishDocumentManager;

    private DocumentoResponse leerCDR(byte[] bytes) {
        return null;
    }


    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void enviarBoleta(BoletaModel boleta, FileModel file) {
//        if (!boleta.getEstado().equals(EstadoComprobantePago.NO_REGISTRADO)) {
//            logger.warnf("Documento Serie %s y Numero %s ya fue registrado previamente en la SUNAT", boleta.getSerie(), boleta.getNumero());
//            return;
//        }
//
//        byte[] zipFile;
//        String zipFilename = boleta.getSerie() + "-" + boleta.getNumero() + ".zip";
//        try {
//            String xmlFileName = boleta.getSerie() + "-" + boleta.getNumero() + ".xml";
//            zipFile = ZipBuilder.createZipInMemory()
//                    .add(file.getBytes())
//                    .path(xmlFileName)
//                    .save()
//                    .toBytes();
//        } catch (IOException e) {
//            throw new RuntimeException("No se pudo crear el zip");
//        }
//
//
//        byte[] responseBytes = sunatProvider.sendBill(zipFilename, zipFile);
//        DocumentoResponse documentoResponse = leerCDR(responseBytes);
//
//        if (documentoResponse.getResponseCode().equals("0")) {
//            try {
//                FileModel cdrFile = fileProvider.addFile("cdr.xml", responseBytes);
//                boleta.setCdrFileId(cdrFile.getFileName());
//            } catch (FileException e) {
//                e.printStackTrace();
//            }
//        } else {
//
//        }
//
//        finishDocumentManager.processBoleta(boleta);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void enviarFactura(OrganizacionInformacionAdicionalModel informacionAdicional, FacturaModel factura, FileModel file) {
        if (!factura.getEstado().equals(EstadoComprobantePago.NO_REGISTRADO)) {
            logger.warnf("Documento Serie %s y Numero %s ya fue registrado previamente en la SUNAT", factura.getSerie(), factura.getNumero());
            return;
        }

        String ruc = informacionAdicional.getAssignedId();
        if (ruc == null || ruc.trim().isEmpty()) {
            return;
        }

        String tipoComprobante = TipoInvoice.FACTURA.getCodigo();
        String serie = SUNATUtils.getSerieConCerosCompletados(factura.getSerie());
        Integer numero = factura.getNumero();
        final String documentName = ruc + "-" + tipoComprobante + "-" + serie + "-" + numero;

        byte[] zipFile;
        try {
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(documentName + ".xml")
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el zip");
        }

        byte[] responseBytes;
        try {
            responseBytes = sunatProvider.sendBill(documentName + ".zip", zipFile);
        } catch (SendSunatException e) {
//            factura.addToHistorialEnviosSunat(EstadoEnvio.ERROR, e.codigo, e.descripcion);
            System.out.println(e);
            return;
        }

        DocumentoResponse documentoResponse = leerCDR(responseBytes);

        if (documentoResponse.getResponseCode().equals("0")) {
            try {
                FileModel cdrFile = fileProvider.addFile("cdr.xml", responseBytes);
                factura.setCdrFileId(cdrFile.getFileName());
            } catch (FileException e) {
                e.printStackTrace();
            }
        } else {

        }

        finishDocumentManager.processFactura(factura);

    }

}
