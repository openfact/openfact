package org.openfact.pe.camel.cfx.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CFXRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(CFXRouter.class);

    public static final String WRITE_URI = "direct:ftpUpload";

    @Override
    public void configure() {
//        errorHandler();
//        from("")
//                .to("cfx://192.168.1.6?serviceClass=");
    }

}
