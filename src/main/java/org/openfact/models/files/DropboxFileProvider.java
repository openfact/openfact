package org.openfact.models.files;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.component.dropbox.util.DropboxConstants;
import org.openfact.camel.cdi.CamelDropboxRouter;
import org.openfact.camel.cdi.CamelFileSystemRouter;
import org.openfact.models.FileProvider;
import org.openfact.models.FileProviderVendor;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.DROPBOX)
public class DropboxFileProvider implements FileProvider {

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelctx;

    @Inject
    @ConfigurationValue("clarksnut.files.dropbox.folder")
    private Optional<String> folder;

    @Override
    public String addFile(String filename, byte[] bytes, String companyId) {
//        Path folderPath = Paths.get(folder.orElseGet(this::defaultFolder), companyId).normalize();

        Map<String, Object> headers = new HashMap<>();
        headers.put(DropboxConstants.HEADER_PUT_FILE_NAME, filename);

        ProducerTemplate producerTemplate = camelctx.createProducerTemplate();

        try {
            producerTemplate.sendBodyAndHeaders(CamelDropboxRouter.OPENFACT_DIRECT_DROPBOX, bytes, headers);
        } catch (CamelExecutionException e) {
//            logger.error("Error saving file", e);
//            throw new FileException(e);
        }

        return "Hello";
    }

}
