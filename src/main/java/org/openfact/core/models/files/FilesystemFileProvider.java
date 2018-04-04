package org.openfact.core.models.files;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;
import org.openfact.core.cdi.CamelFileSystemRouter;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.FileProviderVendor;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FILESYSTEM)
public class FilesystemFileProvider implements FileProvider {

    public static final String DEFAULT_FOLDER_NAME = "openfactFiles";

    private static final Logger logger = Logger.getLogger(FilesystemFileProvider.class);

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

    @Inject
    @ConfigurationValue("openfact.files.filesystem.folder")
    private Optional<String> folder;

    @Override
    public String addFile(String filename, byte[] bytes, String companyId) throws FileException {
        Path folderPath = Paths.get(folder.orElseGet(this::defaultFolder), companyId).normalize();

        Map<String, Object> headers = new HashMap<>();
        headers.put(Exchange.FILE_NAME, filename);
        headers.put(CamelFileSystemRouter.EXCHANGE_FOLDER_NAME, folderPath.toString());

        ProducerTemplate producerTemplate = camelctx.createProducerTemplate();

        try {
//            producerTemplate.sendBodyAndHeaders(CamelFileSystemRouter.FILE_SYSTEM_URI_UPLOAD, bytes, headers);
            Object result = producerTemplate.requestBodyAndHeaders(CamelFileSystemRouter.FILE_SYSTEM_URI_UPLOAD, bytes, headers);
            System.out.println(result);
        } catch (CamelExecutionException e) {
            logger.error("Error saving file", e);
            throw new FileException(e);
        }

        return "Hello";
    }

    private String defaultFolder() {
        logger.debugf("Using default folder system ./$s", DEFAULT_FOLDER_NAME);
        return Paths.get(DEFAULT_FOLDER_NAME).toString();
    }

}
