package org.openfact.core.camel.files.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class FileSystemRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(FileSystemRouter.class);

    public static final String WRITE_URI = "direct:fileSystemWrite";

    public static final String FOLDER_NAME_HEADER = "OpenfactFolderName";

    @Override
    public void configure() {
        from(WRITE_URI)
                .process(exchange -> {
                    Message message = exchange.getIn();
                    logger.debugf("Writing file %s in $s", message.getHeader(Exchange.FILE_NAME), message.getHeader(FOLDER_NAME_HEADER));
                })
                .toD("file:${header." + FOLDER_NAME_HEADER + "}");
    }

}
