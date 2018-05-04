package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import org.jboss.logging.Logger;
import org.openfact.core.files.FileException;
import org.openfact.core.files.FileModel;
import org.openfact.core.files.FileProvider;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.core.utils.files.UncompressFileProvider;
import org.openfact.core.utils.files.UncompressFileProviderFactory;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.JaxbUtils;
import org.openfact.pe.sunat.SendSunatException;
import org.openfact.pe.sunat.SunatSenderProvider;
import org.w3c.dom.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

@Transactional
@ApplicationScoped
public class SunatManager {

    private static final Logger logger = Logger.getLogger(SunatManager.class);

    @Inject
    private FileProvider fileProvider;

    @Inject
    private SunatSenderProvider sunatSenderProvider;

    @Inject
    private OrganizationInformacionSunatProvider orgSunatInfoProvider;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean enviarInvoice(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, InvoiceModel invoice, FileModel invoiceFile) {
//        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
//        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
//            guardarDatosInvalidosEndpoint(invoice.getEstadoSunat());
//            return false;
//        }
//
//        if (isAdditionalInfoInvalid(additionalInfo)) {
//            guardarDatosInvalidosOrganizacion(invoice.getEstadoSunat());
//            return false;
//        }
//
//        String nombreDocumento = additionalInfo.getAssignedId() + "-" + invoice.getCodigoTipoComprobante() + "-" + invoice.getSerie() + "-" + invoice.getNumero();
//
//        byte[] sunatResponse;
//        try {
//            sunatResponse = sendBill(additionalInfo, orgSunatInfo, nombreDocumento, invoiceFile.getBytes());
//        } catch (IOException e) {
//            throw new ModelRuntimeException(e);
//        } catch (SendSunatException e) {
//            guardarEnvioInvalido(invoice.getEstadoSunat(), e);
//            return false;
//        }
//
//        // Leer cdr
//        try {
//            AbstractMap.SimpleEntry<String, String> codigoDescripcion = leerCodigoYDescripcionDesdeCdrZipeado(sunatResponse);
//
//            EstadoSunatModel estadoSunat = invoice.getEstadoSunat();
//            estadoSunat.setCodigo(codigoDescripcion.getKey());
//            estadoSunat.setDescripcion(codigoDescripcion.getValue());
//
//            if (codigoDescripcion.getKey().equals("0")) {
//                invoice.setEstado(EstadoComprobantePago.CERRADO);
//            }
//        } catch (Exception e) {
//            logger.error(e);
//            EstadoSunatModel estadoSunat = invoice.getEstadoSunat();
//            estadoSunat.setCodigo("-1");
//            estadoSunat.setDescripcion("No se pudo leer el codigo de respuesta del cdr de respuesta");
//        }
//
//        // Guardar cdr
//        try {
//            String fileName = ModelUtils.generateId() + ".zip";
//            FileModel cdrFile = fileProvider.addFile(fileName, sunatResponse);
//            invoice.setCdrFileId(cdrFile.getFileName());
//        } catch (FileException e) {
//            logger.error(e);
//        }
//
//        // Validacion
//        EstadoSunatModel estadoSunat = invoice.getEstadoSunat();
//        estadoSunat.setEstado(true);
//        estadoSunat.setError(null);
//        estadoSunat.setErrorDescripcion(null);

        return true;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean enviarNota(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, NotaModel nota, FileModel notaFile) {
//        OrganizacionInformacionSunatModel orgSunatInfo = getInformacionSunat(organization);
//        if (orgSunatInfo.getBoletaFacturaEndpoint() == null) {
//            guardarDatosInvalidosEndpoint(nota.getEstadoSunat());
//            return false;
//        }
//
//        if (isAdditionalInfoInvalid(additionalInfo)) {
//            guardarDatosInvalidosOrganizacion(nota.getEstadoSunat());
//            return false;
//        }
//
//        String nombreDocumento = additionalInfo.getAssignedId() + "-" + nota.getCodigoTipoComprobante() + "-" + nota.getSerie() + "-" + nota.getNumero();
//
//        byte[] sunatResponse;
//        try {
//            sunatResponse = sendBill(additionalInfo, orgSunatInfo, nombreDocumento, notaFile.getBytes());
//        } catch (IOException e) {
//            throw new ModelRuntimeException(e);
//        } catch (SendSunatException e) {
//            guardarEnvioInvalido(nota.getEstadoSunat(), e);
//            return false;
//        }
//
//        // Leer cdr
//        try {
//            AbstractMap.SimpleEntry<String, String> codigoDescripcion = leerCodigoYDescripcionDesdeCdrZipeado(sunatResponse);
//            if (codigoDescripcion.getKey().equals("0")) {
//                nota.setEstado(EstadoComprobantePago.CERRADO);
//                nota.setEstadoDescripcion(codigoDescripcion.getValue());
//            }
//        } catch (Exception e) {
//            logger.error(e);
//            EstadoSunatModel validacion = nota.getEstadoSunat();
//            validacion.setError(Labels.error_al_leer_cdr);
//            validacion.setErrorDescripcion("No se pudo leer el codigo de respuesta del cdr de respuesta");
//        }
//
//        // Guardar cdr
//        try {
//            String fileName = ModelUtils.generateId() + ".zip";
//            FileModel cdrFile = fileProvider.addFile(fileName, sunatResponse);
//            nota.setCdrFileId(cdrFile.getFileName());
//        } catch (FileException e) {
//            logger.error(e);
//        }
//
        return true;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean enviarBaja(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BajaModel baja, FileModel bajaFile) {
        return false;
    }

    private byte[] sendBill(
            OrganizacionInformacionAdicionalModel additionalInfo,
            OrganizacionInformacionSunatModel orgSunatInfo,
            String fileName,
            byte[] xmlDocumentBytes) throws IOException, SendSunatException {

        byte[] zipFile = ZipBuilder.createZipInMemory()
                .add(xmlDocumentBytes)
                .path(fileName + ".xml")
                .save()
                .toBytes();

        return sunatSenderProvider.sendBill(additionalInfo, orgSunatInfo, fileName + ".zip", zipFile);
    }

    //

//    private void guardarDatosInvalidosOrganizacion(EstadoSunatModel validacion) {
//        validacion.setEstado(false);
//        validacion.setError(Labels.datos_organizacion_imcompletos);
//        validacion.setErrorDescripcion("Envío Sunat - Datos de organización incompletos");
//    }
//
//    private void guardarDatosInvalidosEndpoint(EstadoSunatModel validacion) {
//        validacion.setEstado(false);
//        validacion.setError(Labels.endpoint_organizacion_imcompletos);
//        validacion.setErrorDescripcion("Envío Sunat - La organización no tiene endpoins configurados válidos");
//    }
//
//    private void guardarEnvioInvalido(EstadoSunatModel validacion, SendSunatException e) {
//        String errorMessage = e.getMessage().trim();
//        errorMessage = errorMessage.substring(0, Math.min(errorMessage.length(), 400));
//
//        validacion.setEstado(false);
//        validacion.setError(Labels.error_envio_sunat);
//        validacion.setErrorDescripcion("Envío Sunat - " + errorMessage);
//    }
//
//    private boolean isAdditionalInfoInvalid(OrganizacionInformacionAdicionalModel additionalInfo) {
//        String ruc = additionalInfo.getAssignedId();
//        return ruc == null || ruc.trim().isEmpty();
//    }

    private OrganizacionInformacionSunatModel getInformacionSunat(OrganizationModel organization) {
        OrganizacionInformacionSunatModel orgSunatInfo = orgSunatInfoProvider.getOrganizacionInformacionSunat(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización:" + organization.getId()));
        if (orgSunatInfo.isUseCustomConfig()) {
            return orgSunatInfo;
        } else {
            return orgSunatInfoProvider.getOrganizacionInformacionSunat(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización master"));
        }
    }

    // Cdr

    private AbstractMap.SimpleEntry<String, String> leerCodigoYDescripcionDesdeCdrZipeado(byte[] cdrZipBytes) throws Exception {
        Document document = extraerCdrDesdeZip(cdrZipBytes);
        String code = document.getElementsByTagName("cbc:ResponseCode").item(0).getTextContent();
        String description = document.getElementsByTagName("cbc:Description").item(0).getTextContent();
        if (code == null || description == null) {
            throw new Exception("No se pudo leer ResponseCode y/o Description");
        }
        return new AbstractMap.SimpleEntry<>(code, description);
    }

    private static Document extraerCdrDesdeZip(byte[] sunatResponse) throws Exception {
        UncompressFileProviderFactory factory = UncompressFileProviderFactory.getInstance();
        UncompressFileProvider provider = factory.getProvider("zip").orElseThrow(() -> new Exception("No provider for zip file"));
        Map<String, byte[]> entries = provider.uncompress(sunatResponse);
        for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
            byte[] bytes = entry.getValue();
            return JaxbUtils.toDocument(bytes);
        }
        throw new Exception("No se encontró un cdr que leer");
    }

}
