package org.openfact.core.camel.files.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class FtpRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(FtpRouter.class);

    public static final String WRITE_URI = "direct:ftpUpload";

    @Override
    public void configure() {

    }

}
