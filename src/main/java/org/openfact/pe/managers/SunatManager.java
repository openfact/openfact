package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class SunatManager {

    private static final Logger logger = Logger.getLogger(SunatManager.class);

    @Inject
    private FileProvider fileProvider;

    @Inject
    private SunatSenderProvider sunatSenderProvider;

    @Inject
    private OrganizationInformacionSunatProvider orgSunatInfoProvider;

    public boolean enviarBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BoletaModel boleta, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            guardarDatosInvalidosOrganizacion(boleta.getValidacion());
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            guardarDatosInvalidosEndpoint(boleta.getValidacion());
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
            procesarErrorEnEnvioSunat(boleta.getValidacion(), e);
            return false;
        }

        guardarCdr(boleta, sunatResponse);
        procesarCdr(boleta, sunatResponse);

        return true;
    }

    public boolean enviarFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, FacturaModel factura, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            guardarDatosInvalidosOrganizacion(factura.getValidacion());
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            guardarDatosInvalidosEndpoint(factura.getValidacion());
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
            procesarErrorEnEnvioSunat(factura.getValidacion(), e);
            return false;
        }

        guardarCdr(factura, sunatResponse);
        procesarCdr(factura, sunatResponse);

        return true;
    }

    public boolean enviarCreditNote(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, CreditNoteModel creditNote, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            guardarDatosInvalidosOrganizacion(creditNote.getValidacion());
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            guardarDatosInvalidosEndpoint(creditNote.getValidacion());
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
            procesarErrorEnEnvioSunat(creditNote.getValidacion(), e);
            return false;
        }

        guardarCdr(creditNote, sunatResponse);
        procesarCdr(creditNote, sunatResponse);

        return true;
    }

    public boolean enviarDebitNote(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, DebitNoteModel debitNote, FileModel file) {
        if (isAdditionalInfoInvalid(additionalInfo)) {
            guardarDatosInvalidosOrganizacion(debitNote.getValidacion());
            return false;
        }

        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
            guardarDatosInvalidosEndpoint(debitNote.getValidacion());
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
            procesarErrorEnEnvioSunat(debitNote.getValidacion(), e);
            return false;
        }
        guardarCdr(debitNote, sunatResponse);
        procesarCdr(debitNote, sunatResponse);

        return true;
    }

    //

    private void guardarDatosInvalidosOrganizacion(ValidacionModel validacion) {
        validacion.setEstado(false);
        validacion.setError(ErrorType.datos_organizacion_imcompletos);
        validacion.setErrorDescripcion("Envío Sunat - Datos de organización incompletos");
    }

    private void guardarDatosInvalidosEndpoint(ValidacionModel validacion) {
        validacion.setEstado(false);
        validacion.setError(ErrorType.endpoint_organizacion_imcompletos);
        validacion.setErrorDescripcion("Envío Sunat - La organización no tiene endpoins configurados válidos");
    }

    private void procesarErrorEnEnvioSunat(ValidacionModel validacion, SendSunatException e) {
        String errorMessage = e.getMessage().trim();
        errorMessage = errorMessage.substring(0, Math.min(errorMessage.length(), 400));

        validacion.setEstado(false);
        validacion.setError(ErrorType.error_envio_sunat);
        validacion.setErrorDescripcion("Envío Sunat - " + errorMessage);
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
                documentoModel.setEstado(EstadoComprobantePago.CERRADO);
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
