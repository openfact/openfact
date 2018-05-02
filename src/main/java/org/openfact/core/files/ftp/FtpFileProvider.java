package org.openfact.core.files.ftp;

import org.openfact.core.files.FileException;
import org.openfact.core.files.FileModel;
import org.openfact.core.files.FileProvider;
import org.openfact.core.files.FileProviderVendor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@FileProviderVendor(type = FileProviderVendor.Type.FTP)
public class FtpFileProvider implements FileProvider {

    @Override
    public FileModel addFile(String filename, byte[] bytes) throws FileException {
        return new FileModel(filename, bytes);
    }

    @Override
    public boolean removeFile(String id) {
        return false;
    }

}
