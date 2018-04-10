package org.openfact.pe.camel.cfx.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CFXRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(CFXRouter.class);

    public static final String SEND_URI = "direct:cfxSend";

    @Override
    public void configure() {
//        from(SEND_URI)
//                .to("cfx:bean serviceClass=pe.gob.sunat.service.BillService");
    }

}
