package org.openfact.pe.sunat;

import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.sunat.SendSunatException;
import pe.gob.sunat.service.StatusResponse;

public interface SunatSenderProvider {

    byte[] sendBill(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String fileName, byte[] file) throws SendSunatException;

    StatusResponse getStatus(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String ticket) throws SendSunatException;

    String sendSummary(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String fileName, byte[] file) throws SendSunatException;

    String sendPack(String fileName, byte[] file) throws SendSunatException;

}
