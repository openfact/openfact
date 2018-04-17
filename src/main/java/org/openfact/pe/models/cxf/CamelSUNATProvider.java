package org.openfact.pe.models.cxf;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.openfact.pe.models.SendSunatException;
import org.openfact.pe.models.SunatProvider;
import pe.gob.sunat.service.StatusResponse;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

@ApplicationScoped
public class CamelSUNATProvider implements SunatProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Override
    public byte[] sendBill(String fileName, byte[] file) throws SendSunatException {
        DataSource dataSource = new ByteArrayDataSource(file, "application/xml");
        DataHandler dataHandler = new DataHandler(dataSource);

        ProducerTemplate producer = camelContext.createProducerTemplate();

        Object[] serviceParams = serviceParams = new Object[]{fileName, dataHandler, "Carlos"};
        Object result;
        try {
            result = producer.requestBody("direct:start", serviceParams);
        } catch (Throwable e) {
            throw new SendSunatException("", e.getMessage());
        }

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
