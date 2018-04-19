package org.openfact.core.models.files;

import org.openfact.core.models.FileModel;
import org.openfact.core.models.FileProvider;
import org.openfact.core.models.FileProviderVendor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FTP)
public class FtpFileProvider implements FileProvider {

    @Override
    public FileModel addFile(String filename, byte[] bytes) throws FileException {
        return null;
    }

    @Override
    public boolean removeFile(String id) {
        return false;
    }

}
