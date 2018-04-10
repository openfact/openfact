package org.openfact.pe.models.cxf;

import org.openfact.pe.models.SUNATProvider;
import pe.gob.sunat.service.StatusResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CfxSUNATProvider implements SUNATProvider {

    @Override
    public byte[] sendBill(String fileName, byte[] file) {
        return new byte[0];
    }

    @Override
    public StatusResponse getStatus(String ticket) {
        return null;
    }

    @Override
    public String sendSummary(String fileName, byte[] file) {
        return null;
    }

    @Override
    public String sendPack(String fileName, byte[] file) {
        return null;
    }

}
