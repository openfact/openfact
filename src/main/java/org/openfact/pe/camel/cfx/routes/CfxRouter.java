package org.openfact.pe.camel.cfx.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CfxRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(CfxRouter.class);

    @Override
    public void configure() {
        from("direct:start")
                .toD("cxf:https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService?serviceClass=pe.gob.sunat.service.BillService&serviceName=urn:sendBill");
    }

}
