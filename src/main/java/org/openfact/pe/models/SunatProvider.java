package org.openfact.pe.models;

import pe.gob.sunat.service.StatusResponse;

public interface SunatProvider {

    byte[] sendBill(String fileName, byte[] file) throws SendSunatException;

    StatusResponse getStatus(String ticket) throws SendSunatException;

    String sendSummary(String fileName, byte[] file) throws SendSunatException;

    String sendPack(String fileName, byte[] file) throws SendSunatException;

}
