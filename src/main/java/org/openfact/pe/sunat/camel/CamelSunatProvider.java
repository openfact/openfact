package org.openfact.pe.sunat.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.apache.cxf.message.MessageContentsList;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.sunat.SendSunatException;
import org.openfact.pe.sunat.SunatSenderProvider;
import pe.gob.sunat.service.StatusResponse;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.util.ByteArrayDataSource;
import java.util.HashMap;
import java.util.Map;

//import org.apache.cxf.message.MessageContentsList;

@ApplicationScoped
public class CamelSunatProvider implements SunatSenderProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Override
    public byte[] sendBill(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String fileName, byte[] file) throws SendSunatException {
        Map<String, Object> headers = new HashMap<>();
        headers.put(CfxConstants.END_POINT_HEADER, orgSunatInfo.getBoletaFacturaEndpoint());
        headers.put(CfxConstants.USERNAME, orgSunatInfo.getUsuario());
        headers.put(CfxConstants.PASSWORD, orgSunatInfo.getPassword());

        DataSource dataSource = new ByteArrayDataSource(file, "application/xml");
        DataHandler dataHandler = new DataHandler(dataSource);

        ProducerTemplate producer = camelContext.createProducerTemplate();
        Object[] serviceParams = new Object[]{fileName, dataHandler, additionalInfo.getAssignedId()};

        Object result;
        try {
            result = producer.requestBodyAndHeaders(CfxSendBillRouter.SEND_BILL_URI, serviceParams, headers);
        } catch (Throwable e) {
            throw new SendSunatException(e.getCause().getMessage());
        }

        MessageContentsList messageContentsList = (MessageContentsList) result;
        Object message = messageContentsList.get(0);
        return (byte[]) message;
    }

    @Override
    public StatusResponse getStatus(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String ticket) throws SendSunatException {
        Map<String, Object> headers = new HashMap<>();
        headers.put(CfxConstants.END_POINT_HEADER, orgSunatInfo.getBoletaFacturaEndpoint());
        headers.put(CfxConstants.USERNAME, orgSunatInfo.getUsuario());
        headers.put(CfxConstants.PASSWORD, orgSunatInfo.getPassword());

        ProducerTemplate producer = camelContext.createProducerTemplate();

        pe.gob.sunat.service.StatusResponse statusResponse = null;
        try {
            statusResponse = producer.requestBodyAndHeaders(CfxGetStatusRouter.GET_STATUS_URI, ticket, headers, pe.gob.sunat.service.StatusResponse.class);
        } catch (Throwable e) {
            throw new SendSunatException(e.getCause().getMessage());
        }

        return statusResponse;
    }

    @Override
    public String sendSummary(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String fileName, byte[] file) throws SendSunatException {
        Map<String, Object> headers = new HashMap<>();
        headers.put(CfxConstants.END_POINT_HEADER, orgSunatInfo.getBoletaFacturaEndpoint());
        headers.put(CfxConstants.USERNAME, orgSunatInfo.getUsuario());
        headers.put(CfxConstants.PASSWORD, orgSunatInfo.getPassword());

        DataSource dataSource = new ByteArrayDataSource(file, "application/xml");
        DataHandler dataHandler = new DataHandler(dataSource);

        ProducerTemplate producer = camelContext.createProducerTemplate();
        Object[] serviceParams = new Object[]{fileName, dataHandler, additionalInfo.getAssignedId()};

        String ticket;
        try {
            ticket = producer.requestBodyAndHeaders(CfxSendSummaryRouter.SEND_SUMMARY_URI, serviceParams, headers, String.class);
        } catch (Throwable e) {
            throw new SendSunatException(e.getCause().getMessage());
        }

        return ticket;
    }

    @Override
    public String sendPack(String fileName, byte[] file) {
        return null;
    }

}
