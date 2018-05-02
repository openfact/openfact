package org.openfact.core.files.filesystem;

import org.apache.camel.CamelContext;
import org.apache.camel.cdi.ContextName;
import org.jboss.logging.Logger;
import org.openfact.core.files.FileException;
import org.openfact.core.files.FileModel;
import org.openfact.core.files.FileProvider;
import org.openfact.core.files.FileProviderVendor;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FILESYSTEM)
public class FileSystemFileProvider implements FileProvider {

    private static final Logger logger = Logger.getLogger(FileSystemFileProvider.class);

    private static final String DEFAULT_FOLDER = "openfact-files";

    @Inject
    @ContextName("cdi-context")
    private CamelContext camelContext;

    @Inject
    @ConfigurationValue("openfact.files.filesystem.folder")
    private Optional<String> folder;

    @Override
    public FileModel addFile(String fileName, byte[] bytes) throws FileException {
        Path path = Paths.get(folder.orElse(DEFAULT_FOLDER), fileName);
        if (Files.exists(path)) {
            throw new FileException("File already exists");
        }

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                throw new FileException(e);
            }
        }

        try {
            Files.write(path, bytes);
        } catch (Throwable e) {
            throw new FileException(e);
        }

        return new FileModel(path.toString(), bytes);
    }

    @Override
    public boolean removeFile(String id) {
        Path path = Paths.get(folder.orElse(DEFAULT_FOLDER), id);
        try {
            Files.delete(path);
            return true;
        } catch (Throwable e) {
            logger.errorf("Could not delete the file %s", path.toString());
            return false;
        }
    }

}
