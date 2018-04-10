package org.openfact.pe.models;

import pe.gob.sunat.service.StatusResponse;

public interface SUNATProvider {

    byte[] sendBill(String fileName, byte[] file);

    StatusResponse getStatus(String ticket);

    String sendSummary(String fileName, byte[] file);

    String sendPack(String fileName, byte[] file);

}
