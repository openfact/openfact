package org.openfact.camel.cdi;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;
import org.openfact.models.files.FilesystemFileProvider;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("cdi-context")
public class CamelFileSystemRouter extends RouteBuilder {

    private static final Logger logger = Logger.getLogger(FilesystemFileProvider.class);

    public static final String EXCHANGE_FOLDER_NAME = "OpenfactFolderName";

    public static final String FILE_SYSTEM_URI_UPLOAD = "direct:filesystemupload";

    @Override
    public void configure() throws Exception {
        from(FILE_SYSTEM_URI_UPLOAD)
                .process(exchange -> {
                    Message message = exchange.getIn();
                    logger.debugf("Writing file %s to $s", message.getHeader(Exchange.FILE_NAME), message.getHeader(EXCHANGE_FOLDER_NAME));
                })
                .toD("file:${header." + EXCHANGE_FOLDER_NAME + "}");
    }

}
