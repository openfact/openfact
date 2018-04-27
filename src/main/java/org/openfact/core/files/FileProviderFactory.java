package org.openfact.core.files;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Optional;

public class FileProviderFactory {

    @Produces
    @ApplicationScoped
    public FileProvider provideSecurityContext(
            @ConfigurationValue("openfact.files.provider") Optional<String> fileProvider,
            @FileProviderVendor(type = FileProviderVendor.Type.FILESYSTEM) FileProvider fsProvider,
            @FileProviderVendor(type = FileProviderVendor.Type.FTP) FileProvider ftpProvider,
            @FileProviderVendor(type = FileProviderVendor.Type.JPA) FileProvider jpaProvider
    ) {
        String selectedFileProvider = fileProvider.orElse("filesystem").toLowerCase();
        if ("filesystem".equals(selectedFileProvider)) {
            return fsProvider;
        } else if ("ftp".equals(selectedFileProvider)) {
            return ftpProvider;
        }
        if ("jpa".equals(selectedFileProvider)) {
            return jpaProvider;
        } else {
            throw new UnknownFileProviderTypeException(selectedFileProvider);
        }
    }

}
