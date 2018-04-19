package org.openfact.pe.models.cxf;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.apache.cxf.message.MessageContentsList;
import org.openfact.pe.camel.cfx.routes.CfxRouter;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.OrganizacionInformacionSunatModel;
import org.openfact.pe.models.SendSunatException;
import org.openfact.pe.models.SunatSenderProvider;
import pe.gob.sunat.service.StatusResponse;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.util.ByteArrayDataSource;

@ApplicationScoped
public class CamelSunatProvider implements SunatSenderProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Override
    public byte[] sendBill(OrganizacionInformacionAdicionalModel additionalInfo, OrganizacionInformacionSunatModel orgSunatInfo, String fileName, byte[] file) throws SendSunatException {
        DataSource dataSource = new ByteArrayDataSource(file, "application/xml");
        DataHandler dataHandler = new DataHandler(dataSource);

        ProducerTemplate producer = camelContext.createProducerTemplate();
        Object[] serviceParams = serviceParams = new Object[]{fileName, dataHandler, additionalInfo.getAssignedId()};

        Object result;
        try {
            result = producer.requestBody(CfxRouter.SEND_BILL_URI, serviceParams);
        } catch (Throwable e) {
            throw new SendSunatException(e.getCause().getMessage());
        }

        MessageContentsList messageContentsList = (MessageContentsList) result;
        Object message = messageContentsList.get(0);

        return (byte[]) message;
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
