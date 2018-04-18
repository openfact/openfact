package org.openfact.pe.managers;

import jodd.io.ZipBuilder;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ResponseType;
import org.jboss.logging.Logger;
import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.SunatUtils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.IOException;

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
    public ResponseType enviarBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BoletaModel boleta, FileModel file) {
        String ruc = additionalInfo.getAssignedId();
        if (ruc == null || ruc.trim().isEmpty()) {
            throw new ModelRuntimeException("Datos de Organización incompletos");
        }

        OrganizacionInformacionSunatModel orgSunatInfo = orgSunatInfoProvider.getOrganizacionInformacionSUNAT(organization)
                .orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización:" + organization.getId()));

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
            throw new ModelRuntimeException("No se pudo enviar a la SUNAT error:" + e.getMessage());
        }

        ResponseType responseType = SunatUtils.readCdr(sunatResponse);
        if (responseType.getResponseCode().getValue().equals("0")) {
            guardarInvoiceCdrFile(boleta, sunatResponse);
        }

        return responseType;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ResponseType enviarFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, FacturaModel factura, FileModel file) {
        String ruc = additionalInfo.getAssignedId();
        if (ruc == null || ruc.trim().isEmpty()) {
            throw new ModelRuntimeException("Datos de Organización incompletos");
        }

        OrganizacionInformacionSunatModel orgSunatInfo = orgSunatInfoProvider.getOrganizacionInformacionSUNAT(organization)
                .orElseThrow(() -> new ModelRuntimeException("No se encontró información de sunat de la organización:" + organization.getId()));

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
            throw new ModelRuntimeException("No se pudo enviar a la SUNAT error:" + e.getMessage());
        }

        ResponseType responseType = SunatUtils.readCdr(sunatResponse);
        if (responseType.getResponseCode().getValue().equals("0")) {
            guardarInvoiceCdrFile(factura, sunatResponse);
        }

        return responseType;
    }

    private void guardarInvoiceCdrFile(AbstractInvoiceModel invoice, byte[] bytes) {
        try {
            String fileName = ModelUtils.generateId() + ".zip";
            FileModel file = fileProvider.addFile(fileName, bytes);
            invoice.setCdrFileId(file.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar un archivo en el storage");
        }
    }

}
