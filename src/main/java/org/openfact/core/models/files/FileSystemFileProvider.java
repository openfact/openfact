package org.openfact.core.models.files;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;
import org.openfact.core.camel.files.routes.FileSystemRouter;
import org.openfact.core.models.FileModel;
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
public class FileSystemFileProvider implements FileProvider {

    private static final Logger logger = Logger.getLogger(FileSystemFileProvider.class);

    public static final String DEFAULT_FOLDER_NAME = "openfact-files";

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Inject
    @ConfigurationValue("openfact.files.filesystem.folder")
    private Optional<String> folder;

    private String defaultFolder() {
        return Paths.get(DEFAULT_FOLDER_NAME).toString();
    }

    @Override
    public FileModel addFile(String filename, byte[] bytes) throws FileException {
        Path folderPath = Paths.get(folder.orElseGet(this::defaultFolder)).normalize();

        Map<String, Object> headers = new HashMap<>();
        headers.put(Exchange.FILE_NAME, filename);
        headers.put(FileSystemRouter.FOLDER_NAME_HEADER, folderPath.toString());

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        try {
            Object result = producerTemplate.requestBodyAndHeaders(FileSystemRouter.WRITE_URI, bytes, headers);

            System.out.println(result);
        } catch (CamelExecutionException e) {
            logger.error("Error saving file", e);
            throw new FileException(e);
        }

        return new FileModel() {
            @Override
            public String getFileName() {
                return filename;
            }

            @Override
            public byte[] getBytes() {
                return bytes;
            }
        };
    }
}
