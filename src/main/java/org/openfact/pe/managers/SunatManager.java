package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.core.utils.files.UncompressFileProvider;
import org.openfact.core.utils.files.UncompressFileProviderFactory;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoComprobante;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.JaxbUtils;
import org.openfact.pe.models.utils.SunatUtils;
import org.w3c.dom.Document;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Stateless
public class SunatManager {

    private static final Logger logger = Logger.getLogger(SunatManager.class);

    @Inject
    private FileProvider fileProvider;

    @Inject
    private SunatSenderProvider sunatSenderProvider;

    @Inject
    private OrganizationInformacionSunatProvider orgSunatInfoProvider;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean enviarBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BoletaModel boleta, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            logger.warnf("La organización no tienen los datos mínimos para enviar a la SUNAT");
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            logger.warn("Endpoint de boletas y facturas no existe");
            return false;
        }

        String nombreDocumento = additionalInfo.getAssignedId() + "-" + TipoInvoice.BOLETA.getCodigo() + "-" + SunatUtils.getSerieConCerosCompletados(boleta.getSerie(), 4) + "-" + boleta.getNumero();

        byte[] zipFile;
        try {
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(nombreDocumento + ".xml")
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new ModelRuntimeException("No se pudo crear el zip");
        }

        byte[] sunatResponse;
        try {
            sunatResponse = sunatSenderProvider.sendBill(additionalInfo, orgSunatInfo, nombreDocumento + ".zip", zipFile);
        } catch (SendSunatException e) {
            return false;
        }
        guardarCdr(boleta, sunatResponse);
        procesarCdr(boleta, sunatResponse);

        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean enviarFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, FacturaModel factura, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            logger.warnf("La organización no tienen los datos mínimos para enviar a la SUNAT");
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            logger.warn("Endpoint de boletas y facturas no existe");
            return false;
        }

        String nombreDocumento = additionalInfo.getAssignedId() + "-" + TipoInvoice.FACTURA.getCodigo() + "-" + SunatUtils.getSerieConCerosCompletados(factura.getSerie(), 4) + "-" + factura.getNumero();

        byte[] zipFile;
        try {
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(nombreDocumento + ".xml")
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new ModelRuntimeException("No se pudo crear el zip");
        }

        byte[] sunatResponse;
        try {
            sunatResponse = sunatSenderProvider.sendBill(additionalInfo, orgSunatInfo, nombreDocumento + ".zip", zipFile);
        } catch (SendSunatException e) {
            return false;
        }
        guardarCdr(factura, sunatResponse);
        procesarCdr(factura, sunatResponse);

        return true;
    }

    public boolean enviarCreditNote(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, CreditNoteModel creditNote, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            logger.warnf("La organización no tienen los datos mínimos para enviar a la SUNAT");
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            logger.warn("Endpoint de boletas y facturas no existe");
            return false;
        }

        String nombreDocumento = additionalInfo.getAssignedId() + "-" + TipoComprobante.NOTA_CREDITO.getCodigo() + "-" + SunatUtils.getSerieConCerosCompletados(creditNote.getSerie(), 4) + "-" + creditNote.getNumero();

        byte[] zipFile;
        try {
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(nombreDocumento + ".xml")
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new ModelRuntimeException("No se pudo crear el zip");
        }

        byte[] sunatResponse;
        try {
            sunatResponse = sunatSenderProvider.sendBill(additionalInfo, orgSunatInfo, nombreDocumento + ".zip", zipFile);
        } catch (SendSunatException e) {
            return false;
        }
        guardarCdr(creditNote, sunatResponse);
        procesarCdr(creditNote, sunatResponse);

        return true;
    }

    public boolean enviarDebitNote(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, DebitNoteModel debitNote, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            logger.warnf("La organización no tienen los datos mínimos para enviar a la SUNAT");
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            logger.warn("Endpoint de boletas y facturas no existe");
            return false;
        }

        String nombreDocumento = additionalInfo.getAssignedId() + "-" + TipoComprobante.NOTA_DEBITO.getCodigo() + "-" + SunatUtils.getSerieConCerosCompletados(debitNote.getSerie(), 4) + "-" + debitNote.getNumero();

        byte[] zipFile;
        try {
            zipFile = ZipBuilder.createZipInMemory()
                    .add(file.getBytes())
                    .path(nombreDocumento + ".xml")
                    .save()
                    .toBytes();
        } catch (IOException e) {
            throw new ModelRuntimeException("No se pudo crear el zip");
        }

        byte[] sunatResponse;
        try {
            sunatResponse = sunatSenderProvider.sendBill(additionalInfo, orgSunatInfo, nombreDocumento + ".zip", zipFile);
        } catch (SendSunatException e) {
            return false;
        }
        guardarCdr(debitNote, sunatResponse);
        procesarCdr(debitNote, sunatResponse);

        return true;
    }

    private boolean isAdditionalInfoInvalid(OrganizacionInformacionAdicionalModel additionalInfo) {
        String ruc = additionalInfo.getAssignedId();
        return ruc == null || ruc.trim().isEmpty();
    }

    private OrganizacionInformacionSunatModel getInformacionSunat(OrganizationModel organization) {
        OrganizacionInformacionSunatModel orgSunatInfo = orgSunatInfoProvider.getOrganizacionInformacionSunat(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización:" + organization.getId()));
        if (orgSunatInfo.isUseCustomConfig()) {
            return orgSunatInfo;
        } else {
            return orgSunatInfoProvider.getOrganizacionInformacionSunat(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización master"));
        }
    }

    private void procesarCdr(DocumentoModel documentoModel, byte[] sunatResponse) {
        try {
            Document document = readCdr(sunatResponse).orElseThrow(() -> new ModelRuntimeException("No se encontró cdr que leer"));
            String code = document.getElementsByTagName("cbc:ResponseCode").item(0).getTextContent();
            String description = document.getElementsByTagName("cbc:Description").item(0).getTextContent();
            if (code.equals("0")) {
                documentoModel.setEstado(EstadoComprobantePago.REGISTRADO);
                documentoModel.setEstadoDescripcion(description);
            }
        } catch (Exception e) {
            throw new ModelRuntimeException();
        }
    }

    private void guardarCdr(DocumentoModel documentModel, byte[] bytes) {
        try {
            String fileName = ModelUtils.generateId() + ".zip";
            FileModel file = fileProvider.addFile(fileName, bytes);
            documentModel.setCdrFileId(file.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar un archivo en el storage");
        }
    }

    private static Optional<Document> readCdr(byte[] sunatResponse) throws Exception {
        UncompressFileProviderFactory factory = UncompressFileProviderFactory.getInstance();
        UncompressFileProvider provider = factory.getProvider("zip").orElseThrow(() -> new ModelRuntimeException("No provider for zip file"));
        Map<String, byte[]> entries = provider.uncompress(sunatResponse);
        for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
            byte[] bytes = entry.getValue();
            return Optional.of(JaxbUtils.toDocument(bytes));
        }
        return Optional.empty();
    }

}
