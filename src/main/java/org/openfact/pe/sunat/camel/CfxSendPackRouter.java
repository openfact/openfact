package org.openfact.pe.sunat.camel;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CfxSendPackRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(CfxSendPackRouter.class);

    public static final String SEND_PACK_URI = "direct:sunatSendPack";

    @Override
    public void configure() {
        from(SEND_PACK_URI)
                .process(exchange -> {
                    Message message = exchange.getIn();
                    logger.debugf("Sending file to $s", message.getHeader(CfxConstants.END_POINT_HEADER));
                })
                .toD(String.format("cxf:${header.%s}?serviceClass=%s&serviceName=urn:sendPack", CfxConstants.END_POINT_HEADER, pe.gob.sunat.service.BillService.class.getName()));
    }

}
